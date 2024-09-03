package edu.kit.dppviewer.data.model.product.adapter.submodelElement.leaf

import edu.kit.dppviewer.data.model.product.aas4android.submodelElement.SubmodelElementLeaf
import edu.kit.dppviewer.data.model.product.adapter.submodelElement.SubmodelElementAdapter

/**
 * It represents a SubmodelElementLeaf
 * It is a type of SubmodelElementAdapter
 * It contains a SubmodelElementLeaf as content
 * It no longer contains submodel elements adapters  inside
 * @param element content of this class is a SubmodelElementLeaf class in aas4android
 **/
abstract class SubmodelElementLeafAdapter(element: SubmodelElementLeaf) :
    SubmodelElementAdapter(element) {
    var entryValueString: String = element.getValueAsString()


    /**
     * Returns submodel element with correct idPath
     *
     * In a leaf element, there is no longer submodel elements inside
     * so this method will always return null
     * @param idPath a string, which is a idPath to a submodel element
     * @return null because there is no descendant inside
     */
    override fun getSubmodelElementByIdShort(
        idPath: List<String>,
        isNested: Boolean
    ): SubmodelElementAdapter? {
        return null
    }


}
