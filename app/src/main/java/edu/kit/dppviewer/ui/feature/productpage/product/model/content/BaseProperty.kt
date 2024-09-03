package edu.kit.dppviewer.ui.feature.productpage.product.model.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.EMPTY_VALUE_INFORMATION
import edu.kit.dppviewer.ui.feature.productpage.ProductPageNavigationEvent
import edu.kit.dppviewer.ui.feature.productpage.ProductPageUiEvent

/**
 * Abstract class representing a property in a product page.
 * It holds a display name and a value.
 *
 * It provides a default implementation for the [Render] method,
 * which renders the property.
 */
abstract class BaseProperty(
    val displayName: String,
    var value: String,
) : SectionContent {
    @Composable
    override fun Render(
        onEvent: (ProductPageUiEvent) -> Unit,
        onNavigationEvent: (ProductPageNavigationEvent) -> Unit,
        innerPadding: PaddingValues,
    ) {
        Row(
            modifier = Modifier
                .padding(PaddingValues(horizontal = 16.dp, vertical = 8.dp))
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(text = displayName)
            Text(text = value)
        }
    }

    override fun isEmpty(): Boolean {
        return if (value == EMPTY_VALUE_INFORMATION) {
            true
        } else {
            (value == "")
        }
    }

}