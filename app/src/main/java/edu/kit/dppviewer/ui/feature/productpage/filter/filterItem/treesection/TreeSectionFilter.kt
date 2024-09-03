package edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.treesection

import edu.kit.dppviewer.data.model.product.model.Product
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.SectionFilter
import edu.kit.dppviewer.ui.feature.productpage.filter.task.SearchTaskForSubmodel
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.tree.ITreeEntry
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.tree.TreeSection


/**
 * This class is used to filter the whole other section of a product.
 */
class TreeSectionFilter(private var filterItems: List<TreeGroupForSubmodelFilterItem> = mutableListOf()) :
    SectionFilter<ITreeEntry>() {


    /**
     * Apply the filter to the given unfiltered product and generate the whole other section.
     * @param unfilteredProduct the unfiltered product
     * @return the other section of the filtered product
     */
    override fun apply(unfilteredProduct: Product): TreeSection {

        val resultSection = TreeSection()

        if (filterItems.isEmpty()) {
            // empty filter for other section:
            // all submodels be displayed
            val submodelLists = unfilteredProduct.submodelAdapters ?: return resultSection



            for (submodel in submodelLists) {
                resultSection.addChild(buildTreeGroup(submodel))
            }


        } else {

            for (submodelFilterItem in filterItems) {
                resultSection.addChild(
                    submodelFilterItem
                        .apply(
                            SearchTaskForSubmodel(submodelFilterItem.submodelId, unfilteredProduct)
                                .getResult()
                        )
                )
            }

        }
        return resultSection
    }
}

