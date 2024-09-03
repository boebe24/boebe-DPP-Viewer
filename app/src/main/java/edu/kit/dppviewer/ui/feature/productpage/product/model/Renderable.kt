package edu.kit.dppviewer.ui.feature.productpage.product.model

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import edu.kit.dppviewer.ui.feature.productpage.ProductPageNavigationEvent
import edu.kit.dppviewer.ui.feature.productpage.ProductPageUiEvent

/**
 * Represents a renderable object, which can be displayed on the screen.
 *
 * Implemented by the components of a [FilteredProduct].
 */
interface Renderable {

    /**
     * Renders the object on the screen.
     */
    @Composable
    fun Render(
        onEvent: (ProductPageUiEvent) -> Unit,
        onNavigationEvent: (ProductPageNavigationEvent) -> Unit,
        innerPadding: PaddingValues,
    )
}