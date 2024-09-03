package edu.kit.dppviewer.ui.feature.productpage.product.model.content.general

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import edu.kit.dppviewer.ui.feature.productpage.ProductPageNavigationEvent
import edu.kit.dppviewer.ui.feature.productpage.ProductPageUiEvent
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.BaseProperty

/**
 * Represent one entry of the [GeneralSection].
 */
class GeneralProperty(
    displayName: String,
    value: String
) : BaseProperty(
    displayName,
    value
) {
    /**
     * Overrides the [Render] method of the [BaseProperty] class to make the [displayName] bold.
     */
    @Composable
    override fun Render(
        onEvent: (ProductPageUiEvent) -> Unit,
        onNavigationEvent: (ProductPageNavigationEvent) -> Unit,
        innerPadding: PaddingValues,
    ) {
        Row(
            modifier = Modifier
                .padding(PaddingValues(horizontal = 8.dp, vertical = 4.dp))
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(modifier = Modifier.weight(0.5f)) {
                SelectionContainer {
                    Text(
                        text = displayName, fontWeight = FontWeight.Bold, modifier = Modifier
                            .padding(horizontal = 8.dp)
                    )
                }
            }
            Row(modifier = Modifier.weight(0.5f)) {
                SelectionContainer {
                    Text(
                        text = value, modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .weight(0.5f)
                    )
                }
            }
        }
    }
}