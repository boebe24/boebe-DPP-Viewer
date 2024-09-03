package edu.kit.dppviewer.data.model.product.util

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.databind.node.NullNode
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import java.io.File

class JsonTextUtilTest {

    val labelCollectionOne = """
            {
              "idShort": "",
              "displayName": [
                {
                  "language": "en",
                  "text": "Oeko-Tex Standard 100"
                },
                {
                  "language": "de",
                  "text": "Oeko-Tex Standard 100"
                }
              ],
              "value": [
                {
                  "idShort": "IssuingBody",
                  "displayName": [
                    {
                      "language": "en",
                      "text": "Issuing Body"
                    },
                    {
                      "language": "de",
                      "text": "Ausstellende Stelle"
                    }
                  ],
                  "valueType": "xs:string",
                  "value": "Hohenstein Institute",
                  "modelType": "Property"
                },
                {
                  "idShort": "IssueDate",
                  "displayName": [
                    {
                      "language": "en",
                      "text": "Issue Date"
                    },
                    {
                      "language": "de",
                      "text": "Ausstellungsdatum"
                    }
                  ],
                  "valueType": "xs:string",
                  "value": "2023-01-15",
                  "modelType": "Property"
                },
                {
                  "idShort": "ValidityPeriod",
                  "displayName": [
                    {
                      "language": "en",
                      "text": "Validity Period"
                    },
                    {
                      "language": "de",
                      "text": "G\u00FCltigkeitsdauer"
                    }
                  ],
                  "valueType": "xs:string",
                  "value": "1 year",
                  "modelType": "Property"
                },
                {
                  "idShort": "LabelNumber",
                  "displayName": [
                    {
                      "language": "en",
                      "text": "Label Number"
                    },
                    {
                      "language": "de",
                      "text": "Labelnummer"
                    }
                  ],
                  "valueType": "xs:int",
                  "value": "123456789",
                  "modelType": "Property"
                },
                {
                  "idShort": "LabelType",
                  "displayName": [
                    {
                      "language": "en",
                      "text": "Label Type"
                    },
                    {
                      "language": "de",
                      "text": "Labeltyp"
                    }
                  ],
                  "valueType": "xs:string",
                  "value": "Safety",
                  "modelType": "Property"
                },
                {
                  "idShort": "Criteria",
                  "displayName": [
                    {
                      "language": "en",
                      "text": "Criteria"
                    },
                    {
                      "language": "de",
                      "text": "Kriterien"
                    }
                  ],
                  "valueType": "xs:string",
                  "value": "Tested for harmful substances",
                  "modelType": "Property"
                }
              ],
              "modelType": "SubmodelElementCollection"
            }
        """.trimIndent()

    val labelCollectionTwo = """
            {
              "idShort": "",
              "displayName": [
                {
                  "language": "en",
                  "text": "Fairtrade"
                },
                {
                  "language": "de",
                  "text": "Fairtrade"
                }
              ],
              "value": [
                {
                  "idShort": "IssuingBody",
                  "displayName": [
                    {
                      "language": "en",
                      "text": "Issuing Body"
                    },
                    {
                      "language": "de",
                      "text": "Ausstellende Stelle"
                    }
                  ],
                  "valueType": "xs:string",
                  "value": "Fair Trade USA",
                  "modelType": "Property"
                },
                {
                  "idShort": "IssueDate",
                  "displayName": [
                    {
                      "language": "en",
                      "text": "Issue Date"
                    },
                    {
                      "language": "de",
                      "text": "Ausstellungsdatum"
                    }
                  ],
                  "valueType": "xs:string",
                  "value": "2023-02-10",
                  "modelType": "Property"
                },
                {
                  "idShort": "ValidityPeriod",
                  "displayName": [
                    {
                      "language": "en",
                      "text": "Validity Period"
                    },
                    {
                      "language": "de",
                      "text": "G\u00FCltigkeitsdauer"
                    }
                  ],
                  "valueType": "xs:string",
                  "value": "24 months",
                  "modelType": "Property"
                },
                {
                  "idShort": "LabelNumber",
                  "displayName": [
                    {
                      "language": "en",
                      "text": "Label Number"
                    },
                    {
                      "language": "de",
                      "text": "Labelnummer"
                    }
                  ],
                  "valueType": "xs:int",
                  "value": "987654321",
                  "modelType": "Property"
                },
                {
                  "idShort": "LabelType",
                  "displayName": [
                    {
                      "language": "en",
                      "text": "Label Type"
                    },
                    {
                      "language": "de",
                      "text": "Labeltyp"
                    }
                  ],
                  "valueType": "xs:string",
                  "value": "Ethical",
                  "modelType": "Property"
                },
                {
                  "idShort": "Criteria",
                  "displayName": [
                    {
                      "language": "en",
                      "text": "Criteria"
                    },
                    {
                      "language": "de",
                      "text": "Kriterien"
                    }
                  ],
                  "valueType": "xs:string",
                  "value": "Ethically sourced materials and fair labor practices",
                  "modelType": "Property"
                }
              ],
              "modelType": "SubmodelElementCollection"
            }
        """.trimIndent()

