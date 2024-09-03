package edu.kit.dppviewer.data.model.product.aas4android.submodelElement

import com.fasterxml.jackson.databind.JsonNode
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.EMPTY_VALUE_INFORMATION
import edu.kit.dppviewer.data.model.product.util.JsonModelUtil


/**
 *
 * This class models an submodel element which type is not one of our defined types
 *
 * all Data is stored in a JsonNode
 *
 **/
class OtherElement(dataNode: JsonNode, valueString: String) :
    SubmodelElementLeaf(dataNode, valueString) {

        init {
            if (valueString == EMPTY_VALUE_INFORMATION) {
                println("empty other element init")
                println("idShort: ${this.idShort}")
                super.valueString =  JsonModelUtil().removeDisplayNameAndDescription(dataNode).toPrettyString()
            }
        }

    override fun getValueAsString(): String {
        return super.valueString
    }
}