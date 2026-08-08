package edu.kit.dppviewer.data.client

import edu.kit.dppviewer.BuildConfig

/**
 * The AAS server the example products are loaded from.
 *
 * The base URL is not hardcoded: it comes from the `dpp.server.baseUrl` Gradle property
 * (see `app/build.gradle.kts`), so pointing the app at another server does not need a code change.
 * An empty value means that no server is configured.
 */
object DppServer {

    /**
     * Base URL of the AAS API without a trailing slash, e.g. `https://example.org:473/api/v3.0`,
     * or an empty string if no server is configured.
     */
    val baseUrl: String = BuildConfig.DPP_SERVER_BASE_URL.trimEnd('/')

    /**
     * Whether a server is configured. If not, the example products cannot be loaded.
     */
    val isConfigured: Boolean
        get() = baseUrl.isNotEmpty()

    /**
     * URL of the asset administration shell with the given base64 encoded id.
     * @param shellId the base64 encoded id of the shell
     * @return the URL of the shell
     */
    fun shellUrl(shellId: String): String = "$baseUrl/shells/$shellId"
}
