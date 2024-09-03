package edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.treesection

import edu.kit.dppviewer.data.model.product.adapter.DatamodelAdapter
import edu.kit.dppviewer.data.model.product.adapter.SubmodelAdapter
import edu.kit.dppviewer.data.model.product.adapter.submodelElement.SubmodelElementAdapter
import edu.kit.dppviewer.data.model.product.adapter.submodelElement.leaf.SubmodelElementLeafAdapter
import edu.kit.dppviewer.data.model.product.adapter.submodelElement.nested.SubmodelElementNestedAdapter
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.tree.ITreeEntry
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.tree.TreeGroup
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.tree.TreeProperty

fun buildTreeProperty(leafElement: SubmodelElementLeafAdapter?): TreeProperty {

    return if (leafElement == null) {
        TreeProperty()
    } else {
        TreeProperty(displayName = leafElement.name,
            value = leafElement.entryValueString,
            description = leafElement.description)
    }

}

// return a OtherGroup Object that with name and idShort, but no content
fun buildTreeGroupShell(dataModel: DatamodelAdapter?): TreeGroup {

    if (dataModel == null) {
        return TreeGroup()
    }

    return TreeGroup(
        displayName = dataModel.name,
        children = arrayListOf(),
        idShort = dataModel.idShort)

}


fun buildTreeGroup(submodel: SubmodelAdapter?): TreeGroup {
    if (submodel == null) {
        return TreeGroup()
    }

    if (submodel.isChildless()) {
        return TreeGroup()
    }


    val submodelAsGroup = buildTreeGroupShell(submodel)
    for (childElement in submodel.elementsAbs) {

        submodelAsGroup.addChild(directBuild(childElement))
    }

    submodelAsGroup.flatten()
    return submodelAsGroup



}

fun buildTreeGroup(element:  SubmodelElementNestedAdapter?): TreeGroup {



    if (element == null) {
        return TreeGroup()
    }

    // set name of this group
    val otherGroup = buildTreeGroupShell(element)

    if (!element.isChildless()) {
        for (childElement in element.children!!) {
            otherGroup.addChild(directBuild(childElement))
        }
    }
    return otherGroup
}

fun directBuild(element: SubmodelElementAdapter?): ITreeEntry {
    return if (element is SubmodelElementLeafAdapter) {
        buildTreeProperty(element)
    } else {
        buildTreeGroup(element as SubmodelElementNestedAdapter)
    }
}