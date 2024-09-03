package edu.kit.dppviewer.data.model.product.aas4android.submodelElement

import com.fasterxml.jackson.databind.JsonNode
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.KEY_TO_VALUE_NODE
import edu.kit.dppviewer.data.model.product.aas4android.DataModel

/**
 * This class serves as an alternative to SubmodelElement class in aas4j
 * all data is stored in a JsonNode
 **/

abstract class SubmodelElement(dataNode: JsonNode, var isNested: Boolean) :
    DataModel(dataNode) {


    /**
     * valueNode contains all data of the SubmodelElement
     **/
    val valueNode: JsonNode? = dataNode.get(KEY_TO_VALUE_NODE)


}