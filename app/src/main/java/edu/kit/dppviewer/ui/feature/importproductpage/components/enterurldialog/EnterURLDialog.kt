package edu.kit.dppviewer.ui.feature.importproductpage.components.enterurldialog

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import edu.kit.dppviewer.R

@Composable
fun EnterURLDialog(
    url: String,
    onTextChange: (String) -> Unit,
    onOpenAction: (String) -> Unit,
    onDismissAction: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = { onDismissAction() },
        text = {
            TextField(
                value = url,
                onValueChange = { onTextChange(it) },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(stringResource(R.string.enter_url_placeholder)) }
            )
        },
        confirmButton = {
            TextButton(
                onClick = { onOpenAction(url) }) {
                Text(stringResource(R.string.submit))
            }
        },
        dismissButton = {
            TextButton(onClick = { onDismissAction() }) {
                Text(stringResource(R.string.dismiss))
            }
        }
    )
}
