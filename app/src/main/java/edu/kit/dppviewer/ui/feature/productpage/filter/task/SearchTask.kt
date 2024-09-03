package edu.kit.dppviewer.ui.feature.productpage.filter.task

import edu.kit.dppviewer.data.model.product.adapter.DatamodelAdapter
import edu.kit.dppviewer.data.model.product.model.Product


/**
 * A SearchTask is responsible for find the corresponding DatamodelAdapter for a given idPath from a given product
 */
abstract class SearchTask(val idPath: String, val dataProduct: Product) {

    abstract fun getResult(): DatamodelAdapter?


}