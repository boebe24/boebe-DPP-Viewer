package edu.kit.dppviewer.data.model.product.util

val LOCAL_BATTERY_SHELL_12 = """
    {
  "idShort": "Battery_DPP",
  "id": "https://example.com/ids/sm/9143_8002_7042_5188",
  "assetInformation": {
    "assetKind": "Instance",
    "globalAssetId": "https://battery-manufacturer.com/ids/asset/0473_7071_4042_7402",
    "assetType": ""
  },
  "submodels": [
    {
      "type": "ExternalReference",
      "keys": [
        {
          "type": "Submodel",
          "value": "https://example.com/ids/sm/4001_9071_4042_5579"
        }
      ]
    },
    {
      "type": "ModelReference",
      "keys": [
        {
          "type": "Submodel",
          "value": "https://example.com/ids/sm/0341_1260_7042_7305"
        }
      ]
    },
    {
      "type": "ModelReference",
      "keys": [
        {
          "type": "Submodel",
          "value": "https://example.com/ids/sm/4175_8132_7042_7927"
        }
      ]
    },
    {
      "type": "ExternalReference",
      "keys": [
        {
          "type": "Submodel",
          "value": "https://example.com/ids/sm/9143_8002_7042_7188"
        }
      ]
    },
    {
      "type": "ModelReference",
      "keys": [
        {
          "type": "Submodel",
          "value": "https://example.com/ids/sm/6112_9132_7042_1308"
        }
      ]
    },
    {
      "type": "ExternalReference",
      "keys": [
        {
          "type": "Submodel",
          "value": "https://example.com/ids/sm/2385_2162_7042_4842"
        }
      ]
    },
    {
      "type": "ExternalReference",
      "keys": [
        {
          "type": "Submodel",
          "value": "https://example.com/ids/sm/4184_0262_7042_1629"
        }
      ]
    },
    {
      "type": "ExternalReference",
      "keys": [
        {
          "type": "Submodel",
          "value": "https://example.com/ids/sm/7194_0262_7042_1951"
        }
      ]
    }
  ],
  "modelType": "AssetAdministrationShell"
}
""".trimIndent()

