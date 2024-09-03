package edu.kit.dppviewer.data.model.product.model


import edu.kit.dppviewer.data.model.product.aas4android.AssetAdministrationShell
import edu.kit.dppviewer.data.model.product.adapter.SubmodelAdapter
import edu.kit.dppviewer.data.model.product.adapter.submodelElement.SubmodelElementAdapter
import edu.kit.dppviewer.data.model.product.util.IdPathUtil
import edu.kit.dppviewer.ui.feature.productpage.product.model.ProductType


/**
 * Represent the product
 * @param shellModel the AssetAdministrationShell object that contains submodels information
 */
open class Product(shellModel: AssetAdministrationShell) {
    var productType: ProductType = ProductType.OTHER
    var name: String = shellModel.displayName
    var idShort: String = shellModel.idShort
    var submodelAdapters: List<SubmodelAdapter>? = null


    init {
        this.submodelAdapters =
            SubmodelAdapter.submodelsFromSubmodels(shellModel.submodels)
    }


    /**
     * get the submodel element with the correct idShort
     * @param idShort a string, which is a idPath to a submodel element
     * @return the found submodel element or null
     */
    fun getSubmodelElementByIdPathString(
        idShort: String,
        isNested: Boolean
    ): SubmodelElementAdapter? {
        val submodelElementIdPath = IdPathUtil().breakIdPath(idShort)

        return getSubmodelElementByIdPathString(submodelElementIdPath, isNested)

    }


    private fun getSubmodelElementByIdPathString(
        idPath: List<String>,
        isNested: Boolean
    ): SubmodelElementAdapter? {
        if (!IdPathUtil().isSubmodelElementPath(idPath)) {
            return null
        }

        val submodel = getSubmodelByPath(IdPathUtil().getThisId(idPath)) ?: return null

        val restPath = IdPathUtil().getRestIdPath(idPath)

        return submodel.getSubmodelElementByIdShort(restPath, isNested)
    }

    /**
     * get the submodel with the correct idShort
     * @param idShort the path of the submodel
     * @return the submodel
     */
    fun getSubmodelByPath(idShort: String): SubmodelAdapter? {
        val submodelIdPath = IdPathUtil().breakIdPath(idShort)

        if (!IdPathUtil().isSubmodelPath(submodelIdPath)) {
            return null
        }

        for (submodel in submodelAdapters!!) {
            if (submodel.idShort == idShort) {
                return submodel
            }
        }
        return null

    }


}
