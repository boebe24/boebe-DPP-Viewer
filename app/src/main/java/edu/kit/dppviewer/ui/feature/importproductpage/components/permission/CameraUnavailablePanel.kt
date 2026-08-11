package edu.kit.dppviewer.ui.feature.importproductpage.components.permission

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.NoPhotography
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import edu.kit.dppviewer.R
import edu.kit.dppviewer.ui.feature.importproductpage.CameraPermissionState

/**
 * Shown in place of the QR scanner while the camera cannot be used.
 *
 * This only replaces the scanner, never the whole page: the other import options do not need a
 * camera and stay available.
 *
 * @param permission the current state of the camera permission
 * @param onRequestPermission asks for the permission again, the system still shows its dialog
 */
@Composable
fun CameraUnavailablePanel(
    permission: CameraPermissionState,
    onRequestPermission: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Icon(
            imageVector = Icons.Outlined.NoPhotography,
            contentDescription = null,
        )
        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = stringResource(R.string.camera_permission_title),
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
        )
        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = stringResource(R.string.camera_permission_explanation),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
        )

        // Once the system stopped showing its dialog, only the app settings can still grant it.
        if (permission == CameraPermissionState.PERMANENTLY_DENIED) {
            Button(
                modifier = Modifier.padding(top = 24.dp),
                onClick = {
                    context.startActivity(
                        Intent(
                            Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                            "package:${context.packageName}".toUri(),
                        )
                    )
                },
            ) {
                Text(stringResource(R.string.open_app_settings))
            }
        } else {
            Button(
                modifier = Modifier.padding(top = 24.dp),
                onClick = onRequestPermission,
            ) {
                Text(stringResource(R.string.request_camera_permission))
            }
        }
    }
}
