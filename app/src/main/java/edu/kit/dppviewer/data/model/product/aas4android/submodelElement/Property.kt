package edu.kit.dppviewer.data.model.product.aas4android.submodelElement

import com.fasterxml.jackson.databind.JsonNode

/**
 * represents a Property.
 *  It is a type of SubmodelElementLeaf
 *  value of this element should be textual
 *
 * This class serves as an alternative to Property class in aas4j
 * Data is attained from a JsonNode
 **/
class Property(dataNode: JsonNode, valueString: String) :
    SubmodelElementLeaf(dataNode, valueString) {

    /**
     * value of this property as a string
     **/

    override fun getValueAsString(): String {
        return valueString
    }
}