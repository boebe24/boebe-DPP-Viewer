package edu.kit.dppviewer.data.model.product.aas4android

import com.fasterxml.jackson.databind.JsonNode
import edu.kit.dppviewer.data.model.product.util.JsonModelUtil


/**
 * AssetAdministrationShell is a class that represents the AssetAdministrationShell in the AAS model.
 * display name is the idShort of the AssetAdministrationShell,
 * it would be used as the temporary name of the unfiltered product
 * @param shellNode the JsonNode of the AssetAdministrationShell
 * @param submodelsNodes the list of JsonNode of the submodels
 */
class AssetAdministrationShell(shellNode: JsonNode, submodelsNodes: List<JsonNode>) :
    DataModel(shellNode) {

    /**
     * the display name of the AssetAdministrationShell
     */
    val displayName: String = JsonModelUtil().getDisplayNameOrIdShort(dataNode)

    /**
     * all submodels contained in the AssetAdministrationShell
     */
    val submodels: List<Submodel> =
        submodelsNodes.map { submodelNode ->
            Submodel(submodelNode)
        }


}