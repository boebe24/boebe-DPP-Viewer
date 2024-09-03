package edu.kit.dppviewer.data.model.product.aas4android.submodelElement

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ArrayNode
import edu.kit.dppviewer.data.model.product.aas4android.ModelManager
import edu.kit.dppviewer.data.model.product.util.JsonTextUtil


/**
 * this class represents a SubmodelElement, which value contains an array of SubmodelElements
 *
 * all Data is stored in a JsonNode
 *
 **/
abstract class SubmodelElementNested(dataNode: JsonNode, childrenNode: ArrayNode) :
    SubmodelElement(dataNode, true) {

    /**
     *  all the SubmodelElements inside
     **/
    val children: List<SubmodelElement> = JsonTextUtil().arrayNodeToList(childrenNode)
        .map { childNode ->
            ModelManager().createSubmodelElement(childNode)
        }


}
