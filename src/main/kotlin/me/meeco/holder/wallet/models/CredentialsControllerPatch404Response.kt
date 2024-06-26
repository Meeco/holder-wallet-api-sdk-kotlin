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

import me.meeco.holder.wallet.models.CredentialNotFoundError
import me.meeco.holder.wallet.models.DidKidAssociationNotFoundError
import me.meeco.holder.wallet.models.DidNotFoundError
import me.meeco.holder.wallet.models.KeyNotFoundError
import me.meeco.holder.wallet.models.WalletNotFoundError

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param error Unique error identifier
 * @param extraInfo Object that may contain more information about the error
 * @param message User friendly error message
 */


data class CredentialsControllerPatch404Response (

    /* Unique error identifier */
    @Json(name = "error")
    val error: CredentialsControllerPatch404Response.Error?,

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
     * Values: didNotFound
     */
    @JsonClass(generateAdapter = false)
    enum class Error(val value: kotlin.Any) {
        @Json(name = "did_not_found") didNotFound("did_not_found");
    }
}

