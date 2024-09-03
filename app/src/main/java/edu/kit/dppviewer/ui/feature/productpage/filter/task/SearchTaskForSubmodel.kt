package edu.kit.dppviewer.ui.feature.productpage.filter.task

import edu.kit.dppviewer.data.model.product.adapter.SubmodelAdapter
import edu.kit.dppviewer.data.model.product.model.Product


/**
 * A SearchTaskForSubmodel is responsible for find the corresponding SubmodelAdapter
 * with given idPath from a given product
 */
class SearchTaskForSubmodel(idPath: String, product: Product) : SearchTask(idPath, product) {
    override fun getResult(): SubmodelAdapter? {
        return dataProduct.getSubmodelByPath(idPath)
    }
}