package edu.kit.dppviewer.ui.feature.productpage.filter.task


import edu.kit.dppviewer.data.model.product.adapter.submodelElement.SubmodelElementAdapter
import edu.kit.dppviewer.data.model.product.model.Product

/**
 * A SearchTaskForSubmodelElement is responsible for find the corresponding SubmodelElementAdapter
 * with given idPath from a given product
 */
abstract class SearchTaskForSubmodelElement(idPath: String, product: Product) :
    SearchTask(idPath, product) {
    abstract override fun getResult(): SubmodelElementAdapter?
}