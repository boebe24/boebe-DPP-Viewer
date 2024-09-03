package edu.kit.dppviewer.data.client.util

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ArrayNode
import com.google.common.truth.Truth.assertThat
import edu.kit.dppviewer.DPPViewerApplication
import edu.kit.dppviewer.data.model.product.util.JsonTextUtil
import edu.kit.dppviewer.ui.BATTERY_SHELL_URL
import edu.kit.dppviewer.ui.PUZZLE_SHELL_URL
import edu.kit.dppviewer.ui.SMARTPHONE_SHELL_URL
import edu.kit.dppviewer.ui.TEXTILE_SHELL_URL
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.io.File
import java.security.KeyStore
import java.security.cert.CertificateFactory
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext
import javax.net.ssl.X509TrustManager
import javax.net.ssl.TrustManagerFactory


val INVALID_SHELL_URL_HTTP_CONNECTION =
    "http://www.boebe2024tech.top:473/api/v3.0/shells/aHR0cHM6Ly9leGFtcGxlLmNvbS9pZHMvc20vODM3NV83MDMyXzQwNDJfMzAzMA=="
val INVALID_SHELL_URL_START_WITH_WWW =
    "www.boebe2024tech.top:473/api/v3.0/shells/aHR0cHM6Ly9leGFtcGxlLmNvbS9pZHMvc20vODM3NV83MDMyXzQwNDJfMzAzMA=="
val INVALID_SHELL_URL_NO_PORT =
    "https://www.boebe2024tech.top/api/v3.0/shells/aHR0cHM6Ly9leGFtcGxlLmNvbS9pZHMvc20vODM3NV83MDMyXzQwNDJfMzAzMA=="
val INVALID_SHELL_URL_WRONG_PORT =
    "https://www.boebe2024tech.top:575/api/v3.0/shells/aHR0cHM6Ly9leGFtcGxlLmNvbS9pZHMvc20vODM3NV83MDMyXzQwNDJfMzAzMA=="
val INVALID_SHELL_URL_WRONG_SHELL_ID =
    "https://www.boebe2024tech.top:473/api/v3.0/shells/aHR0cHM6Ly9MDMyXzQwNDJfMzAzMA=="

val BATTERY_SHELL_URL_WITH_INVALID_SUBMODEL = ""
val  SHELL_URL_LIST = listOf(
    BATTERY_SHELL_URL,
    SMARTPHONE_SHELL_URL,
    TEXTILE_SHELL_URL,
    PUZZLE_SHELL_URL
)

val  INVALID_SHELL_URL_LIST = listOf(
    INVALID_SHELL_URL_HTTP_CONNECTION,
    INVALID_SHELL_URL_START_WITH_WWW,
    INVALID_SHELL_URL_NO_PORT,
    INVALID_SHELL_URL_WRONG_SHELL_ID
)

val TEXTILE_SHELL_URL_WITH_INVALID_SUBMODEL_ID =
    "https://www.boebe2024tech.top:463/api/v3.0/shells/aHR0cHM6Ly9leGFtcGxlLmNvbS9pZHMvc20vNzI0NF84MDAyXzcwNDJfNzk2OA=="

@RunWith(RobolectricTestRunner::class)
@Config(manifest = "src/main/AndroidManifest.xml", application = DPPViewerApplication::class, resourceDir = "src/main/resources")
class AppUtilTest {







    @Before
    fun setUp() {

    }

    @Test
    fun `certificate error`() {
        assertThat(AppUtil().hasConnectionError(BATTERY_SHELL_URL)).isFalse()
    }

    @Test
    fun `connect to shell url,battery`() {
        setUpCerfiticate()
        assertThat(AppUtil().hasConnectionError(BATTERY_SHELL_URL)).isFalse()
    }

    @Test
    fun `connect to shell url,smartphone`() {
        setUpCerfiticate()
        assertThat(AppUtil().hasConnectionError(SMARTPHONE_SHELL_URL)).isFalse()
    }

    @Test
    fun `connect to shell url,textile`() {
        setUpCerfiticate()
        assertThat(AppUtil().hasConnectionError(TEXTILE_SHELL_URL)).isFalse()
    }

    @Test
    fun `connect to shell url,puzzle`() {
        setUpCerfiticate()
        assertThat(AppUtil().hasConnectionError(PUZZLE_SHELL_URL)).isFalse()
    }


    @Test
    fun `connect to shell url, url start with www directly`() {
        setUpCerfiticate()
        assertThat(AppUtil().hasConnectionError(INVALID_SHELL_URL_START_WITH_WWW)).isTrue()
    }

    @Test
    fun `connect to shell url, http`() {
        setUpCerfiticate()
        assertThat(AppUtil().hasConnectionError(INVALID_SHELL_URL_HTTP_CONNECTION)).isTrue()
    }

    @Test
    fun `connect to shell url, missing port`() {
        setUpCerfiticate()
        assertTrue(AppUtil().hasConnectionError(INVALID_SHELL_URL_NO_PORT))
        //assertNull(AppUtil().getJsonNodeFromURL(INVALID_SHELL_URL_NO_PORT))
    }

