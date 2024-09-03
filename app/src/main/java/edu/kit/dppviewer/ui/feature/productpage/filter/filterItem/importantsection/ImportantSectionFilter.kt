package edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.importantsection

import edu.kit.dppviewer.data.model.product.adapter.submodelElement.leaf.SubmodelElementLeafAdapter
import edu.kit.dppviewer.data.model.product.model.Product
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.SectionFilter
import edu.kit.dppviewer.ui.feature.productpage.filter.task.SearchTaskForLeafElement
import edu.kit.dppviewer.ui.feature.productpage.filter.task.SearchTaskForNestedElement
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.important.ImportantCard
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.important.ImportantSection

/**
 * This class is used to filter the whole important section of a product.
 */
class ImportantSectionFilter(private var filterItems: List<ImportantCardFilterItem>) :
    SectionFilter<ImportantCard>() {


    /**
     * Apply the filter to the given unfiltered product.
     * @param unfilteredProduct the unfiltered product
     * @return the important section of the filtered product
     */
    override fun apply(unfilteredProduct: Product): ImportantSection {

        val importantCards = mutableListOf<ImportantCard>()
        val importantSection = ImportantSection()
        for (filterItem in filterItems) {
            if (filterItem is ImportantSingleEntryCardFilterItem) {

                // set up unit
                var unitProperty: SubmodelElementLeafAdapter? = null
                // check for unit path
                if (filterItem.hasUnitPath()) {
                    val taskForUnitProperty =
                        SearchTaskForLeafElement(filterItem.unitPath!!, unfilteredProduct)
                    unitProperty = taskForUnitProperty.getResult()
                }

                importantSection.addChild(
                    filterItem.apply(
                        SearchTaskForLeafElement(
                            filterItem.idPath,
                            unfilteredProduct
                        ).getResult(),
                        unitProperty
                    )
                )






            } else if (filterItem is ImportantMultipleEntryCardFromNestedElementFilterItem) {

                importantSection.addChild(
                    filterItem.apply(
                        SearchTaskForNestedElement(
                            filterItem.idPath,
                            unfilteredProduct
                        ).getResult()!!
                    )
                )

            } else if (filterItem is ImportantMultipleEntryCardFromPathListFilterItem) {

                val foundLeafElements = mutableListOf<SubmodelElementLeafAdapter>()

                for (idPath in filterItem.idPathsListToLeaf) {
                    foundLeafElements.add(
                        SearchTaskForLeafElement(
                            idPath,
                            unfilteredProduct
                        ).getResult()!!
                    )
                }

                if (foundLeafElements.isNotEmpty()) {
                    val card = filterItem.apply(foundLeafElements)
                    importantSection.addChild(card)
                }

            }


        }

        return importantSection
    }
}

