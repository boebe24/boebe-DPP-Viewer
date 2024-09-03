package edu.kit.dppviewer.data.model.product.aas4android.submodelElement

import com.fasterxml.jackson.databind.JsonNode
import edu.kit.dppviewer.data.model.product.util.JsonModelUtil
import edu.kit.dppviewer.data.model.product.util.JsonTextUtil
import edu.kit.dppviewer.data.model.product.util.SettingConstants.USER_LANGUAGE


/**
 * represents a MultiLanguageProperty.
 * It is a type of SubmodelElementLeaf
 * value of this element is a group of texts in different languages
 *
 * This class serves as an alternative to MultiLanguageProperty class in aas4j
 *
 * all Data is stored in a JsonNode
 *
 * @param dataNode contains all data of the MultiLanguageProperty in JSON format
 */
class MultiLanguageProperty(dataNode: JsonNode, multiLanguageText: JsonNode = JsonTextUtil().getEmptyJsonNode()) :

    SubmodelElementLeaf(dataNode) {

    /**
     * the node containing all the texts in different languages
     * It should be an ArrayNode
     */
    private var languagesInfoNode = multiLanguageText


    init {
        super.valueString = JsonModelUtil()
            .selectStringFromMultiLanguageNode(languagesInfoNode, (USER_LANGUAGE))
    }


    /**
     * the language to be chosen
     */
    private var usrLanguage: String = USER_LANGUAGE

    /**
     * returns the text in the certain language of the user
     *
     * @param language the language in which the text should be returned
     * @return the text in the one language
     */
    private fun getTextInLanguage(language: String): String {
        return JsonModelUtil().selectStringFromMultiLanguageNode(
            languagesInfoNode,
            language
        )
    }


    override fun getValueAsString(): String {
        return getTextInLanguage(usrLanguage)
    }


}