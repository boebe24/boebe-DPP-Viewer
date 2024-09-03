package edu.kit.dppviewer.ui.feature.importproductpage.components.opendialog

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import edu.kit.dppviewer.R

/**
 * Dialog, that shows the scanned product's
 * - qr code
 * - url
 *
 * @param url The URL of the DPP to open.
 * @param productLoaded Boolean indicating whether the product was successfully loaded into the repository.
 * @param onOpenAction The method to execute, when user confirms on Dialog.
 * @param onDismissAction The method to execute, when user dismiss on Dialog.
 */
@Composable
fun OpenDialog(
    url: String,
    productLoaded: Boolean,
    onOpenAction: () -> Unit,
    onDismissAction: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = { onDismissAction() },
        title = { Text(text = LocalContext.current.getString(R.string.scan_qr_code_found_text))},
        icon = { Icon(Icons.Default.QrCodeScanner, contentDescription = stringResource(R.string.qr_scanner_icon)) },
        text = { OpenDialogContent(url) },
        confirmButton = {
            TextButton(
                enabled = productLoaded,
                onClick = { onOpenAction() }) {
                Text(
                    if (productLoaded) {
                        LocalContext.current.getString(R.string.scan_qr_code_result_open_text)
                    } else {
                        LocalContext.current.getString(R.string.scan_qr_code_result_load_text)
                    }
                )
            }
        },
        dismissButton = {
            TextButton(onClick = { onDismissAction() }) {
                Text(LocalContext.current.getString(R.string.dismiss))
            }
        }
    )
}