package edu.kit.dppviewer.data.model.product.aas4android.submodelElement

import com.fasterxml.jackson.databind.JsonNode
import edu.kit.dppviewer.data.model.product.util.FormatConstants.EMPTY_STRING

/**
 * this class represents a SubmodelElement, which value would be viewed as a textual value
 *
 **/
abstract class SubmodelElementLeaf(dataNode: JsonNode, var valueString: String) :
    SubmodelElement(dataNode, false) {

    abstract fun getValueAsString(): String

    constructor(dataNode: JsonNode) : this(dataNode, EMPTY_STRING)
}