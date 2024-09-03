package edu.kit.dppviewer.data.model.product.aas4android

import com.fasterxml.jackson.databind.JsonNode
import edu.kit.dppviewer.data.model.product.util.JsonModelUtil



/**
 * A DataModel is a abstract class for all data models in the AAS4Android project.
 * It provides some basic functions to handle the data.
 * it might has a name, idShort, description.
 */
abstract class DataModel(data: JsonNode) {

    /**
     * The dataNode is the JsonNode that contains the data of the model.
     */
    val dataNode: JsonNode = data

    /**
     * The name is the display name of the model.
     * when there is no display name in dataNode, the idShort will be used.
     */
    val name = JsonModelUtil().getDisplayNameOrIdShort(data)

    /**
     * The idShort is the unique identifier of the model.
     * each model must have an idShort
     */
    val idShort = JsonModelUtil().getIdShortFromNode(data)

    /**
     * The description is the description of the model.
     * when there is no description in dataNode, the description will be empty.
     */
    val description = JsonModelUtil().getDescriptionFromNode(data)




    /**
     * get the model type of the dataNode
     */
    fun getModelType(): String {
        return JsonModelUtil().getModelTypeString(dataNode)
    }


    override fun toString(): String {
        return dataNode.toString()
    }


}