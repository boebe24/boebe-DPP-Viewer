package edu.kit.dppviewer.data.model.product.util


import com.fasterxml.jackson.databind.JsonNode
import edu.kit.dppviewer.data.model.product.aas4android.AssetAdministrationShell
import edu.kit.dppviewer.data.model.product.model.Product
import edu.kit.dppviewer.data.model.product.util.SettingConstants.USER_LANGUAGE
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.io.File

class JsonModelUtilTest {

    val jsonProductShell = getResourceStringFromPath("/raw/test_Json_model/json_product_shell.json")

    val jsonProductSubmodelsOne = getResourceStringFromPath("/raw/test_Json_model/product_submodel_one.json")

    val jsonProductSubmodelsTwo = getResourceStringFromPath("/raw/test_Json_model/product_submodel_two.json")

    var product: Product? = null


    @Before
    fun setUp() {
        USER_LANGUAGE = "de"
    }

    @Test
    fun testLoadRecourses() {
        val batterySubmodelsJson = File(javaClass.getResource("/battery_submodels.json")?.path ?: throw IllegalArgumentException("File not found"))

        val fileNode = JsonTextUtil().generateJsonNode(batterySubmodelsJson.readText())

        val submodelLists = JsonTextUtil().arrayNodeToList(fileNode)

        assertEquals(submodelLists.size, 8)
    }

    @Test
    fun testLoadRecoursesRaw() {
        val batterySubmodelsJson = File(javaClass.getResource("/raw/test_filter_template/battery_submodels.json")?.path ?: throw IllegalArgumentException("File not found"))

        val fileNode = JsonTextUtil().generateJsonNode(batterySubmodelsJson.readText())

        val submodelLists = JsonTextUtil().arrayNodeToList(fileNode)

        assertEquals(submodelLists.size, 8)
    }

    @Test
    fun testLoadRecoursesLocalBattery() {
        val batterySubmodelsJson = File(javaClass.getResource("/raw/local_battery_for_test/battery_shell.json")?.path ?: throw IllegalArgumentException("File not found"))

        val fileNode = JsonTextUtil().generateJsonNode(batterySubmodelsJson.readText())

        val idNode = fileNode!!.get("id")

        assertTrue(idNode.isTextual)
        assertEquals("https://example.com/ids/sm/9143_8002_7042_5188", idNode.textValue())
    }



    @Test
    fun generateProduct() {



        val exampleBatteryShell =
            AssetAdministrationShell(
                JsonTextUtil().generateJsonNode(jsonProductShell)!!,
                listOf(
                    JsonTextUtil().generateJsonNode(jsonProductSubmodelsOne)!!,
                    JsonTextUtil().generateJsonNode(jsonProductSubmodelsTwo)!!
                )
            )

        product = Product(exampleBatteryShell)

        assertEquals("Battery_DPP", product!!.name)
    }

    @Test
    fun `shell node, not null`() {
        val shellNode = JsonTextUtil().generateJsonNode(LOCAL_BATTERY_SHELL_12)
        assertNotNull(shellNode)
    }

    @Test
    fun `shell node, check idShort`() {
        val shellNode = JsonTextUtil().generateJsonNode(LOCAL_BATTERY_SHELL_12)
        assertEquals("Battery_DPP", shellNode!!.get("idShort").textValue())
    }

    @Test
    fun `shell node, check id`() {
        val shellNode = JsonTextUtil().generateJsonNode(LOCAL_BATTERY_SHELL_12)
        assertEquals(
            "https://example.com/ids/sm/9143_8002_7042_5188",
            shellNode!!.get("id").textValue()
        )
    }

    @Test
    fun `shell node, number of submodels contained`() {
        val submodelsNode = JsonTextUtil().generateJsonNode(LOCAL_BATTERY_SUBMODELS_12)
        if (submodelsNode!!.isArray) {

            assertEquals(8, submodelsNode.size())
        }

    }




    @Test
    fun `check if node has textual value`() {
        val submodelElementString = """
            {
        "category": "CONSTANT",
        "idShort": "ModelNumber",
        "displayName": [
          {
            "language": "en",
            "text": "Model Number"
          },
          {
            "language": "de",
            "text": "Modellnummer"
          }
        ],
        "valueType": "xs:string",
        "value": "BC-1000",
        "modelType": "Property"
      }
        """.trimIndent()

        val submodelElementNode = JsonTextUtil().generateJsonNode(submodelElementString)
        assertTrue(JsonModelUtil().checkHasTextualValue(submodelElementNode!!))

    }