val LOCAL_BATTERY_SUBMODELS_12 = """
    [
  {
    "idShort": "Maintenance",
    "id": "https://example.com/ids/sm/4001_9071_4042_5579",
    "kind": "Instance",
    "submodelElements": [
      {
        "idShort": "Repair",
        "value": [
          {
            "idShort": "AvailabilityOfSpareParts",
            "valueType": "xs:string",
            "value": "Authorized Service Providers",
            "modelType": "Property"
          },
          {
            "idShort": "Tools",
            "valueType": "xs:string",
            "value": "Proprietary",
            "modelType": "Property"
          },
          {
            "idShort": "Environment",
            "valueType": "xs:string",
            "value": "Workshop",
            "modelType": "Property"
          },
          {
            "idShort": "SkillLevel",
            "valueType": "xs:string",
            "value": "Generalist",
            "modelType": "Property"
          },
          {
            "idShort": "RemovalOfPersonalData",
            "valueType": "xs:string",
            "value": "Integrated",
            "modelType": "Property"
          },
          {
            "idShort": "ReturnOptions",
            "value": [
              {
                "idShort": "ReturnOption",
                "valueType": "xs:string",
                "value": "ReturnProgram",
                "modelType": "Property"
              },
              {
                "idShort": "ContactInformation",
                "description": [
                  {
                    "language": "en",
                    "text": "The SMC \u201CContactInformation\u201D contains information on how to contact the manufacturer or an authorised service provider, e.g. when a maintenance service is required"
                  }
                ],
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "https://admin-shell.io/zvei/nameplate/1/0/ContactInformations/ContactInformation"
                    }
                  ]
                },
                "qualifiers": [
                  {
                    "type": "Multiplicity",
                    "valueType": "xs:string",
                    "value": "OneToMany"
                  }
                ],
                "value": [
                  {
                    "idShort": "RoleOfContactPerson",
                    "description": [
                      {
                        "language": "en",
                        "text": "enumeration: 0173-1#07-AAS927#001 (administrativ contact), 0173-1#07-AAS928#001 (commercial contact), 0173-1#07-AAS929#001 (other contact), 0173-1#07-AAS930#001 (hazardous goods contact), 0173-1#07-AAS931#001 (technical contact). Note: the above mentioned ECLASS enumeration should be declared as \u201Copen\u201D for further addition. ECLASS enumeration IRDI is preferable. If no IRDI available, custom input as String may also be accepted."
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
                  },
                  {
                    "idShort": "NationalCode",
                    "description": [
                      {
                        "language": "en",
                        "text": " Note: country codes defined accord. to ISO 3166-1. Recommendation: property declaration as MLP is required by its semantic definition. As the property value is language independent, users are recommended to provide maximal 1 string in any language of the user\u2019s choice."
                      }
                    ],
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAO134#002"
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
                    "value": [
                      {
                        "language": "en",
                        "text": "DE"
                      }
                    ],
                    "modelType": "MultiLanguageProperty"
                  },
                  {
                    "idShort": "Language",
                    "description": [
                      {
                        "language": "en",
                        "text": "Note: language codes defined accord. to ISO 639-1. Note: as per ECLASS definition, Expression and representation of thoughts, information, feelings, ideas through characters."
                      }
                    ],
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "https://admin-shell.io/zvei/nameplate/1/0/ContactInformations/ContactInformation/Language"
                        }
                      ]
                    },
                    "qualifiers": [
                      {
                        "type": "Multiplicity",
                        "valueType": "xs:string",
                        "value": "ZeroToMany"
                      }
                    ],
                    "valueType": "xs:string",
                    "value": "de",
                    "modelType": "Property"
                  },
                  {
                    "idShort": "TimeZone",
                    "description": [
                      {
                        "language": "en",
                        "text": "Note: notation accord. to ISO 8601 Note: for time in UTC the zone designator \u201CZ\u201D is to be used"
                      }
                    ],
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "https://admin-shell.io/zvei/nameplate/1/0/ContactInformations/ContactInformation/TimeZone"
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
                    "value": "Z",
                    "modelType": "Property"
                  },
                  {
                    "idShort": "CityTown",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAO132#002"
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
                    "value": [
                      {
                        "language": "de",
                        "text": "Musterstadt"
                      }
                    ],
                    "modelType": "MultiLanguageProperty"
                  },
                  {
                    "idShort": "Company",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAW001#001"
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
                    "value": [
                      {
                        "language": "en",
                        "text": "ABC Company"
                      }
                    ],
                    "modelType": "MultiLanguageProperty"
                  },
                  {
                    "idShort": "Department",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAO127#003"
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
                    "value": [
                      {
                        "language": "de",
                        "text": "Vertrieb"
                      }
                    ],
                    "modelType": "MultiLanguageProperty"
                  },
                  {
                    "idShort": "Phone",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "https://admin-shell.io/zvei/nameplate/1/0/ContactInformations/ContactInformation/Phone"
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
                    "value": [
                      {
                        "idShort": "TelephoneNumber",
                        "description": [
                          {
                            "language": "en",
                            "text": "Recommendation: property declaration as MLP is required by its semantic definition. As the property value is language independent, users are recommended to provide maximal 1 string in any language of the user\u2019s choice."
                          }
                        ],
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "0173-1#02-AAO136#002"
                            }
                          ]
                        },
                        "qualifiers": [
                          {
                            "type": "Multiplicity",
                            "valueType": "xs:string",
                            "value": "One"
                          }
                        ],
                        "value": [
                          {
                            "language": "en",
                            "text": "\u002B491234567890"
                          }
                        ],
                        "modelType": "MultiLanguageProperty"
                      },
                      {
                        "idShort": "TypeOfTelephone",
                        "description": [
                          {
                            "language": "en",
                            "text": " enumeration: 0173-1#07-AAS754#001 (office), 0173-1#07-AAS755#001 (office mobile), 0173-1#07-AAS756#001 (secretary), 0173-1#07-AAS757#001 (substitute), 0173-1#07-AAS758#001 (home), 0173-1#07-AAS759#001 (private mobile)"
                          }
                        ],
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "0173-1#02-AAO137#003"
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
                        "value": "0173-1#07-AAS754#001",
                        "modelType": "Property"
                      },
                      {
                        "idShort": "AvailableTime",
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "https://admin-shell.io/zvei/nameplate/1/0/ContactInformations/ContactInformation/AvailableTime/"
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
                        "value": [
                          {
                            "language": "de",
                            "text": "Montag \u2013 Freitag 08:00 bis 16:00"
                          }
                        ],
                        "modelType": "MultiLanguageProperty"
                      }
                    ],
                    "modelType": "SubmodelElementCollection"
                  },
                  {
                    "idShort": "Fax",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAQ834#005"
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
                    "value": [
                      {
                        "idShort": "FaxNumber",
                        "description": [
                          {
                            "language": "en",
                            "text": "Recommendation: property declaration as MLP is required by its semantic definition. As the property value is language independent, users are recommended to provide maximal 1 string in any language of the user\u2019s choice."
                          }
                        ],
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "0173-1#02-AAO195#002"
                            }
                          ]
                        },
                        "qualifiers": [
                          {
                            "type": "Multiplicity",
                            "valueType": "xs:string",
                            "value": "One"
                          }
                        ],
                        "value": [
                          {
                            "language": "en",
                            "text": "\u002B491234567890"
                          }
                        ],
                        "modelType": "MultiLanguageProperty"
                      },
                      {
                        "idShort": "TypeOfFaxNumber",
                        "description": [
                          {
                            "language": "en",
                            "text": "enumeration: 0173-1#07-AAS754#001 (office), 0173-1#07-AAS756#001 (secretary), 0173-1#07-AAS758#001 (home)"
                          }
                        ],
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "0173-1#02-AAO196#003"
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
                        "value": " 0173-1#07-AAS754#001",
                        "modelType": "Property"
                      }
                    ],
                    "modelType": "SubmodelElementCollection"
                  },
                  {
                    "idShort": "Email",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAQ836#005"
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
                    "value": [
                      {
                        "idShort": "EmailAddress",
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "0173-1#02-AAO198#002"
                            }
                          ]
                        },
                        "qualifiers": [
                          {
                            "type": "Multiplicity",
                            "valueType": "xs:string",
                            "value": "One"
                          }
                        ],
                        "valueType": "xs:string",
                        "value": "email@muster-ag.de",
                        "modelType": "Property"
                      },
                      {
                        "idShort": "PublicKey",
                        "description": [
                          {
                            "language": "en",
                            "text": "Recommendation: property declaration as MLP is required by its semantic definition. As the property value is language independent, users are recommended to provide maximal 1 string in any language of the user\u2019s choice."
                          }
                        ],
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "0173-1#02-AAO200#002"
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
                        "modelType": "MultiLanguageProperty"
                      },
                      {
                        "idShort": "TypeOfEmailAddress",
                        "description": [
                          {
                            "language": "en",
                            "text": "enumeration: 0173-1#07-AAS754#001 (office), 0173-1#07-AAS756#001 (secretary), 0173-1#07-AAS757#001 (substitute), 0173-1#07-AAS758#001 (home)"
                          }
                        ],
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "0173-1#02-AAO199#003"
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
                        "value": "0173-1#07-AAS754#001",
                        "modelType": "Property"
                      },
                      {
                        "idShort": "TypeOfPublicKey",
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "0173-1#02-AAO201#002"
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
                        "modelType": "MultiLanguageProperty"
                      }
                    ],
                    "modelType": "SubmodelElementCollection"
                  },
                  {
                    "idShort": "IPCommunication{00}",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "https://admin-shell.io/zvei/nameplate/1/0/ContactInformations/"
                        }
                      ]
                    },
                    "qualifiers": [
                      {
                        "type": "Multiplicity",
                        "valueType": "xs:string",
                        "value": "ZeroToMany"
                      }
                    ],
                    "value": [
                      {
                        "idShort": "AddressOfAdditionalLink",
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "0173-1#02-AAQ326#002"
                            }
                          ]
                        },
                        "qualifiers": [
                          {
                            "type": "Multiplicity",
                            "valueType": "xs:string",
                            "value": "One"
                          }
                        ],
                        "valueType": "xs:string",
                        "value": "",
                        "modelType": "Property"
                      },
                      {
                        "idShort": "TypeOfCommunication",
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "https://admin-shell.io/zvei/nameplate/1/0/ ContactInformations/ContactInformation/IPCommunication/TypeOfCommunication"
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
                        "value": "Chat",
                        "modelType": "Property"
                      },
                      {
                        "idShort": "AvailableTime",
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "https://admin-shell.io/zvei/nameplate/1/0/ContactInformations/ContactInformation/AvailableTime/"
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
                        "value": [
                          {
                            "language": "de",
                            "text": "Montag \u2013 Freitag 08:00 bis 16:00"
                          }
                        ],
                        "modelType": "MultiLanguageProperty"
                      }
                    ],
                    "modelType": "SubmodelElementCollection"
                  },
                  {
                    "idShort": "Street",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAO128#002"
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
                    "value": [
                      {
                        "language": "de",
                        "text": "Musterstra\u00DFe 1"
                      }
                    ],
                    "modelType": "MultiLanguageProperty"
                  },
                  {
                    "idShort": "Zipcode",
                    "description": [
                      {
                        "language": "en",
                        "text": "Recommendation: property declaration as MLP is required by its semantic definition. As the property value is language independent, users are recommended to provide maximal 1 string in any language of the user\u2019s choice."
                      }
                    ],
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAO129#002"
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
                    "value": [
                      {
                        "language": "de",
                        "text": "12345"
                      }
                    ],
                    "modelType": "MultiLanguageProperty"
                  },
                  {
                    "idShort": "POBox",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAO130#002"
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
                    "value": [
                      {
                        "language": "en",
                        "text": "PF 1234"
                      }
                    ],
                    "modelType": "MultiLanguageProperty"
                  },
                  {
                    "idShort": "ZipCodeOfPOBox",
                    "description": [
                      {
                        "language": "en",
                        "text": "Recommendation: property declaration as MLP is required by its semantic definition. As the property value is language independent, users are recommended to provide maximal 1 string in any language of the user\u2019s choice."
                      }
                    ],
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAO131#002"
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
                    "value": [
                      {
                        "language": "en",
                        "text": "12345"
                      }
                    ],
                    "modelType": "MultiLanguageProperty"
                  },
                  {
                    "idShort": "StateCounty",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAO133#002"
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
                    "value": [
                      {
                        "language": "de",
                        "text": "Muster-Bundesland"
                      }
                    ],
                    "modelType": "MultiLanguageProperty"
                  },
                  {
                    "idShort": "NameOfContact",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAO205#002"
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
                    "modelType": "MultiLanguageProperty"
                  },
                  {
                    "idShort": "FirstName",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAO206#002"
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
                    "modelType": "MultiLanguageProperty"
                  },
                  {
                    "idShort": "MiddleNames",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAO207#002"
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
                    "modelType": "MultiLanguageProperty"
                  },
                  {
                    "idShort": "Title",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAO208#003"
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
                    "modelType": "MultiLanguageProperty"
                  },
                  {
                    "idShort": "AcademicTitle",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAO209#003"
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
                    "modelType": "MultiLanguageProperty"
                  },
                  {
                    "idShort": "FurtherDetailsOfContact",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAO210#002"
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
                    "modelType": "MultiLanguageProperty"
                  },
                  {
                    "idShort": "AddressOfAdditionalLink",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAQ326#002"
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
                    "value": "",
                    "modelType": "Property"
                  }
                ],
                "modelType": "SubmodelElementCollection"
              }
            ],
            "modelType": "SubmodelElementCollection"
          }
        ],
        "modelType": "SubmodelElementCollection"
      },
      {
        "idShort": "Remanufacture",
        "value": [
          {
            "idShort": "PCI",
            "valueType": "xs:string",
            "value": "0.4",
            "modelType": "Property"
          },
          {
            "idShort": "ECI",
            "valueType": "xs:string",
            "value": "0.3",
            "modelType": "Property"
          },
          {
            "idShort": "ReturnOptions",
            "value": [
              {
                "idShort": "ReturnOption",
                "valueType": "xs:string",
                "value": "ReturnProgram",
                "modelType": "Property"
              },
              {
                "idShort": "ContactInformation",
                "description": [
                  {
                    "language": "en",
                    "text": "The SMC \u201CContactInformation\u201D contains information on how to contact the manufacturer or an authorised service provider, e.g. when a maintenance service is required"
                  }
                ],
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "https://admin-shell.io/zvei/nameplate/1/0/ContactInformations/ContactInformation"
                    }
                  ]
                },
                "qualifiers": [
                  {
                    "type": "Multiplicity",
                    "valueType": "xs:string",
                    "value": "OneToMany"
                  }
                ],
                "value": [
                  {
                    "idShort": "RoleOfContactPerson",
                    "description": [
                      {
                        "language": "en",
                        "text": "enumeration: 0173-1#07-AAS927#001 (administrativ contact), 0173-1#07-AAS928#001 (commercial contact), 0173-1#07-AAS929#001 (other contact), 0173-1#07-AAS930#001 (hazardous goods contact), 0173-1#07-AAS931#001 (technical contact). Note: the above mentioned ECLASS enumeration should be declared as \u201Copen\u201D for further addition. ECLASS enumeration IRDI is preferable. If no IRDI available, custom input as String may also be accepted."
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
                  },
                  {
                    "idShort": "NationalCode",
                    "description": [
                      {
                        "language": "en",
                        "text": " Note: country codes defined accord. to ISO 3166-1. Recommendation: property declaration as MLP is required by its semantic definition. As the property value is language independent, users are recommended to provide maximal 1 string in any language of the user\u2019s choice."
                      }
                    ],
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAO134#002"
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
                    "value": [
                      {
                        "language": "en",
                        "text": "DE"
                      }
                    ],
                    "modelType": "MultiLanguageProperty"
                  },
                  {
                    "idShort": "Language",
                    "description": [
                      {
                        "language": "en",
                        "text": "Note: language codes defined accord. to ISO 639-1. Note: as per ECLASS definition, Expression and representation of thoughts, information, feelings, ideas through characters."
                      }
                    ],
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "https://admin-shell.io/zvei/nameplate/1/0/ContactInformations/ContactInformation/Language"
                        }
                      ]
                    },
                    "qualifiers": [
                      {
                        "type": "Multiplicity",
                        "valueType": "xs:string",
                        "value": "ZeroToMany"
                      }
                    ],
                    "valueType": "xs:string",
                    "value": "de",
                    "modelType": "Property"
                  },
                  {
                    "idShort": "TimeZone",
                    "description": [
                      {
                        "language": "en",
                        "text": "Note: notation accord. to ISO 8601 Note: for time in UTC the zone designator \u201CZ\u201D is to be used"
                      }
                    ],
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "https://admin-shell.io/zvei/nameplate/1/0/ContactInformations/ContactInformation/TimeZone"
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
                    "value": "Z",
                    "modelType": "Property"
                  },
                  {
                    "idShort": "CityTown",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAO132#002"
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
                    "value": [
                      {
                        "language": "de",
                        "text": "Musterstadt"
                      }
                    ],
                    "modelType": "MultiLanguageProperty"
                  },
                  {
                    "idShort": "Company",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAW001#001"
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
                    "value": [
                      {
                        "language": "en",
                        "text": "ABC Company"
                      }
                    ],
                    "modelType": "MultiLanguageProperty"
                  },
                  {
                    "idShort": "Department",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAO127#003"
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
                    "value": [
                      {
                        "language": "de",
                        "text": "Vertrieb"
                      }
                    ],
                    "modelType": "MultiLanguageProperty"
                  },
                  {
                    "idShort": "Phone",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "https://admin-shell.io/zvei/nameplate/1/0/ContactInformations/ContactInformation/Phone"
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
                    "value": [
                      {
                        "idShort": "TelephoneNumber",
                        "description": [
                          {
                            "language": "en",
                            "text": "Recommendation: property declaration as MLP is required by its semantic definition. As the property value is language independent, users are recommended to provide maximal 1 string in any language of the user\u2019s choice."
                          }
                        ],
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "0173-1#02-AAO136#002"
                            }
                          ]
                        },
                        "qualifiers": [
                          {
                            "type": "Multiplicity",
                            "valueType": "xs:string",
                            "value": "One"
                          }
                        ],
                        "value": [
                          {
                            "language": "en",
                            "text": "\u002B491234567890"
                          }
                        ],
                        "modelType": "MultiLanguageProperty"
                      },
                      {
                        "idShort": "TypeOfTelephone",
                        "description": [
                          {
                            "language": "en",
                            "text": " enumeration: 0173-1#07-AAS754#001 (office), 0173-1#07-AAS755#001 (office mobile), 0173-1#07-AAS756#001 (secretary), 0173-1#07-AAS757#001 (substitute), 0173-1#07-AAS758#001 (home), 0173-1#07-AAS759#001 (private mobile)"
                          }
                        ],
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "0173-1#02-AAO137#003"
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
                        "value": "0173-1#07-AAS754#001",
                        "modelType": "Property"
                      },
                      {
                        "idShort": "AvailableTime",
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "https://admin-shell.io/zvei/nameplate/1/0/ContactInformations/ContactInformation/AvailableTime/"
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
                        "value": [
                          {
                            "language": "de",
                            "text": "Montag \u2013 Freitag 08:00 bis 16:00"
                          }
                        ],
                        "modelType": "MultiLanguageProperty"
                      }
                    ],
                    "modelType": "SubmodelElementCollection"
                  },
                  {
                    "idShort": "Fax",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAQ834#005"
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
                    "value": [
                      {
                        "idShort": "FaxNumber",
                        "description": [
                          {
                            "language": "en",
                            "text": "Recommendation: property declaration as MLP is required by its semantic definition. As the property value is language independent, users are recommended to provide maximal 1 string in any language of the user\u2019s choice."
                          }
                        ],
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "0173-1#02-AAO195#002"
                            }
                          ]
                        },
                        "qualifiers": [
                          {
                            "type": "Multiplicity",
                            "valueType": "xs:string",
                            "value": "One"
                          }
                        ],
                        "value": [
                          {
                            "language": "en",
                            "text": "\u002B491234567890"
                          }
                        ],
                        "modelType": "MultiLanguageProperty"
                      },
                      {
                        "idShort": "TypeOfFaxNumber",
                        "description": [
                          {
                            "language": "en",
                            "text": "enumeration: 0173-1#07-AAS754#001 (office), 0173-1#07-AAS756#001 (secretary), 0173-1#07-AAS758#001 (home)"
                          }
                        ],
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "0173-1#02-AAO196#003"
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
                        "value": " 0173-1#07-AAS754#001",
                        "modelType": "Property"
                      }
                    ],
                    "modelType": "SubmodelElementCollection"
                  },
                  {
                    "idShort": "Email",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAQ836#005"
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
                    "value": [
                      {
                        "idShort": "EmailAddress",
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "0173-1#02-AAO198#002"
                            }
                          ]
                        },
                        "qualifiers": [
                          {
                            "type": "Multiplicity",
                            "valueType": "xs:string",
                            "value": "One"
                          }
                        ],
                        "valueType": "xs:string",
                        "value": "email@muster-ag.de",
                        "modelType": "Property"
                      },
                      {
                        "idShort": "PublicKey",
                        "description": [
                          {
                            "language": "en",
                            "text": "Recommendation: property declaration as MLP is required by its semantic definition. As the property value is language independent, users are recommended to provide maximal 1 string in any language of the user\u2019s choice."
                          }
                        ],
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "0173-1#02-AAO200#002"
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
                        "modelType": "MultiLanguageProperty"
                      },
                      {
                        "idShort": "TypeOfEmailAddress",
                        "description": [
                          {
                            "language": "en",
                            "text": "enumeration: 0173-1#07-AAS754#001 (office), 0173-1#07-AAS756#001 (secretary), 0173-1#07-AAS757#001 (substitute), 0173-1#07-AAS758#001 (home)"
                          }
                        ],
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "0173-1#02-AAO199#003"
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
                        "value": "0173-1#07-AAS754#001",
                        "modelType": "Property"
                      },
                      {
                        "idShort": "TypeOfPublicKey",
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "0173-1#02-AAO201#002"
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
                        "modelType": "MultiLanguageProperty"
                      }
                    ],
                    "modelType": "SubmodelElementCollection"
                  },
                  {
                    "idShort": "IPCommunication{00}",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "https://admin-shell.io/zvei/nameplate/1/0/ContactInformations/"
                        }
                      ]
                    },
                    "qualifiers": [
                      {
                        "type": "Multiplicity",
                        "valueType": "xs:string",
                        "value": "ZeroToMany"
                      }
                    ],
                    "value": [
                      {
                        "idShort": "AddressOfAdditionalLink",
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "0173-1#02-AAQ326#002"
                            }
                          ]
                        },
                        "qualifiers": [
                          {
                            "type": "Multiplicity",
                            "valueType": "xs:string",
                            "value": "One"
                          }
                        ],
                        "valueType": "xs:string",
                        "value": "",
                        "modelType": "Property"
                      },
                      {
                        "idShort": "TypeOfCommunication",
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "https://admin-shell.io/zvei/nameplate/1/0/ ContactInformations/ContactInformation/IPCommunication/TypeOfCommunication"
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
                        "value": "Chat",
                        "modelType": "Property"
                      },
                      {
                        "idShort": "AvailableTime",
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "https://admin-shell.io/zvei/nameplate/1/0/ContactInformations/ContactInformation/AvailableTime/"
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
                        "value": [
                          {
                            "language": "de",
                            "text": "Montag \u2013 Freitag 08:00 bis 16:00"
                          }
                        ],
                        "modelType": "MultiLanguageProperty"
                      }
                    ],
                    "modelType": "SubmodelElementCollection"
                  },
                  {
                    "idShort": "Street",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAO128#002"
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
                    "value": [
                      {
                        "language": "de",
                        "text": "Musterstra\u00DFe 1"
                      }
                    ],
                    "modelType": "MultiLanguageProperty"
                  },
                  {
                    "idShort": "Zipcode",
                    "description": [
                      {
                        "language": "en",
                        "text": "Recommendation: property declaration as MLP is required by its semantic definition. As the property value is language independent, users are recommended to provide maximal 1 string in any language of the user\u2019s choice."
                      }
                    ],
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAO129#002"
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
                    "value": [
                      {
                        "language": "de",
                        "text": "12345"
                      }
                    ],
                    "modelType": "MultiLanguageProperty"
                  },
                  {
                    "idShort": "POBox",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAO130#002"
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
                    "value": [
                      {
                        "language": "en",
                        "text": "PF 1234"
                      }
                    ],
                    "modelType": "MultiLanguageProperty"
                  },
                  {
                    "idShort": "ZipCodeOfPOBox",
                    "description": [
                      {
                        "language": "en",
                        "text": "Recommendation: property declaration as MLP is required by its semantic definition. As the property value is language independent, users are recommended to provide maximal 1 string in any language of the user\u2019s choice."
                      }
                    ],
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAO131#002"
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
                    "value": [
                      {
                        "language": "en",
                        "text": "12345"
                      }
                    ],
                    "modelType": "MultiLanguageProperty"
                  },
                  {
                    "idShort": "StateCounty",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAO133#002"
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
                    "value": [
                      {
                        "language": "de",
                        "text": "Muster-Bundesland"
                      }
                    ],
                    "modelType": "MultiLanguageProperty"
                  },
                  {
                    "idShort": "NameOfContact",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAO205#002"
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
                    "modelType": "MultiLanguageProperty"
                  },
                  {
                    "idShort": "FirstName",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAO206#002"
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
                    "modelType": "MultiLanguageProperty"
                  },
                  {
                    "idShort": "MiddleNames",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAO207#002"
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
                    "modelType": "MultiLanguageProperty"
                  },
                  {
                    "idShort": "Title",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAO208#003"
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
                    "modelType": "MultiLanguageProperty"
                  },
                  {
                    "idShort": "AcademicTitle",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAO209#003"
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
                    "modelType": "MultiLanguageProperty"
                  },
                  {
                    "idShort": "FurtherDetailsOfContact",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAO210#002"
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
                    "modelType": "MultiLanguageProperty"
                  },
                  {
                    "idShort": "AddressOfAdditionalLink",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "0173-1#02-AAQ326#002"
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
                    "value": "",
                    "modelType": "Property"
                  }
                ],
                "modelType": "SubmodelElementCollection"
              }
            ],
            "modelType": "SubmodelElementCollection"
          }
        ],
        "modelType": "SubmodelElementCollection"
      }
    ],
    "modelType": "Submodel"
  },
  {
    "idShort": "EnvironmentalImpact",
    "displayName": [
      {
        "language": "en",
        "text": "EnvironmentalImpact"
      },
      {
        "language": "de",
        "text": "Umweltvertr\u00E4glichkeit"
      }
    ],
    "id": "https://example.com/ids/sm/0341_1260_7042_7305",
    "kind": "Instance",
    "submodelElements": [
      {
        "idShort": "CarbonFootprint",
        "displayName": [
          {
            "language": "en",
            "text": "Carbon Footprint"
          },
          {
            "language": "de",
            "text": "CO2-Fu\u00DFabdruck"
          }
        ],
        "valueType": "xs:string",
        "value": "5 kg CO2e",
        "modelType": "Property"
      },
      {
        "idShort": "HazardousMaterials",
        "displayName": [
          {
            "language": "en",
            "text": "Hazardous Materials"
          },
          {
            "language": "de",
            "text": "Gef\u00E4hrliche Materialien"
          }
        ],
        "valueType": "xs:string",
        "value": "Contains cobalt and lithium",
        "modelType": "Property"
      },
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
    ],
    "modelType": "Submodel"
  },
  {
    "idShort": "DigitalNameplate",
    "description": [
      {
        "language": "en",
        "text": "Contains the nameplate information attached to the product"
      }
    ],
    "id": "https://example.com/ids/sm/4175_8132_7042_7927",
    "kind": "Instance",
    "semanticId": {
      "type": "ExternalReference",
      "keys": [
        {
          "type": "ConceptDescription",
          "value": "https://admin-shell.io/zvei/nameplate/2/0/Nameplate"
        }
      ]
    },
    "submodelElements": [
      {
        "idShort": "URIOfTheProduct",
        "description": [
          {
            "language": "en",
            "text": "Note: see also [IRDI] 0112/2///61987#ABN590#001 URI of product instance "
          }
        ],
        "semanticId": {
          "type": "ExternalReference",
          "keys": [
            {
              "type": "GlobalReference",
              "value": "0173-1#02-AAY811#001"
            }
          ]
        },
        "qualifiers": [
          {
            "type": "Multiplicity",
            "valueType": "xs:string",
            "value": "One"
          }
        ],
        "valueType": "xs:string",
        "value": "https://www.domain-abc.com/Model-Nr-1234/Serial-Nr-5678",
        "modelType": "Property"
      },
      {
        "idShort": "ManufacturerName",
        "displayName": [
          {
            "language": "en",
            "text": "Manufacturer Name"
          },
          {
            "language": "de",
            "text": "Herstellername"
          }
        ],
        "description": [
          {
            "language": "en",
            "text": "Note: see also [IRDI] 0112/2///61987#ABA565#007 manufacturer Note: mandatory property according to EU Machine Directive 2006/42/EC. "
          }
        ],
        "semanticId": {
          "type": "ExternalReference",
          "keys": [
            {
              "type": "GlobalReference",
              "value": "0173-1#02-AAO677#002"
            }
          ]
        },
        "qualifiers": [
          {
            "type": "Multiplicity",
            "valueType": "xs:string",
            "value": "One"
          }
        ],
        "value": [
          {
            "language": "de",
            "text": "Energizer"
          }
        ],
        "modelType": "MultiLanguageProperty"
      },
      {
        "idShort": "ManufacturerProductDesignation",
        "displayName": [
          {
            "language": "en",
            "text": "Product Name"
          },
          {
            "language": "de",
            "text": "Produktname"
          }
        ],
        "description": [
          {
            "language": "en",
            "text": "Note: see also [IRDI] 0112/2///61987#ABA567#007 name of product Note: Short designation of the product is meant. Note: mandatory property according to EU Machine Directive 2006/42/EC. "
          }
        ],
        "semanticId": {
          "type": "ExternalReference",
          "keys": [
            {
              "type": "GlobalReference",
              "value": "0173-1#02-AAW338#001"
            }
          ]
        },
        "qualifiers": [
          {
            "type": "Multiplicity",
            "valueType": "xs:string",
            "value": "One"
          }
        ],
        "value": [
          {
            "language": "de",
            "text": "Energizer A23 Alkaline"
          }
        ],
        "modelType": "MultiLanguageProperty"
      },
      {
        "idShort": "ContactInformation",
        "description": [
          {
            "language": "en",
            "text": "The SMC \u201CContactInformation\u201D contains information on how to contact the manufacturer or an authorised service provider, e.g. when a maintenance service is required. Note: physical address is a mandatory property according to EU Machine Directive 2006/42/EC"
          }
        ],
        "semanticId": {
          "type": "ExternalReference",
          "keys": [
            {
              "type": "GlobalReference",
              "value": "https://admin-shell.io/zvei/nameplate/1/0/ContactInformations/ContactInformation"
            }
          ]
        },
        "qualifiers": [
          {
            "type": "Multiplicity",
            "valueType": "xs:string",
            "value": "One"
          }
        ],
        "value": [
          {
            "idShort": "RoleOfContactPerson",
            "description": [
              {
                "language": "en",
                "text": "enumeration: 0173-1#07-AAS927#001 (administrativ contact), 0173-1#07-AAS928#001 (commercial contact), 0173-1#07-AAS929#001 (other contact), 0173-1#07-AAS930#001 (hazardous goods contact), 0173-1#07-AAS931#001 (technical contact). Note: the above mentioned ECLASS enumeration should be declared as \u201Copen\u201D for further addition. ECLASS enumeration IRDI is preferable. If no IRDI available, custom input as String may also be accepted."
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
          },
          {
            "idShort": "NationalCode",
            "description": [
              {
                "language": "en",
                "text": "Note: see also [IRDI] 0112/2///61360_4#ADA005#001 country code. country codes defined accord. to DIN EN ISO 3166-1 alpha-2 codes. Mandatory property according to EU Machine Directive 2006/42/EC. Recommendation: property declaration as MLP is required by its semantic definition. As the property value is language independent, users are recommended to provide maximal 1 string in any language of the user\u2019s choice."
              }
            ],
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "0173-1#02-AAO134#002"
                }
              ]
            },
            "qualifiers": [
              {
                "type": "Multiplicity",
                "valueType": "xs:string",
                "value": "One"
              }
            ],
            "value": [
              {
                "language": "en",
                "text": "DE"
              }
            ],
            "modelType": "MultiLanguageProperty"
          },
          {
            "idShort": "Language",
            "description": [
              {
                "language": "en",
                "text": "Note: language codes defined accord. to ISO 639-1. Note: as per ECLASS definition, Expression and representation of thoughts, information, feelings, ideas through characters."
              }
            ],
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "https://admin-shell.io/zvei/nameplate/1/0/ContactInformations/ContactInformation/Language"
                }
              ]
            },
            "qualifiers": [
              {
                "type": "Multiplicity",
                "valueType": "xs:string",
                "value": "ZeroToMany"
              }
            ],
            "valueType": "xs:string",
            "value": "de",
            "modelType": "Property"
          },
          {
            "idShort": "TimeZone",
            "description": [
              {
                "language": "en",
                "text": "Note: notation accord. to ISO 8601 Note: for time in UTC the zone designator \u201CZ\u201D is to be used"
              }
            ],
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "https://admin-shell.io/zvei/nameplate/1/0/ContactInformations/ContactInformation/TimeZone"
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
            "value": "Z",
            "modelType": "Property"
          },
          {
            "idShort": "CityTown",
            "description": [
              {
                "language": "en",
                "text": "Note: see also [IRDI] 0112/2///61987#ABA129#001 city/town. Mandatory property according to EU Machine Directive 2006/42/EC."
              }
            ],
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "0173-1#02-AAO132#002"
                }
              ]
            },
            "qualifiers": [
              {
                "type": "Multiplicity",
                "valueType": "xs:string",
                "value": "One"
              }
            ],
            "value": [
              {
                "language": "de",
                "text": "Musterstadt"
              }
            ],
            "modelType": "MultiLanguageProperty"
          },
          {
            "idShort": "Company",
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "0173-1#02-AAW001#001"
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
            "value": [
              {
                "language": "en",
                "text": "ABC Company"
              }
            ],
            "modelType": "MultiLanguageProperty"
          },
          {
            "idShort": "Department",
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "0173-1#02-AAO127#003"
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
            "value": [
              {
                "language": "de",
                "text": "Vertrieb"
              }
            ],
            "modelType": "MultiLanguageProperty"
          },
          {
            "idShort": "Phone",
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "https://admin-shell.io/zvei/nameplate/1/0/ContactInformations/ContactInformation/Phone"
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
            "value": [
              {
                "idShort": "TelephoneNumber",
                "description": [
                  {
                    "language": "en",
                    "text": "Recommendation: property declaration as MLP is required by its semantic definition. As the property value is language independent, users are recommended to provide maximal 1 string in any language of the user\u2019s choice."
                  }
                ],
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "0173-1#02-AAO136#002"
                    }
                  ]
                },
                "qualifiers": [
                  {
                    "type": "Multiplicity",
                    "valueType": "xs:string",
                    "value": "One"
                  }
                ],
                "value": [
                  {
                    "language": "en",
                    "text": "\u002B491234567890"
                  }
                ],
                "modelType": "MultiLanguageProperty"
              },
              {
                "idShort": "TypeOfTelephone",
                "description": [
                  {
                    "language": "en",
                    "text": " enumeration: 0173-1#07-AAS754#001 (office), 0173-1#07-AAS755#001 (office mobile), 0173-1#07-AAS756#001 (secretary), 0173-1#07-AAS757#001 (substitute), 0173-1#07-AAS758#001 (home), 0173-1#07-AAS759#001 (private mobile)"
                  }
                ],
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "0173-1#02-AAO137#003"
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
                "value": "0173-1#07-AAS754#001",
                "modelType": "Property"
              },
              {
                "idShort": "AvailableTime",
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "https://admin-shell.io/zvei/nameplate/1/0/ContactInformations/ContactInformation/AvailableTime/"
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
                "value": [
                  {
                    "language": "de",
                    "text": "Montag \u2013 Freitag 08:00 bis 16:00"
                  }
                ],
                "modelType": "MultiLanguageProperty"
              }
            ],
            "modelType": "SubmodelElementCollection"
          },
          {
            "idShort": "Fax",
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "0173-1#02-AAQ834#005"
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
            "value": [
              {
                "idShort": "FaxNumber",
                "description": [
                  {
                    "language": "en",
                    "text": "Recommendation: property declaration as MLP is required by its semantic definition. As the property value is language independent, users are recommended to provide maximal 1 string in any language of the user\u2019s choice."
                  }
                ],
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "0173-1#02-AAO195#002"
                    }
                  ]
                },
                "qualifiers": [
                  {
                    "type": "Multiplicity",
                    "valueType": "xs:string",
                    "value": "One"
                  }
                ],
                "value": [
                  {
                    "language": "en",
                    "text": "\u002B491234567890"
                  }
                ],
                "modelType": "MultiLanguageProperty"
              },
              {
                "idShort": "TypeOfFaxNumber",
                "description": [
                  {
                    "language": "en",
                    "text": "enumeration: 0173-1#07-AAS754#001 (office), 0173-1#07-AAS756#001 (secretary), 0173-1#07-AAS758#001 (home)"
                  }
                ],
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "0173-1#02-AAO196#003"
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
                "value": " 0173-1#07-AAS754#001",
                "modelType": "Property"
              }
            ],
            "modelType": "SubmodelElementCollection"
          },
          {
            "idShort": "Email",
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "0173-1#02-AAQ836#005"
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
            "value": [
              {
                "idShort": "EmailAddress",
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "0173-1#02-AAO198#002"
                    }
                  ]
                },
                "qualifiers": [
                  {
                    "type": "Multiplicity",
                    "valueType": "xs:string",
                    "value": "One"
                  }
                ],
                "valueType": "xs:string",
                "value": "email@muster-ag.de",
                "modelType": "Property"
              },
              {
                "idShort": "PublicKey",
                "description": [
                  {
                    "language": "en",
                    "text": "Recommendation: property declaration as MLP is required by its semantic definition. As the property value is language independent, users are recommended to provide maximal 1 string in any language of the user\u2019s choice."
                  }
                ],
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "0173-1#02-AAO200#002"
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
                "modelType": "MultiLanguageProperty"
              },
              {
                "idShort": "TypeOfEmailAddress",
                "description": [
                  {
                    "language": "en",
                    "text": "enumeration: 0173-1#07-AAS754#001 (office), 0173-1#07-AAS756#001 (secretary), 0173-1#07-AAS757#001 (substitute), 0173-1#07-AAS758#001 (home)"
                  }
                ],
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "0173-1#02-AAO199#003"
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
                "value": "0173-1#07-AAS754#001",
                "modelType": "Property"
              },
              {
                "idShort": "TypeOfPublicKey",
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "0173-1#02-AAO201#002"
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
                "modelType": "MultiLanguageProperty"
              }
            ],
            "modelType": "SubmodelElementCollection"
          },
          {
            "idShort": "IPCommunication{00}",
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "https://admin-shell.io/zvei/nameplate/1/0/ContactInformations/"
                }
              ]
            },
            "qualifiers": [
              {
                "type": "Multiplicity",
                "valueType": "xs:string",
                "value": "ZeroToMany"
              }
            ],
            "value": [
              {
                "idShort": "AddressOfAdditionalLink",
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "0173-1#02-AAQ326#002"
                    }
                  ]
                },
                "qualifiers": [
                  {
                    "type": "Multiplicity",
                    "valueType": "xs:string",
                    "value": "One"
                  }
                ],
                "valueType": "xs:string",
                "value": "",
                "modelType": "Property"
              },
              {
                "idShort": "TypeOfCommunication",
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "https://admin-shell.io/zvei/nameplate/1/0/ ContactInformations/ContactInformation/IPCommunication/TypeOfCommunication"
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
                "value": "Chat",
                "modelType": "Property"
              },
              {
                "idShort": "AvailableTime",
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "https://admin-shell.io/zvei/nameplate/1/0/ContactInformations/ContactInformation/AvailableTime/"
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
                "value": [
                  {
                    "language": "de",
                    "text": "Montag \u2013 Freitag 08:00 bis 16:00"
                  }
                ],
                "modelType": "MultiLanguageProperty"
              }
            ],
            "modelType": "SubmodelElementCollection"
          },
          {
            "idShort": "Street",
            "description": [
              {
                "language": "en",
                "text": "Note: see also [IRDI] 0112/2///61987#ABA286#001 street. Mandatory property according to EU Machine Directive 2006/42/EC"
              }
            ],
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "0173-1#02-AAO128#002"
                }
              ]
            },
            "qualifiers": [
              {
                "type": "Multiplicity",
                "valueType": "xs:string",
                "value": "One"
              }
            ],
            "value": [
              {
                "language": "de",
                "text": "Musterstra\u00DFe 1"
              }
            ],
            "modelType": "MultiLanguageProperty"
          },
          {
            "idShort": "Zipcode",
            "description": [
              {
                "language": "en",
                "text": "Note: see also [IRDI] 0112/2///61987#ABA281#001 ZIP/Postal code. Mandatory property according to EU Machine Directive 2006/42/EC. Recommendation: property declaration as MLP is required by its semantic definition. As the property value is language independent, users are recommended to provide maximal 1 string in any language of the user\u2019s choice."
              }
            ],
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "0173-1#02-AAO129#002"
                }
              ]
            },
            "qualifiers": [
              {
                "type": "Multiplicity",
                "valueType": "xs:string",
                "value": "One"
              }
            ],
            "value": [
              {
                "language": "de",
                "text": "12345"
              }
            ],
            "modelType": "MultiLanguageProperty"
          },
          {
            "idShort": "POBox",
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "0173-1#02-AAO130#002"
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
            "value": [
              {
                "language": "en",
                "text": "PF 1234"
              }
            ],
            "modelType": "MultiLanguageProperty"
          },
          {
            "idShort": "ZipCodeOfPOBox",
            "description": [
              {
                "language": "en",
                "text": "Recommendation: property declaration as MLP is required by its semantic definition. As the property value is language independent, users are recommended to provide maximal 1 string in any language of the user\u2019s choice."
              }
            ],
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "0173-1#02-AAO131#002"
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
            "value": [
              {
                "language": "en",
                "text": "12345"
              }
            ],
            "modelType": "MultiLanguageProperty"
          },
          {
            "idShort": "StateCounty",
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "0173-1#02-AAO133#002"
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
            "value": [
              {
                "language": "de",
                "text": "Muster-Bundesland"
              }
            ],
            "modelType": "MultiLanguageProperty"
          },
          {
            "idShort": "NameOfContact",
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "0173-1#02-AAO205#002"
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
            "modelType": "MultiLanguageProperty"
          },
          {
            "idShort": "FirstName",
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "0173-1#02-AAO206#002"
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
            "modelType": "MultiLanguageProperty"
          },
          {
            "idShort": "MiddleNames",
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "0173-1#02-AAO207#002"
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
            "modelType": "MultiLanguageProperty"
          },
          {
            "idShort": "Title",
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "0173-1#02-AAO208#003"
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
            "modelType": "MultiLanguageProperty"
          },
          {
            "idShort": "AcademicTitle",
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "0173-1#02-AAO209#003"
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
            "modelType": "MultiLanguageProperty"
          },
          {
            "idShort": "FurtherDetailsOfContact",
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "0173-1#02-AAO210#002"
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
            "modelType": "MultiLanguageProperty"
          },
          {
            "idShort": "AddressOfAdditionalLink",
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "0173-1#02-AAQ326#002"
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
            "value": "",
            "modelType": "Property"
          }
        ],
        "modelType": "SubmodelElementCollection"
      },
      {
        "idShort": "ManufacturerProductRoot",
        "semanticId": {
          "type": "ExternalReference",
          "keys": [
            {
              "type": "GlobalReference",
              "value": "0173-1#02-AAU732#001"
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
        "value": [
          {
            "language": "en",
            "text": "Battery"
          }
        ],
        "modelType": "MultiLanguageProperty"
      },
      {
        "idShort": "ManufacturerProductFamily",
        "description": [
          {
            "language": "en",
            "text": "Note: conditionally mandatory property according to EU Machine Directive 2006/42/EC. One of the two properties must be provided: ManufacturerProductFamily (0173-1#02-AAU731#001) or ManufacturerProductType (0173-1#02-AAO057#002). "
          }
        ],
        "semanticId": {
          "type": "ExternalReference",
          "keys": [
            {
              "type": "GlobalReference",
              "value": "0173-1#02-AAU731#001"
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
        "value": [
          {
            "language": "en",
            "text": "Battery"
          }
        ],
        "modelType": "MultiLanguageProperty"
      },
      {
        "idShort": "ManufacturerProductType",
        "displayName": [
          {
            "language": "en",
            "text": "Product Type"
          },
          {
            "language": "de",
            "text": "Produkttyp"
          }
        ],
        "description": [
          {
            "language": "en",
            "text": "Note: see also [IRDI] 0112/2///61987#ABA300#006 code of product Note: conditionally mandatory property according to EU Machine Directive 2006/42/EC. One of the two properties must be provided: ManufacturerProductFamily (0173-1#02-AAU731#001) or ManufacturerProductType (0173-1#02-AAO057#002). "
          }
        ],
        "semanticId": {
          "type": "ExternalReference",
          "keys": [
            {
              "type": "GlobalReference",
              "value": "0173-1#02-AAO057#002"
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
        "value": [
          {
            "language": "en",
            "text": "Battery"
          }
        ],
        "modelType": "MultiLanguageProperty"
      },
      {
        "idShort": "OrderCodeOfManufacturer",
        "description": [
          {
            "language": "en",
            "text": "Note: see also [IRDI] 0112/2///61987#ABA950#006 order code of product Note: Recommendation: property declaration as MLP is required by its semantic definition. As the property value is language independent, users are recommended to provide maximal 1 string in any language of the user\u2019s choice."
          }
        ],
        "semanticId": {
          "type": "ExternalReference",
          "keys": [
            {
              "type": "GlobalReference",
              "value": "0173-1#02-AAO227#002"
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
        "value": [
          {
            "language": "en",
            "text": "FMABC1234"
          }
        ],
        "modelType": "MultiLanguageProperty"
      },
      {
        "idShort": "ProductArticleNumberOfManufacturer",
        "description": [
          {
            "language": "en",
            "text": "Note: see also [IRDI] 0112/2///61987#ABA581#006 article number Note: Recommendation: property declaration as MLP is required by its semantic definition. As the property value is language independent, users are recommended to provide maximal 1 string in any language of the user\u2019s choice."
          }
        ],
        "semanticId": {
          "type": "ExternalReference",
          "keys": [
            {
              "type": "GlobalReference",
              "value": "0173-1#02-AAO676#003"
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
        "value": [
          {
            "language": "en",
            "text": "FM11-ABC22-123456"
          }
        ],
        "modelType": "MultiLanguageProperty"
      },
      {
        "idShort": "SerialNumber",
        "description": [
          {
            "language": "en",
            "text": "Note: see also [IRDI] 0112/2///61987#ABA951#007 serial number "
          }
        ],
        "semanticId": {
          "type": "ExternalReference",
          "keys": [
            {
              "type": "GlobalReference",
              "value": "0173-1#02-AAM556#002"
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
        "value": "12345678",
        "modelType": "Property"
      },
      {
        "idShort": "YearOfConstruction",
        "description": [
          {
            "language": "en",
            "text": "Note: mandatory property according to EU Machine Directive 2006/42/EC. "
          }
        ],
        "semanticId": {
          "type": "ExternalReference",
          "keys": [
            {
              "type": "GlobalReference",
              "value": "0173-1#02-AAP906#001"
            }
          ]
        },
        "qualifiers": [
          {
            "type": "Multiplicity",
            "valueType": "xs:string",
            "value": "One"
          }
        ],
        "valueType": "xs:string",
        "value": "2022",
        "modelType": "Property"
      },
      {
        "idShort": "DateOfManufacture",
        "description": [
          {
            "language": "en",
            "text": "Note: see also [IRDI] 0112/2///61987#ABB757#007 date of manufacture Note: format by lexical representation: CCYY-MM-DD "
          }
        ],
        "semanticId": {
          "type": "ExternalReference",
          "keys": [
            {
              "type": "GlobalReference",
              "value": "0173-1#02-AAR972#002"
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
        "valueType": "xs:date",
        "value": "2022-01-01",
        "modelType": "Property"
      },
      {
        "idShort": "HardwareVersion",
        "description": [
          {
            "language": "en",
            "text": "Note: see also [IRDI] 0112/2///61987#ABA926#006 hardware version Note: Recommendation: property declaration as MLP is required by its semantic definition. As the property value is language independent, users are recommended to provide maximal 1 string in any language of the user\u2019s choice."
          }
        ],
        "semanticId": {
          "type": "ExternalReference",
          "keys": [
            {
              "type": "GlobalReference",
              "value": "0173-1#02-AAN270#002"
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
        "value": [
          {
            "language": "en",
            "text": "1.0.0"
          }
        ],
        "modelType": "MultiLanguageProperty"
      },
      {
        "idShort": "FirmwareVersion",
        "description": [
          {
            "language": "en",
            "text": "Note: see also [IRDI] 0112/2///61987#ABA302#004 firmware version Note: Recommendation: property declaration as MLP is required by its semantic definition. As the property value is language independent, users are recommended to provide maximal 1 string in any language of the user\u2019s choice."
          }
        ],
        "semanticId": {
          "type": "ExternalReference",
          "keys": [
            {
              "type": "GlobalReference",
              "value": "0173-1#02-AAM985#002"
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
        "value": [
          {
            "language": "en",
            "text": "1.0"
          }
        ],
        "modelType": "MultiLanguageProperty"
      },
      {
        "idShort": "SoftwareVersion",
        "description": [
          {
            "language": "en",
            "text": "Note: see also [IRDI] 0112/2///61987#ABA601#006 software version Note: Recommendation: property declaration as MLP is required by its semantic definition. As the property value is language independent, users are recommended to provide maximal 1 string in any language of the user\u2019s choice."
          }
        ],
        "semanticId": {
          "type": "ExternalReference",
          "keys": [
            {
              "type": "GlobalReference",
              "value": "0173-1#02-AAM737#002"
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
        "value": [
          {
            "language": "en",
            "text": "1.0.0"
          }
        ],
        "modelType": "MultiLanguageProperty"
      },
      {
        "idShort": "CountryOfOrigin",
        "displayName": [
          {
            "language": "en",
            "text": "Country Of Origin"
          },
          {
            "language": "de",
            "text": "Herkunftsland"
          }
        ],
        "description": [
          {
            "language": "en",
            "text": "Note: see also [IRDI] 0112/2///61360_4#ADA034#001 country of origin Note: Country codes defined accord. to DIN EN ISO 3166-1 alpha-2 codes "
          }
        ],
        "semanticId": {
          "type": "ExternalReference",
          "keys": [
            {
              "type": "GlobalReference",
              "value": "0173-1#02-AAO259#004"
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
        "value": "DE",
        "modelType": "Property"
      },
      {
        "idShort": "CompanyLogo",
        "semanticId": {
          "type": "ExternalReference",
          "keys": [
            {
              "type": "GlobalReference",
              "value": "https://admin-shell.io/zvei/nameplate/2/0/Nameplate/CompanyLogo "
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
        "value": "",
        "contentType": "",
        "modelType": "File"
      },
      {
        "idShort": "Markings",
        "description": [
          {
            "language": "en",
            "text": "Note: CE marking is declared as mandatory according to EU Machine Directive 2006/42/EC."
          }
        ],
        "semanticId": {
          "type": "ExternalReference",
          "keys": [
            {
              "type": "GlobalReference",
              "value": "0173-1#01-AGZ673#001"
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
        "value": [
          {
            "idShort": "Marking",
            "description": [
              {
                "language": "en",
                "text": "Note: see also [IRDI] 0112/2///61987#ABH515#003 Certificate or approval Note: CE marking is declared as mandatory according to the Blue Guide of the EU-Commission "
              }
            ],
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "0173-1#01-AHD206#001"
                }
              ]
            },
            "value": [
              {
                "idShort": "MarkingName",
                "description": [
                  {
                    "language": "en",
                    "text": "Note: see also [IRDI] 0173-1#02-BAB392#015 certificate/approval valueId with ECLASS enumeration IRDI is preferable, e.g. [IRDI] 0173-1#07-DAA603#004 for CE. If no IRDI available, string value can also be accepted. Note: CE marking is declared as mandatory according to Blue Guide of the EU-Commission "
                  }
                ],
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "https://admin-shell.io/zvei/nameplate/2/0/Nameplate/Markings/Marking/MarkingName"
                    }
                  ]
                },
                "qualifiers": [
                  {
                    "type": "Multiplicity",
                    "valueType": "xs:string",
                    "value": "One"
                  }
                ],
                "valueType": "xs:string",
                "value": "0173-1#07-DAA603#004",
                "modelType": "Property"
              },
              {
                "idShort": "DesignationOfCertificateOrApproval",
                "description": [
                  {
                    "language": "en",
                    "text": "Note: Approval identifier, reference to the certificate number, to be entered without spaces "
                  }
                ],
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "0112/2///61987#ABH783#001"
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
                "value": "KEMA99IECEX1105/128",
                "modelType": "Property"
              },
              {
                "idShort": "IssueDate",
                "description": [
                  {
                    "language": "en",
                    "text": "Note: format by lexical representation: CCYY-MM-DD Note: to be specified to the day "
                  }
                ],
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "https://admin-shell.io/zvei/nameplate/2/0/Nameplate/Markings/Marking/IssueDate"
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
                "value": "2022-01-01",
                "modelType": "Property"
              },
              {
                "idShort": "ExpiryDate",
                "description": [
                  {
                    "language": "en",
                    "text": "Note: see also ([IRDI] 0173-1#02-AAO997#001 Validity date Note: format by lexical representation: CCYY-MM-DD Note: to be specified to the day "
                  }
                ],
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "https://admin-shell.io/zvei/nameplate/2/0/Nameplate/Markings/Marking/ExpiryDate"
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
                "value": "2022-01-01",
                "modelType": "Property"
              },
              {
                "idShort": "MarkingFile",
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "https://admin-shell.io/zvei/nameplate/2/0/Nameplate/Markings/Marking/MarkingFile"
                    }
                  ]
                },
                "qualifiers": [
                  {
                    "type": "Multiplicity",
                    "valueType": "xs:string",
                    "value": "One"
                  }
                ],
                "value": "/aasx/Nameplate/marking_ce.png ",
                "contentType": "",
                "modelType": "File"
              },
              {
                "idShort": "MarkingAdditionalText",
                "description": [
                  {
                    "language": "en",
                    "text": "Note: see also [IRDI] 0173-1#02-AAM954#002 details of other certificate "
                  }
                ],
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "https://admin-shell.io/zvei/nameplate/2/0/Nameplate/Markings/Marking/MarkingAdditionalText"
                    }
                  ]
                },
                "qualifiers": [
                  {
                    "type": "Multiplicity",
                    "valueType": "xs:string",
                    "value": "ZeroToMany"
                  }
                ],
                "valueType": "xs:string",
                "value": "0044",
                "modelType": "Property"
              },
              {
                "idShort": "ExplosionSafeties",
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "https://admin-shell.io/zvei/nameplate/2/0/Nameplate/Markings/Marking/ExplosionSafeties"
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
                "value": [
                  {
                    "idShort": "ExplosionSafety",
                    "semanticId": {
                      "type": "ExternalReference",
                      "keys": [
                        {
                          "type": "GlobalReference",
                          "value": "https://admin-shell.io/zvei/nameplate/2/0/Nameplate/Markings/Marking/ExplosionSafeties/ExplosionSafety"
                        }
                      ]
                    },
                    "qualifiers": [
                      {
                        "type": "Multiplicity",
                        "valueType": "xs:string",
                        "value": "OneToMany"
                      }
                    ],
                    "value": [
                      {
                        "idShort": "DesignationOfCertificateOrApproval",
                        "description": [
                          {
                            "language": "en",
                            "text": "Note: Approval identifier, reference to the certificate number, to be entered without spaces "
                          }
                        ],
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "0112/2///61987#ABH783#001"
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
                        "value": "KEMA99IECEX1105/128",
                        "modelType": "Property"
                      },
                      {
                        "idShort": "TypeOfApproval",
                        "description": [
                          {
                            "language": "en",
                            "text": "Note: see also [IRDI] 0112/2///61987#ABA231#008 type of hazardous area approval Note: name of the approval system, e.g. ATEX, IECEX, NEC, EAC, CCC, CEC Note: only values from the enumeration should be used as stated. For additional systems further values can be used. Note: Recommendation: property declaration as MLP is required by its semantic definition. As the property value is language independent, users are recommended to provide maximal 1 string in any language of the user\u2019s choice."
                          }
                        ],
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "0173-1#02-AAM812#003"
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
                        "value": [
                          {
                            "language": "en",
                            "text": "ATEX"
                          }
                        ],
                        "modelType": "MultiLanguageProperty"
                      },
                      {
                        "idShort": "ApprovalAgencyTestingAgency",
                        "description": [
                          {
                            "language": "en",
                            "text": "Note: see also [IRDI] 0112/2///61987#ABA634#004 approval agency/testing agency Note: name of the agency, which has issued the certificate, e.g. PTB, KEMA, CSA, SIRA Note: only values from the enumeration should be used as stated. For additional systems further values can be used. Note: Recommendation: property declaration as MLP is required by its semantic definition. As the property value is language independent, users are recommended to provide maximal 1 string in any language of the user\u2019s choice."
                          }
                        ],
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "0173-1#02-AAM632#001"
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
                        "value": [
                          {
                            "language": "en",
                            "text": "PTB"
                          }
                        ],
                        "modelType": "MultiLanguageProperty"
                      },
                      {
                        "idShort": "TypeOfProtection",
                        "description": [
                          {
                            "language": "en",
                            "text": "Note: see also [IRDI] 0112/2///61987#ABA589#002 type of protection (Ex) Note:  \u00B7\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0 Type of protection for the device as listed in the certificate \u00B7\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0 Symbol(s) for the Type of protection. Several types of protection are separated by a semicolon \u201C;\u201D \u00B7\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0 If several TypeOfProtection are listed in the same certificate, for each TypeOfProtection a separate SMC \u201CExplosion Safety\u201D shall be provided "
                          }
                        ],
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "0173-1#02-AAQ325#003"
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
                        "value": "db",
                        "modelType": "Property"
                      },
                      {
                        "idShort": "RatedInsulationVoltage",
                        "description": [
                          {
                            "language": "en",
                            "text": "Note: Um(eff) Note: Insulation voltage, if specified in the certificate "
                          }
                        ],
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "0173-1#02-AAN532#003"
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
                        "value": "250",
                        "modelType": "Property"
                      },
                      {
                        "idShort": "InstructionsControlDrawing",
                        "description": [
                          {
                            "language": "en",
                            "text": "Note: Reference to the instruction manual or control drawing "
                          }
                        ],
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "0112/2///61987#ABO102#001"
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
                        "modelType": "ReferenceElement"
                      },
                      {
                        "idShort": "SpecificConditionsForUse",
                        "description": [
                          {
                            "language": "en",
                            "text": "Note: X if any, otherwise no entry"
                          }
                        ],
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "https://admin-shell.io/zvei/nameplate/2/0/Nameplate/Markings/Marking/ExplosionSafeties/ExplosionSafety/SpecificConditionsForUse"
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
                        "value": "X",
                        "modelType": "Property"
                      },
                      {
                        "idShort": "IncompleteDevice",
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "https://admin-shell.io/zvei/nameplate/2/0/Nameplate/Markings/Marking/ExplosionSafeties/ExplosionSafety/IncompleteDevice"
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
                        "value": "U",
                        "modelType": "Property"
                      },
                      {
                        "idShort": "AmbientConditions",
                        "description": [
                          {
                            "language": "en",
                            "text": "Note: If the device is mounted in the process boundary, ambient and process conditions are provided separately. "
                          }
                        ],
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "https://admin-shell.io/zvei/nameplate/2/0/Nameplate/Markings/Marking/ExplosionSafeties/ExplosionSafety/AmbientConditions"
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
                        "value": [
                          {
                            "idShort": "DeviceCategory",
                            "description": [
                              {
                                "language": "en",
                                "text": "Note: see also [IRDI] 0112/2///61987#ABA467#002 equipment/device category Note: editorial definiton: Category of device in accordance with directive 2014/34/EU Note: Equipment category according to the ATEX system. According to the current nameplate, also the combination \u201CGD\u201D is permitted Note: The combination \u201CGD\u201D is no longer accepted and was changed in the standards. Currently the marking for \u201CG\u201D and \u201CD\u201D must be provided in a separate marking string. Older devices may still exist with the marking \u201CGD\u201D. "
                              }
                            ],
                            "semanticId": {
                              "type": "ExternalReference",
                              "keys": [
                                {
                                  "type": "GlobalReference",
                                  "value": "0173-1#02-AAK297#004"
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
                            "value": "2G",
                            "modelType": "Property"
                          },
                          {
                            "idShort": "EquipmentProtectionLevel",
                            "description": [
                              {
                                "language": "en",
                                "text": "Note: see also [IRDI] 0112/2///61987#ABA464#005 equipment protection level Note: editorial definition: Level of protection assigned to equipment based on its likelihood of becoming a source of ignition Note: Equipment protection level according to the IEC standards. According to the current nameplate, also the combination \u201CGD\u201D is permitted Note: The combination \u201CGD\u201D is no longer accepted and was changed in the standards. Currently the marking for \u201CG\u201D and \u201CD\u201D must be provided in a separate marking string. Older devices may still exist with the marking \u201CGD\u201D. Note: Recommendation: property declaration as MLP is required by its semantic definition. As the property value is language independent, users are recommended to provide maximal 1 string in any language of the user\u2019s choice."
                              }
                            ],
                            "semanticId": {
                              "type": "ExternalReference",
                              "keys": [
                                {
                                  "type": "GlobalReference",
                                  "value": "0173-1#02-AAM668#001"
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
                            "value": [
                              {
                                "language": "en",
                                "text": "Gb"
                              }
                            ],
                            "modelType": "MultiLanguageProperty"
                          },
                          {
                            "idShort": "RegionalSpecificMarking",
                            "semanticId": {
                              "type": "ExternalReference",
                              "keys": [
                                {
                                  "type": "GlobalReference",
                                  "value": "https://admin-shell.io/zvei/nameplate/2/0/Nameplate/Markings/Marking/ExplosionSafeties/ExplosionSafety/RegionalSpecificMarking"
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
                            "value": "Class I, Division 2",
                            "modelType": "Property"
                          },
                          {
                            "idShort": "TypeOfProtection",
                            "description": [
                              {
                                "language": "en",
                                "text": "Note: see also [IRDI] 0112/2///61987#ABA589#002 type of protection (Ex) Note: Symbol(s) for the Type of protection. Several types of protection are separated by a semicolon \u201C;\u201D "
                              }
                            ],
                            "semanticId": {
                              "type": "ExternalReference",
                              "keys": [
                                {
                                  "type": "GlobalReference",
                                  "value": "0173-1#02-AAQ325#003"
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
                            "value": "db",
                            "modelType": "Property"
                          },
                          {
                            "idShort": "ExplosionGroup",
                            "description": [
                              {
                                "language": "en",
                                "text": "Note: see also [IRDI] 0112/2///61987#ABA961#007 permitted gas group/explosion group Note: Equipment grouping according to IEC 60079-0 is meant by this property Note: Symbol(s) for the gas group (IIA\u2026IIC) or dust group (IIIA\u2026IIIC) "
                              }
                            ],
                            "semanticId": {
                              "type": "ExternalReference",
                              "keys": [
                                {
                                  "type": "GlobalReference",
                                  "value": "0173-1#02-AAT372#001"
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
                            "value": "IIC",
                            "modelType": "Property"
                          },
                          {
                            "idShort": "MinimumAmbientTemperature",
                            "description": [
                              {
                                "language": "en",
                                "text": "Note: see also [IRDI] 0112/2///61987#ABA621#007 minimum ambient temperature Note: editorial defnition: lower limit of the temperature range of the environment in which the component, the pipework or the system can be operated Note: Rated minimum ambient temperature Note: Positive temperatures are listed without \u201C\u002B\u201D sign. If several temperatures ranges are marked, only the most general range shall be indicated in the template, which is consistent with the specified temperature class or maximum surface temperature. Other temperature ranges and temperature classes/maximum surface temperatures may be listed in the instructions."
                              }
                            ],
                            "semanticId": {
                              "type": "ExternalReference",
                              "keys": [
                                {
                                  "type": "GlobalReference",
                                  "value": "0173-1#02-AAZ952#001"
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
                            "value": "-40",
                            "modelType": "Property"
                          },
                          {
                            "idShort": "MaxAmbientTemperature",
                            "description": [
                              {
                                "language": "en",
                                "text": "Note: see also [IRDI] 0112/2///61987#ABA623#007 maximum ambient temperature Note: editorial definition: upper limit of the temperature range of the environment in which the component, the pipework or the system can be operated Note: Rated maximum ambient temperature Note: Positive temperatures are listed without \u201C\u002B\u201D sign. If several temperatures ranges are marked, only the most general range shall be indicated in the template, which is consistent with the specified temperature class or maximum surface temperature. Other temperature ranges and temperature classes/maximum surface temperatures may be listed in the instructions."
                              }
                            ],
                            "semanticId": {
                              "type": "ExternalReference",
                              "keys": [
                                {
                                  "type": "GlobalReference",
                                  "value": "0173-1#02-BAA039#010"
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
                            "value": "120",
                            "modelType": "Property"
                          },
                          {
                            "idShort": "MaxSurfaceTemperatureForDustProof",
                            "description": [
                              {
                                "language": "en",
                                "text": "Note: see also [IRDI] 0112/2///61987#ABB159#004 maximum surface temperature for dust-proof Note: Maximum surface temperature of the device (dust layer \u2264 5 mm) for specified maximum ambient and maximum process temperature, relevant for Group III only Note: Positive temperatures are listed without \u201C\u002B\u201D sign. If several temperatures ranges are marked, only the most general range shall be indicated in the template, which is consistent with the specified temperature class or maximum surface temperature. Other temperature ranges and temperature classes/maximum surface temperatures may be listed in the instructions."
                              }
                            ],
                            "semanticId": {
                              "type": "ExternalReference",
                              "keys": [
                                {
                                  "type": "GlobalReference",
                                  "value": "0173-1#02-AAM666#005"
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
                            "value": "100",
                            "modelType": "Property"
                          },
                          {
                            "idShort": "TemperatureClass",
                            "description": [
                              {
                                "language": "en",
                                "text": "Note: see also [IRDI] 0112/2///61987#ABA593#002 temperature class Note: editorial definition: classification system of electrical apparatus, based on its maximum surface temperature, intended for use in an explosive atmospheres with flammable gas, vapour or mist. Note: Temperature class for specified maximum ambient and maximum process temperature, relevant for Group II only (Further combinations may be provided in the instruction manual). "
                              }
                            ],
                            "semanticId": {
                              "type": "ExternalReference",
                              "keys": [
                                {
                                  "type": "GlobalReference",
                                  "value": "0173-1#02-AAO371#004"
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
                            "value": "T4",
                            "modelType": "Property"
                          }
                        ],
                        "modelType": "SubmodelElementCollection"
                      },
                      {
                        "idShort": "ProcessConditions",
                        "description": [
                          {
                            "language": "en",
                            "text": "Note: If the device is mounted in the process boundary, ambient and process conditions are provided separately. "
                          }
                        ],
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "https://admin-shell.io/zvei/nameplate/2/0/Nameplate/Markings/Marking/ExplosionSafeties/ExplosionSafety/ProcessConditions"
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
                        "value": [
                          {
                            "idShort": "DeviceCategory",
                            "description": [
                              {
                                "language": "en",
                                "text": "Note: see also [IRDI] 0112/2///61987#ABA467#002 equipment/device category Note: editorial defnition: Category of device in accordance with directive 2014/34/EU Note: Equipment category according to the ATEX system. "
                              }
                            ],
                            "semanticId": {
                              "type": "ExternalReference",
                              "keys": [
                                {
                                  "type": "GlobalReference",
                                  "value": "0173-1#02-AAK297#004"
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
                            "value": "1G",
                            "modelType": "Property"
                          },
                          {
                            "idShort": "EquipmentProtectionLevel",
                            "description": [
                              {
                                "language": "en",
                                "text": "Note: see also [IRDI] 0112/2///61987#ABA464#005 equipment protection level Note: editorial defnition: Level of protection assigned to equipment based on its likelihood of becoming a source of ignition Note: Equipment protection level according to the IEC or other standards, e.g. Ga (IEC), Class I/Division 1 (US), Zone (EAC) Note: Recommendation: property declaration as MLP is required by its semantic definition. As the property value is language independent, users are recommended to provide maximal 1 string in any language of the user\u2019s choice."
                              }
                            ],
                            "semanticId": {
                              "type": "ExternalReference",
                              "keys": [
                                {
                                  "type": "GlobalReference",
                                  "value": "0173-1#02-AAM668#001"
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
                            "value": [
                              {
                                "language": "en",
                                "text": "Ga"
                              }
                            ],
                            "modelType": "MultiLanguageProperty"
                          },
                          {
                            "idShort": "RegionalSpecificMarking",
                            "semanticId": {
                              "type": "ExternalReference",
                              "keys": [
                                {
                                  "type": "GlobalReference",
                                  "value": "https://admin-shell.io/zvei/nameplate/2/0/Nameplate/Markings/Marking/ExplosionSafeties/ExplosionSafety/RegionalSpecificMarking"
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
                            "value": "IS",
                            "modelType": "Property"
                          },
                          {
                            "idShort": "TypeOfProtection",
                            "description": [
                              {
                                "language": "en",
                                "text": "Note: see also [IRDI] 0112/2///61987#ABA589#002 type of protection (Ex) Note: Symbol(s) for the Type of protection. Several types of protection are separated by a semicolon \u201C;\u201D "
                              }
                            ],
                            "semanticId": {
                              "type": "ExternalReference",
                              "keys": [
                                {
                                  "type": "GlobalReference",
                                  "value": "0173-1#02-AAQ325#003"
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
                            "value": "ia",
                            "modelType": "Property"
                          },
                          {
                            "idShort": "ExplosionGroup",
                            "description": [
                              {
                                "language": "en",
                                "text": "Note: see also [IRDI] 0112/2///61987#ABA961#007 permitted gas group/explosion group Note: editorial definition: classification of dangerous gaseous substances based on their ability to be ignited Note: Equipment grouping according to IEC 60079-0 is meant by this property Note: Symbol(s) for the gas group (IIA\u2026IIC) or dust group (IIIA\u2026IIIC) "
                              }
                            ],
                            "semanticId": {
                              "type": "ExternalReference",
                              "keys": [
                                {
                                  "type": "GlobalReference",
                                  "value": "0173-1#02-AAT372#001"
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
                            "value": "IIC",
                            "modelType": "Property"
                          },
                          {
                            "idShort": "LowerLimitingValueOfProcessTemperature",
                            "description": [
                              {
                                "language": "en",
                                "text": "Note: Rated minimum process temperature Note: Positive temperatures are listed without \u201C\u002B\u201D sign. If several temperatures ranges are marked, only the most general range shall be indicated in the template, which is consistent with the specified temperature class or maximum surface temperature. Other temperature ranges and temperature classes/maximum surface temperatures may be listed in the instructions."
                              }
                            ],
                            "semanticId": {
                              "type": "ExternalReference",
                              "keys": [
                                {
                                  "type": "GlobalReference",
                                  "value": "0173-1#02-AAN309#004"
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
                            "value": "-40",
                            "modelType": "Property"
                          },
                          {
                            "idShort": "UpperLimitingValueOfProcessTemperature",
                            "description": [
                              {
                                "language": "en",
                                "text": "Note: Rated maximum process temperature Note: Positive temperatures are listed without \u201C\u002B\u201D sign. If several temperatures ranges are marked, only the most general range shall be indicated in the template, which is consistent with the specified temperature class or maximum surface temperature. Other temperature ranges and temperature classes/maximum surface temperatures may be listed in the instructions."
                              }
                            ],
                            "semanticId": {
                              "type": "ExternalReference",
                              "keys": [
                                {
                                  "type": "GlobalReference",
                                  "value": "0173-1#02-AAN307#004"
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
                            "value": "120",
                            "modelType": "Property"
                          },
                          {
                            "idShort": "MaxSurfaceTemperatureForDustProof",
                            "description": [
                              {
                                "language": "en",
                                "text": "Note: see also [IRDI] 0112/2///61987#ABB159#004 maximum surface temperature for dust-proof Note: Maximum surface temperature (dust layer \u2264 5 mm) for specified maximum ambient and maximum process temperature, relevant for Group III only Note: Positive temperatures are listed without \u201C\u002B\u201D sign. If several temperatures ranges are marked, only the most general range shall be indicated in the template, which is consistent with the specified temperature class or maximum surface temperature. Other temperature ranges and temperature classes/maximum surface temperatures may be listed in the instructions."
                              }
                            ],
                            "semanticId": {
                              "type": "ExternalReference",
                              "keys": [
                                {
                                  "type": "GlobalReference",
                                  "value": "0173-1#02-AAM666#005"
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
                            "value": "85",
                            "modelType": "Property"
                          },
                          {
                            "idShort": "TemperatureClass",
                            "description": [
                              {
                                "language": "en",
                                "text": "Note: see also [IRDI] 0112/2///61987#ABA593#002 temperature class Note: editorial definition: classification system of electrical apparatus, based on its maximum surface temperature, intended for use in an explosive atmospheres with flammable gas, vapour or mist. Note: Temperature class for specified maximum ambient and maximum process temperature, relevant for Group II only (Further combinations may be provided in the instruction manual). "
                              }
                            ],
                            "semanticId": {
                              "type": "ExternalReference",
                              "keys": [
                                {
                                  "type": "GlobalReference",
                                  "value": "0173-1#02-AAO371#004"
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
                            "value": "T4",
                            "modelType": "Property"
                          }
                        ],
                        "modelType": "SubmodelElementCollection"
                      },
                      {
                        "idShort": "ExternalElectricalCircuit",
                        "description": [
                          {
                            "language": "en",
                            "text": "Note: If several external circuits can be connected to the device, this block shall provide a cardinality with the number of circuits Note: If for one external IS circuit several sets of safety parameters are provided (e.g. for several material groups), each set is specified in a separate block as a separate circuit. "
                          }
                        ],
                        "semanticId": {
                          "type": "ExternalReference",
                          "keys": [
                            {
                              "type": "GlobalReference",
                              "value": "https://admin-shell.io/zvei/nameplate/2/0/Nameplate/Markings/Marking/ExplosionSafeties/ExplosionSafety/ExternalElectricalCircuit"
                            }
                          ]
                        },
                        "qualifiers": [
                          {
                            "type": "Multiplicity",
                            "valueType": "xs:string",
                            "value": "ZeroToMany"
                          }
                        ],
                        "value": [
                          {
                            "idShort": "DesignationOfElectricalTerminal",
                            "description": [
                              {
                                "language": "en",
                                "text": "Note: For each circuit the designation of the terminals shall be specified. If several circuits are provided with the same parameters, their terminal pairs are listed and separated by a semicolon. If several circuits belong to one channel this shall be described in the instructions. "
                              }
                            ],
                            "semanticId": {
                              "type": "ExternalReference",
                              "keys": [
                                {
                                  "type": "GlobalReference",
                                  "value": "0112/2///61987#ABB147#004"
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
                            "value": "\u002B/-",
                            "modelType": "Property"
                          },
                          {
                            "idShort": "TypeOfProtection",
                            "description": [
                              {
                                "language": "en",
                                "text": "Note: see also [IRDI] 0112/2///61987#ABA589#002 type of protection (Ex)) Note:  \u00B7\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0 Type of protection for the device as listed in the certificate \u00B7\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0 Symbol(s) for the Type of protection. Several types of protection are separated by a semicolon \u201C;\u201D \u00B7\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0 If several TypeOfProtection are listed in the same certificate, for each TypeOfProtection a separate SMC \u201CExplosion Safety\u201D shall be provided "
                              }
                            ],
                            "semanticId": {
                              "type": "ExternalReference",
                              "keys": [
                                {
                                  "type": "GlobalReference",
                                  "value": "0173-1#02-AAQ325#003"
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
                            "value": "db",
                            "modelType": "Property"
                          },
                          {
                            "idShort": "EquipmentProtectionLevel",
                            "description": [
                              {
                                "language": "en",
                                "text": "Note: see also [IRDI] 0112/2///61987#ABA464#005 equipment protection level Note: editorial definition: Level of protection assigned to equipment based on its likelihood of becoming a source of ignition Note: EPL according to IEC standards Note: value should be chosen from an enumeration list with values \u201CGa, Gb, Gc, Da, Db, Dc, Ma, Mb\u201D  Note: Recommendation: property declaration as MLP is required by its semantic definition. As the property value is language independent, users are recommended to provide maximal 1 string in any language of the user\u2019s choice."
                              }
                            ],
                            "semanticId": {
                              "type": "ExternalReference",
                              "keys": [
                                {
                                  "type": "GlobalReference",
                                  "value": "0173-1#02-AAM668#001"
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
                            "value": [
                              {
                                "language": "en",
                                "text": "Ga"
                              }
                            ],
                            "modelType": "MultiLanguageProperty"
                          },
                          {
                            "idShort": "ExplosionGroup",
                            "description": [
                              {
                                "language": "en",
                                "text": "Note: see also [IRDI] 0112/2///61987#ABA961#007 permitted gas group/explosion group Note: editorial definition: classification of dangerous gaseous substances based on their ability to be ignited Note: Equipment grouping according to IEC 60079-0 is meant by this property Note: Symbol(s) for the gas group (IIA\u2026IIC) or dust group (IIIA\u2026IIIC) "
                              }
                            ],
                            "semanticId": {
                              "type": "ExternalReference",
                              "keys": [
                                {
                                  "type": "GlobalReference",
                                  "value": "0173-1#02-AAT372#001"
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
                            "value": "IIC",
                            "modelType": "Property"
                          },
                          {
                            "idShort": "Characteristics",
                            "description": [
                              {
                                "language": "en",
                                "text": "Note: linear/ non-linear "
                              }
                            ],
                            "semanticId": {
                              "type": "ExternalReference",
                              "keys": [
                                {
                                  "type": "GlobalReference",
                                  "value": "https://admin-shell.io/zvei/nameplate/2/0/Nameplate/Markings/Marking/ExplosionSafeties/ExplosionSafety/ExternalElectricalCircuit/Characteristics"
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
                            "value": "linear",
                            "modelType": "Property"
                          },
                          {
                            "idShort": "Fisco",
                            "description": [
                              {
                                "language": "en",
                                "text": "Note: Enter \u201Cx\u201D if relevant "
                              }
                            ],
                            "semanticId": {
                              "type": "ExternalReference",
                              "keys": [
                                {
                                  "type": "GlobalReference",
                                  "value": "https://admin-shell.io/zvei/nameplate/2/0/Nameplate/Markings/Marking/ExplosionSafeties/ExplosionSafety/ExternalElectricalCircuit/Fisco"
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
                            "value": "x",
                            "modelType": "Property"
                          },
                          {
                            "idShort": "TwoWISE",
                            "description": [
                              {
                                "language": "en",
                                "text": "Note: Enter \u201Cx\u201D if relevant "
                              }
                            ],
                            "semanticId": {
                              "type": "ExternalReference",
                              "keys": [
                                {
                                  "type": "GlobalReference",
                                  "value": "https://admin-shell.io/zvei/nameplate/2/0/Nameplate/Markings/Marking/ExplosionSafeties/ExplosionSafety/ExternalElectricalCircuit/TwoWISE"
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
                            "value": "x",
                            "modelType": "Property"
                          },
                          {
                            "idShort": "SafetyRelatedPropertiesForPassiveBehaviour",
                            "description": [
                              {
                                "language": "en",
                                "text": "Note: see also [IRDI] 0112/2///61987#ABC586#001 Safety related properties for passive behaviour Note: IS-parameters for passive circuits, if relevant (e.g. 2 wire field devices, valves) "
                              }
                            ],
                            "semanticId": {
                              "type": "ExternalReference",
                              "keys": [
                                {
                                  "type": "GlobalReference",
                                  "value": "0173-1#02-AAQ380#006"
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
                            "value": [
                              {
                                "idShort": "MaxInputPower",
                                "description": [
                                  {
                                    "language": "en",
                                    "text": "Note: see also [IRDI] 0112/2///61987#ABA981#001 maximum input power (Pi) Note: Limit value for input power "
                                  }
                                ],
                                "semanticId": {
                                  "type": "ExternalReference",
                                  "keys": [
                                    {
                                      "type": "GlobalReference",
                                      "value": "0173-1#02-AAQ372#003"
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
                                "value": "1250",
                                "modelType": "Property"
                              },
                              {
                                "idShort": "MaxInputVoltage",
                                "description": [
                                  {
                                    "language": "en",
                                    "text": "Note: see also [IRDI] 0112/2///61987#ABA982#001 maximum input voltage (Ui) Note: Limit value for input voltage "
                                  }
                                ],
                                "semanticId": {
                                  "type": "ExternalReference",
                                  "keys": [
                                    {
                                      "type": "GlobalReference",
                                      "value": "0173-1#02-AAM638#003"
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
                                "value": "30",
                                "modelType": "Property"
                              },
                              {
                                "idShort": "MaxInputCurrent",
                                "description": [
                                  {
                                    "language": "en",
                                    "text": "Note: see also [IRDI] 0112/2///61987#ABA983#001 maximum input current (Ii) Note: Limit value for input current "
                                  }
                                ],
                                "semanticId": {
                                  "type": "ExternalReference",
                                  "keys": [
                                    {
                                      "type": "GlobalReference",
                                      "value": "0173-1#02-AAM642#004"
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
                                "value": "100",
                                "modelType": "Property"
                              },
                              {
                                "idShort": "MaxInternalCapacitance",
                                "description": [
                                  {
                                    "language": "en",
                                    "text": "Note: see also [IRDI] 0112/2///61987#ABA984#001 maximum internal capacitance (Ci) Note: Maximum internal capacitance of the circuit "
                                  }
                                ],
                                "semanticId": {
                                  "type": "ExternalReference",
                                  "keys": [
                                    {
                                      "type": "GlobalReference",
                                      "value": "0173-1#02-AAM640#004"
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
                                "value": "0",
                                "modelType": "Property"
                              },
                              {
                                "idShort": "MaxInternalInductance",
                                "description": [
                                  {
                                    "language": "en",
                                    "text": "Note: see also [IRDI] 0112/2///61987#ABA985#001 maximum internal inductance (Li) Note: Maximum internal inductance of the circuit "
                                  }
                                ],
                                "semanticId": {
                                  "type": "ExternalReference",
                                  "keys": [
                                    {
                                      "type": "GlobalReference",
                                      "value": "0173-1#02-AAM639#003"
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
                                "value": "0",
                                "modelType": "Property"
                              }
                            ],
                            "modelType": "SubmodelElementCollection"
                          },
                          {
                            "idShort": "SafetyRelatedPropertiesForActiveBehaviour",
                            "description": [
                              {
                                "language": "en",
                                "text": "Note: see also [IRDI] 0112/2///61987#ABC585#001 Safety related properties for active behaviour Note: IS-parameters for active circuits, if relevant (e.g. power supply, IS-barriers) "
                              }
                            ],
                            "semanticId": {
                              "type": "ExternalReference",
                              "keys": [
                                {
                                  "type": "GlobalReference",
                                  "value": "0173-1#02-AAQ381#006"
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
                            "value": [
                              {
                                "idShort": "MaxOutputPower",
                                "description": [
                                  {
                                    "language": "en",
                                    "text": "Note: see also [IRDI] 0112/2///61987#ABA987#001 maximum output power (Po) Note: Limit value for output power "
                                  }
                                ],
                                "semanticId": {
                                  "type": "ExternalReference",
                                  "keys": [
                                    {
                                      "type": "GlobalReference",
                                      "value": "0173-1#02-AAQ371#003"
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
                                "value": "960",
                                "modelType": "Property"
                              },
                              {
                                "idShort": "MaxOutputVoltage",
                                "description": [
                                  {
                                    "language": "en",
                                    "text": "Note: see also [IRDI] 0112/2///61987#ABA989#001 maximum output voltage (Uo) Note: Limit value for open circuits output voltage "
                                  }
                                ],
                                "semanticId": {
                                  "type": "ExternalReference",
                                  "keys": [
                                    {
                                      "type": "GlobalReference",
                                      "value": "0173-1#02-AAM635#003"
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
                                "value": "15.7",
                                "modelType": "Property"
                              },
                              {
                                "idShort": "MaxOutputCurrent",
                                "description": [
                                  {
                                    "language": "en",
                                    "text": "Note: see also [IRDI] 0112/2///61987#ABA988#001maximum output current (Io) Note: Limit value for closed circuit output current "
                                  }
                                ],
                                "semanticId": {
                                  "type": "ExternalReference",
                                  "keys": [
                                    {
                                      "type": "GlobalReference",
                                      "value": "0173-1#02-AAM641#004"
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
                                "value": "245",
                                "modelType": "Property"
                              },
                              {
                                "idShort": "MaxExternalCapacitance",
                                "description": [
                                  {
                                    "language": "en",
                                    "text": "Note: see also [IRDI] 0112/2///61987#ABA990#001 maximum external capacitance (Co) Note: Maximum external capacitance to be connected to the circuit "
                                  }
                                ],
                                "semanticId": {
                                  "type": "ExternalReference",
                                  "keys": [
                                    {
                                      "type": "GlobalReference",
                                      "value": "0173-1#02-AAM637#004"
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
                                "value": "2878",
                                "modelType": "Property"
                              },
                              {
                                "idShort": "MaxExternalInductance",
                                "description": [
                                  {
                                    "language": "en",
                                    "text": "Note: see also [IRDI] 0112/2///61987#ABA991#001 maximum external inductance (Lo) Note: Maximum external inductance to be connected to the circuit "
                                  }
                                ],
                                "semanticId": {
                                  "type": "ExternalReference",
                                  "keys": [
                                    {
                                      "type": "GlobalReference",
                                      "value": "0173-1#02-AAM636#003"
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
                                "value": "2.9",
                                "modelType": "Property"
                              },
                              {
                                "idShort": "MaxExternalInductanceResistanceRatio",
                                "description": [
                                  {
                                    "language": "en",
                                    "text": "Note: see also [IRDI] 0112/2///61987#ABB145#001 maximum external inductance/resistance ratio (Lo/Ro) Note: External Inductance to Resistance ratio "
                                  }
                                ],
                                "semanticId": {
                                  "type": "ExternalReference",
                                  "keys": [
                                    {
                                      "type": "GlobalReference",
                                      "value": "0173-1#02-AAM634#003"
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
                                "value": "",
                                "modelType": "Property"
                              }
                            ],
                            "modelType": "SubmodelElementCollection"
                          }
                        ],
                        "modelType": "SubmodelElementCollection"
                      }
                    ],
                    "modelType": "SubmodelElementCollection"
                  }
                ],
                "modelType": "SubmodelElementCollection"
              }
            ],
            "modelType": "SubmodelElementCollection"
          }
        ],
        "modelType": "SubmodelElementCollection"
      },
      {
        "idShort": "AssetSpecificProperties",
        "description": [
          {
            "language": "en",
            "text": "Note: defined as \u201CAsset specific nameplate information\u201D per ECLASS "
          }
        ],
        "semanticId": {
          "type": "ExternalReference",
          "keys": [
            {
              "type": "GlobalReference",
              "value": "0173-1#01-AGZ672#001"
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
        "value": [
          {
            "idShort": "GuidelineSpecificProperties{00}",
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "0173-1#01-AHD205#001"
                }
              ]
            },
            "qualifiers": [
              {
                "type": "Multiplicity",
                "valueType": "xs:string",
                "value": "OneToMany"
              }
            ],
            "value": [
              {
                "idShort": "GuidelineForConformityDeclaration",
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "0173-1#02-AAO856#002"
                    }
                  ]
                },
                "qualifiers": [
                  {
                    "type": "Multiplicity",
                    "valueType": "xs:string",
                    "value": "One"
                  }
                ],
                "valueType": "xs:string",
                "value": "",
                "modelType": "Property"
              },
              {
                "idShort": "{arbitrary}",
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "www.example.com/ids/cd/3325_9020_5022_1074"
                    }
                  ]
                },
                "qualifiers": [
                  {
                    "type": "Multiplicity",
                    "valueType": "xs:string",
                    "value": "OneToMany"
                  }
                ],
                "valueType": "xs:string",
                "value": "",
                "modelType": "Property"
              }
            ],
            "modelType": "SubmodelElementCollection"
          },
          {
            "idShort": "{arbitrary}",
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "www.example.com/ids/cd/3325_9020_5022_1964"
                }
              ]
            },
            "qualifiers": [
              {
                "type": "Multiplicity",
                "valueType": "xs:string",
                "value": "OneToMany"
              }
            ],
            "valueType": "xs:string",
            "value": "",
            "modelType": "Property"
          }
        ],
        "modelType": "SubmodelElementCollection"
      }
    ],
    "modelType": "Submodel"
  },
  {
    "idShort": "Images",
    "id": "https://example.com/ids/sm/9143_8002_7042_7188",
    "submodelElements": [
      {
        "idShort": "ProductPicture",
        "displayName": [
          {
            "language": "en",
            "text": "Product Picture"
          },
          {
            "language": "de",
            "text": "Produktbild"
          }
        ],
        "value": "https://mm.digikey.com/Volume0/opasdata/d220001/medias/images/4280/MFG_ENR_Max_Product-Image_E92_Straight.jpg",
        "contentType": "image/jpeg",
        "modelType": "File"
      },
      {
        "idShort": "DisplayImage",
        "value": "https://energizer.com/wp-content/uploads/2023/11/enr_watch-electronic_a23bpz_card_hero_upn-143394_amer_520x364.jpg",
        "contentType": "text/xml",
        "modelType": "File"
      }
    ],
    "modelType": "Submodel"
  },
  {
    "idShort": "CarbonFootprint",
    "displayName": [
      {
        "language": "de",
        "text": "C02 Footprint"
      },
      {
        "language": "en",
        "text": "Carbon Footprint"
      }
    ],
    "description": [
      {
        "language": "en",
        "text": "The Submodel provides the means to access the Carbon Footprint of the asset."
      }
    ],
    "administration": {
      "version": "0",
      "revision": "9",
      "templateId": "https://admin-shell.io/idta/CarbonFootprint/CarbonFootprint/0/9"
    },
    "id": "https://example.com/ids/sm/6112_9132_7042_1308",
    "kind": "Instance",
    "semanticId": {
      "type": "ExternalReference",
      "keys": [
        {
          "type": "GlobalReference",
          "value": "https://admin-shell.io/idta/CarbonFootprint/CarbonFootprint/0/9"
        }
      ]
    },
    "submodelElements": [
      {
        "idShort": "ProductCarbonFootprint",
        "displayName": [
          {
            "language": "de",
            "text": "Produkt C02-Fu\u00DFabdruck"
          },
          {
            "language": "en",
            "text": "Product carbon footprint"
          }
        ],
        "description": [
          {
            "language": "en",
            "text": "Balance of greenhouse gas emissions along the entire life cycle of a product in a defined application and in relation to a defined unit of use"
          }
        ],
        "semanticId": {
          "type": "ExternalReference",
          "keys": [
            {
              "type": "GlobalReference",
              "value": "https://admin-shell.io/idta/CarbonFootprint/ProductCarbonFootprint/0/9"
            }
          ]
        },
        "qualifiers": [
          {
            "type": "Cardinality",
            "valueType": "xs:string",
            "value": "ZeroToMany"
          }
        ],
        "embeddedDataSpecifications": [],
        "value": [
          {
            "category": "PARAMETER",
            "idShort": "PCFCalculationMethod",
            "displayName": [
              {
                "language": "de",
                "text": "Folgenabsch\u00E4tzungsmethode / Berechnungsmethode"
              },
              {
                "language": "en",
                "text": "impact assessment method / calculation method"
              }
            ],
            "description": [
              {
                "language": "en",
                "text": "Standard, method for determining the greenhouse gas emissions of a product"
              },
              {
                "language": "de",
                "text": "Norm, Standard, Verfahren zur Ermittlung der Treibhausgas-Emissionen eines Produkts"
              }
            ],
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "0173-1#02-ABG854#001"
                }
              ]
            },
            "qualifiers": [
              {
                "type": "Cardinality",
                "valueType": "xs:string",
                "value": "OneToMany"
              }
            ],
            "embeddedDataSpecifications": [],
            "valueType": "xs:string",
            "value": "ISO-440",
            "modelType": "Property"
          },
          {
            "category": "PARAMETER",
            "idShort": "PCFCO2eq",
            "displayName": [
              {
                "language": "de",
                "text": "CO2 eq Klimawandel"
              },
              {
                "language": "en",
                "text": "CO2 eq Climate Change"
              }
            ],
            "description": [
              {
                "language": "en",
                "text": "Sum of all greenhouse gas emissions of a product according to the quantification requirements of the standard"
              }
            ],
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "0173-1#02-ABG855#001"
                }
              ]
            },
            "qualifiers": [
              {
                "type": "Cardinality",
                "valueType": "xs:string",
                "value": "One"
              }
            ],
            "embeddedDataSpecifications": [],
            "valueType": "xs:double",
            "value": "2000",
            "modelType": "Property"
          },
          {
            "category": "PARAMETER",
            "idShort": "PCFReferenceValueForCalculation",
            "displayName": [
              {
                "language": "de",
                "text": "Referenzeinheit f\u00FCr die Berechnung"
              },
              {
                "language": "en",
                "text": "Reference value for calculation"
              }
            ],
            "description": [
              {
                "language": "en",
                "text": "Quantity unit of the product to which the PCF information on the CO2 footprint refers"
              }
            ],
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "0173-1#02-ABG856#001"
                }
              ]
            },
            "qualifiers": [
              {
                "type": "Cardinality",
                "valueType": "xs:string",
                "value": "One"
              }
            ],
            "embeddedDataSpecifications": [],
            "valueType": "xs:string",
            "value": "1",
            "modelType": "Property"
          },
          {
            "category": "PARAMETER",
            "idShort": "PCFQuantityOfMeasureForCalculation",
            "displayName": [
              {
                "language": "de",
                "text": "Mengenangabe f\u00FCr die Berechnung"
              },
              {
                "language": "en",
                "text": "quantity of measure for calculation"
              }
            ],
            "description": [
              {
                "language": "en",
                "text": "Quantity of the product to which the PCF information on the CO2 footprint refers"
              }
            ],
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "0173-1#02-ABG857#001"
                }
              ]
            },
            "qualifiers": [
              {
                "type": "Cardinality",
                "valueType": "xs:string",
                "value": "One"
              }
            ],
            "embeddedDataSpecifications": [],
            "valueType": "xs:double",
            "value": "kg",
            "modelType": "Property"
          },
          {
            "category": "PARAMETER",
            "idShort": "PCFLifeCyclePhase",
            "displayName": [
              {
                "language": "de",
                "text": "Lebenszyklusphase"
              },
              {
                "language": "en",
                "text": "life cycle phase"
              }
            ],
            "description": [
              {
                "language": "en",
                "text": "Life cycle stages of the product according to the quantification requirements of the standard to which the PCF carbon footprint statement refers"
              }
            ],
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "0173-1#02-ABG858#001"
                }
              ]
            },
            "qualifiers": [
              {
                "type": "Cardinality",
                "valueType": "xs:string",
                "value": "OneToMany"
              }
            ],
            "embeddedDataSpecifications": [],
            "valueType": "xs:string",
            "value": "4",
            "modelType": "Property"
          },
          {
            "category": "PARAMETER",
            "idShort": "ExplanatoryStatement",
            "displayName": [
              {
                "language": "de",
                "text": "Erkl\u00E4rung"
              },
              {
                "language": "en",
                "text": "Explanatory statement"
              }
            ],
            "description": [
              {
                "language": "en",
                "text": "Explanation which is needed or given so that a footprint communication can be properly understood by a purchaser, potential purchaser or user of the product"
              }
            ],
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "https://admin-shell.io/idta/CarbonFootprint/ExplanatoryStatement/1/0"
                }
              ]
            },
            "qualifiers": [
              {
                "type": "Cardinality",
                "valueType": "xs:string",
                "value": "ZeroToOne"
              }
            ],
            "embeddedDataSpecifications": [],
            "value": "",
            "contentType": "application/pdf",
            "modelType": "File"
          },
          {
            "idShort": "PCFGoodsAddressHandover",
            "displayName": [
              {
                "language": "de",
                "text": "PCF Waren\u00FCbergabeadresse"
              },
              {
                "language": "en",
                "text": "PCF goods address hand-over"
              }
            ],
            "description": [
              {
                "language": "en",
                "text": "Indicates the place of hand-over of the goods "
              }
            ],
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "0173-1#02-ABI497#001"
                }
              ]
            },
            "qualifiers": [
              {
                "type": "Cardinality",
                "valueType": "xs:string",
                "value": "One"
              }
            ],
            "embeddedDataSpecifications": [],
            "value": [
              {
                "category": "PARAMETER",
                "idShort": "Street",
                "description": [
                  {
                    "language": "en",
                    "text": "Street indication of the place of transfer of goods"
                  }
                ],
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "0173-1#02-ABH956#001"
                    }
                  ]
                },
                "qualifiers": [
                  {
                    "type": "Cardinality",
                    "valueType": "xs:string",
                    "value": "ZeroToOne"
                  }
                ],
                "embeddedDataSpecifications": [],
                "valueType": "xs:string",
                "value": "",
                "modelType": "Property"
              },
              {
                "category": "PARAMETER",
                "idShort": "HouseNumber",
                "description": [
                  {
                    "language": "en",
                    "text": "Number for identification or differentiation of individual houses of a street"
                  }
                ],
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "0173-1#02-ABH957#001"
                    }
                  ]
                },
                "qualifiers": [
                  {
                    "type": "Cardinality",
                    "valueType": "xs:string",
                    "value": "ZeroToOne"
                  }
                ],
                "embeddedDataSpecifications": [],
                "valueType": "xs:string",
                "value": "",
                "modelType": "Property"
              },
              {
                "category": "PARAMETER",
                "idShort": "ZipCode",
                "description": [
                  {
                    "language": "en",
                    "text": "Zip code of the goods transfer address"
                  }
                ],
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "0173-1#02-ABH958#001"
                    }
                  ]
                },
                "qualifiers": [
                  {
                    "type": "Cardinality",
                    "valueType": "xs:string",
                    "value": "ZeroToOne"
                  }
                ],
                "embeddedDataSpecifications": [],
                "valueType": "xs:string",
                "value": "",
                "modelType": "Property"
              },
              {
                "category": "PARAMETER",
                "idShort": "CityTown",
                "description": [
                  {
                    "language": "en",
                    "text": "Indication of the city or town of the transfer of goods"
                  }
                ],
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "0173-1#02-ABH959#001"
                    }
                  ]
                },
                "qualifiers": [
                  {
                    "type": "Cardinality",
                    "valueType": "xs:string",
                    "value": "ZeroToOne"
                  }
                ],
                "embeddedDataSpecifications": [],
                "valueType": "xs:string",
                "value": "",
                "modelType": "Property"
              },
              {
                "category": "PARAMETER",
                "idShort": "Country",
                "description": [
                  {
                    "language": "en",
                    "text": "Country where the product is transmitted"
                  }
                ],
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "0173-1#02-AAO259#005"
                    }
                  ]
                },
                "qualifiers": [
                  {
                    "type": "Cardinality",
                    "valueType": "xs:string",
                    "value": "ZeroToOne"
                  }
                ],
                "embeddedDataSpecifications": [],
                "valueType": "xs:string",
                "value": "",
                "modelType": "Property"
              }
            ],
            "modelType": "SubmodelElementCollection"
          },
          {
            "category": "PARAMETER",
            "idShort": "PublicationDate",
            "displayName": [
              {
                "language": "de",
                "text": "Ver\u00F6ffentlichungsdatum"
              },
              {
                "language": "en",
                "text": "Publication date"
              }
            ],
            "description": [
              {
                "language": "en",
                "text": "Time at which something was first published or made available"
              }
            ],
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "https://admin-shell.io/idta/CarbonFootprint/PublicationDate/1/0"
                }
              ]
            },
            "qualifiers": [
              {
                "type": "Cardinality",
                "valueType": "xs:string",
                "value": "One"
              }
            ],
            "embeddedDataSpecifications": [],
            "valueType": "xs:string",
            "value": "24.03.2024",
            "modelType": "Property"
          },
          {
            "category": "PARAMETER",
            "idShort": "ExpirationDate",
            "displayName": [
              {
                "language": "de",
                "text": "Ablaufdatum"
              },
              {
                "language": "en",
                "text": "Expiration date"
              }
            ],
            "description": [
              {
                "language": "en",
                "text": "Time at which something should no longer be used effectively because it may lose its validity, quality or safety"
              }
            ],
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "https://admin-shell.io/idta/CarbonFootprint/ExpirationnDate/1/0"
                }
              ]
            },
            "qualifiers": [
              {
                "type": "Cardinality",
                "valueType": "xs:string",
                "value": "ZeroToOne"
              }
            ],
            "embeddedDataSpecifications": [],
            "valueType": "xs:string",
            "value": "",
            "modelType": "Property"
          }
        ],
        "modelType": "SubmodelElementCollection"
      },
      {
        "idShort": "TransportCarbonFootprint",
        "displayName": [
          {
            "language": "de",
            "text": "Transport C02-Fu\u00DFabdruck"
          },
          {
            "language": "en",
            "text": "Transport carbon footprint"
          }
        ],
        "description": [
          {
            "language": "en",
            "text": "Balance of greenhouse gas emissions generated by a transport service of a product"
          }
        ],
        "semanticId": {
          "type": "ExternalReference",
          "keys": [
            {
              "type": "GlobalReference",
              "value": "https://admin-shell.io/idta/CarbonFootprint/TransportCarbonFootprint/0/9"
            }
          ]
        },
        "qualifiers": [
          {
            "type": "Cardinality",
            "valueType": "xs:string",
            "value": "ZeroToMany"
          }
        ],
        "embeddedDataSpecifications": [],
        "value": [
          {
            "category": "PARAMETER",
            "idShort": "TCFCalculationMethod",
            "displayName": [
              {
                "language": "de",
                "text": "TCF Berechnungsmethode"
              },
              {
                "language": "en",
                "text": "TCF calculation method"
              }
            ],
            "description": [
              {
                "language": "en",
                "text": "Standard, method for determining the greenhouse gas emissions for the transport of a product"
              }
            ],
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "0173-1#02-ABG859#001"
                }
              ]
            },
            "qualifiers": [
              {
                "type": "Cardinality",
                "valueType": "xs:string",
                "value": "One"
              }
            ],
            "embeddedDataSpecifications": [],
            "valueType": "xs:string",
            "value": "ISO-440",
            "modelType": "Property"
          },
          {
            "category": "PARAMETER",
            "idShort": "TCFCO2eq",
            "displayName": [
              {
                "language": "de",
                "text": "TCF CO2eq"
              },
              {
                "language": "en",
                "text": "TCF CO2eq"
              }
            ],
            "description": [
              {
                "language": "en",
                "text": "Sum of all greenhouse gas emissions from vehicle operation"
              }
            ],
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "0173-1#02-ABG860#001"
                }
              ]
            },
            "qualifiers": [
              {
                "type": "Cardinality",
                "valueType": "xs:string",
                "value": "One"
              }
            ],
            "embeddedDataSpecifications": [],
            "valueType": "xs:double",
            "value": "400",
            "modelType": "Property"
          },
          {
            "category": "PARAMETER",
            "idShort": "TCFReferenceValueForCalculation",
            "displayName": [
              {
                "language": "de",
                "text": "TCF Bezugsgr\u00F6\u00DFe f\u00FCr die Berechnung"
              },
              {
                "language": "en",
                "text": "TCF reference value for calculation"
              }
            ],
            "description": [
              {
                "language": "en",
                "text": "Amount of product to which the TCF carbon footprint statement relates"
              }
            ],
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "0173-1#02-ABG861#001"
                }
              ]
            },
            "qualifiers": [
              {
                "type": "Cardinality",
                "valueType": "xs:string",
                "value": "One"
              }
            ],
            "embeddedDataSpecifications": [],
            "valueType": "xs:string",
            "value": "1",
            "modelType": "Property"
          },
          {
            "category": "PARAMETER",
            "idShort": "TCFQuantityOfMeasureForCalculation",
            "displayName": [
              {
                "language": "de",
                "text": "TCF Mengenangabe f\u00FCr die Berechnung"
              },
              {
                "language": "en",
                "text": "TCF quantity of measure for calculation"
              }
            ],
            "description": [
              {
                "language": "en",
                "text": "Quantity of the product to which the TCF information on the CO2 footprint refers"
              }
            ],
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "0173-1#02-ABG862#001"
                }
              ]
            },
            "qualifiers": [
              {
                "type": "Cardinality",
                "valueType": "xs:string",
                "value": "One"
              }
            ],
            "embeddedDataSpecifications": [],
            "valueType": "xs:double",
            "value": "",
            "modelType": "Property"
          },
          {
            "category": "PARAMETER",
            "idShort": "TCFProcessesForGreenhouseGasEmissionInATransportService",
            "displayName": [
              {
                "language": "de",
                "text": "TCF Prozesse f\u00FCr die Treibhausgas-Emissionen bei einer Transportdienstleistung"
              },
              {
                "language": "en",
                "text": "TCF processes for greenhouse gas emissions in a transport service"
              }
            ],
            "description": [
              {
                "language": "en",
                "text": "Processes in a transport service to determine the sum of all direct or indirect greenhouse gas emissions from fuel supply and vehicle operation"
              }
            ],
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "0173-1#02-ABG863#001"
                }
              ]
            },
            "qualifiers": [
              {
                "type": "Cardinality",
                "valueType": "xs:string",
                "value": "OneToMany"
              }
            ],
            "embeddedDataSpecifications": [],
            "valueType": "xs:string",
            "value": "",
            "modelType": "Property"
          },
          {
            "category": "PARAMETER",
            "idShort": "ExplanatoryStatement",
            "displayName": [
              {
                "language": "de",
                "text": "Erkl\u00E4rung"
              },
              {
                "language": "en",
                "text": "Explanatory statement"
              }
            ],
            "description": [
              {
                "language": "en",
                "text": "Explanation which is needed or given so that a footprint communication can be properly understood by a purchaser, potential purchaser or user of the product"
              }
            ],
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "https://example.com/ids/cd/3291_7022_2032_0718"
                }
              ]
            },
            "qualifiers": [
              {
                "type": "Cardinality",
                "valueType": "xs:string",
                "value": "ZeroToOne"
              }
            ],
            "embeddedDataSpecifications": [],
            "value": "",
            "contentType": "application/pdf",
            "modelType": "File"
          },
          {
            "idShort": "TCFGoodsTransportAddressTakeover",
            "displayName": [
              {
                "language": "de",
                "text": "Waren\u00FCbernahmeadresse f\u00FCr die Distributionsstufe"
              },
              {
                "language": "en",
                "text": "Goods transport address take-over for distribution stage"
              }
            ],
            "description": [
              {
                "language": "en",
                "text": "Indication of the place of receipt of goods "
              }
            ],
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "0173-1#02-ABI499#001"
                }
              ]
            },
            "qualifiers": [
              {
                "type": "Cardinality",
                "valueType": "xs:string",
                "value": "One"
              }
            ],
            "embeddedDataSpecifications": [],
            "value": [
              {
                "category": "PARAMETER",
                "idShort": "Street",
                "displayName": [
                  {
                    "language": "de",
                    "text": "Stra\u00DFe"
                  },
                  {
                    "language": "en",
                    "text": "street"
                  }
                ],
                "description": [
                  {
                    "language": "en",
                    "text": "Street indication of the place of transfer of goods"
                  }
                ],
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "0173-1#02-ABH956#001"
                    }
                  ]
                },
                "qualifiers": [
                  {
                    "type": "Cardinality",
                    "valueType": "xs:string",
                    "value": "ZeroToOne"
                  }
                ],
                "embeddedDataSpecifications": [],
                "valueType": "xs:string",
                "value": "",
                "modelType": "Property"
              },
              {
                "category": "PARAMETER",
                "idShort": "HouseNumber",
                "displayName": [
                  {
                    "language": "de",
                    "text": "Hausnummer"
                  },
                  {
                    "language": "en",
                    "text": "house number"
                  }
                ],
                "description": [
                  {
                    "language": "en",
                    "text": "Number for identification or differentiation of individual houses of a street"
                  }
                ],
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "0173-1#02-ABH957#001"
                    }
                  ]
                },
                "qualifiers": [
                  {
                    "type": "Cardinality",
                    "valueType": "xs:string",
                    "value": "ZeroToOne"
                  }
                ],
                "embeddedDataSpecifications": [],
                "valueType": "xs:string",
                "value": "",
                "modelType": "Property"
              },
              {
                "category": "PARAMETER",
                "idShort": "ZipCode",
                "displayName": [
                  {
                    "language": "de",
                    "text": "Postleitzahl"
                  },
                  {
                    "language": "en",
                    "text": "zip code"
                  }
                ],
                "description": [
                  {
                    "language": "en",
                    "text": "Zip code of the goods transfer address"
                  }
                ],
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "0173-1#02-ABH958#001"
                    }
                  ]
                },
                "qualifiers": [
                  {
                    "type": "Cardinality",
                    "valueType": "xs:string",
                    "value": "ZeroToOne"
                  }
                ],
                "embeddedDataSpecifications": [],
                "valueType": "xs:string",
                "value": "",
                "modelType": "Property"
              },
              {
                "category": "PARAMETER",
                "idShort": "CityTown",
                "displayName": [
                  {
                    "language": "de",
                    "text": "Ort"
                  },
                  {
                    "language": "en",
                    "text": "city, town"
                  }
                ],
                "description": [
                  {
                    "language": "en",
                    "text": "Indication of the city or town of the transfer of goods"
                  }
                ],
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "0173-1#02-ABH959#001"
                    }
                  ]
                },
                "qualifiers": [
                  {
                    "type": "Cardinality",
                    "valueType": "xs:string",
                    "value": "ZeroToOne"
                  }
                ],
                "embeddedDataSpecifications": [],
                "valueType": "xs:string",
                "value": "",
                "modelType": "Property"
              },
              {
                "category": "PARAMETER",
                "idShort": "Country",
                "displayName": [
                  {
                    "language": "de",
                    "text": "Land"
                  },
                  {
                    "language": "en",
                    "text": "Country"
                  }
                ],
                "description": [
                  {
                    "language": "en",
                    "text": "Country where the product is transmitted"
                  }
                ],
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "0173-1#02-AAO259#005"
                    }
                  ]
                },
                "qualifiers": [
                  {
                    "type": "Cardinality",
                    "valueType": "xs:string",
                    "value": "ZeroToOne"
                  }
                ],
                "embeddedDataSpecifications": [],
                "valueType": "xs:string",
                "value": "",
                "modelType": "Property"
              }
            ],
            "modelType": "SubmodelElementCollection"
          },
          {
            "idShort": "TCFGoodsTransportAddressHandover",
            "displayName": [
              {
                "language": "de",
                "text": "Waren\u00FCbergabeadresse f\u00FCr die Distributionsstufe"
              },
              {
                "language": "en",
                "text": "Goods transport address hand-over for distribution stage"
              }
            ],
            "description": [
              {
                "language": "en",
                "text": "Indicates the hand-over address of the goods transport "
              }
            ],
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "0173-1#02-ABI498#001"
                }
              ]
            },
            "qualifiers": [
              {
                "type": "Cardinality",
                "valueType": "xs:string",
                "value": "One"
              }
            ],
            "embeddedDataSpecifications": [],
            "value": [
              {
                "category": "PARAMETER",
                "idShort": "Street",
                "description": [
                  {
                    "language": "en",
                    "text": "Street indication of the place of transfer of goods"
                  }
                ],
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "0173-1#02-ABH956#001"
                    }
                  ]
                },
                "qualifiers": [
                  {
                    "type": "Cardinality",
                    "valueType": "xs:string",
                    "value": "ZeroToOne"
                  }
                ],
                "embeddedDataSpecifications": [],
                "valueType": "xs:string",
                "value": "",
                "modelType": "Property"
              },
              {
                "category": "PARAMETER",
                "idShort": "HouseNumber",
                "description": [
                  {
                    "language": "en",
                    "text": "Number for identification or differentiation of individual houses of a street"
                  }
                ],
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "0173-1#02-ABH957#001"
                    }
                  ]
                },
                "qualifiers": [
                  {
                    "type": "Cardinality",
                    "valueType": "xs:string",
                    "value": "ZeroToOne"
                  }
                ],
                "embeddedDataSpecifications": [],
                "valueType": "xs:string",
                "value": "",
                "modelType": "Property"
              },
              {
                "category": "PARAMETER",
                "idShort": "ZipCode",
                "description": [
                  {
                    "language": "en",
                    "text": "Zip code of the goods transfer address"
                  }
                ],
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "0173-1#02-ABH958#001"
                    }
                  ]
                },
                "qualifiers": [
                  {
                    "type": "Cardinality",
                    "valueType": "xs:string",
                    "value": "ZeroToOne"
                  }
                ],
                "embeddedDataSpecifications": [],
                "valueType": "xs:string",
                "value": "",
                "modelType": "Property"
              },
              {
                "category": "PARAMETER",
                "idShort": "CityTown",
                "description": [
                  {
                    "language": "en",
                    "text": "Indication of the city or town of the transfer of goods"
                  }
                ],
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "0173-1#02-ABH959#001"
                    }
                  ]
                },
                "qualifiers": [
                  {
                    "type": "Cardinality",
                    "valueType": "xs:string",
                    "value": "ZeroToOne"
                  }
                ],
                "embeddedDataSpecifications": [],
                "valueType": "xs:string",
                "value": "",
                "modelType": "Property"
              },
              {
                "category": "PARAMETER",
                "idShort": "Country",
                "description": [
                  {
                    "language": "en",
                    "text": "Country where the product is transmitted"
                  }
                ],
                "semanticId": {
                  "type": "ExternalReference",
                  "keys": [
                    {
                      "type": "GlobalReference",
                      "value": "0173-1#02-AAO259#005"
                    }
                  ]
                },
                "qualifiers": [
                  {
                    "type": "Cardinality",
                    "valueType": "xs:string",
                    "value": "ZeroToOne"
                  }
                ],
                "embeddedDataSpecifications": [],
                "valueType": "xs:string",
                "value": "",
                "modelType": "Property"
              }
            ],
            "modelType": "SubmodelElementCollection"
          },
          {
            "category": "PARAMETER",
            "idShort": "PublicationDate",
            "displayName": [
              {
                "language": "de",
                "text": "Ver\u00F6ffentlichungsdatum"
              },
              {
                "language": "en",
                "text": "Publication date"
              }
            ],
            "description": [
              {
                "language": "en",
                "text": "Time at which something was first published or made available"
              }
            ],
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "https://admin-shell.io/idta/CarbonFootprint/PublicationDate/1/0"
                }
              ]
            },
            "qualifiers": [
              {
                "type": "Cardinality",
                "valueType": "xs:string",
                "value": "One"
              }
            ],
            "embeddedDataSpecifications": [],
            "valueType": "xs:string",
            "value": "",
            "modelType": "Property"
          },
          {
            "category": "PARAMETER",
            "idShort": "ExpirationDate",
            "displayName": [
              {
                "language": "de",
                "text": "Ablaufdatum"
              },
              {
                "language": "en",
                "text": "Expiration Date"
              }
            ],
            "description": [
              {
                "language": "en",
                "text": "Time at which something should no longer be used effectively because it may lose its validity, quality or safety"
              }
            ],
            "semanticId": {
              "type": "ExternalReference",
              "keys": [
                {
                  "type": "GlobalReference",
                  "value": "https://admin-shell.io/idta/CarbonFootprint/ExpirationnDate/1/0"
                }
              ]
            },
            "qualifiers": [
              {
                "type": "Cardinality",
                "valueType": "xs:string",
                "value": "ZeroToOne"
              }
            ],
            "embeddedDataSpecifications": [],
            "valueType": "xs:string",
            "value": "",
            "modelType": "Property"
          }
        ],
        "modelType": "SubmodelElementCollection"
      }
    ],
    "modelType": "Submodel"
  },
  {
    "idShort": "Certifications",
    "displayName": [
      {
        "language": "en",
        "text": "Certifications"
      },
      {
        "language": "de",
        "text": "Zertifikate"
      }
    ],
    "description": [
      {
        "language": "en",
        "text": " Verify compliance of cellular products in accordance with the standard IEEE 1725 \u2018Standard for Rechargeable Batteries for Cellular Telephones\u2019 or IEEE 1625 \u0022Standard for Rechargeable Batteries for Multi-cell Mobile Computing Devices\u201D and associated CTIA documents"
      }
    ],
    "id": "https://example.com/ids/sm/2385_2162_7042_4842",
    "submodelElements": [
      {
        "idShort": "CertificationName",
        "valueType": "xs:string",
        "value": "Cellular Telecommunications Industry Association (CTIA) Battery Certification",
        "modelType": "Property"
      },
      {
        "idShort": "IssuingBody",
        "valueType": "xs:string",
        "value": "UEV SUED ",
        "modelType": "Property"
      },
      {
        "idShort": "IssueDate",
        "valueType": "xs:string",
        "value": "2023-07-17",
        "modelType": "Property"
      },
      {
        "idShort": "ExpiryDate",
        "valueType": "xs:string",
        "value": "2035-07-17",
        "modelType": "Property"
      },
      {
        "idShort": "CertificationNumber",
        "valueType": "xs:int",
        "value": "31RSRG52NF35",
        "modelType": "Property"
      },
      {
        "idShort": "Scope",
        "valueType": "xs:string",
        "value": "compliance of cellular products ",
        "modelType": "Property"
      },
      {
        "idShort": "Status",
        "valueType": "xs:string",
        "value": "Valid",
        "modelType": "Property"
      }
    ],
    "modelType": "Submodel"
  },
  {
    "idShort": "TechnicalSpecification",
    "displayName": [
      {
        "language": "en",
        "text": "Technical Specifications"
      },
      {
        "language": "de",
        "text": "Technische Spezifikationen"
      }
    ],
    "id": "https://example.com/ids/sm/4184_0262_7042_1629",
    "submodelElements": [
      {
        "idShort": "ElectricalCharacteristics",
        "displayName": [
          {
            "language": "en",
            "text": "Electrical Characteristics"
          },
          {
            "language": "de",
            "text": "Elektrische Eigenschaften"
          }
        ],
        "value": [
          {
            "idShort": "NominalVoltage",
            "displayName": [
              {
                "language": "en",
                "text": "Nominal Voltage"
              },
              {
                "language": "de",
                "text": "Nennspannung"
              }
            ],
            "valueType": "xs:double",
            "value": "3.7",
            "modelType": "Property"
          },
          {
            "idShort": "MaximumVoltage",
            "displayName": [
              {
                "language": "en",
                "text": "Maximum Voltage"
              },
              {
                "language": "de",
                "text": "Maximale Spannung"
              }
            ],
            "valueType": "xs:double",
            "value": "4.2",
            "modelType": "Property"
          },
          {
            "idShort": "MinimumVoltage",
            "displayName": [
              {
                "language": "en",
                "text": "Minimum Voltage"
              },
              {
                "language": "de",
                "text": "MindestSpannung"
              }
            ],
            "valueType": "xs:double",
            "value": "3.0",
            "modelType": "Property"
          }
        ],
        "modelType": "SubmodelElementCollection"
      },
      {
        "category": "CONSTANT",
        "idShort": "Voltage",
        "displayName": [
          {
            "language": "en",
            "text": "Voltage"
          },
          {
            "language": "de",
            "text": "Spannung"
          }
        ],
        "valueType": "xs:double",
        "value": "3.7V",
        "modelType": "Property"
      },
      {
        "idShort": "PhysicalCharacteristics",
        "displayName": [
          {
            "language": "en",
            "text": "Physical Characteristics"
          },
          {
            "language": "de",
            "text": "Physikalische Eigenschaften"
          }
        ],
        "value": [
          {
            "idShort": "Weight",
            "displayName": [
              {
                "language": "en",
                "text": "Weight"
              },
              {
                "language": "de",
                "text": "Gewicht"
              }
            ],
            "valueType": "xs:double",
            "value": "45.0",
            "modelType": "Property"
          },
          {
            "idShort": "Dimensions",
            "displayName": [
              {
                "language": "en",
                "text": "Dimensions"
              },
              {
                "language": "de",
                "text": "Abmessungen"
              }
            ],
            "valueType": "xs:string",
            "value": "65 x 18 x 18",
            "modelType": "Property"
          }
        ],
        "modelType": "SubmodelElementCollection"
      },
      {
        "category": "CONSTANT",
        "idShort": "Capacity",
        "displayName": [
          {
            "language": "en",
            "text": "Capacity"
          },
          {
            "language": "de",
            "text": "Kapazit\u00E4t"
          }
        ],
        "valueType": "xs:long",
        "value": "3000",
        "modelType": "Property"
      },
      {
        "idShort": "CellType",
        "displayName": [
          {
            "language": "en",
            "text": "CellType"
          },
          {
            "language": "de",
            "text": "Zelltyp"
          }
        ],
        "valueType": "xs:string",
        "value": "Lithium-Ion",
        "modelType": "Property"
      }
    ],
    "modelType": "Submodel"
  },
  {
    "idShort": "Identification",
    "displayName": [
      {
        "language": "en",
        "text": "Identification"
      },
      {
        "language": "de",
        "text": "Identizierung"
      }
    ],
    "id": "https://example.com/ids/sm/7194_0262_7042_1951",
    "submodelElements": [
      {
        "category": "CONSTANT",
        "idShort": "ID",
        "displayName": [
          {
            "language": "en",
            "text": "ID"
          },
          {
            "language": "de",
            "text": "ID"
          }
        ],
        "valueType": "xs:string",
        "value": "12345-ABCDE",
        "modelType": "Property"
      },
      {
        "category": "CONSTANT",
        "idShort": "ProductionDate",
        "displayName": [
          {
            "language": "en",
            "text": "Production Date"
          },
          {
            "language": "de",
            "text": "Produktionsdatum"
          }
        ],
        "valueType": "xs:string",
        "value": "06.07.2024",
        "modelType": "Property"
      },
      {
        "category": "CONSTANT",
        "idShort": "Manufacturer",
        "displayName": [
          {
            "language": "en",
            "text": "Manufacturer"
          },
          {
            "language": "de",
            "text": "Hersteller"
          }
        ],
        "valueType": "xs:string",
        "value": "BatteryCorp Inc.",
        "modelType": "Property"
      },
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
    ],
    "modelType": "Submodel"
  }
]
""".trimIndent()