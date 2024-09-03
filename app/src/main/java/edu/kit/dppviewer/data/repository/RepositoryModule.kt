package edu.kit.dppviewer.data.repository

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.kit.dppviewer.data.repository.product.ProductRepository
import edu.kit.dppviewer.data.repository.product.ProductRepositoryImpl
import javax.inject.Singleton

/**
 * Dagger Hilt module for providing dependencies related to data repositories.
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    /**
     * Provides a singleton instance of [ProductRepository].
     *
     * @param context The application context used for accessing system services.
     * @return An implementation of [ProductRepository] that is ready for dependency injection.
     */
    @Provides
    @Singleton
    fun provideProductRepository(
        @ApplicationContext context: Context
    ): ProductRepository = ProductRepositoryImpl(context)

}