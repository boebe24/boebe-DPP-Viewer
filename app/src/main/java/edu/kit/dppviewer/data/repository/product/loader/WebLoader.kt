package edu.kit.dppviewer.data.repository.product.loader

import edu.kit.dppviewer.data.model.product.model.Product
import edu.kit.dppviewer.data.model.product.model.ProductCreator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


/**
 * Implementation of [LoaderStrategy] for loading product data from the web.
 *
 * @property url The URL from which to fetch the product data.
 */
class WebLoader(
    private val url: String
) : LoaderStrategy {

    /**
     * Loads the product from the web.
     *
     * @return The loaded [Product] from the web.
     */
    override suspend fun loadProduct(): Product {
        val product: Product = withContext(Dispatchers.IO) {
            ProductCreator().createProduct(url)
        }
        return product
    }
}