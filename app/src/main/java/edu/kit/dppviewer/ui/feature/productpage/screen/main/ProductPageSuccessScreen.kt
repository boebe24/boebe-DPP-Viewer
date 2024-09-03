package edu.kit.dppviewer.ui.feature.productpage.screen.main

import android.content.Context
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.FilterAltOff
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import edu.kit.dppviewer.R
import edu.kit.dppviewer.ui.feature.productpage.ProductPageNavigationEvent
import edu.kit.dppviewer.ui.feature.productpage.ProductPageUiEvent
import edu.kit.dppviewer.ui.feature.productpage.ProductPageUiState
import edu.kit.dppviewer.ui.platform.util.copyToClipboard

/**
 * The success (loaded) screen of the [ProductPageRootScreen].
 *
 * It includes the rendered filtered product and the top app bar with the back button and a refresh button.
 *
 * @param uiState The loaded state of the UI.
 * @param onEvent The event handler to handle UI events.
 * @param onNavigationEvent The event handler to handle navigation events.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductPageSuccessScreen(
    uiState: ProductPageUiState.Success,
    onEvent: (ProductPageUiEvent) -> Unit,
    onNavigationEvent: (ProductPageNavigationEvent) -> Unit,
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val context = LocalContext.current

    val url = uiState.url
    val filteredProduct = uiState.filteredProduct
    val topBarTitle = filteredProduct.name

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text(topBarTitle, Modifier.basicMarquee()) },
                scrollBehavior = scrollBehavior,
                navigationIcon = {
                    IconButton(onClick = { onNavigationEvent(ProductPageNavigationEvent.NavigateUp) }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    MoreOptionsButtonWithDropdownMenu(
                        url = url,
                        context = context,
                        onEvent = onEvent,
                        onNavigationEvent = onNavigationEvent,
                    )
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .consumeWindowInsets(innerPadding) // make content display behind bottom navigation bar
                .padding(top = innerPadding.calculateTopPadding()) // only display content below top app bar
                .padding(horizontal = 8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
        ) {
            filteredProduct.Render(
                onEvent = onEvent,
                onNavigationEvent = onNavigationEvent,
                innerPadding = innerPadding,
            )
        }
    }
}

/**
 * The dropdown menu and the more options button.
 */
@Composable
fun MoreOptionsButtonWithDropdownMenu(
    url: String,
    context: Context,
    onEvent: (ProductPageUiEvent) -> Unit,
    onNavigationEvent: (ProductPageNavigationEvent) -> Unit,
) {
    var showDropdownMenu by remember { mutableStateOf(false) }

    Box {
        IconButton(onClick = { showDropdownMenu = true }) {
            Icon(
                imageVector = Icons.Filled.MoreVert,
                contentDescription = stringResource(id = R.string.more_options)
            )
        }

        DropdownMenu(
            expanded = showDropdownMenu,
            onDismissRequest = { showDropdownMenu = false }
        ) {
            DropdownMenuItem(
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Refresh,
                        contentDescription = stringResource(id = R.string.refresh)
                    )
                },
                text = { Text(text = stringResource(id = R.string.refresh)) },
                onClick = {
                    showDropdownMenu = false
                    onEvent(
                        ProductPageUiEvent.RefreshFilteredProduct(context = context)
                    )
                }
            )
            DropdownMenuItem(
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.ContentCopy,
                        contentDescription = stringResource(id = R.string.copy_url)
                    )
                },
                text = { Text(text = stringResource(id = R.string.copy_url)) },
                onClick = {
                    showDropdownMenu = false
                    copyToClipboard(context = context, label = "url", text = url)
                }
            )
            DropdownMenuItem(
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.FilterAltOff,
                        contentDescription = stringResource(id = R.string.view_raw_information)
                    )
                },
                text = { Text(text = stringResource(id = R.string.view_raw_information)) },
                onClick = {
                    showDropdownMenu = false
                    onNavigationEvent(ProductPageNavigationEvent.EnterRawDataScreen)
                }
            )
        }
    }
}