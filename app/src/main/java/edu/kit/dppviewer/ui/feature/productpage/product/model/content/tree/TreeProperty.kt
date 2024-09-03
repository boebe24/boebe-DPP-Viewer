package edu.kit.dppviewer.ui.feature.productpage.product.model.content.tree

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import edu.kit.dppviewer.data.model.product.util.FormatConstants.EMPTY_STRING
import edu.kit.dppviewer.ui.feature.productpage.ProductPageNavigationEvent
import edu.kit.dppviewer.ui.feature.productpage.ProductPageUiEvent
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.BaseProperty
import edu.kit.dppviewer.ui.platform.components.InformationPopupDialog

/**
 * Property inside the [TreeSection].
 *
 * It overrides the [Render] method to also display a description.
 *
 * Leaf part of the composite design pattern.
 */
class TreeProperty(
    displayName: String = EMPTY_STRING,
    value: String = EMPTY_STRING,
    private val description: String = EMPTY_STRING,
) : ITreeEntry, BaseProperty(
    displayName,
    value,
) {


    /**
     * Shows the display name, value and description of the property.
     */
    @Composable
    override fun Render(
        onEvent: (ProductPageUiEvent) -> Unit,
        onNavigationEvent: (ProductPageNavigationEvent) -> Unit,
        innerPadding: PaddingValues,
    ) {
        var showDialog by remember { mutableStateOf(false) }

        if (showDialog) {
            InformationPopupDialog(
                onDismiss = { showDialog = false },
                title = displayName,
                text = description,
            )
        }

        OutlinedCard {
            Row(
                modifier = Modifier
                    .padding(PaddingValues(horizontal = 16.dp, vertical = 8.dp))
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (description.isNotEmpty()) {
                    Row(modifier = Modifier.weight(0.5f)) {
                        SelectionContainer {
                            DisplayName(Modifier)
                        }
                    }
                    Row(modifier = Modifier.weight(0.4f)) {
                        SelectionContainer {
                            Value(Modifier)
                        }
                    }

                    InfoIcon(Modifier.weight(0.1f)) { showDialog = true }
                } else {
                    Row(modifier = Modifier.weight(0.5f)) {
                        SelectionContainer {
                            DisplayName(Modifier)
                        }
                    }
                    Row(modifier = Modifier.weight(0.5f)) {
                        SelectionContainer {
                            Value(Modifier)
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun DisplayName(modifier: Modifier) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .padding(end = 8.dp)
        )
    }

    @Composable
    fun Value(modifier: Modifier) {
        Text(
            text = value,
            modifier = modifier
                .padding(end = 8.dp)
        )
    }

    @Composable
    fun InfoIcon(modifier: Modifier, onClick: () -> Unit) {
        IconButton(
            onClick = onClick,
            modifier = modifier
        ) {
            Icon(
                imageVector = Icons.Outlined.Info,
                contentDescription = "Information",
            )
        }
    }

    override fun flatten() {
        // do nothing
    }
}