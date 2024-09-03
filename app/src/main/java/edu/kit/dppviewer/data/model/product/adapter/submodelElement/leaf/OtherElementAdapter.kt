package edu.kit.dppviewer.data.model.product.adapter.submodelElement.leaf

import edu.kit.dppviewer.data.model.product.aas4android.submodelElement.OtherElement
import edu.kit.dppviewer.data.client.util.AppUtil


/**
 * It represents an unrecognised type of SubmodelElement.
 * It is a type of SubmodelElementLeaf
 *
 * content of this class is a OtherElement class in aas4android
 *
 **/
class OtherElementAdapter(element: OtherElement) :
    SubmodelElementLeafAdapter(element) {
    private val submodelElementOther = element


    /**
     * return whole data as a string
     */
    override fun toString(): String {
        return AppUtil().getStringOfOtherSubmodelElement(submodelElementOther)
    }
}
