package edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.treesection

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ArrayNode
import edu.kit.dppviewer.data.model.product.adapter.SubmodelAdapter
import edu.kit.dppviewer.data.model.product.util.JsonTextUtil
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.tree.TreeGroup

private const val KEY_TO_INSIDE_FILTERS = "displayedIDs"

/**
 * This FilterItem is used to filter a a Group of Properties from a SubmodelAdapter.
 *
 */
class TreeGroupForSubmodelFilterItem(
    dataNode: JsonNode,
    isNested: Boolean,
    var submodelId: String
) : TreeFilterItem(dataNode) {

    private val insideFilter: MutableList<TreeGroupForSubmodelElementFilterItem> = arrayListOf()


    init {

        super.isNested = isNested

        if (JsonTextUtil().checkNodeHasKey(dataNode, KEY_TO_INSIDE_FILTERS)) {
            val insideFilterNode = dataNode.get(KEY_TO_INSIDE_FILTERS)
            if (insideFilterNode is ArrayNode) {
                for (elementFilter in insideFilterNode) {
                    insideFilter.add(TreeGroupForSubmodelElementFilterItem(elementFilter))

                }
            }

        }

    }


    /**
     * Apply the filter to the given SubmodelAdapter.
     * @submodel a SubmodelAdapter
     * @return a Group of Properties
     */
    fun apply(submodel: SubmodelAdapter?): TreeGroup {

        val submodelAsGroup = buildTreeGroupShell(submodel)

        if (insideFilter.isEmpty() || submodel == null) {

            return buildTreeGroup(submodel)
        } else {
            if (submodel.elementsAbs.isEmpty()) {
                return submodelAsGroup
            }

            for (element in submodel.elementsAbs) {
                if (!isContained(element.idShort)) {
                    continue
                }


                val childFilter = getInsideFilter(element.idShort)



                submodelAsGroup.addChild(childFilter.apply(element))

            }
        }

        return submodelAsGroup

    }



    private fun isContained(childId: String): Boolean {
        for (filter in insideFilter) {
            if (filter.idShort == childId) {
                return true
            }
        }
        return false
    }

    private fun getInsideFilter(id: String): TreeGroupForSubmodelElementFilterItem {
        for (filter in insideFilter) {
            if (filter.idShort == id) {
                return filter
            }
        }
        return TreeGroupForSubmodelElementFilterItem(ObjectMapper().createObjectNode())
    }


}
