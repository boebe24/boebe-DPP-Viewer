package edu.kit.dppviewer.ui.feature.productpage

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.kit.dppviewer.R
import edu.kit.dppviewer.data.repository.product.ProductRepository
import edu.kit.dppviewer.ui.feature.productpage.filter.ProductFilter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Viewmodel for ProductPage
 */
@HiltViewModel
class ProductPageViewmodel @Inject constructor(private val productRepository: ProductRepository) :
    ViewModel() {

    private var _uiState: MutableStateFlow<ProductPageUiState> =
        MutableStateFlow(ProductPageUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        loadUiState()
    }

    /**
     * handles ui events coming from the composable
     */
    fun onEvent(event: ProductPageUiEvent) {
        when (event) {
            is ProductPageUiEvent.RefreshFilteredProduct -> {
                refreshProduct(context = event.context)
            }
        }
    }


    /**
     * Load the ui state from the product repository.
     *
     * Applies the filter to the product.
     */
    private fun loadUiState() {
        val productFilter = ProductFilter()
        viewModelScope.launch {
            combine(
                productRepository.product,
                productRepository.productUrl,
            ) { unfilteredProduct, url ->
                ProductPageUiState.Success(
                    filteredProduct = productFilter.apply(unfilteredProduct),
                    url = url,
                )
            }.collect { uiState: ProductPageUiState ->
                _uiState.value = uiState
            }
        }
    }

    /**
     * Let the product repository load the product again and refresh the ui state.
     *
     * Shows a toast if an error occurs, for example if no internet connection is available.
     */
    private fun refreshProduct(context: Context) {

        /**
         * app crashed when trying to refresh without internet connection.
         * using existing connection check doesn't work,
         * would need `suspend`:
         *
         *  val isNotConnected = withContext(Dispatchers.IO) {
         *             AppUtil().hasConnectionError(url)
         *         }
         */

        viewModelScope.launch {
            _uiState.value = ProductPageUiState.Loading
            try {
                productRepository.refresh()
            } catch (e: Exception) {
                Toast.makeText(
                    context,
                    context.getString(R.string.error_occurred), Toast.LENGTH_SHORT
                ).show()
            }
            loadUiState()
        }
    }
}