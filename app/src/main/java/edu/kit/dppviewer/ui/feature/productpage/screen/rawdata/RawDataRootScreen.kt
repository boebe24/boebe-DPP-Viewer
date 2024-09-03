package edu.kit.dppviewer.ui.feature.productpage.screen.rawdata

import androidx.compose.runtime.Composable
import edu.kit.dppviewer.ui.feature.productpage.ProductPageNavigationEvent
import edu.kit.dppviewer.ui.feature.productpage.ProductPageUiEvent
import edu.kit.dppviewer.ui.feature.productpage.ProductPageUiState
import edu.kit.dppviewer.ui.platform.components.LoadingScreen

/**
 * Screen for displaying the everythingSection of a FilteredProduct.
 *
 * Can´t reuse the OtherGroupRootScreen, because OtherSection contains a List, so there´s no single group UUID to pass.
 */
@Composable
fun RawDataRootScreen(
    uiState: ProductPageUiState,
    onEvent: (ProductPageUiEvent) -> Unit,
    onNavigationEvent: (ProductPageNavigationEvent) -> Unit,
) {
    when (uiState) {
        is ProductPageUiState.Loading -> {
            LoadingScreen(onNavigationUp = { onNavigationEvent(ProductPageNavigationEvent.NavigateUp) })
        }

        is ProductPageUiState.Success -> {
            RawDataSuccessScreen(
                uiState = uiState,
                onEvent = onEvent,
                onNavigationEvent = onNavigationEvent,
            )
        }
    }
}