    var labelslistsString: String = ""

    val empty_string = ""

    val empty_array_string = "[]"

    var empty_array_node : JsonNode ?= null
    var array_battey_submodels_node : JsonNode ?= null
    var array_battey_first_submodel_node : JsonNode ?= null

    val emptyJsonNode: JsonNode = ObjectMapper().createObjectNode()

    @Before
    fun setUp() {
        labelslistsString =
            getResourceStringFromPath("/raw/test_Json_Model/label_list.json")
        array_battey_submodels_node = JsonTextUtil().generateJsonNode(getResourceStringFromPath("/raw/local_battery_for_test/battery_submodels.json"))
        array_battey_first_submodel_node = JsonTextUtil().generateJsonNode(getResourceStringFromPath("/raw/local_battery_for_test/battery_first_submodel.json"))
        empty_array_node = JsonTextUtil().generateJsonNode(empty_array_string)
    }

    @Test
    fun `general Json node, from json file`(){
        val jsonNode = JsonTextUtil().generateJsonNode(labelslistsString)
        assertNotNull(jsonNode)
    }

    @Test
    fun `general Json node, empty string`(){
        val jsonNode = JsonTextUtil().generateJsonNode(empty_string)
        assertNotNull(jsonNode)
        assertTrue(jsonNode!!.isEmpty)
    }

    @Test
    fun arrayNodeGetOne() {
        assertEquals(array_battey_first_submodel_node, JsonTextUtil().arrayNodeGetOne(array_battey_submodels_node as ArrayNode))
    }

    @Test
    fun `arrayNodeGetOne, but null node`(){
        assertEquals(NullNode.getInstance(), JsonTextUtil().arrayNodeGetOne(null))
    }

    @Test
    fun `arrayNodeGetOne, but empty array node`(){
        assertEquals(NullNode.getInstance(), JsonTextUtil().arrayNodeGetOne(empty_array_node as ArrayNode))
    }


    @Test
    fun `arrayNodeToList, but null node`() {
        assertEquals(mutableListOf<JsonNode>(), JsonTextUtil().arrayNodeToList(null))
    }

    @Test
    fun `arrayNodeToList, but not array`() {
        val labelOneNode = JsonTextUtil().generateJsonNode(labelCollectionOne)
        assertEquals(mutableListOf<JsonNode>(), JsonTextUtil().arrayNodeToList(labelOneNode))
    }

    @Test
    fun `getEachInChildren, but null node`() {
        assertEquals(mutableListOf<JsonNode>(), JsonTextUtil().getEachInChildren(null, "idShort"))
    }

    @Test
    fun `checkNodeHasBooleanAtKey, no such key as all`() {
        assertFalse(JsonTextUtil().checkNodeHasBooleanAtKey(array_battey_submodels_node as ArrayNode,"password") )
    }

    @Test
    fun `checkNodeHasTextualAtKey, no such key at all`() {
        assertFalse(JsonTextUtil().checkNodeHasTextualAtKey(array_battey_submodels_node as ArrayNode,"password") )
    }

    @Test
    fun `checkNodeHasKey, but null node`() {
        assertFalse(JsonTextUtil().checkNodeHasKey(null, "idShort"))
    }

