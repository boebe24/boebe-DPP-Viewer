package edu.kit.dppviewer.ui.feature.productpage.product.model.content.tree

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import edu.kit.dppviewer.R

class EverythingSection(entries: List<ITreeEntry> = mutableListOf()) : TreeSection(entries) {



    @Composable
    override fun LoadTitle() {
        sectionTitle = LocalContext.current.getString(R.string.section_title_everything)
    }
}