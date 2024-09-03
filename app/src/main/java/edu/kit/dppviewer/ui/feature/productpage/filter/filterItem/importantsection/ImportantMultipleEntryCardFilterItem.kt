package edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.importantsection

import com.fasterxml.jackson.databind.JsonNode

/**
 * this class is used to filter a multiple-entry-card.
 *
 *  Each such filterItem should contains a idPath for a submodel element
 *  * or idPaths for multiple submodel elements
 */
abstract class ImportantMultipleEntryCardFilterItem(cardNode: JsonNode) :
    ImportantCardFilterItem(cardNode, true)
