package edu.kit.dppviewer.data.model.product.aas4android

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ArrayNode
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.EMPTY_VALUE_INFORMATION
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.FILE_TYPE
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.INVALID_SUBMODEL_ELEMENT_INFORMATION
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.KEY_TO_MODEL_TYPE
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.KEY_TO_VALUE_NODE
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.MULTI_LANGUAGE_PROPERTY_TYPE
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.PROPERTY_TYPE
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.SUBMODEL_ELEMENT_COLLECTION_TYPE
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.SUBMODEL_ELEMENT_LIST_TYPE
import edu.kit.dppviewer.data.model.product.aas4android.submodelElement.File
import edu.kit.dppviewer.data.model.product.aas4android.submodelElement.MultiLanguageProperty
import edu.kit.dppviewer.data.model.product.aas4android.submodelElement.OtherElement
import edu.kit.dppviewer.data.model.product.aas4android.submodelElement.Property
import edu.kit.dppviewer.data.model.product.aas4android.submodelElement.SubmodelElement
import edu.kit.dppviewer.data.model.product.aas4android.submodelElement.SubmodelElementCollection
import edu.kit.dppviewer.data.model.product.aas4android.submodelElement.SubmodelElementList
import edu.kit.dppviewer.data.model.product.util.JsonModelUtil
import edu.kit.dppviewer.data.model.product.util.JsonTextUtil


/**
 * This class is responsible for creating submodel elements from JsonNode
 */
class ModelManager {


    /**
     * This function creates a submodel element using a dataNode
     * @param dataNode the JsonNode that contains the data of the submodel element
     * @return the submodel element
     */
    fun createSubmodelElement(dataNode: JsonNode): SubmodelElement {

        if (JsonTextUtil().checkNodeHasKey(dataNode, KEY_TO_MODEL_TYPE)
        ) {

            if (!JsonTextUtil().checkNodeHasKey(dataNode, KEY_TO_VALUE_NODE)) {

                // sometimes, known element types might have no "value" key at all
                val modelTypeString = JsonModelUtil().getModelTypeString(dataNode)

                val dataNodeWithoutDisplayName = JsonModelUtil().removeDisplayNameAndDescription(dataNode)

                when (modelTypeString) {
                    PROPERTY_TYPE -> {
                        return Property(dataNode, EMPTY_VALUE_INFORMATION)
                    }
                    SUBMODEL_ELEMENT_COLLECTION_TYPE -> {
                        return SubmodelElementCollection(dataNode)
                    }
                    SUBMODEL_ELEMENT_LIST_TYPE -> {
                        return SubmodelElementList(dataNode)
                    }
                    MULTI_LANGUAGE_PROPERTY_TYPE -> {
                        return MultiLanguageProperty(dataNode)
                    }
                    FILE_TYPE -> {
                        return File(dataNode, EMPTY_VALUE_INFORMATION)
                    }
                }



                return OtherElement(dataNode, EMPTY_VALUE_INFORMATION)
            }


            val valueNode = dataNode.get(KEY_TO_VALUE_NODE)

            val modelTypeString = JsonModelUtil().getModelTypeString(dataNode)


            if (valueNode.isTextual) {


                when (modelTypeString) {
                    PROPERTY_TYPE -> {
                        return Property(
                            dataNode,
                            JsonModelUtil().markEmptyString(valueNode.textValue())
                        )
                    }
                }
            }

            if (valueNode.isArray) {
                when (modelTypeString) {
                    SUBMODEL_ELEMENT_COLLECTION_TYPE -> {
                        return SubmodelElementCollection(dataNode, valueNode as ArrayNode)
                    }

                    SUBMODEL_ELEMENT_LIST_TYPE -> {
                        return SubmodelElementList(dataNode, valueNode as ArrayNode)
                    }

                    MULTI_LANGUAGE_PROPERTY_TYPE -> {
                        return MultiLanguageProperty(dataNode, valueNode)
                    }
                }
            }

            if (modelTypeString == FILE_TYPE) {
                return File(dataNode, valueNode.textValue())
            }

            return OtherElement(dataNode, valueNode.toString())
        }


        throw IllegalArgumentException(INVALID_SUBMODEL_ELEMENT_INFORMATION)


    }
}