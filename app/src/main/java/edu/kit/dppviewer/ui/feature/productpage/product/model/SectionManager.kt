package edu.kit.dppviewer.ui.feature.productpage.product.model


import edu.kit.dppviewer.ui.feature.productpage.product.model.content.BaseSection
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.SectionContent
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.general.GeneralProperty
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.general.GeneralSection
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.important.ImportantSection
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.tree.EverythingSection
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.tree.OtherSection

class SectionManager {
    private val normalSections = mutableListOf<BaseSection<out SectionContent>>()
    var everthingSection: EverythingSection = EverythingSection()


    fun addGeneralSection(section: GeneralSection, lastUpdateProperty: GeneralProperty) {
        if (!section.isEmpty()) {
            section.addChild(lastUpdateProperty)
            normalSections.add(section)
        }
    }

    fun addImportantSection(section: ImportantSection) {
        if (!section.isEmpty()) {
            normalSections.add(section)
        }
    }


    fun addOtherSection(section: OtherSection) {

        if (!section.isEmpty()) {
            // remove images
            normalSections.add(section)
        }
    }

    fun addOtherSection(section: OtherSection, excludeSubmodel: String) {

        if (!section.isEmpty()) {
            // remove images
            section.removeGroup(excludeSubmodel)
            normalSections.add(section)
        }
    }

    fun addEverythingSection(section: EverythingSection) {
        everthingSection = section
    }

    fun getNormalSectionsAsList(): List<BaseSection<out SectionContent>> {
        return normalSections
    }


}