package edu.kit.dppviewer.ui.feature.productpage

import edu.kit.dppviewer.ui.feature.productpage.product.model.FilteredProduct

/**
 * Ui States for ProductPage
 */
sealed interface ProductPageUiState {
    /**
     * state while loading the ui state
     */
    data object Loading : ProductPageUiState

    /**
     * ui state after it has been loaded
     */
    data class Success(val filteredProduct: FilteredProduct, val url: String) : ProductPageUiState
}