package edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.importantsection

import com.fasterxml.jackson.databind.JsonNode
import edu.kit.dppviewer.data.model.product.aas4android.AssetAdministrationShell
import edu.kit.dppviewer.data.model.product.model.Product
import edu.kit.dppviewer.data.model.product.util.JsonTextUtil
import edu.kit.dppviewer.data.model.product.util.SettingConstants.USER_LANGUAGE
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.important.ImportantCardMultipleEntries
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.important.ImportantCardSingleEntry
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import java.io.File

/**
 * This class is used to test the ImportantSectionFilter class
 */
class ImportantSectionFilterTest {
    private var importantSectionFilter: ImportantSectionFilter? = null
    private var product_local_battery: Product? = null
    private var filterItems: List<ImportantCardFilterItem>? = null

    val jsonImportantFilterFile = File(javaClass.getResource(
        "/raw/important_section_filter_battery.json")?.path ?:
    throw IllegalArgumentException("File not found"))

    val jsonImportantFilterItems = jsonImportantFilterFile.readText()



    /**
     * This function is used to set up the test environment
     */
    @Before
    fun setUp() {
        USER_LANGUAGE = "de"
        val batterySubmodelsJson = File(javaClass.getResource(
            "/raw/local_battery_for_test/battery_submodels.json")?.path ?: throw IllegalArgumentException("File not found"))

        val batteryShellJson = File(javaClass.getResource(
            "/raw/local_battery_for_test/battery_submodels.json")?.path ?: throw IllegalArgumentException("File not found"))

        // Parse JSON strings to objects
        product_local_battery = createProductWithSubmodels(
            batteryShellJson.readText(), batterySubmodelsJson.readText()
        )
        filterItems = getAllImportantCardFilters()
        importantSectionFilter = ImportantSectionFilter(filterItems!!)
    }

    /**
     * This function is used to get all the important card filters
     */
    private fun getAllImportantCardFilters(): List<ImportantCardFilterItem> {

        val importantNode = JsonTextUtil().generateJsonNode(this.jsonImportantFilterItems)
        val importantNodes = JsonTextUtil().arrayNodeToList(importantNode)

        val importantCardsFilterItems = mutableListOf<ImportantCardFilterItem>()

        for (node in importantNodes) {
            if (!JsonTextUtil().checkNodeHasKey(node, "value")) {
                continue
            }

            val valueNode = node.get("value")

            if (!JsonTextUtil().checkNodeHasTextualAtKey(node, "card")) {
                continue
            }


            when (node.get("card").asText()) {
                "single" -> {
                    if (!valueNode.get("nested").isBoolean) {
                        continue
                    }

                    if (!valueNode.get("idShortPath").isTextual) {
                        continue
                    }

                    if (!valueNode.get("nested").asBoolean()) {
                        importantCardsFilterItems.add(
                            ImportantSingleEntryCardFilterItem(
                                node,
                                valueNode.get("idShortPath").asText()
                            )
                        )
                    }

                }

                "multiple" -> {
                    if (valueNode.isArray) {
                        val idPathList = mutableListOf<String>()
                        for (entryNode in valueNode) {

                            if (!checkNodeHasBooleanAndTextualAtKey(
                                    entryNode, "nested", "idShortPath"
                                )
                            ) {
                                continue
                            }

                            if (!entryNode.get("nested").asBoolean()) {
                                idPathList.add(entryNode.get("idShortPath").asText())
                            }

                        }

                        importantCardsFilterItems.add(
                            ImportantMultipleEntryCardFromPathListFilterItem(node, idPathList)
                        )
                    } else {
                        if (!valueNode.get("nested").isBoolean) {
                            continue
                        }

                        if (!valueNode.get("idShortPath").isTextual) {
                            continue
                        }


                        if (valueNode.get("nested").asBoolean()) {
                            importantCardsFilterItems.add(
                                ImportantMultipleEntryCardFromNestedElementFilterItem(
                                    node,
                                    valueNode.get("idShortPath").asText()
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
     * This function is used to check if a node has a boolean and textual value at a key
     */
    private fun checkNodeHasBooleanAndTextualAtKey(
        node: JsonNode?, keyToBoolean: String, keyToText: String
    ): Boolean {
        return (JsonTextUtil().checkNodeHasBooleanAtKey(node, keyToBoolean)
                && JsonTextUtil().checkNodeHasTextualAtKey(node, keyToText))
    }

    /**
     * This function is used to create a product with submodels
     */
    private fun createProductWithSubmodels(
        jsonShell: String,
        jsonSubmodel: String,

        ): Product {
        val shellNode = JsonTextUtil().generateJsonNode(jsonShell)
        val submodelsArray = JsonTextUtil().generateJsonNode(jsonSubmodel)
        val submodelsNodes = JsonTextUtil().arrayNodeToList(submodelsArray)

        val shell = AssetAdministrationShell(shellNode!!, submodelsNodes)
        return Product(shell)
    }

    /**
     * This function is used to test ImportantSection is not null.
     */
    @Test
    fun `apply should return non-null ImportantSection`() {
        val importantSection = importantSectionFilter!!.apply(product_local_battery!!)
        assertNotNull(importantSection)
    }

    /**
     * This function is used to test the expected number of ImportantSection entries
     */
    @Test
    fun `apply should return expected ImportantSection properties`() {
        val importantSection = importantSectionFilter!!.apply(product_local_battery!!)
        assertEquals(
            6,
            importantSection.entries.size
        )
    }

    /**
     * This function is used to test the expected Important Section properties
     */
    @Test
    fun checkExpectedProperty(){
        val importantSection = importantSectionFilter!!.apply(product_local_battery!!)
        val firstCard = importantSection.entries[0]

        if (firstCard is ImportantCardSingleEntry) {
            val firstProperty = firstCard.getProperty()
            assertEquals(
                "2000 kg",
                firstProperty.value
            )
        } else {
            assert(false)
        }
    }

    /**
     * This function is used to test the expected Important Section card.
     */
    @Test
    fun checkExpectedCard(){
        val importantSection = importantSectionFilter!!.apply(product_local_battery!!)
        val card_material_RawCompositionMaterials = importantSection.entries[2]

        if (card_material_RawCompositionMaterials is ImportantCardMultipleEntries) {
            val firstEntry = card_material_RawCompositionMaterials.entries[0]
            val secondEntry = card_material_RawCompositionMaterials.entries[1]

            assertEquals(
                "Kobaltgehalt",
                firstEntry.displayName
            )
            assertEquals(
                "2% ",
                firstEntry.value
            )
           assertEquals(
               "Lithiumgehalt",
               secondEntry.displayName
           )
           assertEquals(
               "5% ",
               secondEntry.value
           )
        } else {
            assert(false)
        }

    }

}