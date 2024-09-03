package edu.kit.dppviewer.data.model.product.adapter

import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.FILE_TYPE
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.MULTI_LANGUAGE_PROPERTY_TYPE
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.OTHER_SUBMODEL_ELEMENT_TYPE
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.PROPERTY_TYPE
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.SUBMODEL_ELEMENT_COLLECTION_TYPE
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.SUBMODEL_ELEMENT_LIST_TYPE

/**
 * This class models a type of a submodel element adapter.
 * It cloud be property, element collection, element list, multilanguage property, file or other element type
 *
 * there is in unknown element type, because the type of the element is cataloged as "other"
 **/
enum class SubmodelElementTypeAdapter(val modelTypeString: String) {
    PROPERTY(PROPERTY_TYPE),
    ELEMENT_COLLECTION(SUBMODEL_ELEMENT_COLLECTION_TYPE),
    ELEMENT_LIST(SUBMODEL_ELEMENT_LIST_TYPE),
    MULTILANGUAGE_PROPERTY(MULTI_LANGUAGE_PROPERTY_TYPE),
    FILE(FILE_TYPE),
    OTHER_ELEMENT_TYPE(OTHER_SUBMODEL_ELEMENT_TYPE);

    companion object {
        @JvmStatic
        fun fromString(typeString: String?): SubmodelElementTypeAdapter {
            for (type in entries) {
                if (type.modelTypeString.equals(typeString, ignoreCase = true)) {
                    return type
                }
            }
            return OTHER_ELEMENT_TYPE
        }
    }
}
