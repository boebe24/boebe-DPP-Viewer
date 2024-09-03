package edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.importantsection

import com.fasterxml.jackson.databind.JsonNode
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.BaseFilterItem


private const val KEY_TO_VALUE_NODE = "value"

/**
 * An ImportantCardFilterItem is a filter item that used to generate an card for the ImportantSection
 *
 * Each such filterItem should contains a idPath for a submodel element
 * or idPaths for multiple submodel elements
 *
 */
abstract class ImportantCardFilterItem(cardNode: JsonNode, nested: Boolean) :BaseFilterItem(cardNode){
    var isMultiple = nested

    var valueNode: JsonNode = cardNode.get(KEY_TO_VALUE_NODE)


}
