package edu.kit.dppviewer.data.repository.product.loader

import edu.kit.dppviewer.data.model.product.model.Product

/**
 * Interface defining a strategy for loading product data.
 *
 * Implementing classes are expected to provide a way to load a [Product].
 */
interface LoaderStrategy {

    /**
     * Loads a product.
     *
     * @return The loaded [Product].
     */
    suspend fun loadProduct(): Product

}