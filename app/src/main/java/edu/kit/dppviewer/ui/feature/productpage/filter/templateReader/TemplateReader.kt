package edu.kit.dppviewer.ui.feature.productpage.filter.templateReader

import com.fasterxml.jackson.databind.JsonNode
import edu.kit.dppviewer.data.model.product.util.JsonTextUtil
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.GENERAL_SECTION_NODE_STRING
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.IMPORTANT_SECTION_NODE_STRING_BATTERY
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.IMPORTANT_SECTION_NODE_STRING_SMARTPHONE
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.IMPORTANT_SECTION_NODE_STRING_TEXTILE
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.OTHER_SECTION_NODE_STRING_BATTERY
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.OTHER_SECTION_NODE_STRING_SMARTPHONE
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.OTHER_SECTION_NODE_STRING_TEXTILE
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.generalsection.GeneralFilterItem
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.importantsection.ImportantCardFilterItem
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.importantsection.ImportantMultipleEntryCardFromNestedElementFilterItem
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.importantsection.ImportantMultipleEntryCardFromPathListFilterItem
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.importantsection.ImportantSingleEntryCardFilterItem
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.treesection.TreeGroupForSubmodelFilterItem
import edu.kit.dppviewer.ui.feature.productpage.product.model.ProductType


private const val NESTED_KEY = "nested"
private const val ID_SHORT_PATH_KEY = "idShortPath"
private const val CARD_KEY = "card"
private const val VALUE_KEY = "value"
private const val SUBMODEL_ID_KEY = "submodelID"
private const val DISPLAYED_IDS_KEY = "displayedIDs"
private const val CARD_TYPE_MULTIPLE = "multiple"
private const val CARD_TYPE_SINGLE = "single"

/**
 * This class is used to read the template data.
 * It knows the design of the template and return the relevant lists of FilterItems.
 */
class TemplateReader {

    private val generalNode = JsonTextUtil().generateJsonNode(GENERAL_SECTION_NODE_STRING)

    private val importantNodes = mapOf(
        ProductType.SMARTPHONE to JsonTextUtil().generateJsonNode(
            IMPORTANT_SECTION_NODE_STRING_SMARTPHONE
        ),
        ProductType.BATTERY to JsonTextUtil().generateJsonNode(IMPORTANT_SECTION_NODE_STRING_BATTERY),
        ProductType.TEXTILE to JsonTextUtil().generateJsonNode(IMPORTANT_SECTION_NODE_STRING_TEXTILE),
    )

    private val otherNodes = mapOf(
        ProductType.SMARTPHONE to JsonTextUtil().generateJsonNode(
            OTHER_SECTION_NODE_STRING_SMARTPHONE
        ),
        ProductType.BATTERY to JsonTextUtil().generateJsonNode(OTHER_SECTION_NODE_STRING_BATTERY),
        ProductType.TEXTILE to JsonTextUtil().generateJsonNode(OTHER_SECTION_NODE_STRING_TEXTILE),
    )


    /**
     * Returns all  filter items for general section.
     * Each such filterItem should contains a idPath for a submodel element
     * and a boolean value to indicate if the submodel element is nested.
     * each filterItem can be used to generate an entry for the GeneralSection
     */
    fun getAllGeneralFilterNodes(): List<GeneralFilterItem> {
        // read general filter items

        val generalNodes = JsonTextUtil().arrayNodeToList(generalNode)
        val generalFilterItems = mutableListOf<GeneralFilterItem>()

        for (generalNode in generalNodes) {
            if (containsNestedAndIdShortPathInformation(generalNode)) {
                if (!generalNode.get(NESTED_KEY).asBoolean()) {
                    generalFilterItems.add(
                        GeneralFilterItem(
                            generalNode,
                            generalNode.get(ID_SHORT_PATH_KEY).asText()
                        )
                    )
                }

            }

        }
        return generalFilterItems
    }

