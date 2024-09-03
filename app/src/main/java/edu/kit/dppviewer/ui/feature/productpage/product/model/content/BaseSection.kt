package edu.kit.dppviewer.ui.feature.productpage.product.model.content

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.kit.dppviewer.ui.feature.productpage.ProductPageNavigationEvent
import edu.kit.dppviewer.ui.feature.productpage.ProductPageUiEvent
import edu.kit.dppviewer.ui.feature.productpage.product.model.Renderable

/**
 * Abstract class for all sections in the product page.
 *
 * It provides a default implementation for the Render method,
 * which renders the section title and all entries.
 */
abstract class BaseSection<T : SectionContent>(
    var sectionTitle: String,
    open var entries: List<T>,
) : Renderable {

    @Composable
    override fun Render(
        onEvent: (ProductPageUiEvent) -> Unit,
        onNavigationEvent: (ProductPageNavigationEvent) -> Unit,
        innerPadding: PaddingValues
    ) {
        LoadTitle()
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = sectionTitle,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
            )
            for (entry in entries) {
                Box(
                    modifier = Modifier.padding(6.dp)
                ) {
                    entry.Render(
                        onEvent = onEvent,
                        onNavigationEvent = onNavigationEvent,
                        innerPadding = innerPadding,
                    )
                }
            }
        }
    }

    @Composable
    abstract fun LoadTitle()


    fun addChild(child: T) {
        if (!child.isEmpty()) {
            val result = entries.toMutableList()
            result.add(child)
            entries = result.toList()
        }

    }

    fun isEmpty(): Boolean {
        return entries.isEmpty()
    }
}