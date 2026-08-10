package edu.kit.dppviewer.data.repository.product.loader

import android.content.Context
import edu.kit.dppviewer.data.model.product.aas4android.AssetAdministrationShell
import edu.kit.dppviewer.data.model.product.model.LocalDemoProduct
import edu.kit.dppviewer.data.model.product.model.Product
import edu.kit.dppviewer.data.model.product.util.JsonTextUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Implementation of [LoaderStrategy] for the example products bundled with the app.
 *
 * Unlike [WebLoader] this needs no server and no internet connection, the product data is read
 * from the assets. Only the product images are still loaded from the web.
 *
 * @property context the context used to open the assets
 * @property demoProduct the example product to load
 */
class AssetLoader(
    private val context: Context,
    private val demoProduct: LocalDemoProduct,
) : LoaderStrategy {

    /**
     * Loads the example product from the assets.
     *
     * @return the loaded [Product]
     */
    override suspend fun loadProduct(): Product = withContext(Dispatchers.IO) {
        val shellNode = JsonTextUtil().generateJsonNode(readAsset(demoProduct.shellAssetPath))
            ?: throw IllegalStateException("Asset ${demoProduct.shellAssetPath} is no valid JSON")
        val submodelNodes = JsonTextUtil().arrayNodeToList(
            JsonTextUtil().generateJsonNode(readAsset(demoProduct.submodelsAssetPath))
        )

        Product(AssetAdministrationShell(shellNode, submodelNodes))
    }

    private fun readAsset(path: String): String =
        context.assets.open(path).bufferedReader().use { it.readText() }
}
