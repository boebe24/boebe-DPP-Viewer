package edu.kit.dppviewer.data.client.util

import java.util.Base64

/**
 * some utility functions that process url-strings
 * utility functions do not use internet connection
 */
class UrlUtil {


    /**
     * Extract the service endpoint from the url to assert administration shell
     * @param shellUrl the url to assert administration shell
     * @return the url to the service endpoint
     */
    fun getServiceEndpointFromShellUrl(shellUrl: String): String {
        // Assuming the service endpoint always ends with "/api/v3.0"
        val endIndex = shellUrl.lastIndexOf("/api/v3.0") + "/api/v3.0".length
        return shellUrl.substring(0, endIndex)
    }


    /**
     * Extract the shell id from the url to assert administration shell
     * @param shellUrl the url to assert administration shell
     * @return the shell id
     */
    fun getShellIdFromShellUrl(shellUrl: String): String {
        // Extract the Base64 encoded part of the URL
        val encodedShellId = shellUrl.substring(shellUrl.lastIndexOf("/") + 1)
        // Decode the Base64 encoded string
        val decodedBytes = Base64.getUrlDecoder().decode(encodedShellId)
        return String(decodedBytes)
    }


    /**
     * Read the information(ids of all submodels) in the url to assert administration shell,
     * extract the url to the service endpoint
     * Then generate a list of all urls to all submodels
     */
    fun getAllModelUrlsFromShellUrlAndModelIds(
        shellUrl: String,
        modelIds: List<String>
    ): List<String> {
        val endpointUrl = getServiceEndpointFromShellUrl(shellUrl)
        return modelIds.map { modelId ->
            getModelUrlFromShellUrlUndModelId(endpointUrl, modelId)
        }
    }

    /**
     * Generate a url to a submodel using the url to assert administration shell and the model id
     * @param shellUrl the url to assert administration shell
     * @param modelId the model id
     * @return url to the submodel
     */
    fun getModelUrlFromShellUrlUndModelId(shellUrl: String, modelId: String): String {
        val endpointUrl: String = getServiceEndpointFromShellUrl(shellUrl)
        return getModelUrlFromEndpointUrlAndModelId(endpointUrl, modelId)
    }

    private fun getModelUrlFromEndpointUrlAndModelId(endpointUrl: String, modelId: String): String {
        val encodedModelId = encodeToBase64(modelId)
        return "$endpointUrl/submodels/$encodedModelId"
    }


    private fun encodeToBase64(input: String): String {
        return Base64.getEncoder().encodeToString(input.toByteArray())
    }


}