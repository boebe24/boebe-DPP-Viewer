package edu.kit.dppviewer.data.model.product.util

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.databind.node.ObjectNode
import edu.kit.dppviewer.data.client.util.UrlUtil
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.EMPTY_ID_INFORMATION
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.EMPTY_MODEL_TYPE_INFORMATION
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.EMPTY_VALUE_INFORMATION
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.KEY_STRING_IN_SHELL_NODE
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.KEY_TO_DESCRIPTION
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.KEY_TO_DISPLAY_NAME
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.KEY_TO_ID_SHORT
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.KEY_TO_LANGUAGE
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.KEY_TO_MODEL_TYPE
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.KEY_TO_SUBMODEL_ELEMENT
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.KEY_TO_SUBMODELS_IN_SHELL_NODE
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.KEY_TO_TEXT
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.KEY_TO_VALUE_NODE
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.MODEL_TYPE_VALUE_SUBMODEL
import edu.kit.dppviewer.data.model.product.util.FormatConstants.EMPTY_STRING
import edu.kit.dppviewer.data.model.product.util.SettingConstants.USER_LANGUAGE


/**
 * functions here deal with json nodes with knowledge in aas model
 * they do not use internet connection
 */
class JsonModelUtil {


    /**
     * This class contains some utility functions to deal with json nodes
     * it deals only with jsonNodes and strings(urls), process no internet connection
     */
    fun getSubmodelUrlsFromShell(shellNode: JsonNode?, shellUrl: String): List<String> {
        val modelIds = getSubmodelIdsFromShellNode(shellNode)
        val modelUrls = mutableListOf<String>()
        for (modelId in modelIds) {
            modelUrls.add(UrlUtil().getModelUrlFromShellUrlUndModelId(shellUrl, modelId))
        }


        return modelUrls
    }

    private fun getSubmodelIdsFromShellNode(shellNode: JsonNode?): List<String> {
        val modelIds = mutableListOf<String>()

        if (!JsonTextUtil().checkNodeHasKey(shellNode, KEY_TO_SUBMODELS_IN_SHELL_NODE)) {
            return modelIds
        }


        val modelPartNode = shellNode!!.get(KEY_TO_SUBMODELS_IN_SHELL_NODE) ?: return modelIds

        if (!modelPartNode.isArray) {
            return modelIds
        }


        val keysNode =
            JsonTextUtil().getEachInChildren(modelPartNode as ArrayNode, KEY_STRING_IN_SHELL_NODE)


        for (keyNode in keysNode) {

            if (!keyNode.isArray) {
                continue
            }

            val keyNodeItem =
                JsonTextUtil().arrayNodeGetOne(keyNode as ArrayNode)
            if (JsonTextUtil().checkNodeHasKey(keyNodeItem, KEY_TO_VALUE_NODE)) {
                val valueNode = keyNodeItem.get(KEY_TO_VALUE_NODE) ?: continue


                if (valueNode.isTextual) {

                    modelIds.add(valueNode.textValue())
                }
            }
        }
        return modelIds
    }


    /**
     * check if the node is a textual value to key KEY_TO_VALUE_OF_MODEL
     */
    fun checkHasTextualValue(node: JsonNode): Boolean {
        return JsonTextUtil().checkNodeHasTextualAtKey(node, KEY_TO_VALUE_NODE)
    }


    /**
     * get the display name of a node as a string
     * If the node has no display name, return the idShort of the node
     * @param node a node that is a submodel element node or submodel node
     */
    fun getDisplayNameOrIdShort(node: JsonNode): String {
        if (JsonTextUtil().checkNodeHasKey(node, KEY_TO_DISPLAY_NAME)) {
            val displayNameNode = node.get(KEY_TO_DISPLAY_NAME)
            val displayNameString = selectStringFromMultiLanguageNode(displayNameNode)
            if (displayNameString != EMPTY_STRING) {
                return displayNameString
            }
        }
        return getIdShortFromNode(node)
    }

    /**
     * get the idShort of a node as a string
     * If the node has no idShort, return an empty string
     * @param node a node that is a submodel element node or submodel node
     */
    fun getIdShortFromNode(node: JsonNode): String {
        if (JsonTextUtil().checkNodeHasKey(node, KEY_TO_ID_SHORT))
            if (node.get(KEY_TO_ID_SHORT).isTextual) {
                return node.get(KEY_TO_ID_SHORT).textValue()
            }
        return EMPTY_ID_INFORMATION
    }

    /**
     * get the description of a node as a string
     * If the node has no description, return an empty string
     * @param node a node that is a submodel element node or submodel node
     */
    fun getDescriptionFromNode(node: JsonNode): String {
        if (JsonTextUtil().checkNodeHasKey(
                node,
                KEY_TO_DESCRIPTION
            ) && node.get(KEY_TO_DESCRIPTION).isArray
        ) {
            return selectStringFromMultiLanguageNode(node.get(KEY_TO_DESCRIPTION), USER_LANGUAGE)
        }
        return EMPTY_STRING
    }


