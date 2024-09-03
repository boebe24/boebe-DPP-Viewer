package edu.kit.dppviewer.data.repository.product

import edu.kit.dppviewer.data.model.product.model.Product
import kotlinx.coroutines.flow.StateFlow

/**
 * Interface for the repository module responsible for providing data related to products.
 */
interface ProductRepository {

    /**
     * A flow representing the current product state.
     */
    var product: StateFlow<Product>

    /**
     * The URL of the product.
     */
    val productUrl: StateFlow<String>

    /**
     * Reloads the product from the current loader
     */
    suspend fun refresh()

    /**
     * Loads a product from a specified URL.
     *
     * @param url The URL from which to load the product.
     */
    suspend fun loadProductFromURL(url: String)

    /**
     * Loads a product based on its ID.
     *
     * @param productId The ID of the product to load.
     */
    suspend fun loadProductFromId(productId: String)

    /**
     * Adds a product to a specified collection.
     *
     * @param collectionName The name of the collection to add the product to.
     */
    fun addToCollection(collectionName: String)

    /**
     * Deletes a product from a specified collection.
     *
     * @param collectionName The name of the collection to delete the product from.
     */
    fun deleteFromCollection(collectionName: String)

    /**
     * Adds the manufacturer of the product to a blacklist.
     */
    fun addCompanyToBlacklist()

    /**
     * Removes the manufacturer of the product from the blacklist.
     */
    fun removeCompanyFromBlacklist()
}
