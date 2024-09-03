package edu.kit.dppviewer.data.model.product.aas4android

import edu.kit.dppviewer.data.model.product.util.JsonTextUtil
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.BeforeEach
import org.junit.Test


class ModelManagerTest {

    @BeforeEach
    fun setUp() {


    }

    @Test
    fun `check submodel toString`() {

    }

    @Test
    fun `check submodel Element toString`() {
        val submodelElementString = "{\"category\":\"CONSTANT\",\"idShort\":\"ModelNumber\",\"displayName\":[{\"language\":\"en\",\"text\":\"Model Number\"},{\"language\":\"de\",\"text\":\"Modellnummer\"}],\"valueType\":\"xs:string\",\"value\":\"BC-1000\",\"modelType\":\"Property\"}"

        val node = JsonTextUtil().generateJsonNode(submodelElementString)!!
        val submodelElement = ModelManager().createSubmodelElement(node)
        assertEquals(submodelElementString,submodelElement.toString())
    }


    @Test
    fun `check shell toString`() {

    }
}