package edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.importantsection

import edu.kit.dppviewer.data.model.product.adapter.submodelElement.leaf.SubmodelElementLeafAdapter
import edu.kit.dppviewer.data.model.product.adapter.submodelElement.nested.SubmodelElementNestedAdapter
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.important.ImportantCardMultipleEntries
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.important.ImportantCardSingleEntry
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.important.ImportantProperty



fun buildProperty(leafElement: SubmodelElementLeafAdapter?): ImportantProperty {
    return if (leafElement == null) {
        ImportantProperty()
    } else {
        ImportantProperty(leafElement.name, leafElement.entryValueString)
    }
}

fun buildProperty(leafElement: SubmodelElementLeafAdapter?, unit: String): ImportantProperty {

    return if (leafElement == null) {
        ImportantProperty()
    } else {
        ImportantProperty(leafElement.name, leafElement.entryValueString, unit)
    }

}

fun buildCardSingleEntry(leafElement: SubmodelElementLeafAdapter?): ImportantCardSingleEntry {
    return if (leafElement == null) {
        ImportantCardSingleEntry()
    } else {
        ImportantCardSingleEntry(leafElement.name, buildProperty(leafElement))
    }
}

fun buildCardSingleEntry(leafElement: SubmodelElementLeafAdapter?, unitString: String): ImportantCardSingleEntry {

    return if (leafElement == null) {
        ImportantCardSingleEntry()
    } else {
        ImportantCardSingleEntry(leafElement.name, buildProperty(leafElement,unitString))
    }


}

fun buildCardMultipleEntries(nestedElement: SubmodelElementNestedAdapter?): ImportantCardMultipleEntries {
        if (nestedElement == null) {
            return ImportantCardMultipleEntries()
        } else {
            //val card = buildCardMultipleEntriesShell(nestedElement)

            val properties = mutableListOf<ImportantProperty>()

            for (child in nestedElement.children!!) {

                if (!child.isNested) {
                    properties.add(buildProperty(child as SubmodelElementLeafAdapter))
                }

                // non-leaf children is ignored
            }


            return ImportantCardMultipleEntries(nestedElement.name, properties)


        }
}


