package edu.kit.dppviewer.ui.feature.productpage.screen.othergroup

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
import edu.kit.dppviewer.ui.feature.productpage.product.model.FilteredProduct
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.tree.ITreeEntry
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.tree.TreeGroup
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.tree.TreeSection
import edu.kit.dppviewer.ui.platform.util.isLandscape
import java.util.UUID

/**
 * The success (loaded) screen of the [OtherGroupRootScreen].
 *
 * It displays the children of one [TreeGroup] and a top app bar with a back button.
 *
 * @param uiState The loaded state of the UI.
 * @param groupUUID The UUID of the group to display.
 * @param onEvent The event handler to handle UI events.
 * @param onNavigationEvent The event handler to handle navigation events.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtherGroupSuccessScreen(
    uiState: ProductPageUiState.Success,
    groupUUID: String,
    onEvent: (ProductPageUiEvent) -> Unit,
    onNavigationEvent: (ProductPageNavigationEvent) -> Unit,
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val filteredProduct = uiState.filteredProduct
    val group: TreeGroup? = findGroup(filteredProduct, UUID.fromString(groupUUID))
    val topBarTitle = group?.getDisplayName() ?: "Group not found"

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = topBarTitle,
                        modifier = Modifier.basicMarquee(),
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
        },
    ) { innerPadding ->
        var modifier = Modifier
            .consumeWindowInsets(innerPadding) // make content display behind bottom navigation bar
            .padding(top = innerPadding.calculateTopPadding()) // only display content below top app bar

        // Don't overlap with punch hole camera
        if (isLandscape(LocalContext.current)) modifier = modifier.displayCutoutPadding()

        LazyColumn(
            modifier = modifier
        ) {
            if (group != null) {
                val children: List<ITreeEntry> = group.getChildren()

                items(children.size) {
                    Box(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        children[it].Render(
                            onEvent = onEvent,
                            onNavigationEvent = onNavigationEvent,
                            innerPadding = innerPadding,
                        )
                    }
                }
            }
        }
    }
}

/**
 * Search the filtered product for the group with the given UUID.
 */
private fun findGroup(filteredProduct: FilteredProduct, groupUUID: UUID): TreeGroup? {
    for (section in filteredProduct.sections) {
        if (section is TreeSection) {
            val foundGroup = section.findGroup(groupUUID)
            if (foundGroup != null) {
                return foundGroup
            }
        }
    }
    val foundGroupEverythingSection = filteredProduct.everythingSection.findGroup(groupUUID)
    if (foundGroupEverythingSection != null) {
        return foundGroupEverythingSection
    }
    return null
}