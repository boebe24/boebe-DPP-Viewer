package edu.kit.dppviewer.ui.feature.productpage.screen.main

import androidx.compose.runtime.Composable
import edu.kit.dppviewer.ui.feature.productpage.ProductPageNavigationEvent
import edu.kit.dppviewer.ui.feature.productpage.ProductPageUiEvent
import edu.kit.dppviewer.ui.feature.productpage.ProductPageUiState
import edu.kit.dppviewer.ui.platform.components.LoadingScreen

/**
 * The main screen of the product page.
 */
@Composable
fun ProductPageRootScreen(
    uiState: ProductPageUiState,
    onEvent: (ProductPageUiEvent) -> Unit,
    onNavigationEvent: (ProductPageNavigationEvent) -> Unit,
) {
    when (uiState) {
        is ProductPageUiState.Loading -> {
            LoadingScreen(onNavigationUp = { onNavigationEvent(ProductPageNavigationEvent.NavigateUp) })
        }

        is ProductPageUiState.Success -> {
            ProductPageSuccessScreen(
                uiState = uiState,
                onEvent = onEvent,
                onNavigationEvent = onNavigationEvent
            )
        }
    }
}