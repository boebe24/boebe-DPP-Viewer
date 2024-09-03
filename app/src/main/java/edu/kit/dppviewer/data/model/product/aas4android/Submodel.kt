package edu.kit.dppviewer.data.model.product.aas4android

import com.fasterxml.jackson.databind.JsonNode
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.KEY_TO_SUBMODEL_ELEMENT
import edu.kit.dppviewer.data.model.product.aas4android.submodelElement.SubmodelElement
import edu.kit.dppviewer.data.model.product.util.JsonModelUtil
import edu.kit.dppviewer.data.model.product.util.JsonTextUtil


/**
 * This class serves as an alternative to Submodel class in aas4j
 * Data is attained from a JsonNode
 */
class Submodel(dataNode: JsonNode) : DataModel(dataNode) {


    /**
     * a list of all submodel elements contained in the submodel
     */
    val submodelElements: MutableList<SubmodelElement> = mutableListOf()

    /**
     * the display name of this submodel
     */
    val displayName: String = JsonModelUtil().getDisplayNameOrIdShort(dataNode)


    init {

        if (JsonTextUtil().checkNodeHasKey(dataNode, KEY_TO_SUBMODEL_ELEMENT)) {
            val submodelElementsNode = dataNode.get(KEY_TO_SUBMODEL_ELEMENT)
            if (submodelElementsNode.isArray) {
                submodelElementsNode.forEach { submodelElementNode ->
                    submodelElements.add(
                        ModelManager().createSubmodelElement(
                            submodelElementNode
                        )
                    )
                }
            }
        }
    }
}
