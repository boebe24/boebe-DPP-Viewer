package edu.kit.dppviewer.ui.feature.productpage.product.model.content.important

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import edu.kit.dppviewer.data.model.product.util.FormatConstants.EMPTY_STRING
import edu.kit.dppviewer.ui.feature.productpage.ProductPageNavigationEvent
import edu.kit.dppviewer.ui.feature.productpage.ProductPageUiEvent
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.BaseProperty

/**
 * Property which holds important information.
 * Gets displayed on a [ImportantCard].
 */
class ImportantProperty(
    displayName: String = EMPTY_STRING,
    value: String = EMPTY_STRING,
    var unit: String = EMPTY_STRING,
) : BaseProperty(
    displayName,
    value,
) {

    init {
        super.value = "$value $unit"
    }



    @Composable
    override fun Render(
        onEvent: (ProductPageUiEvent) -> Unit,
        onNavigationEvent: (ProductPageNavigationEvent) -> Unit,
        innerPadding: PaddingValues,
    ) {
        Row(
            modifier = Modifier
                .padding(PaddingValues(vertical = 4.dp))
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
        ) {
            Row(modifier = Modifier.weight(0.5f)) {
                SelectionContainer {
                    Text(
                        text = displayName,
                        modifier = Modifier
                            .weight(0.5f)
                    )
                }
            }

            Row(modifier = Modifier.weight(0.5f)) {
                SelectionContainer {
                    Text(
                        text = super.value,
                        modifier = Modifier
                            .weight(1f)
                    )
                }
            }
        }
    }
}