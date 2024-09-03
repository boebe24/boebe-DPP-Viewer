package edu.kit.dppviewer.data.model.product.adapter.submodelElement

import edu.kit.dppviewer.data.model.product.aas4android.submodelElement.SubmodelElement
import edu.kit.dppviewer.data.model.product.adapter.DatamodelAdapter
import edu.kit.dppviewer.data.model.product.adapter.SubmodelElementTypeAdapter
import edu.kit.dppviewer.data.client.util.AppUtil


/**
 * This class models a SubmodelElement Adapter
 * It calls methods from models in aas4android
 *
 * It has name, idShort, description and a list of submodel elements adapter
 * It also support searching for a submodel element by path of idShorts
 **/
abstract class SubmodelElementAdapter(submodelElement: SubmodelElement) :
    DatamodelAdapter(submodelElement) {
    var isNested: Boolean = submodelElement.isNested
    private var elementType: SubmodelElementTypeAdapter =
        AppUtil().getSubmodelElementTypeofSubmodelElement(
            submodelElement
        )


    open val typeString: String
        get() = elementType.toString()


    abstract override fun getSubmodelElementByIdShort(
        idPath: List<String>,
        isNested: Boolean
    ): SubmodelElementAdapter?



}
