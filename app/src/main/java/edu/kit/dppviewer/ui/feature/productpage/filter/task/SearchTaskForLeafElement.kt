package edu.kit.dppviewer.ui.feature.productpage.filter.task

import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.EMPTY_VALUE_INFORMATION
import edu.kit.dppviewer.data.model.product.adapter.submodelElement.leaf.SubmodelElementLeafAdapter
import edu.kit.dppviewer.data.model.product.model.Product

/**
 * A SearchTask is responsible for find the corresponding SubmodelElementLeafAdapter with given idPath from a given product
 */
class SearchTaskForLeafElement(idPath: String, product: Product) :
    SearchTaskForSubmodelElement(idPath, product) {
    override fun getResult(): SubmodelElementLeafAdapter? {
        val result = dataProduct.getSubmodelElementByIdPathString(
            idPath,
            false
        ) as SubmodelElementLeafAdapter?
            ?: return null

        if (result.entryValueString == EMPTY_VALUE_INFORMATION) {

            return null
        }



        return result
    }
}