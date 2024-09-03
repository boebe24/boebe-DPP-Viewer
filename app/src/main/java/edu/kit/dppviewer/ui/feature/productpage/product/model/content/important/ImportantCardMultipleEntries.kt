package edu.kit.dppviewer.ui.feature.productpage.product.model.content.important

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import edu.kit.dppviewer.data.model.product.util.FormatConstants.EMPTY_STRING
import edu.kit.dppviewer.ui.feature.productpage.ProductPageNavigationEvent
import edu.kit.dppviewer.ui.feature.productpage.ProductPageUiEvent

/**
 * [ImportantCard] which shows multiple [ImportantProperty].
 */
class ImportantCardMultipleEntries(
    cardName: String = EMPTY_STRING,
    val entries: List<ImportantProperty> = emptyList(),
) : ImportantCard(cardName) {


    /**
     * Content of MultipleEntries card are the entries
     */
    @Composable
    override fun CardContent(
        onEvent: (ProductPageUiEvent) -> Unit,
        onNavigationEvent: (ProductPageNavigationEvent) -> Unit,
        innerPadding: PaddingValues,
    ) {
        Column {
            for (entry in entries) {
                entry.Render(
                    onEvent = onEvent,
                    onNavigationEvent = onNavigationEvent,
                    innerPadding = innerPadding,
                )
            }
        }
    }

    override fun isEmpty(): Boolean {
        return entries.isEmpty()
    }
}