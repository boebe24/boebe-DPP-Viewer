package edu.kit.dppviewer.data.model.product.aas4android.submodelElement

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ArrayNode
import edu.kit.dppviewer.data.model.product.util.JsonTextUtil

/**
 * represents a List of SubmodelElements.
 * It is a type of SubmodelElementNested
 * value of this element is a array of submodel elements
 *
 * This class serves as an alternative to SubmodelElementList class in aas4j
 *
 * all Data is stored in a JsonNode
 **/
class SubmodelElementList(dataNode: JsonNode, childrenNode: ArrayNode = JsonTextUtil().getEmptyArrayNode()) :
    SubmodelElementNested(dataNode, childrenNode)