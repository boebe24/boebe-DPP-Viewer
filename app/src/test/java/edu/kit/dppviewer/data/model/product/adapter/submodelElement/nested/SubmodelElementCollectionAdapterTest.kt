package edu.kit.dppviewer.data.model.product.adapter.submodelElement.nested

import com.fasterxml.jackson.databind.JsonNode
import edu.kit.dppviewer.data.model.product.aas4android.ModelManager
import edu.kit.dppviewer.data.model.product.aas4android.submodelElement.SubmodelElementCollection
import edu.kit.dppviewer.data.model.product.util.JsonModelUtil
import edu.kit.dppviewer.data.model.product.util.JsonTextUtil
import edu.kit.dppviewer.data.model.product.util.SettingConstants.USER_LANGUAGE
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test


class SubmodelElementCollectionAdapterTest {

    val nestedelementCollection = """
            {
        "idShort": "MaterialComposition",
        "displayName": [
          {
            "language": "en",
            "text": "Material Composition"
          },
          {
            "language": "de",
            "text": "Materialzusammensetzung"
          }
        ],
        "value": [
          {
            "idShort": "CobaltContent",
            "displayName": [
              {
                "language": "en",
                "text": "Cobalt Content"
              },
              {
                "language": "de",
                "text": "Kobaltgehalt"
              }
            ],
            "valueType": "xs:string",
            "value": "2%",
            "modelType": "Property"
          },
          {
            "idShort": "LithiumContent",
            "displayName": [
              {
                "language": "en",
                "text": "Lithium Content"
              },
              {
                "language": "de",
                "text": "Lithiumgehalt"
              }
            ],
            "valueType": "xs:string",
            "value": "5%",
            "modelType": "Property"
          }
        ],
        "modelType": "SubmodelElementCollection"
      }
        """.trimIndent()

    val propertyOne = """
            {
            "idShort": "CobaltContent",
            "displayName": [
              {
                "language": "en",
                "text": "Cobalt Content"
              },
              {
                "language": "de",
                "text": "Kobaltgehalt"
              }
            ],
            "valueType": "xs:string",
            "value": "2%",
            "modelType": "Property"
          }
        """.trimIndent()

    val propertyTwo = """
            {
            "idShort": "LithiumContent",
            "displayName": [
              {
                "language": "en",
                "text": "Lithium Content"
              },
              {
                "language": "de",
                "text": "Lithiumgehalt"
              }
            ],
            "valueType": "xs:string",
            "value": "5%",
            "modelType": "Property"
          }
        """.trimIndent()

    var nestedElementNode: JsonNode? = null
    var propertyOneNode: JsonNode? = null
    var propertyTwoNode: JsonNode? = null

    @Before
    fun setUp() {
        nestedElementNode = JsonTextUtil().generateJsonNode(nestedelementCollection)
        propertyOneNode = JsonTextUtil().generateJsonNode(propertyOne)
        propertyTwoNode = JsonTextUtil().generateJsonNode(propertyTwo)
    }

    @Test
    fun `extract children`() {
        assertEquals(
            listOf(propertyOneNode, propertyTwoNode),
            JsonModelUtil().getChildrenNodeFromSubmodelElementNestedNode(nestedElementNode!!)
        )
    }

    @Test
    fun `idShort is correct`() {
        val materialCompositionCollection = ModelManager().createSubmodelElement(nestedElementNode!!)
        assertNotNull(materialCompositionCollection)
        assertEquals( "MaterialComposition",materialCompositionCollection.idShort)
    }

    @Test
    fun `displayName in english`() {
        USER_LANGUAGE = "en"
        val materialCompositionCollection = ModelManager().createSubmodelElement(nestedElementNode!!)
        assertNotNull(materialCompositionCollection)
        assertEquals( "Material Composition",materialCompositionCollection.name)
    }

    @Test
    fun `displayName in german`() {
        USER_LANGUAGE = "de"
        val materialCompositionCollection = ModelManager().createSubmodelElement(nestedElementNode!!)
        assertNotNull(materialCompositionCollection)
        assertEquals("Materialzusammensetzung",materialCompositionCollection.name)
    }

    @Test
    fun `idShort of adpater`() {
        val materialCompositionCollection = ModelManager().createSubmodelElement(nestedElementNode!!)
        val adapter = SubmodelElementCollectionAdapter(materialCompositionCollection as SubmodelElementCollection)
        assertEquals("MaterialComposition",adapter.idShort)
    }

    @Test
    fun `name of adpater`() {
        val materialCompositionCollection = ModelManager().createSubmodelElement(nestedElementNode!!)
        val adapter = SubmodelElementCollectionAdapter(materialCompositionCollection as SubmodelElementCollection)
        USER_LANGUAGE = "de"
        assertEquals("Materialzusammensetzung",adapter.name)
    }

}