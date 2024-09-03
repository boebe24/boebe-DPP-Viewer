package edu.kit.dppviewer.data.model.product.model

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import edu.kit.dppviewer.data.model.product.aas4android.AssetAdministrationShell


private val emptyJsonNode: JsonNode = ObjectMapper().createObjectNode()
private val null_shell =
    AssetAdministrationShell(
        emptyJsonNode,
        listOf()
    )

var NullProduct = Product(null_shell)



