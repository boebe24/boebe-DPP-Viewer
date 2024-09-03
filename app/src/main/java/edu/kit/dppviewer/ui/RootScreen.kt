package edu.kit.dppviewer.ui

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import edu.kit.dppviewer.ui.feature.importproductpage.ImportProductPageRoute
import edu.kit.dppviewer.ui.feature.importproductpage.ImportProductPageScreen
import edu.kit.dppviewer.ui.feature.productpage.ProductPageNavigationEvent
import edu.kit.dppviewer.ui.feature.productpage.ProductPageRoute
import edu.kit.dppviewer.ui.feature.productpage.ProductPageViewmodel
import edu.kit.dppviewer.ui.feature.productpage.screen.main.ProductPageRootScreen
import edu.kit.dppviewer.ui.feature.productpage.screen.main.ProductPageScreenRoute
import edu.kit.dppviewer.ui.feature.productpage.screen.othergroup.OtherGroupRootScreen
import edu.kit.dppviewer.ui.feature.productpage.screen.othergroup.OtherGroupScreenRoute
import edu.kit.dppviewer.ui.feature.productpage.screen.rawdata.RawDataRootScreen
import edu.kit.dppviewer.ui.feature.productpage.screen.rawdata.RawDataScreenRoute

/**
 * Makes snackbar host available to all composables by LocalSnackbarHostState.current
 */
val LocalSnackbarHostState = compositionLocalOf {
    SnackbarHostState()
}

/**
 * The root composable of the application.
 *
 * Sets up the navigation graph and the viewmodels.
 */
@Composable
fun RootScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ImportProductPageRoute) {
        composable<ImportProductPageRoute> {
            ImportProductPageScreen(
                onNavigateToProductPage = {
                    navController.navigate(route = ProductPageScreenRoute)
                },
            )
        }
        navigation<ProductPageRoute>(startDestination = ProductPageScreenRoute) {
            composable<ProductPageScreenRoute> {
                val productPageViewmodel = it.sharedViewModel<ProductPageViewmodel>(navController)
                val uiState by productPageViewmodel.uiState.collectAsStateWithLifecycle()

                ProductPageRootScreen(
                    uiState = uiState,
                    onEvent = productPageViewmodel::onEvent,
                    onNavigationEvent = { event ->
                        handleProductPageNavigationEvent(
                            navController = navController,
                            event = event,
                        )
                    },
                )
            }
            composable<RawDataScreenRoute> {
                val productPageViewmodel = it.sharedViewModel<ProductPageViewmodel>(navController)
                val uiState by productPageViewmodel.uiState.collectAsStateWithLifecycle()

                RawDataRootScreen(
                    uiState = uiState,
                    onEvent = productPageViewmodel::onEvent,
                    onNavigationEvent = { event ->
                        handleProductPageNavigationEvent(
                            navController = navController,
                            event = event,
                        )
                    },
                )
            }
            composable<OtherGroupScreenRoute> {
                val productPageViewmodel = it.sharedViewModel<ProductPageViewmodel>(navController)
                val uiState by productPageViewmodel.uiState.collectAsStateWithLifecycle()

                val args = it.toRoute<OtherGroupScreenRoute>()

                OtherGroupRootScreen(
                    uiState = uiState,
                    groupUUID = args.groupUUID,
                    onEvent = productPageViewmodel::onEvent,
                    onNavigationEvent = { event ->
                        handleProductPageNavigationEvent(
                            navController = navController,
                            event = event,
                        )
                    },
                )
            }
        }
    }
}

/**
 * Used for sharing viewmodels between destinations in a navgraph.
 * By sharing one viewmodel across screens, they can access the same data.
 */
@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(
    navController: NavHostController,
): T {
    val navGraphRoute = destination.parent?.route ?: return hiltViewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return hiltViewModel(parentEntry)
}

/**
 * Handles UI Events which lead to navigation to a different screen.
 *
 * NavigationEvents are not included in ProductPageUIEvent,
 * because navController would need to be passed down to every composable.
 *
 * Also possible to pass navController directly to the viewmodel and handle the events there.
 *
 * Composables should not call navController.navigate().
 */
fun handleProductPageNavigationEvent(
    navController: NavHostController,
    event: ProductPageNavigationEvent,
) {
    when (event) {
        is ProductPageNavigationEvent.NavigateUp -> {
            navController.navigateUp()
        }

        is ProductPageNavigationEvent.EnterRawDataScreen -> {
            navController.navigate(route = RawDataScreenRoute)
        }

        is ProductPageNavigationEvent.EnterChildrenScreen -> {
            navController.navigate(route = OtherGroupScreenRoute(event.parentGroupUUID.toString()))
        }
    }
}