    @Test
    fun `get display name or id, both exists`() {
        val submodelElementString = """
            {
        "category": "CONSTANT",
        "idShort": "ModelNumber",
        "displayName": [
          {
            "language": "en",
            "text": "Model Number"
          },
          {
            "language": "de",
            "text": "Modellnummer"
          }
        ],
        "valueType": "xs:string",
        "value": "BC-1000",
        "modelType": "Property"
      }
        """.trimIndent()

        val submodelElementNode = JsonTextUtil().generateJsonNode(submodelElementString)
        assertEquals(
            "Modellnummer",
            JsonModelUtil().getDisplayNameOrIdShort(submodelElementNode!!)
        )
    }

    @Test
    fun `get display name or id, when node has no displayname`() {
        val submodelElementString = """
            {
        "category": "CONSTANT",
        "idShort": "ModelNumber",
        "valueType": "xs:string",
        "value": "BC-1000",
        "modelType": "Property"
      }
        """.trimIndent()

        val submodelElementNode = JsonTextUtil().generateJsonNode(submodelElementString)
        assertEquals(
            "ModelNumber",
            JsonModelUtil().getDisplayNameOrIdShort(submodelElementNode!!)
        )
    }


    @Test
    fun `get idShort`() {
        val submodelElementString = """
            {
        "category": "CONSTANT",
        "idShort": "ModelNumber",
        "displayName": [
          {
            "language": "en",
            "text": "Model Number"
          },
          {
            "language": "de",
            "text": "Modellnummer"
          }
        ],
        "valueType": "xs:string",
        "value": "BC-1000",
        "modelType": "Property"
      }
        """.trimIndent()

        val submodelElementNode = JsonTextUtil().generateJsonNode(submodelElementString)
        assertEquals("ModelNumber", JsonModelUtil().getIdShortFromNode(submodelElementNode!!))

    }

    @Test
    fun `read node, get description, when there is only description in english`() {

        val submodelElementString = """
            {
                    "idShort": "RoleOfContactPerson",
                    "description": [
                      {
                        "language": "en",
                        "text": "If no IRDI available, custom input as String may also be accepted."
                      }
                    ],
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAO204#003"
                        }
                      ]
                    },
                    "qualifiers": [
                      {
                        "type": "Multiplicity",
                        "valueType": "xs:string",
                        "value": "ZeroToOne"
                      }
                    ],
                    "valueType": "xs:string",
                    "value": "0173-1#07-AAS931#001",
                    "modelType": "Property"
                  }
            """.trimIndent()

        val submodelElementNode = JsonTextUtil().generateJsonNode(submodelElementString)
        assertEquals(
            "If no IRDI available, custom input as String may also be accepted.",
            JsonModelUtil().getDescriptionFromNode(submodelElementNode!!)
        )

    }

    @Test
    fun `multiple language string, select text`() {
        val multipleLanguageString = """
            [
          {
            "language": "en",
            "text": "Model Number"
          },
          {
            "language": "de",
            "text": "Modellnummer"
          }
        ]
        """.trimIndent()

        val multipleLanguageNode = JsonTextUtil().generateJsonNode(multipleLanguageString)
        assertEquals(
            "Modellnummer",
            JsonModelUtil().selectStringFromMultiLanguageNode(multipleLanguageNode!!)
        )
    }


    @Test
    fun `submodel element leaf, get value as string`() {
        val submodelElementString = """
            {
        "category": "CONSTANT",
        "idShort": "ModelNumber",
        "displayName": [
          {
            "language": "en",
            "text": "Model Number"
          },
          {
            "language": "de",
            "text": "Modellnummer"
          }
        ],
        "valueType": "xs:string",
        "value": "BC-1000",
        "modelType": "Property"
      }
        """.trimIndent()

        val submodelElementNode = JsonTextUtil().generateJsonNode(submodelElementString)
        assertEquals(
            "BC-1000",
            JsonModelUtil().getValueFromSubmodelElementLeafNode(submodelElementNode!!)
        )
    }

    @Test
    fun `SubmodelElementNestedNode, collection, extract children`() {
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

        val nestedElementNode = JsonTextUtil().generateJsonNode(nestedelementCollection)
        val propertyOneNode = JsonTextUtil().generateJsonNode(propertyOne)
        val propertyTwoNode = JsonTextUtil().generateJsonNode(propertyTwo)

        assertEquals(
            listOf(propertyOneNode, propertyTwoNode),
            JsonModelUtil().getChildrenNodeFromSubmodelElementNestedNode(nestedElementNode!!)
        )
    }



