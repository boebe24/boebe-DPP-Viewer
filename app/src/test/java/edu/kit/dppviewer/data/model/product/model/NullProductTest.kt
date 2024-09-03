package edu.kit.dppviewer.data.model.product.model


import com.fasterxml.jackson.databind.JsonNode
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.EMPTY_ID_INFORMATION
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.EMPTY_VALUE_INFORMATION
import edu.kit.dppviewer.data.model.product.aas4android.AssetAdministrationShell
import edu.kit.dppviewer.data.model.product.model.Product
import edu.kit.dppviewer.data.model.product.util.SettingConstants.USER_LANGUAGE
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.io.File

class NullProductTest {




    @Before
    fun setUp() {
        USER_LANGUAGE = "de"
    }

    @Test
    fun `null product, id`(){
        assertEquals(EMPTY_ID_INFORMATION, NullProduct.idShort)
    }

    @Test
    fun `null product, displayname`(){
        assertEquals(EMPTY_ID_INFORMATION, NullProduct.name)
    }


}