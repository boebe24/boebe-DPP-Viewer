package edu.kit.dppviewer.ui.feature.productpage.filter.filterItem

import edu.kit.dppviewer.data.model.product.model.Product
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.BaseSection
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.SectionContent


/**
 * This class is used to filter a whole section of a product.
 */
abstract class SectionFilter<T : SectionContent> {

    abstract fun apply(unfilteredProduct: Product): BaseSection<T>
}