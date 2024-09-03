package edu.kit.dppviewer.ui.feature.importproductpage.components.topbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FlashOff
import androidx.compose.material.icons.filled.FlashOn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import edu.kit.dppviewer.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImportTopBar(
    hasFlash: Boolean,
    isFlashOn: Boolean,
    onFlashClick: () -> Unit,
) {
    TopAppBar(
        title = { Text(LocalContext.current.getString(R.string.scan_qr_code_text)) },
        actions = {
            if (hasFlash) {
                IconButton(onClick = onFlashClick) {
                    Icon(
                        imageVector = if (isFlashOn) Icons.Default.FlashOn else Icons.Default.FlashOff,
                        contentDescription = if (isFlashOn) stringResource(R.string.turn_off_flash) else stringResource(
                            R.string.turn_on_flash
                        )
                    )
                }
            }
        }
    )
}