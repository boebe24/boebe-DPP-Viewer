package edu.kit.dppviewer.ui.feature.productpage.product.model

import edu.kit.dppviewer.R

/**
 * Supported Product Types.
 *
 * Each product type has a display name and a placeholder image.
 */
enum class ProductType(val displayName: String, val placeholderResID: Int) {
    BATTERY("Battery", R.drawable.placeholder_battery),
    SMARTPHONE("Smartphone", R.drawable.placeholder_smartphone),
    TEXTILE("Textile", R.drawable.placeholder_textile),
    OTHER("Other", R.drawable.placeholder_other);
}