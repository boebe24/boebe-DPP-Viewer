package edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.treesection

import com.fasterxml.jackson.databind.JsonNode
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.BaseFilterItem

/**
 * An OtherFilterItem is a filter item that used to generate an IOtherEntry for the OtherSection
 *
 * It contains a dataNode that contains the all information from the template
 * and a boolean value to indicate if the IOtherEntry is nested.
 */
abstract class TreeFilterItem(dataNode: JsonNode) : BaseFilterItem(dataNode) {

    protected var isNested: Boolean = false







}