    /**
     * select the string from a multi language node with a specific language
     * @param multiLanguageNode a node that contains a group of texts in different languages
     * @param usrLanguage the language that the user wants to get the text in
     */
    fun selectStringFromMultiLanguageNode(
        multiLanguageNode: JsonNode,
        usrLanguage: String
    ): String {
        if (multiLanguageNode.isEmpty) {
            return EMPTY_STRING
        }

        if (!multiLanguageNode.isArray) {
            return EMPTY_STRING
        }

        val nameNodes = JsonTextUtil().arrayNodeToList(multiLanguageNode as ArrayNode)

        var nameString = EMPTY_STRING
        val nameMaps = mutableMapOf<String, String>()

        for (nameNode in nameNodes) {

            if (nameNode.hasNonNull(KEY_TO_LANGUAGE) && nameNode.hasNonNull(KEY_TO_TEXT)) {
                if (nameNode.get(KEY_TO_LANGUAGE).isTextual && nameNode.get(KEY_TO_TEXT).isTextual) {
                    nameMaps[nameNode.get(KEY_TO_LANGUAGE).textValue()] =
                        nameNode.get(KEY_TO_TEXT).textValue()
                }
            }
        }

        if (nameMaps.containsKey(usrLanguage)) {
            nameString = nameMaps[usrLanguage].toString()
        } else {
            if (nameMaps.isNotEmpty()) {
                nameString = nameMaps.values.first()
            }
        }

        return nameString

    }

    /**
     * select the string from a multi language node with default language
     * @param multiLanguageNode a node that contains a group of texts in different languages
     */
    fun selectStringFromMultiLanguageNode(multiLanguageNode: JsonNode): String {

        return (selectStringFromMultiLanguageNode(multiLanguageNode, USER_LANGUAGE))
    }


    /**
     * get the value of a leaf submodel element node as a string
     * @param leafNode a node that is a leaf node of a submodel element
     */
    fun getValueFromSubmodelElementLeafNode(leafNode: JsonNode): String {
        return if (!JsonTextUtil().checkNodeHasTextualAtKey(leafNode, KEY_TO_VALUE_NODE)) {
            EMPTY_VALUE_INFORMATION
        } else {
            markEmptyString(leafNode.get(KEY_TO_VALUE_NODE).textValue())
        }

    }

    fun markEmptyString(textValue: String): String {
        return if (textValue == EMPTY_STRING) {
            EMPTY_VALUE_INFORMATION
        } else {
            textValue
        }

    }

    /**
     * get the children nodes of a nested submodel element node
     * @param nestedNode a node that is a nested submodel element node
     */
    fun getChildrenNodeFromSubmodelElementNestedNode(nestedNode: JsonNode): List<JsonNode> {

        if (JsonTextUtil().checkNodeHasKey(nestedNode, KEY_TO_VALUE_NODE)) {
            val valueNode = nestedNode.get(KEY_TO_VALUE_NODE)
            if (valueNode != null) {
                if (valueNode.isArray) {
                    return JsonTextUtil().arrayNodeToList(valueNode)
                }
            }
        }

        return listOf()
    }


    /**
     * get the model type of a node as a string
     */
    fun getModelTypeString(node: JsonNode): String {

        if (!JsonTextUtil().checkNodeHasTextualAtKey(node, KEY_TO_MODEL_TYPE)) {
            return EMPTY_MODEL_TYPE_INFORMATION
        }

        return node.get(KEY_TO_MODEL_TYPE).textValue()
    }


    /**
     * check if the node is a submodel
     */
    fun checkModelTypeSubmodel(node: JsonNode): Boolean {
        if (!JsonTextUtil().checkValueAtKey(node, KEY_TO_MODEL_TYPE, MODEL_TYPE_VALUE_SUBMODEL)) {
            return false
        }

        if (!JsonTextUtil().checkNodeHasKey(node, KEY_TO_ID_SHORT)) {
            return false
        }

        return JsonTextUtil().checkNodeHasKey(node, KEY_TO_SUBMODEL_ELEMENT)
    }

    /**
     * copy a code of the existing node,
     * but remove the whole displayName and description key,value pair
     */
    fun removeDisplayNameAndDescription(node: JsonNode): JsonNode {
        val objectMapper = ObjectMapper()
        val copiedNode: JsonNode = objectMapper.readTree(objectMapper.writeValueAsString(node))
        if (copiedNode.has(KEY_TO_DISPLAY_NAME)) {
            (copiedNode as ObjectNode).remove(KEY_TO_DISPLAY_NAME)
        }

        if (copiedNode.has(KEY_TO_DESCRIPTION)) {
            (copiedNode as ObjectNode).remove(KEY_TO_DESCRIPTION)
        }
        return copiedNode
    }


}