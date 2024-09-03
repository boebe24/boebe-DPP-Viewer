package edu.kit.dppviewer.ui.feature.productpage.filter

import android.net.Uri
import edu.kit.dppviewer.data.model.product.aas4android.AasModelConstants.IMAGE_SUBMODEL_ID_PATH
import edu.kit.dppviewer.data.model.product.adapter.SubmodelAdapter
import edu.kit.dppviewer.data.model.product.adapter.submodelElement.leaf.FileAdapter
import edu.kit.dppviewer.data.model.product.model.Product
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.generalsection.GeneralSectionFilter
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.importantsection.ImportantSectionFilter
import edu.kit.dppviewer.ui.feature.productpage.filter.filterItem.treesection.TreeSectionFilter
import edu.kit.dppviewer.ui.feature.productpage.filter.task.SearchTaskForSubmodel
import edu.kit.dppviewer.ui.feature.productpage.filter.templateReader.TemplateReader
import edu.kit.dppviewer.ui.feature.productpage.product.model.FilteredProduct
import edu.kit.dppviewer.ui.feature.productpage.product.model.SectionManager
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.general.GeneralProperty
import java.time.LocalDate


/**
 * ProductFilter can filter a backend unfiltered product to a filtered product.
 */
class ProductFilter {
    /**
     * ---------------------
     * Product Images
     * ---------------------
     */

    private var givenImages = mutableListOf<Uri>()
    private var importantSectionFilter: ImportantSectionFilter? = null
    private var generalSectionFilter: GeneralSectionFilter? = null
    private var treeSectionFilter: TreeSectionFilter? = null
    private var filterData = TemplateReader()

    /**
     * Apply the filter to the given unfiltered product.
     * @param unfilteredProduct the unfiltered product
     * @return the filtered product
     */
    fun apply(unfilteredProduct: Product): FilteredProduct {

        val givenLastUpdatedDate = LocalDate.now()
        val lastUpdateProperty = GeneralProperty("Stand", LocalDate.now().toString())

        extractImagesUris(unfilteredProduct)

        val sectionManager = SectionManager()

        // generate general section
        generalSectionFilter = GeneralSectionFilter(filterData.getAllGeneralFilterNodes())
        val filteredGeneralSection = generalSectionFilter!!.apply(unfilteredProduct)
        sectionManager.addGeneralSection(filteredGeneralSection, lastUpdateProperty)

        // these variable is assigned during the generation of General Section
        val givenName = unfilteredProduct.name
        val givenType = unfilteredProduct.productType

        // create everything section
        val everythingSection = TreeSectionFilter().apply(unfilteredProduct).toEverythingSection()
        // add everything section
        //everythingSection.setAsEverythingSection()
        sectionManager.addEverythingSection(everythingSection)


        // create important section
        importantSectionFilter =
            ImportantSectionFilter(filterData.getAllImportantCardFilters(givenType))
        val filteredImportantSection = importantSectionFilter!!.apply(unfilteredProduct)

        sectionManager.addImportantSection(filteredImportantSection)


        val otherFilterItems = filterData.getAllOtherFilterNodes(givenType)
        if (otherFilterItems.isEmpty()) {
            sectionManager.addOtherSection(TreeSectionFilter().apply(unfilteredProduct).toOtherSection())
        } else {
            // create other section from a filter
            treeSectionFilter = TreeSectionFilter(otherFilterItems)
            val iOtherSection = treeSectionFilter!!.apply(unfilteredProduct).toOtherSection()
            sectionManager.addOtherSection(iOtherSection, IMAGE_SUBMODEL_ID_PATH)
        }

        return FilteredProduct(
            name = givenName,
            type = givenType,
            images = givenImages,
            lastUpdatedDate = givenLastUpdatedDate,
            sections = sectionManager.getNormalSectionsAsList(),
            everythingSection = sectionManager.everthingSection
        )
    }

    private fun extractImagesUris(unfilteredProduct: Product) {
        // generate images
        // read pictures in images submodel
        val imagesTask = SearchTaskForSubmodel(IMAGE_SUBMODEL_ID_PATH, unfilteredProduct)

        var imagesSubmodel: SubmodelAdapter? = null
        if (imagesTask.getResult() != null) {
            imagesSubmodel = imagesTask.getResult()!!
        }

        if (imagesSubmodel != null) {
            for (child in imagesSubmodel.elementsAbs) {
                if (child is FileAdapter) {

                    givenImages.add(Uri.parse(child.entryValueString))
                }
            }
        }
    }
}