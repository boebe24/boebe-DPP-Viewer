package edu.kit.dppviewer.data.model.product.aas4android

object AasModelConstants {

    /**
     * keys that different type of model should have
     */
    const val KEY_TO_MODEL_TYPE = "modelType"
    const val KEY_TO_VALUE_NODE = "value"
    const val KEY_TO_DISPLAY_NAME = "displayName"
    const val KEY_TO_DESCRIPTION = "description"
    const val KEY_TO_ID_SHORT = "idShort"

    /**
     * keys in a  JsonNode of asset administration shell
     */
    const val KEY_STRING_IN_SHELL_NODE = "keys"
    const val KEY_TO_SUBMODELS_IN_SHELL_NODE = "submodels"


    /**
     * keys in a  JsonNode of submodel
     */

    const val KEY_TO_SUBMODEL_ELEMENT = "submodelElements"


    /**
     * keys in a  JsonNode of submodel element
     */


    /**
     * keys in a  JsonNode of value to a multi language property
     */
    const val KEY_TO_LANGUAGE = "language"
    const val KEY_TO_TEXT = "text"

    /**
     * types of submodel element
     */
    const val PROPERTY_TYPE = "Property"
    const val SUBMODEL_ELEMENT_COLLECTION_TYPE = "SubmodelElementCollection"
    const val SUBMODEL_ELEMENT_LIST_TYPE = "SubmodelElementList"
    const val MULTI_LANGUAGE_PROPERTY_TYPE = "MultiLanguageProperty"
    const val FILE_TYPE = "File"
    const val OTHER_SUBMODEL_ELEMENT_TYPE = "OtherElementType"


    /**
     * types of model
     */
    const val MODEL_TYPE_VALUE_SUBMODEL = "Submodel"



    /**
     * Information
     */
    const val EMPTY_VALUE_INFORMATION = "Empty Value"
    const val INVALID_SUBMODEL_ELEMENT_INFORMATION = "Invalid Submodel element"
    const val EMPTY_ID_INFORMATION = "No IdShort"
    const val EMPTY_MODEL_TYPE_INFORMATION = "Empty Model Type"

    /**
     * special submodels id
     */
    const val IMAGE_SUBMODEL_ID_PATH = "Images"


}