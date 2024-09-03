package edu.kit.dppviewer.data.model.product.adapter.submodelElement.leaf

import com.fasterxml.jackson.databind.JsonNode
import edu.kit.dppviewer.data.model.product.aas4android.ModelManager
import edu.kit.dppviewer.data.model.product.aas4android.submodelElement.OtherElement
import edu.kit.dppviewer.data.model.product.util.JsonTextUtil
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class OtherElementAdapterTest {
    val rangeModelString_full = """
       {
              "idShort": "RecommendedTemperatureRange",
              "displayName": [
                {
                  "language": "en",
                  "text": "Recommended Temperature Range"
                },
                {
                  "language": "de",
                  "text": "Empfohlener Temperaturbereich"
                }
              ],
              "valueType": "xs:string",
              "min": "35",
              "max": "50",
              "modelType": "Range"
            }
    """.trimIndent()

    val rangeModelString_simple = """
       {
              "idShort": "RecommendedTemperatureRange",
              "valueType": "xs:string",
              "min": "35",
              "max": "50",
              "modelType": "Range"
            }
    """.trimIndent()

    var rangeNode : JsonNode?= null

    @Before
    fun setUp() {
        rangeNode = JsonTextUtil().generateJsonNode(rangeModelString_full)

    }

    @Test
    fun `generate a element model from node`() {
        assertNotNull(rangeNode)
        val rangeElement = ModelManager().createSubmodelElement(rangeNode!!)
        assertEquals(rangeElement.idShort, "RecommendedTemperatureRange")
    }

    @Test
    fun `element value is toString`() {
        assertNotNull(rangeNode)
        val rangeElement = ModelManager().createSubmodelElement(rangeNode!!)
        val rangeAdapter = OtherElementAdapter(rangeElement as OtherElement)
        assertEquals(JsonTextUtil().generateJsonNode(rangeModelString_simple)!!.toPrettyString(),
            rangeElement.getValueAsString(), )
    }





}