package edu.kit.dppviewer.data.client

import java.net.URL
import javax.net.ssl.HttpsURLConnection

/** Kept short so an unreachable server costs seconds, not minutes. */
private const val PROBE_TIMEOUT_MILLIS = 2_000

/**
 * Tests that talk to the configured AAS server ([DppServer]) are pointless when no server is
 * reachable, and each of them would block until the connection times out. They ask this object
 * once per test JVM whether the server answers and skip themselves if it does not.
 */
object DemoServerAvailability {

    /** Whether the configured server answered the probe. Determined once, then reused. */
    val isReachable: Boolean by lazy { probe() }

    private fun probe(): Boolean {
        if (!DppServer.isConfigured) {
            return false
        }

        return try {
            val connection = URL(DppServer.baseUrl).openConnection() as HttpsURLConnection
            connection.requestMethod = "HEAD"
            connection.connectTimeout = PROBE_TIMEOUT_MILLIS
            connection.readTimeout = PROBE_TIMEOUT_MILLIS
            try {
                // Any answer proves the server is up, the status code itself does not matter.
                connection.responseCode
                true
            } finally {
                connection.disconnect()
            }
        } catch (e: Exception) {
            println("Demo server ${DppServer.baseUrl} is unreachable, skipping tests that need it: $e")
            false
        }
    }
}
