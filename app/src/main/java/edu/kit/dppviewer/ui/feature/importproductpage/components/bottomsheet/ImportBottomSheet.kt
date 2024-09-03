package edu.kit.dppviewer.ui.feature.importproductpage.components.bottomsheet

import android.content.Context
import android.net.Uri
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import edu.kit.dppviewer.BuildConfig
import edu.kit.dppviewer.R
import edu.kit.dppviewer.data.client.util.AppUtil
import edu.kit.dppviewer.ui.BATTERY_SHELL_URL
import edu.kit.dppviewer.ui.LocalSnackbarHostState
import edu.kit.dppviewer.ui.PUZZLE_SHELL_URL
import edu.kit.dppviewer.ui.SMARTPHONE_SHELL_URL
import edu.kit.dppviewer.ui.TEXTILE_SHELL_URL
import edu.kit.dppviewer.ui.feature.importproductpage.ImportProductPageUiEvent
import edu.kit.dppviewer.ui.feature.importproductpage.util.invalidInternetSnackbar
import edu.kit.dppviewer.ui.feature.importproductpage.util.invalidQRSnackbar
import edu.kit.dppviewer.ui.feature.importproductpage.util.invalidUrlSnackbar
import edu.kit.dppviewer.ui.feature.importproductpage.util.isValidURL
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Composable that contains the UI for the Bottom Sheet.
 * The Bottom Sheet contains all options how a user can import a DPP.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImportBottomSheet(
    sheetState: SheetState,
    scope: CoroutineScope,
    singlePhotoPickerLauncher: ManagedActivityResultLauncher<PickVisualMediaRequest, Uri?>,
    onEvent: (ImportProductPageUiEvent) -> Unit,
) {
    val context = LocalContext.current
    val snackbarHostState = LocalSnackbarHostState.current
    ModalBottomSheet(
        onDismissRequest = { onEvent(ImportProductPageUiEvent.HideBottomSheet) },
        sheetState = sheetState,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.import_options_text),
                style = MaterialTheme.typography.titleMedium
            )
            if (BuildConfig.INCLUDE_DEBUG_OPTIONS) {
                Spacer(modifier = Modifier.height(16.dp))
                OptionItem(
                    icon = Icons.Default.QrCodeScanner,
                    text = "Simulate Textile",
                    onClick = {

                        loadProductWithErrorHandling(
                            context = context,
                            url = TEXTILE_SHELL_URL,
                            scope = scope,
                            snackbarHostState = snackbarHostState,
                            onEvent = onEvent
                        )
                    },
                    sheetState = sheetState,
                    scope = scope
                )
                Spacer(modifier = Modifier.height(16.dp))
                OptionItem(
                    icon = Icons.Default.QrCodeScanner,
                    text = "Simulate Smartphone",
                    onClick = {
                        loadProductWithErrorHandling(
                            context = context,
                            url = SMARTPHONE_SHELL_URL,
                            scope = scope,
                            snackbarHostState = snackbarHostState,
                            onEvent = onEvent
                        )
                    },
                    sheetState = sheetState,
                    scope = scope
                )
                Spacer(modifier = Modifier.height(16.dp))
                OptionItem(
                    icon = Icons.Default.QrCodeScanner,
                    text = "Simulate Battery",
                    onClick = {
                        loadProductWithErrorHandling(
                            context = context,
                            url = BATTERY_SHELL_URL,
                            scope = scope,
                            snackbarHostState = snackbarHostState,
                            onEvent = onEvent
                        )
                    },
                    sheetState = sheetState,
                    scope = scope
                )
                Spacer(modifier = Modifier.height(16.dp))
                OptionItem(
                    icon = Icons.Default.QrCodeScanner,
                    text = "Simulate Puzzle",
                    onClick = {
                        loadProductWithErrorHandling(
                            context = context,
                            url = PUZZLE_SHELL_URL,
                            scope = scope,
                            snackbarHostState = snackbarHostState,
                            onEvent = onEvent
                        )
                    },
                    sheetState = sheetState,
                    scope = scope
                )
                Spacer(modifier = Modifier.height(16.dp))
                OptionItem(
                    icon = Icons.Default.Error,
                    text = "Simulate invalid QR scan",
                    onClick = {
                        onEvent(ImportProductPageUiEvent.HideBottomSheet)
                        invalidQRSnackbar(context, scope, snackbarHostState)
                    },
                    sheetState = sheetState,
                    scope = scope
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            OptionItem(
                icon = Icons.Default.Image,
                text = stringResource(id = R.string.scan_from_photo_text),
                onClick = {
                    onEvent(ImportProductPageUiEvent.HideBottomSheet)
                    onEvent(ImportProductPageUiEvent.LaunchPhotoPicker(singlePhotoPickerLauncher))
                },
                sheetState = sheetState,
                scope = scope
            )
            Spacer(modifier = Modifier.height(16.dp))
            OptionItem(
                icon = Icons.Default.Public,
                text = stringResource(id = R.string.enter_url_manually),
                onClick = {
                    onEvent(ImportProductPageUiEvent.HideBottomSheet)
                    onEvent(ImportProductPageUiEvent.ShowURLEntryDialog)
                },
                sheetState = sheetState,
                scope = scope
            )
        }
    }
}


fun loadProductWithErrorHandling(
    context: Context,
    url: String,
    scope: CoroutineScope,
    snackbarHostState: SnackbarHostState,
    onEvent: (ImportProductPageUiEvent) -> Unit
) {
    scope.launch {
        onEvent(ImportProductPageUiEvent.HideBottomSheet)

        val isNotConnected = withContext(Dispatchers.IO) {
            AppUtil().hasConnectionError(url)
        }

        if (BuildConfig.INCLUDE_DEBUG_OPTIONS) {
            // only when debug
            println("connection error detected? : !$isNotConnected")
        } else {
            // only when release
        }

        if (!isValidURL(url)) {
            invalidUrlSnackbar(context, scope, snackbarHostState)
        } else if (isNotConnected) {
            invalidInternetSnackbar(context, scope, snackbarHostState)
        } else {
            onEvent(ImportProductPageUiEvent.SetUrl(url))
            onEvent(ImportProductPageUiEvent.LoadProductFromUrl)
            onEvent(ImportProductPageUiEvent.ShowDialog)
        }
    }
}

