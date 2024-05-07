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
 * @param id 
 * @param claimsToDisclose List of claims to disclose when presenting the credential. When a claim is nested, use object notation.  Examples: `given_name`, `address.street` or `nationality.country[0]` 
 * @param kid Key to use for signing the presentation of the credential. If no key is specified, the key linked to the credential is used. If no key is linked to the credential, no signature is added to the presentation.
 */


data class PresentationRequestSetCredentialsRequestModelDtoCredentialsInnerCredential (

    @Json(name = "id")
    val id: kotlin.String,

    /* List of claims to disclose when presenting the credential. When a claim is nested, use object notation.  Examples: `given_name`, `address.street` or `nationality.country[0]`  */
    @Json(name = "claims_to_disclose")
    val claimsToDisclose: kotlin.collections.List<kotlin.String>? = null,

    /* Key to use for signing the presentation of the credential. If no key is specified, the key linked to the credential is used. If no key is linked to the credential, no signature is added to the presentation. */
    @Json(name = "kid")
    val kid: kotlin.String? = null

)

