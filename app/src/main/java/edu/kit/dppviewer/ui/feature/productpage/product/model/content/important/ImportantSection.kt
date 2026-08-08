package edu.kit.dppviewer.ui.feature.productpage.product.model.content.important

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import edu.kit.dppviewer.R
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.BaseSection

/**
 * The "Important" section of the product page.
 */
class ImportantSection(entries: List<ImportantCard> = mutableListOf()) :
    BaseSection<ImportantCard>(
        sectionTitle = "Important",
        entries
    ) {

    @Composable
    override fun LoadTitle() {
        sectionTitle = stringResource(R.string.section_title_important)
    }
}
