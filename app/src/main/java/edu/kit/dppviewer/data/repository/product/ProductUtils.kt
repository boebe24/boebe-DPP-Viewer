package edu.kit.dppviewer.data.repository.product

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

/**
 * Checks if the device is currently connected to the internet.
 *
 * This function uses the `ConnectivityManager` system service to determine if the device
 * has an active internet connection via cellular, WiFi, or Ethernet.
 *
 * @return `true` if the device has an active internet connection, `false` otherwise.
 */
fun hasInternet(context: Context): Boolean {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val capabilities =
        connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
    return capabilities?.run {
        hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
    } ?: false
}