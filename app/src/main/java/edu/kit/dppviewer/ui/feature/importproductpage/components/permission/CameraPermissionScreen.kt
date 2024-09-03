package edu.kit.dppviewer.ui.feature.importproductpage.components.permission

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.core.content.ContextCompat
import edu.kit.dppviewer.R
import edu.kit.dppviewer.ui.LocalSnackbarHostState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CameraPermissionScreen(onPermissionGranted: () -> Unit) {
    val topBarTitle = stringResource(R.string.allow_camera_access)

    val context = LocalContext.current
    var hasCameraPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        )
    }
    if (hasCameraPermission) {
        onPermissionGranted()
    }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        hasCameraPermission = isGranted

        if (isGranted) {
            onPermissionGranted()
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = topBarTitle)
                }
            )
        },
        snackbarHost = { SnackbarHost(LocalSnackbarHostState.current) },
    ) { innerPadding ->
        launcher.launch(Manifest.permission.CAMERA)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .consumeWindowInsets(innerPadding),
            contentAlignment = Alignment.Center,
        ) {
            Button(
                enabled = !hasCameraPermission,
                onClick = {
                    launcher.launch(Manifest.permission.CAMERA)
                },
            ) {
                Text(stringResource(R.string.request_camera_permission))
            }
        }
    }
}