package edu.kit.dppviewer.ui.feature.productpage.product.model.content.general

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.kit.dppviewer.R
import edu.kit.dppviewer.ui.feature.productpage.ProductPageNavigationEvent
import edu.kit.dppviewer.ui.feature.productpage.ProductPageUiEvent
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.BaseSection

/**
 * The "General" section of the product page.
 *
 * It holds multiple [GeneralProperty] as entries.
 */
class GeneralSection(entries: List<GeneralProperty> = emptyList()) :
    BaseSection<GeneralProperty>(
        sectionTitle = "General", entries
    ) {


    /**
     * Renders the [GeneralSection] of the product page.
     *
     * It shows the entries in a card.
     */
    @Composable
    override fun Render(
        onEvent: (ProductPageUiEvent) -> Unit,
        onNavigationEvent: (ProductPageNavigationEvent) -> Unit,
        innerPadding: PaddingValues,
    ) {
        LoadTitle()
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = sectionTitle,
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
            )
            OutlinedCard(modifier = Modifier.padding(6.dp)) {
                Spacer(modifier = Modifier.padding(4.dp))
                for (entry in entries) {
                    entry.Render(
                        onEvent = onEvent,
                        onNavigationEvent = onNavigationEvent,
                        innerPadding = innerPadding,
                    )
                }
                Spacer(modifier = Modifier.padding(4.dp))
            }
        }
    }

    @Composable
    override fun LoadTitle() {
        sectionTitle = LocalContext.current.getString(R.string.section_title_general)
    }
}