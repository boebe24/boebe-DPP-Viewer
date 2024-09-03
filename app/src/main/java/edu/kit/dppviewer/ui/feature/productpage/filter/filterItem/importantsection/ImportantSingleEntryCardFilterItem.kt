package edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.importantsection

import com.fasterxml.jackson.databind.JsonNode
import edu.kit.dppviewer.data.model.product.adapter.submodelElement.leaf.SubmodelElementLeafAdapter
import edu.kit.dppviewer.data.model.product.util.JsonTextUtil
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.important.ImportantCardSingleEntry

private const val KEY_TO_DEFAULT_UNIT = "unit"
private const val KEY_TO_UNIT_PATH = "unitPath"

/**
 * This FilterItem is used to filter a single-entry-card from a leaf submodel element.
 *
 * Each such filterItem should contains a idPath for a leaf submodel element
 */
class ImportantSingleEntryCardFilterItem(cardNode: JsonNode, var idPath: String) :
    ImportantCardFilterItem(cardNode, false) {

    var unit: String? = null

    var unitPath: String? = null

    init {
        if (JsonTextUtil().checkNodeHasTextualAtKey(dataNode, KEY_TO_DEFAULT_UNIT)
        ) {
            unit = super.dataNode.get(KEY_TO_DEFAULT_UNIT).asText()
        }

        if (JsonTextUtil().checkNodeHasTextualAtKey(dataNode, KEY_TO_UNIT_PATH)
        ) {
            unitPath = super.dataNode.get(KEY_TO_UNIT_PATH).asText()
        }

    }

    fun apply(leafElement: SubmodelElementLeafAdapter?, unitElement: SubmodelElementLeafAdapter?): ImportantCardSingleEntry {
        if (unitElement == null) {
            return apply(leafElement)
        }

        val unitValue = unitElement.entryValueString
        return buildCardSingleEntry(leafElement, unitValue)
    }
    /**
     * Generate a ImportantCard from a  leaf submodel elements
     * @leafElement: a leaf submodel elements
     * @return: a single-entry-card
     */
    fun apply(leafElement: SubmodelElementLeafAdapter?): ImportantCardSingleEntry {

        if (leafElement == null) {
            return ImportantCardSingleEntry()
        }

        if (unit != null) {
            return buildCardSingleEntry(leafElement, unit!!)
        }
        return buildCardSingleEntry(leafElement)

    }

    fun hasUnitPath(): Boolean {
        return unitPath != null
    }



}
