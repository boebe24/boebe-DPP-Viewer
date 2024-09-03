package edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.importantsection

import com.fasterxml.jackson.databind.JsonNode
import edu.kit.dppviewer.data.model.product.adapter.submodelElement.leaf.SubmodelElementLeafAdapter
import edu.kit.dppviewer.data.model.product.util.JsonModelUtil
import edu.kit.dppviewer.data.model.product.util.JsonTextUtil
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.important.ImportantCardMultipleEntries
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.important.ImportantProperty

private const val KEY_TO_NAME_NODE = "name"
private const val DEFAULT_CARD_NAME = ""

/**
 * This FilterItem is used to filter a multiple-entry-card  from a list of idPaths to leaf submodel
 * elements.
 *
 * Each such filterItem should contains a lists of idPaths for leaf submodel elements
 */
class ImportantMultipleEntryCardFromPathListFilterItem(
    cardNode: JsonNode,
    var idPathsListToLeaf: List<String>
) : ImportantMultipleEntryCardFilterItem(cardNode) {

    private var cardName: String = DEFAULT_CARD_NAME

    init {
        if (JsonTextUtil().checkNodeHasKey(cardNode, KEY_TO_NAME_NODE)) {
            val cardNameNode = cardNode.get(KEY_TO_NAME_NODE)
            cardName = JsonModelUtil().selectStringFromMultiLanguageNode(cardNameNode)
        }
    }

    /**
     * Generate a ImportantCard from a list of leaf submodel elements
     * @leafElements: a list of leaf submodel elements
     * @return: a multiple-entry-card
     */
    fun apply(leafElements: List<SubmodelElementLeafAdapter>?): ImportantCardMultipleEntries {
        if (leafElements == null) {
            return ImportantCardMultipleEntries()
        }


        val properties = mutableListOf<ImportantProperty>()

        for (leafElement in leafElements) {
            properties.add(buildProperty(leafElement))

        }

        if (properties.isEmpty()) {
            return ImportantCardMultipleEntries()
        }

        return ImportantCardMultipleEntries(cardName, properties)
    }

}
