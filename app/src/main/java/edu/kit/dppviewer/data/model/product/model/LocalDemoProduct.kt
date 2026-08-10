package edu.kit.dppviewer.data.model.product.model

import androidx.annotation.StringRes
import edu.kit.dppviewer.R

private const val DEMO_ASSET_ROOT = "demo"

/**
 * The example products that ship with the app.
 *
 * Their data is bundled as assets, so they can be opened without reaching a server. The bundled
 * data is a snapshot of the products of the DPP server, see `app/src/main/assets/demo`.
 *
 * @property assetDirectory the directory below `assets/demo` that holds the product data
 * @property labelResId the name shown in the import options
 */
enum class LocalDemoProduct(
    private val assetDirectory: String,
    @param:StringRes val labelResId: Int,
) {
    BATTERY("battery", R.string.demo_product_battery),
    SMARTPHONE("smartphone", R.string.demo_product_smartphone),
    TEXTILE("textile", R.string.demo_product_textile),
    PUZZLE("puzzle", R.string.demo_product_puzzle);

    /** Path of the asset holding the asset administration shell. */
    val shellAssetPath: String = "$DEMO_ASSET_ROOT/$assetDirectory/shell.json"

    /** Path of the asset holding the submodels of the shell. */
    val submodelsAssetPath: String = "$DEMO_ASSET_ROOT/$assetDirectory/submodels.json"
}
