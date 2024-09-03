package edu.kit.dppviewer.data.model.product.util

import edu.kit.dppviewer.data.model.product.util.FormatConstants.DELIMITER_DOT

private const val MINIMAL_SUBMODEL_ELEMENT_PATH_LENGTH = 2
private const val SUBMODEL_PATH_LENGTH = 1

/**
 * utility functions to help process path of idShorts
 */
class IdPathUtil {


    /**
     * check if the path leads to a submodel
     * @param idPath
     * @return true, if the path has correct length
     */
    fun isSubmodelPath(idPath: List<String>): Boolean {
        return idPath.size == SUBMODEL_PATH_LENGTH
    }


    /**
     * check if the path leads to a submodel element
     * @param idPath
     * @return true, if the path has correct length
     */
    fun isSubmodelElementPath(idPath: List<String>): Boolean {
        return idPath.size >= MINIMAL_SUBMODEL_ELEMENT_PATH_LENGTH
    }


    /**
     * check if there is only one last step on the path
     * @param idPath
     * @return true, if the path has correct length
     */
    fun isLastPath(idPath: List<String>): Boolean {
        return getPathLevel(idPath) == 1
    }

    /**
     * get the length of the path
     * @param idPath
     * @return the length of the path
     */
    private fun getPathLevel(idPath: List<String>): Int {
        return idPath.size
    }

    /**
     * break the idPath from string into a list of strings
     * @param idPath
     * @return a list of idShorts
     */
    fun breakIdPath(idPath: String): List<String> {
        return idPath.split(DELIMITER_DOT)
    }


    /**
     * get the idShort of the next node on the path
     * @param idPath
     * @return the idShort of the next node on the path
     */
    fun getThisId(idPath: List<String>): String {
        return idPath[0]
    }

    /**
     * get the idShorts of the other nodes on the path
     * @param idPath
     * @return the idShorts of the other nodes on the path
     */
    fun getRestIdPath(idPath: List<String>): List<String> {
        return idPath.subList(1, idPath.size)
    }


}