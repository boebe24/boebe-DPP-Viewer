package edu.kit.dppviewer.ui.feature.importproductpage.components.scanner

import android.content.Context
import android.graphics.Bitmap
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.view.PreviewView
import androidx.core.content.ContextCompat
import com.google.zxing.BarcodeFormat
import com.google.zxing.BinaryBitmap
import com.google.zxing.DecodeHintType
import com.google.zxing.MultiFormatReader
import com.google.zxing.NotFoundException
import com.google.zxing.PlanarYUVLuminanceSource
import com.google.zxing.RGBLuminanceSource
import com.google.zxing.common.HybridBinarizer

/**
 * Initializes a camera preview and sets up the surface provider for the given [PreviewView].
 *
 * @param previewView The [PreviewView] that will be used to display the camera preview.
 * @return The configured [Preview] instance.
 */
fun initCameraPreview(
    previewView: PreviewView
): Preview {
    return Preview.Builder().build().apply {
        setSurfaceProvider(previewView.surfaceProvider)
    }
}

/**
 * Initializes an image analysis use case for barcode detection, specifically for QR codes.
 *
 * @param onBarcodeDetected A callback function that is invoked when a QR code is detected.
 * @param context The context used to get the main executor for setting the analyzer.
 * @return The configured [ImageAnalysis] instance.
 */
fun initImageAnalysis(
    context: Context,
    onBarcodeDetected: (String) -> Unit,
): ImageAnalysis {
    return ImageAnalysis.Builder()
        .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
        .build()
        .also { it ->
            it.setAnalyzer(ContextCompat.getMainExecutor(context)) { imageProxy ->
                val buffer = imageProxy.planes[0].buffer
                val bytes = ByteArray(buffer.remaining())
                buffer.get(bytes)

                val source = PlanarYUVLuminanceSource(
                    bytes,
                    imageProxy.width,
                    imageProxy.height,
                    0,
                    0,
                    imageProxy.width,
                    imageProxy.height,
                    false
                )
                val binaryBitmap = BinaryBitmap(HybridBinarizer(source))

                try {
                    val hints = HashMap<DecodeHintType, Any>()
                    hints[DecodeHintType.POSSIBLE_FORMATS] = listOf(BarcodeFormat.QR_CODE)

                    val reader = MultiFormatReader().apply { setHints(hints) }
                    val result = reader.decodeWithState(binaryBitmap)
                    result.text?.let { onBarcodeDetected(it) }
                } catch (e: NotFoundException) {
                    // Didn't find qr code
                } finally {
                    imageProxy.close()
                }
            }
        }
}

/**
 * Analyzes a [Bitmap] for a QR code.
 *
 * @param bitmap The [Bitmap] to analyze.
 * @param onBarcodeDetected A callback function that is invoked when a QR code is detected.
 * @param onNoBarcodeDetected A callback function that is invoked when no QR code is detected.
 */
fun analyzeQRCode(
    bitmap: Bitmap,
    onBarcodeDetected: (String) -> Unit,
    onNoBarcodeDetected: () -> Unit,
) {
    // Convert the Bitmap to a BinaryBitmap
    val width = bitmap.width
    val height = bitmap.height
    val intArray = IntArray(width * height)
    bitmap.getPixels(intArray, 0, width, 0, 0, width, height)

    val source = RGBLuminanceSource(width, height, intArray)
    val binaryBitmap = BinaryBitmap(HybridBinarizer(source))

    try {
        val hints = hashMapOf<DecodeHintType, Any>(
            DecodeHintType.POSSIBLE_FORMATS to listOf(BarcodeFormat.QR_CODE)
        )

        val reader = MultiFormatReader().apply { setHints(hints) }
        val result = reader.decodeWithState(binaryBitmap)

        onBarcodeDetected(result.text)
    } catch (e: NotFoundException) {
        // Didn't find QR code
        onNoBarcodeDetected()
    } catch (e: Exception) {
        // Handle other exceptions if necessary
        e.printStackTrace()
    }
}
