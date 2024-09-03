package edu.kit.dppviewer.data.repository.product.loader

import edu.kit.dppviewer.data.model.product.model.Product


/**
 * Implementation of [LoaderStrategy] for loading product data from a database.
 *
 * @property productId The ID of the product to load from the database.
 */
class DatabaseLoader(
    private val productId: String
) : LoaderStrategy {

    /**
     * Loads the product from the database.
     *
     * @return The loaded [Product] from the database.
     */
    override suspend fun loadProduct(): Product {
        TODO("Not yet implemented")
    }

}