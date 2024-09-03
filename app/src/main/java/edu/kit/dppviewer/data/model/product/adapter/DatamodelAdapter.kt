package edu.kit.dppviewer.data.model.product.adapter

import edu.kit.dppviewer.data.model.product.aas4android.DataModel
import edu.kit.dppviewer.data.model.product.adapter.submodelElement.SubmodelElementAdapter

/**
 * This class models a data model.
 * It could be a submodel or submodel element
 * but details about structure of the JSON Node is hidden to it
 * It simply call methods from models in aas4android
 * @param datamodel a data model.
 **/
abstract class DatamodelAdapter(datamodel: DataModel) {

    /**
     * name of the data model
     */
    val name: String = datamodel.name

    /**
     * idShort of the data model
     */
    val idShort: String = datamodel.idShort

    /**
     * description of the data model
     */
    val description: String = datamodel.description


    /**
     * get the submodel element with the correct path of idShorts
     * @param idPath a string, which is a idPath to a submodel element
     * @return the found submodel element or null
     */
    abstract fun getSubmodelElementByIdShort(
        idPath: List<String>,
        isNested: Boolean
    ): SubmodelElementAdapter?

}