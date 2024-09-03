package edu.kit.dppviewer.ui.feature.importproductpage

import android.graphics.Bitmap
import com.google.common.truth.Truth.assertThat
import com.google.zxing.BinaryBitmap
import com.google.zxing.MultiFormatReader
import com.google.zxing.RGBLuminanceSource
import com.google.zxing.ReaderException
import com.google.zxing.common.HybridBinarizer
import edu.kit.dppviewer.ui.feature.importproductpage.util.generateQRCode
import edu.kit.dppviewer.ui.feature.importproductpage.util.isValidURL
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Unit tests for QR code generation and URL validity checks using Robolectric.
 */
@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class ImportPageUtilsKtTest {

    // Constants for testing
    private val invalidUrl: String = "https://www.example.com/"
    private val validUrl: String =
        "https://www.boebe2024tech.top:473/api/v3.0/shells/aHR0cHM6Ly9leGFtcGxlLmNvbS9pZHMvc20vMjU5MV84MDAyXzcwNDJfNDU4MA=="
    private val size: Int = 200

    // Late-initialized property to hold generated QR code bitmap
    private lateinit var bitmap: Bitmap

    /**
     * Setup method to initialize test data before each test case.
     */
    @Before
    fun setup() {
        bitmap = generateQRCode(validUrl, size)
    }

    /**
     * Test case to verify that the generated QR code bitmap is not null.
     */
    @Test
    fun `Generate qr code, not null`() {
        assertThat(bitmap).isNotNull()
    }

    /**
     * Test case to verify that the generated QR code bitmap has the correct size.
     */
    @Test
    fun `Generate qr code, correct size`() {
        assertThat(bitmap.width).isEqualTo(size)
        assertThat(bitmap.height).isEqualTo(size)
    }

    /**
     * Test case to verify that decoding the generated QR code bitmap encodes the correct URL.
     */
    @Test
    fun `Generate qr code, correct url`() {
        assertThat(decodeQRCode(bitmap)).isEqualTo(validUrl)
    }

    /**
     * Test case to verify the validity of a valid URL.
     */
    @Test
    fun `Check URL, valid`() {
        assertThat(isValidURL(validUrl)).isTrue()
    }

    /**
     * Test case to verify the validity of an invalid URL.
     */
    @Test
    fun `Check URL, invalid`() {
        assertThat(isValidURL(invalidUrl)).isFalse()
    }

    /**
     * Utility function to decode a QR code bitmap and retrieve its content.
     *
     * @param bitmap The QR code bitmap to decode.
     * @return The decoded text content of the QR code, or null if decoding fails.
     */
    private fun decodeQRCode(bitmap: Bitmap): String? {
        val intArray = IntArray(bitmap.width * bitmap.height)
        bitmap.getPixels(intArray, 0, bitmap.width, 0, 0, bitmap.width, bitmap.height)

        val source = RGBLuminanceSource(bitmap.width, bitmap.height, intArray)
        val binarizer = HybridBinarizer(source)
        val binaryBitmap = BinaryBitmap(binarizer)

        val hints: MutableMap<com.google.zxing.DecodeHintType, Any> = mutableMapOf()
        hints[com.google.zxing.DecodeHintType.POSSIBLE_FORMATS] =
            listOf(com.google.zxing.BarcodeFormat.QR_CODE)

        val reader = MultiFormatReader()

        return try {
            val result = reader.decode(binaryBitmap, hints)
            result.text
        } catch (e: ReaderException) {
            e.printStackTrace()
            null
        }
    }
}