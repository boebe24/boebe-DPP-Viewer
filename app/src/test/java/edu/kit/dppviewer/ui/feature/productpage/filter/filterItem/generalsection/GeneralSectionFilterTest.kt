package edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.generalsection
import edu.kit.dppviewer.data.model.product.util.SettingConstants.USER_LANGUAGE
import com.fasterxml.jackson.databind.JsonNode
import edu.kit.dppviewer.data.model.product.aas4android.AssetAdministrationShell
import edu.kit.dppviewer.data.model.product.model.Product
import edu.kit.dppviewer.data.model.product.util.JsonTextUtil
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.general.GeneralProperty
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import java.io.File

/**
 * This class is used to test the GeneralSectionFilter class
 */
class GeneralSectionFilterTest {


    private var generalSectionFilter: GeneralSectionFilter? = null
    private var product: Product? = null
    private var filterItems: List<GeneralFilterItem>? = null

    val productNameOrder = 0
    val productTypeOrder = 1
    val manufacturerOrder = 2

    val jsonGeneralFilterFile = File(
        javaClass.getResource(
            "/raw/test_filter_template/general_section_filter_old.json"
        )?.path ?: throw IllegalArgumentException("File not found")
    )

    val jsonGeneralFilterItems = jsonGeneralFilterFile.readText()

    /**
     * This function is used to set up the test environment
     */
    @Before
    fun setUp() {
        USER_LANGUAGE = "de"
        val batterySubmodelsJson = File(
            javaClass.getResource(
                "/raw/local_battery_for_test/battery_submodels.json"
            )?.path ?: throw IllegalArgumentException("File not found")
        )

        val batteryShellJson = File(
            javaClass.getResource(
                "/raw/local_battery_for_test/battery_submodels.json"
            )?.path ?: throw IllegalArgumentException("File not found")
        )

        // Parse JSON strings to objects
        product = createProductWithSubmodels(
            batteryShellJson.readText(), batterySubmodelsJson.readText()
        )
        filterItems = getAllGeneralFilterNodes()
        generalSectionFilter = GeneralSectionFilter(filterItems!!)
    }

    /**
     * This function is used to get all general filter nodes
     */
    fun getAllGeneralFilterNodes(): List<GeneralFilterItem> {
        // read general filter items
        val generalNode = JsonTextUtil().generateJsonNode(jsonGeneralFilterItems)
        val generalNodes = JsonTextUtil().arrayNodeToList(generalNode)
        val generalFilterItems = mutableListOf<GeneralFilterItem>()

        for (generalNode in generalNodes) {
            if (checkNodeHasBooleanAndTextualAtKey(
                    generalNode, "nested", "idShortPath"
                )
            ) {
                if (!generalNode.get("nested").asBoolean()) {
                    generalFilterItems.add(
                        GeneralFilterItem(
                            generalNode,
                            generalNode.get("idShortPath").asText()
                        )
                    )
                }
            }

        }
        return generalFilterItems
    }

    /**
     * This function is used to check if a node has a boolean and textual value at a key
     */
    private fun checkNodeHasBooleanAndTextualAtKey(
        node: JsonNode?, keyToBoolean: String, keyToText: String
    ): Boolean {
        return (JsonTextUtil().checkNodeHasBooleanAtKey(
            node, keyToBoolean
        ) && JsonTextUtil().checkNodeHasTextualAtKey(node, keyToText))
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
     * This function is used to test the existence of the General Section class
     */
    @Test
    fun `apply should return non-null GeneralSection`() {
        val generalSection = generalSectionFilter!!.apply(product!!)
        assertNotNull(generalSection, "Expected GeneralSection to be not null")
    }

    /**
     * This function is used to test the expected number of GeneralSection entries
     */
    @Test
    fun checkExpectedNumberOfGeneralSectionEntries() {
        val generalSection = generalSectionFilter!!.apply(product!!)
        if (generalSection != null) {
            assertEquals(
                5, generalSection.entries.size,
                "Expected number of GeneralSection entries"
            )
        } else {
            assert(false)
        }
    }

    /**
     * This function is used to test the expected General Section properties
     */
    @Test
    fun `apply should return expected GeneralSection properties`() {
        val generalSection = generalSectionFilter!!.apply(product!!)
        val firstValue = generalSection.entries[manufacturerOrder]
        if (firstValue is GeneralProperty) {
            assertEquals(
                "Energizer",
                firstValue.value,
                "Manufacturer Name should match"
            )
        } else {
            assert(false)
        }

        val secondValue = generalSection.entries.get(productTypeOrder)
        if (secondValue is GeneralProperty) {
            assertEquals(
                    "Battery",
                    secondValue.value,
                   "Manufacturer Product Type should match"
            )
        } else {
            assert(false)
        }

        val thirdValue = generalSection.entries.get(productNameOrder)
        if (thirdValue is GeneralProperty) {
            assertEquals(
                "Energizer A23 Alkaline",
                thirdValue.value,
                "Manufacturer Product Designation should match"
            )
        } else {
            assert(false)
        }
    }

    /**
     * This function is used to test the general property with unit
     */
    @Test
    fun checkGeneralPropertyWithUnit() {
        val generalSection = generalSectionFilter!!.apply(product!!)
        val fourthValue = generalSection.entries.get(3)
        if (fourthValue is GeneralProperty) {
            assertEquals(
                "CO2 eq Klimawandel",
                fourthValue.displayName,
                "Display name should match"
            )
            assertEquals(
                "2000 kg", fourthValue.value,"Both number and unit should match"
            )
        } else {
            assert(false)
        }

        val fifthValue = generalSection.entries.get(4)
        if (fifthValue is GeneralProperty) {
            assertEquals(
                "TCF CO2eq",
                fifthValue.displayName,
                "Display name should match"
            )
            assertEquals(
                "400 kg", fifthValue.value, "Both number and unit should match"
            )
        }
    }
}
