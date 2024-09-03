package edu.kit.dppviewer.ui.feature.importproductpage.components.scanner

import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.compose.LocalLifecycleOwner
import edu.kit.dppviewer.ui.feature.importproductpage.ImportProductPageUiEvent

/**
 * Composable for the QR Scanner.
 * Sets camera [Preview] and handles QR Scans with [ImageAnalysis].
 *
 * @param modifier The [Modifier] for the UI
 * @param onBarcodeDetected The callback function that is invoked when a QR Code is found
 */
@Composable
fun QRScanner(
    modifier: Modifier = Modifier,
    onBarcodeDetected: (String) -> Unit,
    onEvent: (ImportProductPageUiEvent) -> Unit,
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    // Variables for creating the camera preview
    val previewView = remember { PreviewView(context) }
    val preview = initCameraPreview(previewView)

    // Camera specific setup
    val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
    val cameraProviderFuture = ProcessCameraProvider.getInstance(context)

    // Processing of camera feed -> recognize QR-Codes
    val imageAnalysis = initImageAnalysis(
        context = context,
        onBarcodeDetected = onBarcodeDetected,
    )

    LaunchedEffect(Unit) {
        val cameraProvider = cameraProviderFuture.get()
        cameraProvider.unbindAll()
        val camera = cameraProvider.bindToLifecycle(
            lifecycleOwner,
            cameraSelector,
            preview,
            imageAnalysis
        )
        onEvent(ImportProductPageUiEvent.SetCamera(camera))
    }

    AndroidView(
        factory = { previewView },
        modifier = modifier
    )
}