package edu.kit.dppviewer.ui.feature.importproductpage.components.enterurldialog

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import edu.kit.dppviewer.R

@Composable
fun EnterURLDialog(
    url: String,
    onTextChange: (String) -> Unit,
    onOpenAction: (String) -> Unit,
    onDismissAction: () -> Unit,
) {

    val context = LocalContext.current

    AlertDialog(
        onDismissRequest = { onDismissAction() },
        text = {
            TextField(
                value = url,
                onValueChange = { onTextChange(it) },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(context.getString(R.string.enter_url_placeholder)) }
            )
        },
        confirmButton = {
            TextButton(
                onClick = { onOpenAction(url) }) {
                Text(context.getString(R.string.submit))
            }
        },
        dismissButton = {
            TextButton(onClick = { onDismissAction() }) {
                Text(context.getString(R.string.dismiss))
            }
        }
    )
}
