package edu.kit.dppviewer.ui.feature.productpage.filter.task

import edu.kit.dppviewer.data.model.product.adapter.submodelElement.nested.SubmodelElementNestedAdapter
import edu.kit.dppviewer.data.model.product.model.Product


/**
 * A SearchTask is responsible for find the corresponding SubmodelElementNestedAdapter with given idPath from a given product
 */
class SearchTaskForNestedElement(idPath: String, product: Product) :
    SearchTaskForSubmodelElement(idPath, product) {
    override fun getResult(): SubmodelElementNestedAdapter? {
        return dataProduct.getSubmodelElementByIdPathString(
            idPath,
            true
        ) as SubmodelElementNestedAdapter?
    }
}