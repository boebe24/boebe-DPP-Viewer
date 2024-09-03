package edu.kit.dppviewer.ui.platform.util

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.res.Configuration


/**
 * Checks if the device is currently in landscape mode.
 *
 * @param context The context of the calling component.
 * @return `true` if the device is in landscape mode, `false` otherwise.
 */
fun isLandscape(context: Context): Boolean {
    return context.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
}

/**
 * Copies the given text to the clipboard.
 *
 * @param context The context of the calling component.
 * @param label A label for the clipboard data.
 * @param text The text to be copied to the clipboard.
 */
fun copyToClipboard(context: Context, label: String, text: String) {
    val clipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText(label, text)
    clipboardManager.setPrimaryClip(clip)
}