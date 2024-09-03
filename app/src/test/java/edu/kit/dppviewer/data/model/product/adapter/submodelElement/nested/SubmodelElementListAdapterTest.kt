package edu.kit.dppviewer.data.model.product.adapter.submodelElement.nested

import com.fasterxml.jackson.databind.JsonNode
import edu.kit.dppviewer.data.model.product.aas4android.ModelManager
import edu.kit.dppviewer.data.model.product.aas4android.submodelElement.SubmodelElementList
import edu.kit.dppviewer.data.model.product.util.JsonModelUtil
import edu.kit.dppviewer.data.model.product.util.JsonTextUtil
import edu.kit.dppviewer.data.model.product.util.SettingConstants.USER_LANGUAGE
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import java.io.File

class SubmodelElementListAdapterTest {



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

    var labelslistNode: JsonNode? = null
    var labelOneNode: JsonNode? = null
    var labelTwoNode: JsonNode? = null

    @Before
    fun setUp() {
        labelslistNode = JsonTextUtil().generateJsonNode(
            getResourceStringFromPath("/raw/test_Json_Model/label_list.json"))
        labelOneNode = JsonTextUtil().generateJsonNode(labelCollectionOne)
        labelTwoNode = JsonTextUtil().generateJsonNode(labelCollectionTwo)
    }

    @Test
    fun `extract children`() {
        assertEquals(
            listOf(labelOneNode, labelTwoNode),
            JsonModelUtil().getChildrenNodeFromSubmodelElementNestedNode(labelslistNode!!)
        )
    }

    @Test
    fun `idShort is correct`() {
        val labelsList = ModelManager().createSubmodelElement(labelslistNode!!)
        assertNotNull(labelsList)
        assertEquals( "Labels",labelsList.idShort)
    }

    @Test
    fun `displayName in english`() {
        USER_LANGUAGE = "en"
        val labelsList = ModelManager().createSubmodelElement(labelslistNode!!)
        assertNotNull(labelsList)
        assertEquals( "Labels", labelsList.name)
    }

    @Test
    fun `displayName in german`() {
        USER_LANGUAGE = "de"
        val labelslist = ModelManager().createSubmodelElement(labelslistNode!!)
        assertNotNull(labelslist)
        assertEquals("Labeln",labelslist.name)
    }

    @Test
    fun `idShort of adpater`() {
        val labelslist = ModelManager().createSubmodelElement(labelslistNode!!)
        val adapter = SubmodelElementListAdapter(labelslist as SubmodelElementList)
        assertEquals("Labels",adapter.idShort)
    }

    @Test
    fun `name of adapter`() {
        val labelslist = ModelManager().createSubmodelElement(labelslistNode!!)
        val adapter = SubmodelElementListAdapter(labelslist as SubmodelElementList)
        USER_LANGUAGE = "de"
        assertEquals("Labeln",adapter.name)
    }

    fun getResourceStringFromPath(path: String): String{

        return (File(javaClass.getResource(path)?.path ?: throw IllegalArgumentException("File not found"))).readText()
    }

}
