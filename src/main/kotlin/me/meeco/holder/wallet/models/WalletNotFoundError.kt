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


data class WalletNotFoundError (

    /* Unique error identifier */
    @Json(name = "error")
    val error: WalletNotFoundError.Error,

    /* Object that may contain more information about the error */
    @Json(name = "extra_info")
    val extraInfo: kotlin.Any,

    /* User friendly error message */
    @Json(name = "message")
    val message: kotlin.String

) {

    /**
     * Unique error identifier
     *
     * Values: walletNotFound
     */
    @JsonClass(generateAdapter = false)
    enum class Error(val value: kotlin.String) {
        @Json(name = "wallet_not_found") walletNotFound("wallet_not_found");
    }
}
