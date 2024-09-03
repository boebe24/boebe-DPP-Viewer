package edu.kit.dppviewer.ui.feature.productpage.screen.rawdata

import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import edu.kit.dppviewer.ui.feature.productpage.ProductPageNavigationEvent
import edu.kit.dppviewer.ui.feature.productpage.ProductPageUiEvent
import edu.kit.dppviewer.ui.feature.productpage.ProductPageUiState
import edu.kit.dppviewer.ui.platform.util.isLandscape

/**
 * The success (loaded) screen of the [RawDataRootScreen].
 *
 * It displays the everythingSection of a filteredProduct and a top app bar with a back button.
 *
 * @param uiState The loaded state of the UI.
 * @param onEvent The event handler to handle UI events.
 * @param onNavigationEvent The event handler to handle navigation events.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RawDataSuccessScreen(
    uiState: ProductPageUiState.Success,
    onEvent: (ProductPageUiEvent) -> Unit,
    onNavigationEvent: (ProductPageNavigationEvent) -> Unit,
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val filteredProduct = uiState.filteredProduct
    filteredProduct.everythingSection.LoadTitle()
    val topBarTitle = filteredProduct.everythingSection.sectionTitle

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        topBarTitle,
                        Modifier.basicMarquee(),
                    )
                },
                scrollBehavior = scrollBehavior,
                navigationIcon = {
                    IconButton(onClick = { onNavigationEvent(ProductPageNavigationEvent.NavigateUp) }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
            )
        }
    ) { innerPadding ->

        var modifier = Modifier
            .consumeWindowInsets(innerPadding) // make content display behind bottom navigation bar
            .padding(top = innerPadding.calculateTopPadding()) // only display content below top app bar

        // Don't overlap with punch hole camera
        if (isLandscape(LocalContext.current)) modifier = modifier.displayCutoutPadding()

        LazyColumn(
            modifier = modifier
        ) {
            items(filteredProduct.everythingSection.entries.size) {
                Box(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    filteredProduct.everythingSection.entries[it].Render(
                        onEvent = onEvent,
                        onNavigationEvent = onNavigationEvent,
                        innerPadding = innerPadding,
                    )
                }
            }
        }
    }
}