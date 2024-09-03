package edu.kit.dppviewer.data.model.product.util

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.databind.node.NullNode


private const val EMPTY_ARRAY_STRING = "[]"
/**
 * functions here only process json node and strings
 * they do not use internet connection
 * they do not care about aas model
 *
 * there may be existing functions in jackson library or better ways to implement these functions
 *
 */
class JsonTextUtil {


    fun getEmptyJsonNode(): JsonNode {
        return ObjectMapper().createObjectNode()
    }

    fun getEmptyArrayNode(): ArrayNode {
        return JsonTextUtil().generateJsonNode(EMPTY_ARRAY_STRING) as ArrayNode
    }
    /**
     * generate a JsonNode from a jsonString
     * @param jsonString the string to be converted to JsonNode
     * @return the JsonNode generated from the string
     */
    fun generateJsonNode(jsonString: String): JsonNode? {
        val objectMapper = ObjectMapper()
        return objectMapper.readTree(jsonString)
    }


    /**
     * If the given node is an arrayNode, return the first element of the arrayNode
     * @param arrayNode the node that could be an arrayNode
     * @return the first element of the arrayNode
     */
    fun arrayNodeGetOne(arrayNode: ArrayNode?): JsonNode {
        if (arrayNode == null) {
            return NullNode.getInstance()
        }

        return if (arrayNode.size() >= 1) {
            arrayNode.get(0)
        } else {
            NullNode.getInstance()
        }
    }

    /**
     * convert an arrayNode to a list of JsonNode
     * @param arrayNode the node that could be an arrayNode
     * @return a list of JsonNode
     */
    fun arrayNodeToList(arrayNode: JsonNode?): List<JsonNode> {
        if (arrayNode == null) {
            return mutableListOf()
        }

        val list = mutableListOf<JsonNode>()
        if (!arrayNode.isArray) {
            return mutableListOf()
        }


        for (node in arrayNode) {
            if (node != null) {
                if (!node.isEmpty) {
                    list.add(node)
                }

            }

        }

        return list
    }


    /**
     * given an arrayNode, search for a key in each of its children
     * return the found values as a list of nodes
     * @param node the node that could be a ArrayNode
     * @param key the key that each child might have
     * @return the value of the key
     */
    fun getEachInChildren(node: ArrayNode?, key: String): List<JsonNode> {
        if (node == null) {
            return mutableListOf()
        }

        val list = mutableListOf<JsonNode>()
        for (child in node) {
            if (child == null) {
                continue
            }

            // please always get value from a key like this: check hasNonNull first.
            if (child.hasNonNull(key)) {
                list.add(child.get(key))
            }
        }
        return list
    }

    /**
     * Check if the given node has a boolean value at certain key
     * @param node the node that could be a JsonNode
     * @param key the key that the node might have
     * @return true, if the node has a boolean value at the key
     */
    fun checkNodeHasBooleanAtKey(node: JsonNode?, key: String): Boolean {
        if (!checkNodeHasKey(node, key)) {
            return false
        }


        return node!!.get(key).isBoolean


    }

    /**
     * Check if the given node has a textual value at certain key
     * @param node the node that could be a JsonNode
     * @param key the key that the node might have
     * @return true, if the node has a textual value at the key
     */
    fun checkNodeHasTextualAtKey(node: JsonNode?, key: String): Boolean {
        if (!checkNodeHasKey(node, key)) {
            return false
        }

        return node!!.get(key).isTextual
    }


    /**
     * Check if the given node is not null and has a non-null value at certain key
     * @param node the node that could be a JsonNode or null
     * @param key the key that the node might have
     * @return true, if the node has a non-value at the key
     */
    fun checkNodeHasKey(node: JsonNode?, key: String): Boolean {
        if (node == null) {
            return false
        }

        if (node.isEmpty) {
            return false
        }
        return node.hasNonNull(key)
    }


    fun checkValueAtKey(node: JsonNode?, key: String, expectedValue: String): Boolean {
        if (node == null) {
            return false
        }

        if (!node.hasNonNull(key)) {
            return false
        }

        // Removes the quotes from the string
        return (node.get(key).toString() == "\"$expectedValue\"")


    }


}
