package edu.kit.dppviewer.ui.feature.productpage

import android.content.Context

/**
 * Represents actions the user can perform on the product page.
 */
sealed interface ProductPageUiEvent {
    data class RefreshFilteredProduct(val context: Context) : ProductPageUiEvent
}