package edu.kit.dppviewer.ui.feature.productpage.product.model.content.important

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import edu.kit.dppviewer.ui.feature.productpage.ProductPageNavigationEvent
import edu.kit.dppviewer.ui.feature.productpage.ProductPageUiEvent
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.SectionContent

/**
 * Represents one entry of the [ImportantSection].
 */
abstract class ImportantCard(private val cardName: String) : SectionContent {

    /**
     * Renders the card.
     * Includes the card name and content
     */
    @Composable
    override fun Render(
        onEvent: (ProductPageUiEvent) -> Unit,
        onNavigationEvent: (ProductPageNavigationEvent) -> Unit,
        innerPadding: PaddingValues,
    ) {
        OutlinedCard {
            Column(
                modifier = Modifier.padding(PaddingValues(horizontal = 16.dp, vertical = 8.dp)),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.padding(2.dp))
                if (cardName.isNotEmpty()) {
                    Row(modifier = Modifier.align(Alignment.Start)) {
                        SelectionContainer {
                            Text(
                                text = cardName,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                    Spacer(modifier = Modifier.padding(2.dp))
                }
                CardContent(
                    onEvent = onEvent,
                    onNavigationEvent = onNavigationEvent,
                    innerPadding = innerPadding,
                )
                Spacer(modifier = Modifier.padding(2.dp))
            }
        }
    }

    /**
     * Content is displayed inside of the card.
     */
    @Composable
    protected abstract fun CardContent(
        onEvent: (ProductPageUiEvent) -> Unit,
        onNavigationEvent: (ProductPageNavigationEvent) -> Unit,
        innerPadding: PaddingValues
    )

    abstract override fun isEmpty(): Boolean
}