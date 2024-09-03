package edu.kit.dppviewer


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import edu.kit.dppviewer.data.model.product.util.SettingConstants.USER_LANGUAGE
import edu.kit.dppviewer.ui.RootScreen
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.GENERAL_SECTION_NODE_STRING
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.IMPORTANT_SECTION_NODE_STRING_BATTERY
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.IMPORTANT_SECTION_NODE_STRING_SMARTPHONE
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.IMPORTANT_SECTION_NODE_STRING_TEXTILE
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.OTHER_SECTION_NODE_STRING_BATTERY
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.OTHER_SECTION_NODE_STRING_SMARTPHONE
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.OTHER_SECTION_NODE_STRING_TEXTILE
import edu.kit.dppviewer.ui.platform.theme.DPPViewerTheme
import java.util.Locale


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("BuildConfigCheck", "INCLUDE_DEBUG_OPTIONS: ${BuildConfig.INCLUDE_DEBUG_OPTIONS}")



        setUpLanguage()
        setUpFilter()
        enableEdgeToEdge()
        setContent {
            DPPViewerTheme {
                RootScreen()
            }
        }
    }

    private fun setUpFilter(){
        //GENERAL_SECTION_NODE_STRING = assets.open("filter_template/general_section_filter.json")
        //    .bufferedReader().use { it.readText() }


        GENERAL_SECTION_NODE_STRING = getResourceStringFromRaw(R.raw.general_section_filter)
        IMPORTANT_SECTION_NODE_STRING_SMARTPHONE = getResourceStringFromRaw(R.raw.important_section_filter_smartphone)
        IMPORTANT_SECTION_NODE_STRING_BATTERY = getResourceStringFromRaw(R.raw.important_section_filter_battery)
        IMPORTANT_SECTION_NODE_STRING_TEXTILE = getResourceStringFromRaw(R.raw.important_section_filter_textile)

        OTHER_SECTION_NODE_STRING_TEXTILE = getResourceStringFromRaw(R.raw.other_section_filter_textile)
        OTHER_SECTION_NODE_STRING_BATTERY = getResourceStringFromRaw(R.raw.other_section_filter_battery)
        OTHER_SECTION_NODE_STRING_SMARTPHONE = getResourceStringFromRaw(R.raw.other_section_filter_smartphone)


    }

    private fun getResourceStringFromRaw(resourceId: Int): String {
        return resources.openRawResource(resourceId).bufferedReader().use { it.readText() }
    }

    private fun setUpLanguage(){
        val language = getUserPreferredLanguageWithoutCountry(this)

        USER_LANGUAGE = language

        if (BuildConfig.INCLUDE_DEBUG_OPTIONS) {
            println("Language: $USER_LANGUAGE")
        } else {
            // Hide debug options
        }


    }

    private fun getUserPreferredLanguageWithoutCountry(context: Context): String {
        val locale: Locale = context.resources.configuration.locales[0]
        return locale.language // Returns "en", "de", etc.
    }





}
