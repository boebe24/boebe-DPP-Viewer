package edu.kit.dppviewer.data.model.product.adapter.submodelElement.nested

import edu.kit.dppviewer.data.model.product.aas4android.submodelElement.SubmodelElementNested
import edu.kit.dppviewer.data.model.product.adapter.submodelElement.SubmodelElementAdapter
import edu.kit.dppviewer.data.client.util.AppUtil
import edu.kit.dppviewer.data.model.product.util.IdPathUtil

/**
 * This class models a SubmodelElementNested Adapter
 * It calls methods from models in aas4android
 *
 * It has name, idShort, description and a list of submodel elements adapter as children
 * It also support searching for a submodel element by path of idShorts
 *
 * @param element a submodel element nested.
 * it contains data of the submodel element and provide basic functions and attributes
 **/
abstract class SubmodelElementNestedAdapter(element: SubmodelElementNested) :
    SubmodelElementAdapter(element) {
    private val submodelElementNested = element

    /**
     * children should be a list of SubmodelElementAdapter
     */
    var children: List<SubmodelElementAdapter>? =
        AppUtil().getAllSubmodelElementAbs(submodelElementNested.children)



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

        if (children == null) {
            return null
        }

        if (children!!.isEmpty()) {
            return null
        }

        for (element in children!!) {
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
        return if (children == null) {
            true
        } else {
            children!!.isEmpty()
        }
    }




}
