package edu.kit.dppviewer.data.model.product.util

import edu.kit.dppviewer.data.client.util.UrlUtil
import org.junit.Assert.assertEquals
import org.junit.Test

class UrlUtilTest {


    private var endPointUrl = "https://example.com/api/v3.0"
    private var testShellId = "bcbidhwoeh686uwycvcva>cdwcb@"
    private var testSubmodelId = "4001_9071_9cdcjlhiugu452542"
    private var testSubmodelUrl =
        "https://example.com/api/v3.0/submodels/NDAwMV85MDcxXzljZGNqbGhpdWd1NDUyNTQy"
    private var shellUrl =
        "https://example.com/api/v3.0/shells/YmNiaWRod29laDY4NnV3eWN2Y3ZhPmNkd2NiQA=="

    @Test
    fun testGetServiceEndpointFromShellUrl() {
        assertEquals(endPointUrl, UrlUtil().getServiceEndpointFromShellUrl(shellUrl))
    }

    @Test
    fun testGetShellIdFromShellUrl() {
        assertEquals(testShellId, UrlUtil().getShellIdFromShellUrl(shellUrl))

    }

    @Test
    fun testGetAllModelUrlsFromShellUrlAndModelIds() {
        var modelIds = listOf(testSubmodelId)
        var modelUrls = listOf(testSubmodelUrl)
        assertEquals(
            modelUrls,
            UrlUtil().getAllModelUrlsFromShellUrlAndModelIds(shellUrl, modelIds)
        )
    }

    @Test
    fun testGetModelUrlFromShellUrlUndModelId() {
        assertEquals(
            testSubmodelUrl,
            UrlUtil().getModelUrlFromShellUrlUndModelId(shellUrl, testSubmodelId)
        )
    }


}