    @Test
    fun `checkNodeHasKey, but has null value`() {
        val labelCollectionTwo_null_idshort = """
            {
              "idShort": null ,
              "displayName": [
                {
                  "language": "en",
                  "text": "Fairtrade"
                },
                {
                  "language": "de",
                  "text": "Fairtrade"
                }
              ],
              "value": [
                {
                  "idShort": "IssuingBody",
                  "displayName": [
                    {
                      "language": "en",
                      "text": "Issuing Body"
                    },
                    {
                      "language": "de",
                      "text": "Ausstellende Stelle"
                    }
                  ],
                  "valueType": "xs:string",
                  "value": "Fair Trade USA",
                  "modelType": "Property"
                },
                {
                  "idShort": "IssueDate",
                  "displayName": [
                    {
                      "language": "en",
                      "text": "Issue Date"
                    },
                    {
                      "language": "de",
                      "text": "Ausstellungsdatum"
                    }
                  ],
                  "valueType": "xs:string",
                  "value": "2023-02-10",
                  "modelType": "Property"
                },
                {
                  "idShort": "ValidityPeriod",
                  "displayName": [
                    {
                      "language": "en",
                      "text": "Validity Period"
                    },
                    {
                      "language": "de",
                      "text": "G\u00FCltigkeitsdauer"
                    }
                  ],
                  "valueType": "xs:string",
                  "value": "24 months",
                  "modelType": "Property"
                },
                {
                  "idShort": "LabelNumber",
                  "displayName": [
                    {
                      "language": "en",
                      "text": "Label Number"
                    },
                    {
                      "language": "de",
                      "text": "Labelnummer"
                    }
                  ],
                  "valueType": "xs:int",
                  "value": "987654321",
                  "modelType": "Property"
                },
                {
                  "idShort": "LabelType",
                  "displayName": [
                    {
                      "language": "en",
                      "text": "Label Type"
                    },
                    {
                      "language": "de",
                      "text": "Labeltyp"
                    }
                  ],
                  "valueType": "xs:string",
                  "value": "Ethical",
                  "modelType": "Property"
                },
                {
                  "idShort": "Criteria",
                  "displayName": [
                    {
                      "language": "en",
                      "text": "Criteria"
                    },
                    {
                      "language": "de",
                      "text": "Kriterien"
                    }
                  ],
                  "valueType": "xs:string",
                  "value": "Ethically sourced materials and fair labor practices",
                  "modelType": "Property"
                }
              ],
              "modelType": "SubmodelElementCollection"
            }
        """.trimIndent()
        assertFalse(JsonTextUtil().checkNodeHasKey(JsonTextUtil().generateJsonNode(labelCollectionTwo_null_idshort), "idShort"))
    }

    @Test
    fun `checkValueAtKey, but null node `() {
        assertFalse(JsonTextUtil().checkValueAtKey(null, "idShort", "ProductPrice"))
    }

    @Test
    fun `checkValueAtKey, but has null value `() {
        val labelCollectionTwo_null_modelType = """
            {
              "idShort": "labels2",
              "displayName": [
                {
                  "language": "en",
                  "text": "Fairtrade"
                },
                {
                  "language": "de",
                  "text": "Fairtrade"
                }
              ],
              "value": [
                {
                  "idShort": "IssuingBody",
                  "displayName": [
                    {
                      "language": "en",
                      "text": "Issuing Body"
                    },
                    {
                      "language": "de",
                      "text": "Ausstellende Stelle"
                    }
                  ],
                  "valueType": "xs:string",
                  "value": "Fair Trade USA",
                  "modelType": "Property"
                },
                {
                  "idShort": "IssueDate",
                  "displayName": [
                    {
                      "language": "en",
                      "text": "Issue Date"
                    },
                    {
                      "language": "de",
                      "text": "Ausstellungsdatum"
                    }
                  ],
                  "valueType": "xs:string",
                  "value": "2023-02-10",
                  "modelType": "Property"
                },
                {
                  "idShort": "ValidityPeriod",
                  "displayName": [
                    {
                      "language": "en",
                      "text": "Validity Period"
                    },
                    {
                      "language": "de",
                      "text": "G\u00FCltigkeitsdauer"
                    }
                  ],
                  "valueType": "xs:string",
                  "value": "24 months",
                  "modelType": "Property"
                },
                {
                  "idShort": "LabelNumber",
                  "displayName": [
                    {
                      "language": "en",
                      "text": "Label Number"
                    },
                    {
                      "language": "de",
                      "text": "Labelnummer"
                    }
                  ],
                  "valueType": "xs:int",
                  "value": "987654321",
                  "modelType": "Property"
                },
                {
                  "idShort": "LabelType",
                  "displayName": [
                    {
                      "language": "en",
                      "text": "Label Type"
                    },
                    {
                      "language": "de",
                      "text": "Labeltyp"
                    }
                  ],
                  "valueType": "xs:string",
                  "value": "Ethical",
                  "modelType": "Property"
                },
                {
                  "idShort": "Criteria",
                  "displayName": [
                    {
                      "language": "en",
                      "text": "Criteria"
                    },
                    {
                      "language": "de",
                      "text": "Kriterien"
                    }
                  ],
                  "valueType": "xs:string",
                  "value": "Ethically sourced materials and fair labor practices",
                  "modelType": "Property"
                }
              ],
              "modelType": null
            }
        """.trimIndent()
        assertFalse(JsonTextUtil().checkValueAtKey(JsonTextUtil().generateJsonNode(labelCollectionTwo_null_modelType), "modelType", "SubmodelElementList"))
    }

    fun getResourceStringFromPath(path: String): String{

        return (File(javaClass.getResource(path)?.path ?: throw IllegalArgumentException("File not found"))).readText()
    }
}