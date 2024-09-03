package edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.generalsection

import com.fasterxml.jackson.databind.JsonNode
import edu.kit.dppviewer.data.model.product.adapter.submodelElement.leaf.SubmodelElementLeafAdapter
import edu.kit.dppviewer.data.model.product.util.JsonTextUtil
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.BaseFilterItem

import edu.kit.dppviewer.ui.feature.productpage.product.model.content.general.GeneralProperty


private const val KEY_TO_DEFAULT_UNIT = "unit"
private const val KEY_TO_UNIT_PATH = "unitPath"

/**
 * A GeneralFilterItem is a filter item that used to generate an entry for the GeneralSection
 *
 * It contains a idPath for a submodel element
 * and a boolean value to indicate if the submodel element is nested.
 * dataNode is the node that contains the all information from the template
 */
class GeneralFilterItem(dataNode: JsonNode, var idPath: String): BaseFilterItem(dataNode) {

    var isNested: Boolean = false
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


    /**
     * Generate a GeneralProperty from a leaf submodel element
     * @leafElement: a leaf submodel element
     * @return: a general property
     */
    fun apply(leafElement: SubmodelElementLeafAdapter): GeneralProperty {

        if (unit != null) {
            return GeneralProperty(
                leafElement.name,
                addUnitString(leafElement.entryValueString, unit!!)
            )
        }
        return GeneralProperty(leafElement.name, leafElement.entryValueString)
    }

    fun hasUnitPath(): Boolean {
        return unitPath != null
    }

    /**
     * Generate a GeneralProperty from a leaf submodel element
     * @leafElement: a leaf submodel element
     * @return: a general property
     */
    fun apply(
        leafElement: SubmodelElementLeafAdapter,
        unitElement: SubmodelElementLeafAdapter?
    ): GeneralProperty {

        if (unitElement == null) {
            return apply(leafElement)
        }

        val unitValue = unitElement.entryValueString
        return GeneralProperty(
            leafElement.name,
            addUnitString(leafElement.entryValueString, unitValue)
        )
    }

    private fun addUnitString(value: String, unit: String): String {
        return "$value $unit"
    }

}