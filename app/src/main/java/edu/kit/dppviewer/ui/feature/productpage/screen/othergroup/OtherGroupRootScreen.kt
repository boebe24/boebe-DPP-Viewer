package edu.kit.dppviewer.ui.feature.productpage.screen.othergroup

import androidx.compose.runtime.Composable
import edu.kit.dppviewer.ui.feature.productpage.ProductPageNavigationEvent
import edu.kit.dppviewer.ui.feature.productpage.ProductPageUiEvent
import edu.kit.dppviewer.ui.feature.productpage.ProductPageUiState
import edu.kit.dppviewer.ui.platform.components.LoadingScreen

/**
 * Screen for displaying the children of one [edu.kit.dppviewer.ui.feature.productpage.product.model.content.tree.TreeGroup].
 */
@Composable
fun OtherGroupRootScreen(
    uiState: ProductPageUiState,
    groupUUID: String,
    onEvent: (ProductPageUiEvent) -> Unit,
    onNavigationEvent: (ProductPageNavigationEvent) -> Unit,
) {
    when (uiState) {
        is ProductPageUiState.Loading -> {
            LoadingScreen(onNavigationUp = { onNavigationEvent(ProductPageNavigationEvent.NavigateUp) })
        }

        is ProductPageUiState.Success -> {
            OtherGroupSuccessScreen(
                uiState = uiState,
                groupUUID = groupUUID,
                onEvent = onEvent,
                onNavigationEvent = onNavigationEvent,
            )
        }
    }
}