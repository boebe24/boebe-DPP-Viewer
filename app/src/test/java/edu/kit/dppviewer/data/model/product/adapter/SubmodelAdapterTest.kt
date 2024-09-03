package edu.kit.dppviewer.data.model.product.adapter

import com.fasterxml.jackson.databind.JsonNode
import edu.kit.dppviewer.data.model.product.aas4android.ModelManager
import edu.kit.dppviewer.data.model.product.aas4android.Submodel
import edu.kit.dppviewer.data.model.product.util.JsonTextUtil
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test



import java.io.File

class SubmodelAdapterTest {

    val jsonProductSubmodelsOne = getResourceStringFromPath("/raw/test_Json_model/product_submodel_one.json")

    var submodelAdapterOne : SubmodelAdapter? = null

    @Before
    fun setUp(){
        val submodelModelnode = getNodeFromResourcePath("/raw/test_Json_Model/product_submodel_one.json")

        val submodelOne = Submodel(submodelModelnode!!)
        submodelAdapterOne = SubmodelAdapter(submodelOne)
    }

    @Test
    fun `get element by id path, does not exist`() {
        assertNull(submodelAdapterOne!!.getSubmodelElementByIdShort(listOf("TechnicalInformations"), false))
    }

    @Test
    fun `get element by id path,  exist, child`() {
        assertNotNull(submodelAdapterOne!!.getSubmodelElementByIdShort(listOf("Repair"), true))
    }

    @Test
    fun `get element by id path,  exist, grandchild `() {
        assertNotNull(submodelAdapterOne!!.getSubmodelElementByIdShort(listOf("Repair", "AvailabilityOfSpareParts"), false))
    }

    @Test
    fun `single child test`() {
        assertTrue(submodelAdapterOne!!.hasOnlySingleChild())
    }

    @Test
    fun `get element by id path,  exist, not wrong nested Attribute`() {
        assertNull(submodelAdapterOne!!.getSubmodelElementByIdShort(listOf("Repair"), false))
    }

    @Test
    fun `get first child`() {
        assertNotNull("Repair",submodelAdapterOne!!.getFirstChild()!!.idShort)
    }

    fun getNodeFromResourcePath(path: String): JsonNode ?{
        return JsonTextUtil().generateJsonNode(getResourceStringFromPath(path))
    }

    fun getResourceStringFromPath(path: String): String{
        return (File(javaClass.getResource(path)?.path ?: throw IllegalArgumentException("File not found"))).readText()
    }
}