package edu.kit.dppviewer.ui.feature.importproductpage

import android.graphics.ImageDecoder
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import edu.kit.dppviewer.R
import edu.kit.dppviewer.ui.LocalSnackbarHostState
import edu.kit.dppviewer.ui.feature.importproductpage.components.bottomsheet.ImportBottomSheet
import edu.kit.dppviewer.ui.feature.importproductpage.components.bottomsheet.loadProductWithErrorHandling
import edu.kit.dppviewer.ui.feature.importproductpage.components.enterurldialog.EnterURLDialog
import edu.kit.dppviewer.ui.feature.importproductpage.components.opendialog.OpenDialog
import edu.kit.dppviewer.ui.feature.importproductpage.components.permission.CameraPermissionScreen
import edu.kit.dppviewer.ui.feature.importproductpage.components.scanner.QRScanner
import edu.kit.dppviewer.ui.feature.importproductpage.components.scanner.analyzeQRCode
import edu.kit.dppviewer.ui.feature.importproductpage.components.topbar.ImportTopBar
import edu.kit.dppviewer.ui.feature.importproductpage.util.hasFlashlight
import edu.kit.dppviewer.ui.feature.importproductpage.util.noQRCodeFoundSnackbar

/**
 * The main screen of the Import Product Page.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImportProductPageScreen(
    onNavigateToProductPage: () -> Unit,
    viewmodel: ImportProductPageViewmodel = hiltViewModel(),
    onEvent: (ImportProductPageUiEvent) -> Unit = viewmodel::onEvent,
) {
    val uiState by viewmodel.uiState.collectAsStateWithLifecycle()

    val productLoaded: Boolean = uiState.productLoadingState == ProductLoadingState.LOADED

    val snackbarHostState = LocalSnackbarHostState.current
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()


    // Reset flashlight when app is resumed
    val lifecycleOwner = LocalLifecycleOwner.current
    val lifecycleState by lifecycleOwner.lifecycle.currentStateFlow.collectAsState()
    LaunchedEffect(lifecycleState) {
        when (lifecycleState) {
            Lifecycle.State.DESTROYED -> {}
            Lifecycle.State.INITIALIZED -> {}
            Lifecycle.State.CREATED -> {}
            Lifecycle.State.STARTED -> {}
            Lifecycle.State.RESUMED -> {
                onEvent(ImportProductPageUiEvent.OnResumed)
            }
        }
    }

    val context = LocalContext.current
    val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri ->
            if (uri != null) {
                Log.d("PhotoPicker", "Selected URI: $uri")
                val source = ImageDecoder.createSource(context.contentResolver, uri)
                // create mutable bitmap
                val bitmap = ImageDecoder.decodeBitmap(
                    source
                ) { imageDecoder: ImageDecoder, _: ImageDecoder.ImageInfo?, _: ImageDecoder.Source? ->
                    imageDecoder.isMutableRequired = true
                }
                analyzeQRCode(
                    bitmap = bitmap,
                    onBarcodeDetected = { result ->
                        loadProductWithErrorHandling(
                            context = context,
                            url = result,
                            scope = scope,
                            snackbarHostState = snackbarHostState,
                            onEvent = onEvent,
                        )
                    },
                    onNoBarcodeDetected = {
                        noQRCodeFoundSnackbar(
                            context = context,
                            scope = scope,
                            snackbarHostState = snackbarHostState,
                        )
                    }
                )
            } else {
                Log.d("PhotoPicker", "No media selected")
            }
        }
    )

    /**
     * Show Dialog for URL entry
     */
    var urlEntry by remember { mutableStateOf("") }
    if (uiState.showEnterURLDialog) {
        EnterURLDialog(
            url = urlEntry,
            onTextChange = { urlEntry = it },
            onOpenAction = {
                onEvent(ImportProductPageUiEvent.HideURLEntryDialog)
                loadProductWithErrorHandling(
                    context = context,
                    url = urlEntry,
                    scope = scope,
                    snackbarHostState = snackbarHostState,
                    onEvent = onEvent,
                )
                urlEntry = ""
            },
            onDismissAction = {
                onEvent(ImportProductPageUiEvent.HideURLEntryDialog)
                urlEntry = "" // Reset text field
            }
        )
    }

    /**
     * Show QR Dialog after scan is completed
     */
    if (uiState.showDialog) {
        val url = uiState.url
        OpenDialog(
            url = url,
            productLoaded = productLoaded,
            onOpenAction = {
                // Product should be already loaded into repo when dialog is shown
                onEvent(ImportProductPageUiEvent.ResetUiState)
                onNavigateToProductPage()
            },
            onDismissAction = {
                onEvent(ImportProductPageUiEvent.HideDialog)
            }
        )
    }

    /**
     * Show Bottom Sheet for more options when Import button was pressed
     */
    if (uiState.showSheet) {
        ImportBottomSheet(
            sheetState = sheetState,
            scope = scope,
            singlePhotoPickerLauncher = singlePhotoPickerLauncher,
            onEvent = onEvent,
        )
    }

    if (!uiState.showQRScanner) {
        CameraPermissionScreen(onPermissionGranted = { onEvent(ImportProductPageUiEvent.ShowQRScanner) })
    } else {
        /**
         * Main content
         */
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                ImportTopBar(
                    isFlashOn = uiState.isFlashOn,
                    hasFlash = hasFlashlight(context),
                    onFlashClick = {
                        onEvent(ImportProductPageUiEvent.ToggleFlash)
                    }
                )
            },
            snackbarHost = { SnackbarHost(snackbarHostState) },
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .consumeWindowInsets(innerPadding)
            ) {
                QRScanner(
                    modifier = Modifier.matchParentSize(),
                    onBarcodeDetected = { result ->
                        val scanningActive: Boolean =
                            !uiState.showSheet && !uiState.showDialog && !uiState.showEnterURLDialog
                        if (scanningActive) {
                            loadProductWithErrorHandling(
                                context = context,
                                url = result,
                                scope = scope,
                                snackbarHostState = snackbarHostState,
                                onEvent = onEvent,
                            )
                        }
                    }, onEvent = onEvent
                )
                /**
                 * Import Button
                 */
                FilledTonalButton(
                    modifier = Modifier
                        .align(alignment = Alignment.BottomCenter)
                        .padding(bottom = 100.dp),
                    onClick = {
                        onEvent(ImportProductPageUiEvent.ShowBottomSheet)
                    },
                    colors = ButtonDefaults.filledTonalButtonColors(
                        containerColor = ButtonDefaults.filledTonalButtonColors().containerColor
                    )
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            modifier = Modifier.padding(end = 6.dp),
                            imageVector = Icons.Outlined.AddCircleOutline,
                            contentDescription = "import icon",
                        )
                        Text(
                            text = context.getString(R.string.import_button_text),
                        )
                    }
                }
            }
        }
    }
}