package edu.kit.dppviewer.ui.feature.productpage

import java.util.UUID

/**
 * Represents screen navigation events that the user can perform on the product page.
 */
sealed interface ProductPageNavigationEvent {
    data object NavigateUp : ProductPageNavigationEvent
    data object EnterRawDataScreen : ProductPageNavigationEvent
    data class EnterChildrenScreen(val parentGroupUUID: UUID) : ProductPageNavigationEvent
}