    @Test
    fun `SubmodelElementNestedNode, list, extract children`() {
        val nestedelementListNode = getNodeFromResourcePath("/raw/test_Json_model/submodelelementlist_node.json")

        val propertyOne = """
            {
      "idShort": "StepOne",
      "value": [
        {
          "language": "en",
          "text": "Assemble the dump truck as per the manual in the package."
        }
      ],
      "modelType": "MultiLanguageProperty"
    }
    """.trimIndent()

        val propertyTwo = """
            {
      "idShort": "StepTwo",
      "value": [
        {
          "language": "en",
          "text": "Put simulated props into the carriage."
        }
      ],
      "modelType": "MultiLanguageProperty"
    }
        """.trimIndent()

        val propertyThree = """
            {
      "idShort": "StepThree",
      "value": [
        {
          "language": "en",
          "text": "Pull to tilt the carriage to dump."
        }
      ],
      "modelType": "MultiLanguageProperty"
    }
        """.trimIndent()


        val propertyOneNode = JsonTextUtil().generateJsonNode(propertyOne)
        val propertyTwoNode = JsonTextUtil().generateJsonNode(propertyTwo)
        val propertyThreeNode = JsonTextUtil().generateJsonNode(propertyThree)

        assertEquals(
            listOf(propertyOneNode, propertyTwoNode, propertyThreeNode),
            JsonModelUtil().getChildrenNodeFromSubmodelElementNestedNode(nestedelementListNode!!)
        )
    }

    @Test
    fun `model node, read model type`() {
        var submodelElementString = """
            {
        "category": "CONSTANT",
        "idShort": "ModelNumber",
        "displayName": [
          {
            "language": "en",
            "text": "Model Number"
          },
          {
            "language": "de",
            "text": "Modellnummer"
          }
        ],
        "valueType": "xs:string",
        "value": "BC-1000",
        "modelType": "Property"
      }
        """.trimIndent()

        val submodelElementNode = JsonTextUtil().generateJsonNode(submodelElementString)
        assertEquals("Property", JsonModelUtil().getModelTypeString(submodelElementNode!!))
    }


    @Test
    fun `submodel node, read model type`() {
        var submodelElementString = """
            {
        "category": "CONSTANT",
        "idShort": "ModelNumber",
        "displayName": [
          {
            "language": "en",
            "text": "Model Number"
          },
          {
            "language": "de",
            "text": "Modellnummer"
          }
        ],
        "valueType": "xs:string",
        "value": "BC-1000",
        "modelType": "Property"
      }
        """.trimIndent()

        val submodelElementNode = JsonTextUtil().generateJsonNode(submodelElementString)
        assertFalse(JsonModelUtil().checkModelTypeSubmodel(submodelElementNode!!))
    }

    @Test
    fun `remove display name and descrption`(){
        var submodelElementString = """
            {
        "category": "CONSTANT",
        "idShort": "ModelNumber",
        "displayName": [
          {
            "language": "en",
            "text": "Model Number"
          },
          {
            "language": "de",
            "text": "Modellnummer"
          }
        ],
      "description": [
                      {
                        "language": "en",
                        "text": "If no IRDI available, custom input as String may also be accepted."
                      }
                    ],
        "valueType": "xs:string",
        "value": "BC-1000",
        "modelType": "Property"
      }
        """.trimIndent()

        val element_with_display_name_and_description = JsonTextUtil().generateJsonNode(submodelElementString)!!

        var submodelElementString_no_displayname = """
            {
        "category": "CONSTANT",
        "idShort": "ModelNumber",
        "valueType": "xs:string",
        "value": "BC-1000",
        "modelType": "Property"
      }
        """.trimIndent()
        val element_without_display_name = JsonTextUtil().generateJsonNode(submodelElementString_no_displayname)!!


        assertEquals(element_without_display_name, JsonModelUtil().removeDisplayNameAndDescription(element_with_display_name_and_description))

    }

    fun getNodeFromResourcePath(path: String): JsonNode ?{
        return JsonTextUtil().generateJsonNode(getResourceStringFromPath(path))
    }

    fun getResourceStringFromPath(path: String): String{
        return (File(javaClass.getResource(path)?.path ?: throw IllegalArgumentException("File not found"))).readText()
    }

}