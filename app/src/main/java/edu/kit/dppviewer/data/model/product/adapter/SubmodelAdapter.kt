package edu.kit.dppviewer.data.model.product.adapter

import edu.kit.dppviewer.data.model.product.aas4android.Submodel
import edu.kit.dppviewer.data.model.product.adapter.submodelElement.SubmodelElementAdapter
import edu.kit.dppviewer.data.client.util.AppUtil
import edu.kit.dppviewer.data.model.product.util.IdPathUtil


/**
 * This class models a Submodel
 * It calls methods from models in aas4android
 *
 * It has name, idShort, description and a list of submodel elements adapter
 * It also support searching for a submodel element by path of idShorts
 **/
class SubmodelAdapter(submodel: Submodel) : DatamodelAdapter(submodel) {
    val elementsAbs: List<SubmodelElementAdapter> =
        AppUtil().getAllSubmodelElementAbs(submodel.submodelElements)


    companion object {

        /**
         * get a list of submodel adapters from a list of submodels
         * @param submodels a list of submodels
         * @return a list of submodel adapters
         */
        fun submodelsFromSubmodels(submodels: List<Submodel>): List<SubmodelAdapter> {
            val resultSubmodelAdapters: MutableList<SubmodelAdapter> = ArrayList()
            for (submodel in submodels) {
                resultSubmodelAdapters.add(SubmodelAdapter(submodel))
            }
            return resultSubmodelAdapters
        }
    }

    /**
     * get the submodel element with the correct path of idShorts
     * @param idPath a string, which is a idPath to a submodel element
     * @param isNested a boolean, if the target submodel element is nested
     * @return the found submodel element or null
     */
    override fun getSubmodelElementByIdShort(
        idPath: List<String>,
        isNested: Boolean
    ): SubmodelElementAdapter? {
        var foundElement: SubmodelElementAdapter? = null
        for (element in elementsAbs) {
            if (element.idShort == idPath[0]) {
                foundElement = element
            }
        }

        if (foundElement == null) {
            return null
        }

        return if (IdPathUtil().isLastPath(idPath)) {
            if (foundElement.isNested == isNested) {
                foundElement
            } else {
                null
            }
        } else {
            foundElement.getSubmodelElementByIdShort(
                IdPathUtil().getRestIdPath(idPath),
                isNested
            )
        }


    }

    fun isChildless(): Boolean {
        return elementsAbs.isEmpty()
    }

    fun hasOnlySingleChild(): Boolean {
        return elementsAbs.size == 1
    }

    fun getFirstChild(): SubmodelElementAdapter? {
        if (isChildless()) {
            return null
        }

        return elementsAbs[0]
    }



}
