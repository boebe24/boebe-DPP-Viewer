package edu.kit.dppviewer.ui.feature.importproductpage.util

import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.compose.material3.SnackbarHostState
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.common.BitMatrix
import edu.kit.dppviewer.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.net.MalformedURLException

/**
 * Generates a QR code bitmap from the given text.
 *
 * This function encodes the provided text into a QR code bitmap using the specified size.
 * The resulting bitmap will have black pixels for the QR code modules and white pixels
 * for the background.
 *
 * @param text The text to be encoded into the QR code.
 * @param size The width and height of the generated QR code bitmap in pixels.
 * @return A [Bitmap] containing the generated QR code.
 */
fun generateQRCode(text: String, size: Int): Bitmap {
    val bitMatrix: BitMatrix = MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, size, size)
    val width = bitMatrix.width
    val height = bitMatrix.height
    val bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
    for (x in 0 until width) {
        for (y in 0 until height) {
            bmp.setPixel(
                x,
                y,
                if (bitMatrix[x, y]) android.graphics.Color.BLACK else android.graphics.Color.WHITE
            )
        }
    }
    return bmp
}

/**
 * Checks if a URL is a valid URL of a DPP Server with a regex.
 *
 * @param url The URL of the server to check.
 * @return `true` if the server URL is valid, otherwise `false`.
 */
fun isValidURL(url: String): Boolean {
    val regex = Regex("^https://www\\.[^.]+\\.[^.]+/api/v3\\.0/shells/[^/]+$")
    return regex.matches(url)
}

/**
 * Extracts the base website URL from a DPP Server URL.
 *
 * This function extracts and returns the base website URL from the provided [url].
 * If the URL does not match the expected pattern, a [MalformedURLException] is thrown.
 *
 * @param url The full DPP Server URL.
 * @return The base website URL as a [String].
 * @throws MalformedURLException if the URL does not match the expected pattern.
 */
fun getBaseWebsite(url: String): String {
    val regex = Regex("^(https://www\\.[^.]+\\.[^.]+)/api/")
    val matchResult = regex.find(url)
    val returns = matchResult?.groups?.get(1)?.value

    returns?.let { return it }
    throw MalformedURLException()
}

/**
 * Displays a snackbar with a message indicating that the QR code is invalid.
 *
 * This function launches a coroutine in the provided [scope] to display the snackbar
 * using the provided [snackbarHostState]. The snackbar will contain a dismiss action.
 *
 * @param context The [Context] for accessing resources.
 * @param scope The [CoroutineScope] in which the coroutine to show the snackbar will be launched.
 * @param snackbarHostState The [SnackbarHostState] used to control the snackbar's display state.
 */
fun invalidQRSnackbar(
    context: Context,
    scope: CoroutineScope,
    snackbarHostState: SnackbarHostState
) {
    scope.launch {
        snackbarHostState.showSnackbar(
            message = context.getString(R.string.error_invalid_qr),
            withDismissAction = true,
        )
    }
}

/**
 * Displays a snackbar with a message indicating that there is no internet connection.
 *
 * This function launches a coroutine in the provided [scope] to display the snackbar
 * using the provided [snackbarHostState]. The snackbar will include a dismiss action.
 * It prevents multiple snackbars from stacking if triggered repeatedly.
 *
 * @param context The [Context] for accessing resources.
 * @param scope The [CoroutineScope] in which the coroutine to show the snackbar will be launched.
 * @param snackbarHostState The [SnackbarHostState] used to control the snackbar's display state.
 */
fun invalidInternetSnackbar(
    context: Context,
    scope: CoroutineScope,
    snackbarHostState: SnackbarHostState
) {
    scope.launch {
        // Prevent from stacking infinitely when scanning with no internet
        if (snackbarHostState.currentSnackbarData == null) {
            snackbarHostState.showSnackbar(
                message = context.getString(R.string.error_no_internet),
                withDismissAction = true,
            )
        }
    }
}

/**
 * Displays a snackbar with a message indicating that the URL is invalid.
 *
 * This function launches a coroutine in the provided [scope] to display the snackbar
 * using the provided [snackbarHostState]. The snackbar will include a dismiss action.
 *
 * @param context The [Context] for accessing resources.
 * @param scope The [CoroutineScope] in which the coroutine to show the snackbar will be launched.
 * @param snackbarHostState The [SnackbarHostState] used to control the snackbar's display state.
 */
fun invalidUrlSnackbar(
    context: Context,
    scope: CoroutineScope,
    snackbarHostState: SnackbarHostState
) {
    scope.launch {
        snackbarHostState.showSnackbar(
            message = context.getString(R.string.error_invalid_url),
            withDismissAction = true,
        )
    }
}

/**
 * Displays a snackbar with a message indicating that no QR code was found in the photo.
 *
 * This function launches a coroutine in the provided [scope] to display the snackbar
 * using the provided [snackbarHostState]. The snackbar will include a dismiss action.
 *
 * @param context The [Context] for accessing resources.
 * @param scope The [CoroutineScope] in which the coroutine to show the snackbar will be launched.
 * @param snackbarHostState The [SnackbarHostState] used to control the snackbar's display state.
 */
fun noQRCodeFoundSnackbar(
    context: Context,
    scope: CoroutineScope,
    snackbarHostState: SnackbarHostState
) {
    scope.launch {
        snackbarHostState.showSnackbar(
            message = context.getString(R.string.error_no_qr_in_photo),
            withDismissAction = true,
        )
    }
}

/**
 * Checks if the device has a flashlight.
 *
 * @param context The context of the calling component.
 * @return `true` if the device has a flashlight, `false` otherwise.
 */
fun hasFlashlight(context: Context): Boolean {
    return context.packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)
}