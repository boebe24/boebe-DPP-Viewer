package edu.kit.dppviewer.ui.feature.productpage.product.model.content.tree

import edu.kit.dppviewer.ui.feature.productpage.product.model.content.SectionContent

/**
 * Represents one entry of the [TreeSection].
 *
 * Component part of the composite design pattern.
 */
interface ITreeEntry : SectionContent {
    fun flatten()

}