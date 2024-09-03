package edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.treesection

import com.fasterxml.jackson.databind.JsonNode
import edu.kit.dppviewer.data.model.product.aas4android.AssetAdministrationShell
import edu.kit.dppviewer.data.model.product.model.Product
import edu.kit.dppviewer.data.model.product.util.JsonTextUtil
import edu.kit.dppviewer.data.model.product.util.SettingConstants.USER_LANGUAGE
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.tree.TreeGroup
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.tree.TreeProperty
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import java.io.File

/**
 * This class is used to test the OtherSectionFilter class
 */
class TreeSectionFilterTest {
    private var treeSectionFilter: TreeSectionFilter? = null
    private var product: Product? = null
    private var filterItems: List<TreeGroupForSubmodelFilterItem>? = null

    val jsonOtherFilterFile = File(javaClass.getResource(
        "/raw/other_section_filter_battery.json")?.path ?: throw IllegalArgumentException("File not found"))

    val jsonOtherFilterItems = jsonOtherFilterFile.readText()

    @Before
    /**
     * This function is used to set up the test environment
     */
    fun setUp() {
        USER_LANGUAGE = "de"
        val batterySubmodelsJson = File(javaClass.getResource(
            "/raw/local_battery_for_test/battery_submodels.json")?.path ?: throw IllegalArgumentException("File not found"))

        val batteryShellJson = File(javaClass.getResource(
            "/raw/local_battery_for_test/battery_submodels.json")?.path ?: throw IllegalArgumentException("File not found"))

        // Parse JSON strings to objects
        product = createProductWithSubmodels(
            batteryShellJson.readText(), batterySubmodelsJson.readText()
        )
        filterItems = getAllOtherFilterNodes()
        treeSectionFilter = TreeSectionFilter(filterItems!!)
    }

    /**
     * This function is used to get all other filter nodes
     */
    fun getAllOtherFilterNodes(): List<TreeGroupForSubmodelFilterItem> {

        val otherNodes = JsonTextUtil().generateJsonNode(this.jsonOtherFilterItems)
        val filterItemForSubmodel = mutableListOf<TreeGroupForSubmodelFilterItem>()

        if (otherNodes!!.isArray) {
            for (submodelNode in otherNodes) {

                if (!checkNodeHasBooleanAndTextualAtKey(
                        submodelNode, "nested", "submodelID"
                    )
                ) {
                    continue
                }

                if (submodelNode.get("nested").asBoolean()) {
                    filterItemForSubmodel.add(
                        TreeGroupForSubmodelFilterItem(
                            submodelNode,
                            JsonTextUtil().checkNodeHasKey(submodelNode, "displayedIDs"),
                            submodelNode.get("submodelID").asText()
                        )
                    )
                }

            }
        }
        return filterItemForSubmodel
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
     * This function is used to check if the amount of filterItems is correct.
     */
    @Test
    fun checkNumberOfFilterItems() {
        assertEquals(2, filterItems!!.size)
    }

    /**
     * This function is used to check if the product is not null
     */
    @Test
    fun `apply should return non-null otherSection`() {
        val otherSection = treeSectionFilter!!.apply(product!!)
        assertNotNull(otherSection, "Expected OtherSection to be not null")
    }

    /**
     * This function is used to check the total number of of the other section entries.
     */
    @Test
    fun checkTotalNumberOfSectionEntries() {
        val otherSection = treeSectionFilter!!.apply(product!!)
        if (otherSection != null) {
            assertEquals(
                2,
                otherSection.entries.size,
                "Expected number of OtherSection entries"
            )
        } else {
            Assert.fail("Expected OtherSection to be not null")
        }
    }

    /**
     * This function is used to check the first entry of the other section, which only has one child.
     */
    @Test
    fun checkFirstEntry() {
        val otherSection = treeSectionFilter!!.apply(product!!)
        val firstOtherEntry = otherSection!!.entries[0]
        if (firstOtherEntry is TreeGroup) {
            assertEquals(firstOtherEntry.getDisplayName(), "Umweltverträglichkeit")
            assertEquals(firstOtherEntry.getChildren().size, 2)

            // Check the first child.
            val firstChild = firstOtherEntry.getChildren().get(0)
            if (firstChild is TreeProperty) {
                assertEquals(firstChild.displayName, "Gefährliche Materialien")
                assertEquals(firstChild.value, "Contains cobalt and lithium")
            } else {
                Assertions.fail("Expected Type is OtherProperty")
            }

        } else {
            Assertions.fail("Expected Type is OtherGroup")
        }
    }

    /**
     * This function is used to check the second entry of the other section.
     */
   @Test
    fun `apply should return expected otherEntry`() {
        val otherSection = treeSectionFilter!!.apply(product!!)
        val secondOtherEntry = otherSection!!.entries[1]
        if (secondOtherEntry is TreeGroup) {
            // Check the total number of Children of the second entry.
            val expectedTotalNumberOfChildren = secondOtherEntry.getChildren().size
            assertEquals(expectedTotalNumberOfChildren, 1)

            // Check the first and only child.
            val firstChild = secondOtherEntry.getChildren().get(0)
            if (firstChild is TreeGroup) {
                assertEquals(
                    "Remanufacture - ReturnOptions - ContactInformation",
                    firstChild.getDisplayName())
            } else {
                Assertions.fail("Expected Type is OtherGroup")
            }

        } else {
            Assertions.fail("Expected Type is OtherGroup")
        }
    }


}