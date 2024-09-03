package edu.kit.dppviewer.data.repository.product

//import edu.kit.dppviewer.data.model.product.getExampleSmartphone
import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import edu.kit.dppviewer.data.model.product.model.NullProduct
import edu.kit.dppviewer.data.model.product.model.Product
import edu.kit.dppviewer.data.repository.product.loader.DatabaseLoader
import edu.kit.dppviewer.data.repository.product.loader.LoaderStrategy
import edu.kit.dppviewer.data.repository.product.loader.WebLoader
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * Repository module responsible for providing data related to products.
 *
 * @property context The application context used for accessing system services.
 */
class ProductRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : ProductRepository {

    private var _product: MutableStateFlow<Product> = MutableStateFlow(NullProduct)
    override var product: StateFlow<Product> = _product

    private var _productUrl: MutableStateFlow<String> = MutableStateFlow("")
    override var productUrl: StateFlow<String> = _productUrl

    private var loader: LoaderStrategy? = null


    /**
     * Reloads the [product] from the current loader.
     * Requires that [loader] is initialized.
     */
    override suspend fun refresh() {
        loader?.let {
            _product.value = it.loadProduct()
        }
    }


    /**
     * Loads a [Product] based on a specified URL.
     * Checks for internet connectivity using the application [context].
     * Decides based on internet connectivity if loading from web or from database.
     * Initiates a database update if necessary.
     *
     * Saves URL in [productUrl] for later use.
     *
     * @param url The URL of the product to load.
     */
    override suspend fun loadProductFromURL(url: String) {
        _productUrl.value = url
        if (hasInternet(context)) {
            loader = WebLoader(url)
            refresh()
            // updateDatabase()
        } else {
            val productId = urlToProductId(url)
            loader = DatabaseLoader(productId)
            refresh()
        }
    }

    /**
     * Loads a [Product] based on its ID.
     * Checks for internet connectivity using the application [context].
     * Decides based on internet connectivity if loading from web or from database.
     * Initiates a database update if necessary.
     *
     * @param productId The ID of the product to load.
     */
    override suspend fun loadProductFromId(productId: String) {
        if (hasInternet(context)) {
            val url = productIdToUrl(productId)
            loader = WebLoader(url)
            refresh()
            updateDatabase()
        } else {
            loader = DatabaseLoader(productId)
            refresh()
        }
    }

    /**
     * Adds a product to a specified collection.
     * Makes required database changes.
     *
     * @param collectionName The name of the collection to add the product to.
     */
    override fun addToCollection(collectionName: String) {
        TODO("Not yet implemented")
    }

    /**
     * Deletes a product from a specified collection.
     * Makes required database changes.
     *
     * @param collectionName The name of the collection to delete the product from.
     */
    override fun deleteFromCollection(collectionName: String) {
        TODO("Not yet implemented")
    }

    /**
     * Adds the manufacturer of the product to a blacklist.
     * Makes required data store changes.
     */
    override fun addCompanyToBlacklist() {
        TODO("Not yet implemented")
    }

    /**
     * Removes the manufacturer of the product from the blacklist.
     * Makes required data store changes.
     */
    override fun removeCompanyFromBlacklist() {
        TODO("Not yet implemented")
    }

    /**
     * Updates database with current information from the product.
     * Makes changes to all affected tables.
     */
    private fun updateDatabase() {
        TODO("Update database")
    }

    /**
     * Converts the url of a [Product] to productId via database joins.
     */
    private fun urlToProductId(url: String): String {
        TODO("Convert url to productId via database joins")
    }

    /**
     * Converts a productId to the url of a [Product] via database joins.
     */
    private fun productIdToUrl(url: String): String {
        TODO("Convert productId to url via database joins")
    }
}