    @Test
    fun `connect to shell url, wrong port`() {
        setUpCerfiticate()
        assertThat(AppUtil().hasConnectionError(INVALID_SHELL_URL_WRONG_PORT)).isTrue()
    }

    @Test
    fun `connect to shell url, wrong shell id`() {
        setUpCerfiticate()
        assertTrue(AppUtil().hasConnectionError(INVALID_SHELL_URL_WRONG_SHELL_ID))
    }


    @Test
    fun getJsonNodeFromURL() {
        setUpCerfiticate()
        val battery_shell_node = AppUtil().getJsonNodeFromURL(BATTERY_SHELL_URL)
        println(battery_shell_node.asText())
        assertThat(battery_shell_node).isNotNull()

    }

    @Test
    fun `shell node from shell url,  textile at 473` () {
        setUpCerfiticate()
        val textile_shell_473_node   = AppUtil().getJsonNodeFromURL(TEXTILE_SHELL_URL)

        val local_textile_shell_473_node =
            getNodeFromResourcePath("/raw/test_Json_Model/textile_shell_473.json")

        assertEquals(textile_shell_473_node, local_textile_shell_473_node)
    }

    @Test
    fun `shell node from shell url,  smartphone at 473` () {
        setUpCerfiticate()
        val smartphone_shell_473_node   = AppUtil().getJsonNodeFromURL(
            SMARTPHONE_SHELL_URL)

        val local_smartphone_shell_473_node =
            getNodeFromResourcePath("/raw/test_Json_Model/smartphone_shell_473.json")

        assertEquals(smartphone_shell_473_node, local_smartphone_shell_473_node)
    }

    @Test
    fun `shell node from shell url,  battery at 473` () {
        setUpCerfiticate()
        val battery_shell_473_node   = AppUtil().getJsonNodeFromURL(BATTERY_SHELL_URL)

        val local_battery_shell_473_node =
            getNodeFromResourcePath("/raw/test_Json_Model/battery_shell_473.json")

        assertEquals(battery_shell_473_node, local_battery_shell_473_node)
    }

    @Test
    fun `submodel nodes from shell url,  textile at 473` () {
        setUpCerfiticate()
        val textile_submodel_473_node   = AppUtil().getSubmodelNodesFromShellUrl(TEXTILE_SHELL_URL)

        val local_textile_submodel_473_node = JsonTextUtil().arrayNodeToList(
            getNodeFromResourcePath("/raw/test_Json_Model/textile_submodels_473.json"))



        assertEquals(local_textile_submodel_473_node.size, textile_submodel_473_node.size)



        for (i in 0 until local_textile_submodel_473_node.size){
            val local_submodel = local_textile_submodel_473_node[i]
            val web_submodel = textile_submodel_473_node[i]
            assertEquals(local_submodel.get("idShort"), web_submodel.get("idShort"), "index: $i ${local_submodel.get("idShort")}  vs ${web_submodel.get("idShort")}")
            assertEquals(local_submodel.get("submodelElements"), web_submodel.get("submodelElements"))

        }

        //assertEquals(local_textile_submodel_473_node, textile_submodel_473_node)
        //assertThat(battery_473_shell_node).isNotEmpty()

        //val battery_submodel_nodes =
    }

    @Test
    fun `submodel nodes from shell url, textile at 463` () {
        setUpCerfiticate()
        val submodelNodes = AppUtil().getSubmodelNodesFromShellUrl(
            TEXTILE_SHELL_URL_WITH_INVALID_SUBMODEL_ID)
        assertThat(submodelNodes).isNotEmpty()
    }

    fun setUpCerfiticate() {
        println("setUp")
        val certInputStream = javaClass.classLoader?.getResourceAsStream("raw/boebe_bundle.pem")
        val certificateFactory = CertificateFactory.getInstance("X.509")
        val certificate = certificateFactory.generateCertificate(certInputStream)

        val keyStore = KeyStore.getInstance(KeyStore.getDefaultType())
        keyStore.load(null, null)
        keyStore.setCertificateEntry("boebe", certificate)

        val tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
        tmf.init(keyStore)

        val trustManagers = tmf.trustManagers
        if (trustManagers.isEmpty() || trustManagers[0] !is X509TrustManager) {
            throw IllegalStateException("No X509TrustManager implementation available")
        }

        val x509TrustManager = trustManagers[0] as X509TrustManager

        val sslContext = SSLContext.getInstance("TLS")
        sslContext.init(null, arrayOf(x509TrustManager), null)

        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.socketFactory)
    }

    fun getNodeFromResourcePath(path: String): JsonNode?{
        return JsonTextUtil().generateJsonNode(getResourceStringFromPath(path))
    }

    fun getResourceStringFromPath(path: String): String{

        val local_json_file = File(javaClass.getResource(path)?.path ?: throw IllegalArgumentException("File not found"))

        return (local_json_file.readText())
    }





}