package edu.kit.dppviewer.ui.feature.productpage.product.model.content

import edu.kit.dppviewer.ui.feature.productpage.product.model.Renderable

/**
 * Content of [BaseSection].
 */
interface SectionContent : Renderable {
    fun isEmpty(): Boolean
}