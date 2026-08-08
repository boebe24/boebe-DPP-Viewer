package edu.kit.dppviewer.ui

import edu.kit.dppviewer.data.client.DppServer

/**
 * Base64 encoded ids of the example shells. The server they live on is configured separately,
 * see [DppServer].
 */
//smart phone shell
const val SHELL_ID_EXAMPLE = "aHR0cHM6Ly9leGFtcGxlLmNvbS9pZHMvc20vODM3NV83MDMyXzQwNDJfMzAzMA=="

//battery shell
const val SHELL_ID_BATTERY = "aHR0cHM6Ly9leGFtcGxlLmNvbS9pZHMvc20vOTE0M184MDAyXzcwNDJfNTE4OA=="

const val SHELL_ID_SMARTPHONE = "aHR0cHM6Ly9leGFtcGxlLmNvbS9pZHMvc20vMjU5MV84MDAyXzcwNDJfNDU4MA=="

const val SHELL_ID_TEXTILE = "aHR0cHM6Ly9leGFtcGxlLmNvbS9pZHMvc20vNzI0NF84MDAyXzcwNDJfNzk2OA=="

const val SHELL_ID_PUZZLE = "aHR0cHM6Ly9leGFtcGxlLmNvbS9pZHMvc20vMDA0M18wMjUxXzgwNDJfOTgyMA=="

val EXAMPLE_QR_RESULT = DppServer.shellUrl(SHELL_ID_EXAMPLE)

val EXAMPLE_QR_RESULT_BATTERY = DppServer.shellUrl(SHELL_ID_BATTERY)

val MULTIPLE_PRODUCT_ENDPOINT = DppServer.baseUrl

val BATTERY_SHELL_URL = DppServer.shellUrl(SHELL_ID_BATTERY)

val SMARTPHONE_SHELL_URL = DppServer.shellUrl(SHELL_ID_SMARTPHONE)

val TEXTILE_SHELL_URL = DppServer.shellUrl(SHELL_ID_TEXTILE)

val PUZZLE_SHELL_URL = DppServer.shellUrl(SHELL_ID_PUZZLE)

var LOCAL_SHELL_STRING_TEST = ""
var LOCAL_SUBMODEL_ONE_STRING_TEST = ""
var LOCAL_SUBMODEL_TWO_STRING_TEST = ""
var LOCAL_OTHER_SECTION_FILTER_STRING = ""
