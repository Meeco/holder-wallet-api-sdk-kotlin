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


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param error Unique error identifier
 * @param extraInfo Object that may contain more information about the error
 * @param message User friendly error message
 */


data class InvalidClaimsToDiscloseError (

    /* Unique error identifier */
    @Json(name = "error")
    val error: InvalidClaimsToDiscloseError.Error? = null,

    /* Object that may contain more information about the error */
    @Json(name = "extra_info")
    val extraInfo: kotlin.Any? = null,

    /* User friendly error message */
    @Json(name = "message")
    val message: kotlin.String? = null

) {

    /**
     * Unique error identifier
     *
     * Values: invalidClaimsToDiscloseError
     */
    @JsonClass(generateAdapter = false)
    enum class Error(val value: kotlin.String) {
        @Json(name = "invalid_claims_to_disclose_error") invalidClaimsToDiscloseError("invalid_claims_to_disclose_error");
    }
}

