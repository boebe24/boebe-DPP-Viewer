package edu.kit.dppviewer.ui.feature.productpage.product.model.content.tree

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import edu.kit.dppviewer.R
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.BaseSection
import java.util.UUID

/**
 * The "Other information" section of the product page.
 */
open class TreeSection(entries: List<ITreeEntry> = mutableListOf()) :
    BaseSection<ITreeEntry>(sectionTitle = "Other Information", entries = entries) {



    fun removeGroup(groupID: String) {

        val result = entries.toMutableList()

        for (entry in super.entries) {
            if (entry is TreeGroup) {
                // println("group id: ${entry.idShort}")
                if (entry.idShort == groupID) {
                    result.remove(entry)
                }
            }
        }

        entries = result.toList()
    }


    fun toOtherSection(): OtherSection {
        return OtherSection(entries)
    }

    fun toEverythingSection(): EverythingSection {
        return EverythingSection(entries)
    }



    /**
     * Find a [TreeGroup] by its UUID.
     * Searches recursively in all entries.
     */
    fun findGroup(groupUUID: UUID): TreeGroup? {
        for (entry in entries) {

            // --- duplicate code ---
            if (entry is TreeGroup) {
                if (entry.uuid == groupUUID) {
                    return entry
                } else {
                    val result = recursiveFindGroup(entry, groupUUID)
                    if (result != null) {
                        return result
                    }
                }
            }
            // --- duplicate code ---
        }
        return null
    }

    private fun recursiveFindGroup(parentGroup: TreeGroup, groupUUID: UUID): TreeGroup? {
        for (entry in parentGroup.getChildren()) {

            // --- duplicate code ---
            if (entry is TreeGroup) {
                if (entry.uuid == groupUUID) {
                    return entry
                } else {
                    val result = recursiveFindGroup(entry, groupUUID)
                    if (result != null) {
                        return result
                    }
                }
            }
            // --- duplicate code---

        }
        return null
    }

    @Composable
    override fun LoadTitle() {
        sectionTitle = "Other Information"
    }
}

