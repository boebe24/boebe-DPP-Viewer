package edu.kit.dppviewer.ui.feature.productpage.filter.filterItem

import com.fasterxml.jackson.databind.JsonNode

open class BaseFilterItem(var dataNode: JsonNode) {

    override fun toString(): String {
        return dataNode.toString()
    }
}