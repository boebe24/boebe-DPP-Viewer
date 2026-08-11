package edu.kit.dppviewer.ui.feature.importproductpage

import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.camera.core.Camera
import edu.kit.dppviewer.data.model.product.model.LocalDemoProduct

/**
 * Represents events that can occur in the Import Product Page.
 */
sealed interface ImportProductPageUiEvent {
    data class SetCameraPermission(val state: CameraPermissionState) : ImportProductPageUiEvent
    data object ShowBottomSheet : ImportProductPageUiEvent
    data object HideBottomSheet : ImportProductPageUiEvent
    data object ShowDialog : ImportProductPageUiEvent
    data object HideDialog : ImportProductPageUiEvent
    data object ToggleFlash : ImportProductPageUiEvent
    data object LoadProductFromUrl : ImportProductPageUiEvent
    data object ShowURLEntryDialog : ImportProductPageUiEvent
    data object HideURLEntryDialog : ImportProductPageUiEvent
    data object OnResumed : ImportProductPageUiEvent
    data object ResetUiState : ImportProductPageUiEvent
    data class SetUrl(val url: String) : ImportProductPageUiEvent
    data class LoadLocalProduct(val demoProduct: LocalDemoProduct) : ImportProductPageUiEvent
    data class SetCamera(val camera: Camera) : ImportProductPageUiEvent
    data class LaunchPhotoPicker(val singlePhotoPickerLauncher: ActivityResultLauncher<PickVisualMediaRequest>) :
        ImportProductPageUiEvent
}