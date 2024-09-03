package edu.kit.dppviewer.ui.feature.importproductpage

import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.Camera
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.kit.dppviewer.data.repository.product.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Viewmodel for the [ImportProductPageScreen].
 */
@HiltViewModel
class ImportProductPageViewmodel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private var camera: Camera? = null

    private var _uiState = MutableStateFlow(ImportProductPageUiState())
    val uiState = _uiState.asStateFlow()

    /**
     * Loads the product that is currently specified in the URL.
     *
     * Sets ProductLoadingState.
     */
    private fun loadProductFromUrl() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(productLoadingState = ProductLoadingState.LOADING)
            productRepository.loadProductFromURL(uiState.value.url)
            _uiState.value = _uiState.value.copy(productLoadingState = ProductLoadingState.LOADED)
        }
    }

    /**
     * Sets the flash state of the camera.
     */
    private fun setIsFlashOn(boolean: Boolean) {

        _uiState.value = _uiState.value.copy(isFlashOn = boolean)

        val camera = camera
        camera?.let {
            camera.cameraControl.enableTorch(boolean)
        }
    }

    /**
     * Handles all events of the [ImportProductPageScreen].
     */
    fun onEvent(event: ImportProductPageUiEvent) {
        when (event) {
            is ImportProductPageUiEvent.ResetUiState -> {
                // reset ui state of import product page, so it´s on default when navigating back to it
                _uiState.value = ImportProductPageUiState()
            }

            is ImportProductPageUiEvent.ShowBottomSheet -> {
                _uiState.value = _uiState.value.copy(showSheet = true)
            }

            is ImportProductPageUiEvent.HideBottomSheet -> {
                _uiState.value = _uiState.value.copy(showSheet = false)
            }

            is ImportProductPageUiEvent.ShowDialog -> {
                _uiState.value = _uiState.value.copy(showDialog = true)
            }

            is ImportProductPageUiEvent.HideDialog -> {
                _uiState.value = _uiState.value.copy(showDialog = false)
            }

            is ImportProductPageUiEvent.SetUrl -> {
                _uiState.value = _uiState.value.copy(url = event.url)
            }

            is ImportProductPageUiEvent.ShowQRScanner -> {
                _uiState.value = _uiState.value.copy(showQRScanner = true)
            }

            is ImportProductPageUiEvent.ToggleFlash -> {
                setIsFlashOn(!_uiState.value.isFlashOn)
            }

            is ImportProductPageUiEvent.SetCamera -> {
                camera = event.camera
            }

            is ImportProductPageUiEvent.LoadProductFromUrl -> {
                loadProductFromUrl()
            }

            is ImportProductPageUiEvent.LaunchPhotoPicker -> {
                event.singlePhotoPickerLauncher.launch(
                    PickVisualMediaRequest(
                        ActivityResultContracts.PickVisualMedia.ImageOnly
                    )
                )
            }

            is ImportProductPageUiEvent.OnResumed -> {
                setIsFlashOn(false)
            }

            is ImportProductPageUiEvent.ShowURLEntryDialog -> {
                _uiState.value = _uiState.value.copy(showEnterURLDialog = true)
            }

            is ImportProductPageUiEvent.HideURLEntryDialog -> {
                _uiState.value = _uiState.value.copy(showEnterURLDialog = false)
            }
        }
    }
}