    /**
     * Returns a list of  filter items for ImportantSection
     * Each such filterItem should contains a idPath for a submodel element
     * or idPaths for multiple submodel elements
     * each filterItem can be used to generate a Card for the ImportantSection
     */
    fun getAllImportantCardFilters(type: ProductType): List<ImportantCardFilterItem> {
        // read important filter items
        val importantNodes = importantNodes[type] ?: return emptyList()

        val importantCardsFilterItems = mutableListOf<ImportantCardFilterItem>()

        if (!importantNodes.isArray) {
            return emptyList()
        }


        for (node in importantNodes) {
            if (!JsonTextUtil().checkNodeHasKey(node, VALUE_KEY)) {
                continue
            }

            val valueNode = node.get(VALUE_KEY)

            if (!JsonTextUtil().checkNodeHasTextualAtKey(node, CARD_KEY)) {
                continue
            }


            when (node.get(CARD_KEY).asText()) {
                CARD_TYPE_SINGLE -> {
                    if (!valueNode.get(NESTED_KEY).isBoolean) {
                        continue
                    }

                    if (!valueNode.get(ID_SHORT_PATH_KEY).isTextual) {
                        continue
                    }

                    if (!valueNode.get(NESTED_KEY).asBoolean()) {
                        importantCardsFilterItems.add(
                            ImportantSingleEntryCardFilterItem(
                                node,
                                valueNode.get(ID_SHORT_PATH_KEY).asText()
                            )
                        )
                    }

                }

                CARD_TYPE_MULTIPLE -> {
                    if (valueNode.isArray) {
                        val idPathList = mutableListOf<String>()
                        for (entryNode in valueNode) {

                            if (!containsNestedAndIdShortPathInformation(
                                    entryNode
                                )
                            ) {
                                continue
                            }

                            if (!entryNode.get(NESTED_KEY).asBoolean()) {
                                idPathList.add(entryNode.get(ID_SHORT_PATH_KEY).asText())
                            }


                        }

                        importantCardsFilterItems.add(
                            ImportantMultipleEntryCardFromPathListFilterItem(
                                node,
                                idPathList
                            )
                        )
                    } else {
                        if (!valueNode.get(NESTED_KEY).isBoolean) {
                            continue
                        }

                        if (!valueNode.get(ID_SHORT_PATH_KEY).isTextual) {
                            continue
                        }


                        if (valueNode.get(NESTED_KEY).asBoolean()) {
                            importantCardsFilterItems.add(
                                ImportantMultipleEntryCardFromNestedElementFilterItem(
                                    node,
                                    valueNode.get(ID_SHORT_PATH_KEY).asText()
                                )
                            )
                        }


                    }
                }
            }

        }


        return importantCardsFilterItems
    }


    /**
     * Returns a list of filter items for "Other Information" Section
     * Each such filterItem should contains a idShort for a submodel
     * Each filterItem can be used to generate a OtherGroup
     */
    fun getAllOtherFilterNodes(type: ProductType): List<TreeGroupForSubmodelFilterItem> {
        // read other filter items
        val otherNodes = otherNodes[type] ?: return emptyList()
        val filterItemForSubmodel = mutableListOf<TreeGroupForSubmodelFilterItem>()

        if (otherNodes.isArray) {
            // create filter item
            for (submodelNode in otherNodes) {

                if (!containsNestedAndSubmodelIdInformation(
                        submodelNode
                    )
                ) {
                    continue
                }

                if (submodelNode.get(NESTED_KEY).asBoolean()) {
                    filterItemForSubmodel.add(
                        TreeGroupForSubmodelFilterItem(
                            submodelNode,
                            JsonTextUtil().checkNodeHasKey(submodelNode, DISPLAYED_IDS_KEY),
                            submodelNode.get(SUBMODEL_ID_KEY).asText()
                        )
                    )
                }

            }


        }

        return filterItemForSubmodel


    }

    private fun containsNestedAndSubmodelIdInformation(node: JsonNode?): Boolean {
        return containsNestedInformationAndTextualAtKey(node, SUBMODEL_ID_KEY)
    }

    private fun containsNestedAndIdShortPathInformation(node: JsonNode?): Boolean {
        return containsNestedInformationAndTextualAtKey(node, ID_SHORT_PATH_KEY)
    }

    private fun containsNestedInformationAndTextualAtKey(
        node: JsonNode?,
        keyToText: String
    ): Boolean {
        return (JsonTextUtil().checkNodeHasBooleanAtKey(
            node,
            NESTED_KEY
        ) && JsonTextUtil().checkNodeHasTextualAtKey(node, keyToText))
    }
}