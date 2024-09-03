package edu.kit.dppviewer.ui.feature.productpage.product.model.content.tree

import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.NavigateNext
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import edu.kit.dppviewer.data.model.product.util.FormatConstants.EMPTY_STRING
import edu.kit.dppviewer.ui.feature.productpage.ProductPageNavigationEvent
import edu.kit.dppviewer.ui.feature.productpage.ProductPageUiEvent
import java.util.UUID

/**
 * Group inside the [TreeSection].
 *
 * Composite part of the composite design pattern.
 */
class TreeGroup(
    private var displayName: String = EMPTY_STRING,
    private var children: MutableList<ITreeEntry> = arrayListOf(),
    val uuid: UUID = UUID.randomUUID(),
    var idShort: String = EMPTY_STRING,
) : ITreeEntry {

    /**
     * Shows a clickable card with the name of the group and an arrow to the right.
     * Redirects the user to the [edu.kit.dppviewer.ui.feature.productpage.screen.othergroup] Screen when clicked.
     */
    @Composable
    override fun Render(
        onEvent: (ProductPageUiEvent) -> Unit,
        onNavigationEvent: (ProductPageNavigationEvent) -> Unit,
        innerPadding: PaddingValues,
    ) {
        Card(
            modifier = Modifier.fillMaxSize(),
            onClick = { enterGroupChildrenScreen(onNavigationEvent = onNavigationEvent) }) {
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = displayName,
                    modifier = Modifier
                        .padding(8.dp)
                        .weight(1f)
                        .basicMarquee(),
                )
                IconButton(onClick = {
                    enterGroupChildrenScreen(onNavigationEvent = onNavigationEvent)
                }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.NavigateNext,
                        contentDescription = "open group",
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }

    private fun enterGroupChildrenScreen(onNavigationEvent: (ProductPageNavigationEvent) -> Unit) {
        onNavigationEvent(ProductPageNavigationEvent.EnterChildrenScreen(parentGroupUUID = uuid))
    }


    /**
     * Adds a child to the group, if the child is not empty.
     * the to be added child will be flattened first
     */
    fun addChild(iOtherEntry: ITreeEntry) {

        iOtherEntry.flatten()

        if (!iOtherEntry.isEmpty()) {
            children.add(iOtherEntry)
        }

    }

    override fun flatten() {

        if (hasSingleChild()) {
            val child = getFirstChild()

            if (child is TreeGroup) {
                addChildNameAtBack(child.displayName)
                children = child.getChildren()
            }
        }

    }

    /**
     * Returns the children of the group.
     */
    fun getChildren(): MutableList<ITreeEntry> {
        return children
    }

    /**
     * Returns the display name of the group.
     */
    fun getDisplayName(): String {
        return displayName
    }

    /**
     * Adds the name of the child to the display name of the group.
     * This method is used during flattening, when the child is the only child of the group.
     */
    private fun addChildNameAtBack(childName: String) {
        displayName = "$displayName - $childName"
    }

    private fun hasSingleChild(): Boolean {

        return children.size == 1
    }


    private fun getFirstChild(): ITreeEntry {
        return children[0]
    }


    override fun isEmpty(): Boolean {
        return children.isEmpty()
    }
}