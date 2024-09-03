package edu.kit.dppviewer.data.model.product.model

import edu.kit.dppviewer.data.client.util.AppUtil
import edu.kit.dppviewer.data.model.product.aas4android.AssetAdministrationShell
import edu.kit.dppviewer.data.model.product.aas4android.submodelElement.File
import edu.kit.dppviewer.data.model.product.aas4android.submodelElement.MultiLanguageProperty
import edu.kit.dppviewer.data.model.product.aas4android.submodelElement.OtherElement
import edu.kit.dppviewer.data.model.product.aas4android.submodelElement.Property
import edu.kit.dppviewer.data.model.product.aas4android.submodelElement.SubmodelElement
import edu.kit.dppviewer.data.model.product.aas4android.submodelElement.SubmodelElementCollection
import edu.kit.dppviewer.data.model.product.aas4android.submodelElement.SubmodelElementList
import edu.kit.dppviewer.data.model.product.adapter.submodelElement.SubmodelElementAdapter
import edu.kit.dppviewer.data.model.product.adapter.submodelElement.leaf.FileAdapter
import edu.kit.dppviewer.data.model.product.adapter.submodelElement.leaf.MultiLanguagePropertyAdapter
import edu.kit.dppviewer.data.model.product.adapter.submodelElement.leaf.OtherElementAdapter
import edu.kit.dppviewer.data.model.product.adapter.submodelElement.leaf.PropertyAdapter
import edu.kit.dppviewer.data.model.product.adapter.submodelElement.nested.SubmodelElementCollectionAdapter
import edu.kit.dppviewer.data.model.product.adapter.submodelElement.nested.SubmodelElementListAdapter


private const val UNKNOWN_ELEMENT_TYPE_INFORMATION = "Unknown submodel element type"

/**
 * This class is responsible for creating a product and creating submodels
 *
 */
class ProductCreator {


    /**
     * This function creates a product from a shell URL
     * It would save string from a URL to a JsonNode, generate a AssetAdministrationShell object from the JsonNode
     * then generate submodels from the AssetAdministrationShell object
     * @param shellURL the URL of the shell
     * @return the product created
     */
    fun createProduct(shellURL: String): Product {

        val shellNode = AppUtil().getJsonNodeFromURL(shellURL) // this is tested
        val submodelNodes = AppUtil().getSubmodelNodesFromShellUrl(shellURL)
        val assetAdministrationShell =
            AssetAdministrationShell(
                shellNode,
                submodelNodes
            )

        val product = Product(assetAdministrationShell)

        return product
    }

    /**
     * This function creates a submodel element of a specific type from a submodel element
     * @param submodelElement the submodel element
     * @return the submodel element adapter created
     */
    fun createSubmodelElement(submodelElement: SubmodelElement): SubmodelElementAdapter {
        when (submodelElement) {
            is Property -> {
                return PropertyAdapter(submodelElement)
            }

            is File -> {
                return FileAdapter(submodelElement)
            }

            is MultiLanguageProperty -> {
                return MultiLanguagePropertyAdapter(submodelElement)
            }

            is OtherElement -> {
                return OtherElementAdapter(submodelElement)
            }

            is SubmodelElementCollection -> {
                return SubmodelElementCollectionAdapter(submodelElement)
            }

            is SubmodelElementList -> {
                return SubmodelElementListAdapter(submodelElement)
            }

            else -> {
                throw Exception(UNKNOWN_ELEMENT_TYPE_INFORMATION)
            }
        }

    }
}