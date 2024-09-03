package edu.kit.dppviewer.ui.feature.productpage.product.model.content.important

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.kit.dppviewer.data.model.product.util.FormatConstants.EMPTY_STRING
import edu.kit.dppviewer.ui.feature.productpage.ProductPageNavigationEvent
import edu.kit.dppviewer.ui.feature.productpage.ProductPageUiEvent

/**
 * [ImportantCard] which shows one [ImportantProperty].
 */
class ImportantCardSingleEntry(
    cardName: String = EMPTY_STRING,
    private val property: ImportantProperty = ImportantProperty(),
) : ImportantCard(cardName) {

    /**
     * Content of SingleEntry card is the property value
     */
    @Composable
    override fun CardContent(
        onEvent: (ProductPageUiEvent) -> Unit,
        onNavigationEvent: (ProductPageNavigationEvent) -> Unit,
        innerPadding: PaddingValues,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row {
                SelectionContainer {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = property.value,
                        fontSize = 24.sp,
                    )
                }
            }
        }
    }

    fun getProperty(): ImportantProperty {
        return property
    }

    override fun isEmpty(): Boolean {
        return property.isEmpty()
    }
}