package edu.kit.dppviewer.ui.feature.importproductpage

/**
 * Whether the app may use the camera for scanning QR codes.
 *
 * Only the QR scanner needs the camera. All other import options keep working in every state, so
 * this decides what is shown in place of the camera preview, not whether the page is usable.
 */
enum class CameraPermissionState {

    /** Not asked yet in this session. */
    UNKNOWN,

    /** The camera can be used. */
    GRANTED,

    /** Denied, but asking again still shows the system dialog. */
    DENIED,

    /**
     * Denied to the point where the system no longer shows its dialog. Only the app settings can
     * grant the permission now.
     */
    PERMANENTLY_DENIED,
}
