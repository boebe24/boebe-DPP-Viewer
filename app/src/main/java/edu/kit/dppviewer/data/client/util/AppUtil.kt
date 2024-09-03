package edu.kit.dppviewer.data.client.util

import com.fasterxml.jackson.databind.JsonNode
import edu.kit.dppviewer.BuildConfig
import edu.kit.dppviewer.data.model.product.aas4android.submodelElement.OtherElement
import edu.kit.dppviewer.data.model.product.aas4android.submodelElement.SubmodelElement
import edu.kit.dppviewer.data.model.product.adapter.SubmodelElementTypeAdapter
import edu.kit.dppviewer.data.model.product.adapter.submodelElement.SubmodelElementAdapter
import edu.kit.dppviewer.data.model.product.model.ProductCreator
import edu.kit.dppviewer.data.model.product.util.JsonModelUtil
import edu.kit.dppviewer.data.model.product.util.JsonTextUtil
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection


private const val REQUEST_METHOD_GET = "GET"

/**
 * This class contains utility functions that interact with internet
 */
class AppUtil {

    fun hasConnectionError(url: String): Boolean {
        try {
            if (BuildConfig.INCLUDE_DEBUG_OPTIONS) {
                println("check response...")
            }

            // Attempt to fetch content from the URL
            val response = fetchTextFromUrlAsString(url)
            return false
        } catch (e: javax.net.ssl.SSLHandshakeException) {
            // If any exception occurs, print the stack trace and return false
            if (BuildConfig.INCLUDE_DEBUG_OPTIONS) {
                println("Connection check passed: ignore SSLHandshakeException")
                println(e.toString())
            }

            return false


        } catch (e: Exception) {

            // java.net.ConnectException: KA-WLAN
            // java.net.UnknownHostException: no wifi, SW-KA
            // If any exception occurs, print the stack trace and return false

            if (BuildConfig.INCLUDE_DEBUG_OPTIONS) {
                e.printStackTrace()
                println("Connection check failed, other issue: $e")
            }
            return true
        }
    }


    /**
     * fetch JsonNode from a URL
     * @param wantedURL the URL of the JsonNode
     * @return the JsonNode fetched from the URL
     */
    fun getJsonNodeFromURL(wantedURL: String): JsonNode {
        // fetch String
        val responseString: String = fetchTextFromUrlAsString(wantedURL)

        return JsonTextUtil().generateJsonNode(responseString)!!
    }

    private fun fetchTextFromUrlAsString(wantedURL: String): String {

        val url = URL(wantedURL)
        val connection = url.openConnection() as HttpsURLConnection
        connection.requestMethod = REQUEST_METHOD_GET

        // Mimic a browser's User-Agent
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.5481.77 Safari/537.36")

        val reader = BufferedReader(InputStreamReader(connection.inputStream))
        val response = reader.use { it.readText() }
        connection.disconnect()

        return response
    }

    /**
     * fetch all submodels nodes from a url of a asset administration shell
     * @param shellURL the URL of  a asset administration shell
     * @return a list of JsonNode of all submodels
     */
    fun getSubmodelNodesFromShellUrl(shellURL: String): List<JsonNode> {
        val submodelUrls = getSubmodelUrlsFromShellUrl(shellURL)
        val submodelNodes = mutableListOf<JsonNode>()
        for (submodelUrl in submodelUrls) {

            try {
                val submodelNode = getJsonNodeFromURL(submodelUrl)
                if (!JsonModelUtil().checkModelTypeSubmodel(submodelNode)) {
                    continue
                }

                submodelNodes.add(submodelNode)
            } catch (e: Exception) {
                // do nothing. ignore this submodel
            }

        }

        return submodelNodes

    }

    private fun getSubmodelUrlsFromShellUrl(shellURL: String): List<String> {
        val shellNode = getJsonNodeFromURL(shellURL)

        return JsonModelUtil().getSubmodelUrlsFromShell(shellNode, shellURL)

    }


    /**
     * convert a list of SubmodelElement to a list of SubmodelElementAdapter
     * @param submodelElements: a list of SubmodelElement
     * @return a list of SubmodelElementAdapter
     */
    fun getAllSubmodelElementAbs(submodelElements: List<SubmodelElement>): List<SubmodelElementAdapter> {
        val elementsAbsList = mutableListOf<SubmodelElementAdapter>()
        for (alterElement in submodelElements) {
            try {
                elementsAbsList.add(ProductCreator().createSubmodelElement(alterElement))
            } catch (e: Exception) {
                // do nothing. ignore this element
            }
        }
        return elementsAbsList
    }

    /**
     * generate the SubmodelElementType for a SubmodelElement
     * @param submodelElement the submodel element
     * @return type of the submodel element
     */
    fun getSubmodelElementTypeofSubmodelElement(submodelElement: SubmodelElement): SubmodelElementTypeAdapter {
        val modelTypeString = submodelElement.getModelType()
        return SubmodelElementTypeAdapter.fromString(modelTypeString)
    }

    /**
     * get the value of a submodel element of unknown type as string
     * @param submodelElementOther the submodel element, with type
     * @return the value of the submodel element as a string
     */
    fun getStringOfOtherSubmodelElement(submodelElementOther: OtherElement): String {
        return submodelElementOther.valueString
    }



}