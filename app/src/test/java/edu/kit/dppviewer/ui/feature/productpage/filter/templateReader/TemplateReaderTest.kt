package edu.kit.dppviewer.ui.feature.productpage.filter.templateReader


import edu.kit.dppviewer.data.model.product.aas4android.AssetAdministrationShell
import edu.kit.dppviewer.data.model.product.model.Product
import edu.kit.dppviewer.data.model.product.util.JsonTextUtil
import edu.kit.dppviewer.data.model.product.util.LOCAL_BATTERY_SHELL_12
import edu.kit.dppviewer.data.model.product.util.LOCAL_BATTERY_SUBMODELS_12
import edu.kit.dppviewer.data.model.product.util.SettingConstants.USER_LANGUAGE
import edu.kit.dppviewer.ui.feature.productpage.filter.ProductFilter
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.GENERAL_SECTION_NODE_STRING
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.IMPORTANT_SECTION_NODE_STRING_BATTERY
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.IMPORTANT_SECTION_NODE_STRING_SMARTPHONE
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.IMPORTANT_SECTION_NODE_STRING_TEXTILE
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.OTHER_SECTION_NODE_STRING_BATTERY
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.OTHER_SECTION_NODE_STRING_SMARTPHONE
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.OTHER_SECTION_NODE_STRING_TEXTILE
import edu.kit.dppviewer.ui.feature.productpage.product.model.FilteredProduct
import edu.kit.dppviewer.ui.feature.productpage.product.model.ProductType
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.general.GeneralProperty
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.io.File

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class TemplateReaderTest {

    var templateReader: TemplateReader? = null

    var filteredProduct: FilteredProduct? = null


    @Before
    fun setUp() = runBlocking {
        USER_LANGUAGE = "de"
        GENERAL_SECTION_NODE_STRING =  getResourceStringFromPath("/raw/test_filter_template/general_section_filter_old.json")

        //GENERAL_SECTION_NODE_STRING = File("src/main/assets/filter_template/general_section_filter.json")
        //    .bufferedReader()
        //    .use { it.readText() }

        IMPORTANT_SECTION_NODE_STRING_SMARTPHONE = getResourceStringFromPath("/raw/important_section_filter_smartphone.json")
        IMPORTANT_SECTION_NODE_STRING_BATTERY = getResourceStringFromPath("/raw/important_section_filter_battery.json")
        IMPORTANT_SECTION_NODE_STRING_TEXTILE = getResourceStringFromPath("/raw/important_section_filter_textile.json")

        OTHER_SECTION_NODE_STRING_TEXTILE = getResourceStringFromPath("/raw/other_section_filter_textile.json")
        OTHER_SECTION_NODE_STRING_BATTERY = getResourceStringFromPath("/raw/other_section_filter_battery.json")
        OTHER_SECTION_NODE_STRING_SMARTPHONE = getResourceStringFromPath("/raw/other_section_filter_smartphone.json")



        templateReader = TemplateReader()
        val example_battery_aashell =
            AssetAdministrationShell(
                JsonTextUtil().generateJsonNode(LOCAL_BATTERY_SHELL_12)!!,
                JsonTextUtil().arrayNodeToList(
                    JsonTextUtil().generateJsonNode(
                        LOCAL_BATTERY_SUBMODELS_12
                    )!!
                )
            )


        var unfilteredProduct = Product(example_battery_aashell)

        var productFilter = ProductFilter()


        filteredProduct = productFilter.apply(unfilteredProduct)


    }

    @Test
    fun `general filter from json, number of sections correct`() {

        assertNotNull(templateReader)
        assertEquals(5, templateReader!!.getAllGeneralFilterNodes().size)

    }

    @Test
    fun `important filter from json, number of sections correct,smartphone`() {
        assertEquals(3, templateReader!!.getAllImportantCardFilters(ProductType.SMARTPHONE).size)

    }

    @Test
    fun `important filter from json, number of sections correct,battery`() {
        assertEquals(6, templateReader!!.getAllImportantCardFilters(ProductType.BATTERY).size)

    }

    @Test
    fun `important filter from json, number of sections correct,textile`() {
        assertEquals(4, templateReader!!.getAllImportantCardFilters(ProductType.TEXTILE).size)

    }

    @Test
    fun `important filter from json, number of sections correct,unrecognised type`() {
        assertEquals(0, templateReader!!.getAllImportantCardFilters(ProductType.OTHER).size)

    }

    @Test
    fun `filtered result, not null`() = runBlocking {
        assertNotNull(filteredProduct)
    }

    @Test
    fun `filtered result, product name`() {
        assertEquals("Energizer A23 Alkaline", filteredProduct!!.name)
    }

    @Test
    fun `filtered result, product type`() {
        assertEquals(ProductType.BATTERY, filteredProduct!!.type)

        assertNotEquals(ProductType.SMARTPHONE, filteredProduct!!.type)
    }

    @Test
    fun `filtered result, battery, number of sections correct`() {
        assertEquals(3, filteredProduct!!.sections.size)
    }

    @Test
    fun `filtered result, battery, general section, number of entries correct`() {

        val entries = filteredProduct!!.sections[0].entries
        val entriesNames = mutableListOf<String>()
        for (entry in entries) {
            if (entry is GeneralProperty) {
                entriesNames.add(entry.displayName)
                println(entry.displayName)
            }
        }
        //assertEquals(5, entriesNames.size)
        assertEquals(6, filteredProduct!!.sections[0].entries.size)
    }

    @Test
    fun `filtered result, battery, important section, number of entries correct`() {
        assertEquals(6, filteredProduct!!.sections[1].entries.size)
    }

    @Test
    fun `filtered result, battery, other section, number of group correct`() {
        assertEquals(2, filteredProduct!!.sections[2].entries.size)
    }


    fun getResourceStringFromPath(path: String): String{

        val local_json_file = File(javaClass.getResource(path)?.path ?: throw IllegalArgumentException("File not found"))

        return (File(javaClass.getResource(path)?.path ?: throw IllegalArgumentException("File not found"))).readText()
    }
}