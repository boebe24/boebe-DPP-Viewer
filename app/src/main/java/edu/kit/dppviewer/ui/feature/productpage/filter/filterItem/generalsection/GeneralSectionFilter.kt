package edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.generalsection

import edu.kit.dppviewer.data.model.product.adapter.submodelElement.leaf.SubmodelElementLeafAdapter
import edu.kit.dppviewer.data.model.product.model.Product
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.SectionFilter
import edu.kit.dppviewer.ui.feature.productpage.filter.task.SearchTaskForLeafElement
import edu.kit.dppviewer.ui.feature.productpage.product.model.ProductType
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.general.GeneralProperty
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.general.GeneralSection


private const val PATH_TO_PRODUCT_TYPE = "DigitalNameplate.ManufacturerProductType"
private const val PATH_TO_PRODUCT_NAME = "DigitalNameplate.ManufacturerProductDesignation"
private const val BATTERY_TYPE_STRING = "Battery"
private const val SMARTPHONE_TYPE_STRING = "Smartphone"
private const val TEXTILE_TYPE_STRING = "Textile"

/**
 * This class is used to filter the whole general section of a product.
 */
class GeneralSectionFilter(private var filterItems: List<GeneralFilterItem>) :
    SectionFilter<GeneralProperty>() {


    /**
     * Apply the filter to the given unfiltered product.
     * @param unfilteredProduct the unfiltered product
     * @return the general section of the filtered product
     */
    override fun apply(unfilteredProduct: Product): GeneralSection {
        val resultSection = GeneralSection()

        for (filterItem in filterItems) {
            val task = SearchTaskForLeafElement(filterItem.idPath, unfilteredProduct)
            if (task.getResult() == null) {
                continue
            }

            val leafAdapter = task.getResult()

            // set up unit
            var unitProperty: SubmodelElementLeafAdapter? = null
            // check for unit path
            if (filterItem.hasUnitPath()) {
                val taskForUnitProperty =
                    SearchTaskForLeafElement(filterItem.unitPath!!, unfilteredProduct)
                unitProperty = taskForUnitProperty.getResult()

            }

            resultSection.addChild(filterItem.apply(leafAdapter!!, unitProperty))


            // update product name and type
            if (filterItem.idPath == PATH_TO_PRODUCT_TYPE) {
                val submodelElementLeafAdapter = task.getResult() ?: continue


                when (submodelElementLeafAdapter.entryValueString) {
                    BATTERY_TYPE_STRING -> unfilteredProduct.productType = ProductType.BATTERY
                    SMARTPHONE_TYPE_STRING -> unfilteredProduct.productType = ProductType.SMARTPHONE
                    TEXTILE_TYPE_STRING -> unfilteredProduct.productType = ProductType.TEXTILE
                    else -> unfilteredProduct.productType = ProductType.OTHER
                }
            } else if (filterItem.idPath == PATH_TO_PRODUCT_NAME) {
                unfilteredProduct.name = task.getResult()!!.entryValueString
            }
        }

        return resultSection
    }

}
