package edu.kit.dppviewer.data.repository.product.loader

import com.google.common.truth.Truth.assertThat
import edu.kit.dppviewer.data.model.product.model.LocalDemoProduct
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

/**
 * Checks that the example products bundled in `assets/demo` can be loaded without a server.
 */
@RunWith(RobolectricTestRunner::class)
class AssetLoaderTest {

    @Test
    fun `every example product loads from the assets`() = runTest {
        for (demoProduct in LocalDemoProduct.entries) {
            val product = AssetLoader(RuntimeEnvironment.getApplication(), demoProduct).loadProduct()

            assertThat(product.name).isNotEmpty()
            assertThat(product.idShort).isNotEmpty()
            assertThat(product.submodelAdapters).isNotEmpty()
        }
    }
}
