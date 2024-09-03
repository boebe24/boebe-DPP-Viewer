package edu.kit.dppviewer.data.model.product.aas4android.submodelElement


import com.fasterxml.jackson.databind.JsonNode


/**
 * represents a File
 * It is a type of SubmodelElementLeaf
 * value of this element is a url to a file
 *
 * This class serves as an alternative to File class in aas4j
 * all Data is stored in a JsonNode
 **/
class File(dataNode: JsonNode, valueString: String) :
    SubmodelElementLeaf(dataNode, valueString) {

    override fun getValueAsString(): String {

        return super.valueString
    }
}