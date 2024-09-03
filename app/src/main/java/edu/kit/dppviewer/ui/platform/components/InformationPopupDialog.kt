package edu.kit.dppviewer.ui.platform.components

import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import edu.kit.dppviewer.R

/**
 * Dialog for displaying information to the user.
 *
 * @param onDismiss Callback to be executed when the dialog is dismissed.
 * @param title Title of the dialog.
 * @param text Text content of the dialog.
 */
@Composable
fun InformationPopupDialog(
    onDismiss: () -> Unit,
    title: String,
    text: String,
) {
    val scrollState = rememberScrollState()

    AlertDialog(
        onDismissRequest = onDismiss,
        icon = {
            Icon(
                Icons.Outlined.Info, contentDescription = "Information Icon"
            )
        },
        title = {
            Text(
                text = title, maxLines = 1, modifier = Modifier.basicMarquee()
            )
        },
        text = {
            SelectionContainer {
                Text(
                    text = text,
                    modifier = Modifier
                        .heightIn(min = 100.dp, max = 200.dp)
                        .verticalScroll(scrollState),
                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = onDismiss
            ) {
                Text(LocalContext.current.getString(R.string.dismiss))
            }
        })
}