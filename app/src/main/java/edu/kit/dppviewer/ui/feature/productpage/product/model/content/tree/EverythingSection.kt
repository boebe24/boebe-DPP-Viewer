package edu.kit.dppviewer.ui.feature.productpage.product.model.content.tree

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import edu.kit.dppviewer.R

class EverythingSection(entries: List<ITreeEntry> = mutableListOf()) : TreeSection(entries) {



    @Composable
    override fun LoadTitle() {
        sectionTitle = stringResource(R.string.section_title_everything)
    }
}