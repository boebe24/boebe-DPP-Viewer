package edu.kit.dppviewer.ui.feature.importproductpage

/**
 * Ui State for ImportProductPage
 */
data class ImportProductPageUiState(
    val showQRScanner: Boolean = false,
    val showSheet: Boolean = false,
    val showDialog: Boolean = false,
    val isFlashOn: Boolean = false,
    val showEnterURLDialog: Boolean = false,
    val url: String = "",
    val productLoadingState: ProductLoadingState = ProductLoadingState.LOADING,
)