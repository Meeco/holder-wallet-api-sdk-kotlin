/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package me.meeco.holder.wallet.models

import me.meeco.holder.wallet.models.InternalServerError

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param error Unique error identifier
 * @param extraInfo Object that may contain more information about the error
 * @param message User friendly error message
 */


data class ReceiveControllerGetInfo500Response (

    /* Unique error identifier */
    @Json(name = "error")
    val error: ReceiveControllerGetInfo500Response.Error?,

    /* Object that may contain more information about the error */
    @Json(name = "extra_info")
    val extraInfo: kotlin.Any,

    /* User friendly error message */
    @Json(name = "message")
    val message: kotlin.Any?

) {

    /**
     * Unique error identifier
     *
     * Values: internalServerError
     */
    @JsonClass(generateAdapter = false)
    enum class Error(val value: kotlin.Any) {
        @Json(name = "internal_server_error") internalServerError("internal_server_error");
    }
}

