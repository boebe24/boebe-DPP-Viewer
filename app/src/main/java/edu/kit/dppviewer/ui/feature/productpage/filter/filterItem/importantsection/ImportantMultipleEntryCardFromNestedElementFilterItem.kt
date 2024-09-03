package edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.importantsection

import com.fasterxml.jackson.databind.JsonNode
import edu.kit.dppviewer.data.model.product.adapter.submodelElement.nested.SubmodelElementNestedAdapter
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.important.ImportantCardMultipleEntries


/**
 * This FilterItem is used to filter a multiple-entry-card  from a nested submodel element.
 *
 *  Each such filterItem should contains a idPath for a nested submodel element
 *
 */
class ImportantMultipleEntryCardFromNestedElementFilterItem(
    cardNode: JsonNode,
    var idPath: String
) : ImportantMultipleEntryCardFilterItem(cardNode) {


    /**
     * Generate a ImportantCard from a nested submodel element
     * @nestedElement: the nested submodel element
     * @return: a multiple-entry-card
     */
    fun apply(nestedElement: SubmodelElementNestedAdapter?): ImportantCardMultipleEntries {

        if (nestedElement == null) {
            return ImportantCardMultipleEntries()
        }

        return buildCardMultipleEntries(nestedElement)
    }


}
