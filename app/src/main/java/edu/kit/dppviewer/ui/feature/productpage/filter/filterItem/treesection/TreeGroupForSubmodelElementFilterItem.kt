package edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.treesection

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ArrayNode
import edu.kit.dppviewer.data.model.product.adapter.submodelElement.SubmodelElementAdapter
import edu.kit.dppviewer.data.model.product.adapter.submodelElement.leaf.SubmodelElementLeafAdapter
import edu.kit.dppviewer.data.model.product.adapter.submodelElement.nested.SubmodelElementNestedAdapter
import edu.kit.dppviewer.data.model.product.util.JsonTextUtil
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.tree.ITreeEntry
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.tree.TreeGroup


/**
 * This FilterItem is used to filter a IOtherEntry.
 * An IOtherEntry could be a Group of Properties or a single Property.
 *
 * The returned Type of a IOtherEntry is depend on the type of the given SubmodelElementAdapter.
 * Given a SubmodelElementLeafAdapter, the returned IOtherEntry is a Property.
 * Given a SubmodelElementNestedAdapter, the returned IOtherEntry is a Group.
 *
 */
class TreeGroupForSubmodelElementFilterItem(dataNode: JsonNode) : TreeFilterItem(dataNode) {
    var idShort: String? = null
    private var insideFilter: MutableList<TreeGroupForSubmodelElementFilterItem> = arrayListOf()


    init {
        if (JsonTextUtil().checkNodeHasKey(dataNode, "idShort") && JsonTextUtil().checkNodeHasKey(
                dataNode,
                "nested"
            )
        ) {
            idShort = dataNode.get("idShort").asText()
            super.isNested = dataNode.get("nested").asBoolean()


        }

        if (JsonTextUtil().checkNodeHasKey(dataNode, "displayedIDs")) {
            val insideFilterNode = dataNode.get("displayedIDs")
            if (insideFilterNode is ArrayNode) {
                for (elementFilter in insideFilterNode) {
                    insideFilter.add(TreeGroupForSubmodelElementFilterItem(elementFilter))

                }
            }
        }
    }

    /**
     * Apply the filter to the given SubmodelElementAdapter.
     *
     * If the given SubmodelElementAdapter is a SubmodelElementLeafAdapter, the filter is applied to the leaf element.
     *
     *
     * If the given SubmodelElementAdapter is a SubmodelElementNestedAdapter,
     * check for the existence of filters inside.
     *
     * At the existence of filters inside, only return filtered children elements that matches a filter.
     * At the absence of filters inside, return all children elements.
     *
     * @param element the SubmodelElementAdapter to apply the filter to
     * @return the IOtherEntry after the filter is applied
     */
    fun apply(element: SubmodelElementAdapter?): ITreeEntry {

        if (element == null) {
            return TreeGroup()
        }

        //submodelElementAsGroup.idShort = element.idShort
        if (element is SubmodelElementLeafAdapter) {
            // ignore the filter

            //return OtherProperty(element)
            return buildTreeProperty(element)

        } else {
            element as SubmodelElementNestedAdapter

            if (element.isChildless()) {
                // return an empty group
                return TreeGroup()
            }

            val submodelElementAsGroup = buildTreeGroupShell(element)

            if (insideFilter.isEmpty()) {
                //println("no inside filter")
                return buildTreeGroup(element)
                //return getOtherSectionGroup(element)
            }

            // there are filters inside and child inside

            for (childElement in element.children!!) {
                if (!isContained(childElement.idShort)) {
                    continue
                }

                // filter this submodel element
                val childFilter = getInsideFilter(childElement.idShort)

                // isNested attribute in filer setting should be consist with the element
                if (childFilter.isNested == childElement.isNested) {
                    submodelElementAsGroup.addChild(childFilter.apply(childElement))
                }


            }

            return submodelElementAsGroup

        }
    }




    private fun getInsideFilter(id: String): TreeGroupForSubmodelElementFilterItem {
        for (filter in insideFilter) {
            if (filter.idShort == id) {
                return filter
            }
        }
        return TreeGroupForSubmodelElementFilterItem(ObjectMapper().createObjectNode())
    }

    private fun isContained(childId: String): Boolean {
        for (filter in insideFilter) {
            if (filter.idShort == childId) {
                return true
            }
        }
        return false
    }


}