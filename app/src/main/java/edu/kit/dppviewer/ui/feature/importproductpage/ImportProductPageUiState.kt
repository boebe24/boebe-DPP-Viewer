package edu.kit.dppviewer.ui.feature.importproductpage

/**
 * Ui State for ImportProductPage
 */
data class ImportProductPageUiState(
    val cameraPermission: CameraPermissionState = CameraPermissionState.UNKNOWN,
    val showSheet: Boolean = false,
    val showDialog: Boolean = false,
    val isFlashOn: Boolean = false,
    val showEnterURLDialog: Boolean = false,
    val url: String = "",
    val productLoadingState: ProductLoadingState = ProductLoadingState.LOADING,
    /**
     * Set once an example product finished loading. Those skip the QR dialog, which has no
     * meaningful URL to show for them, and open the product page directly.
     */
    val openProductPage: Boolean = false,
)