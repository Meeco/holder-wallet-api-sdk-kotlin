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

import me.meeco.holder.wallet.models.CredentialOfferDto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param credentialOffer 
 * @param credentialOfferUri 
 * @param state 
 */


data class CredentialReceiveResponseModelDto (

    @Json(name = "credential_offer")
    val credentialOffer: CredentialOfferDto? = null,

    @Json(name = "credential_offer_uri")
    val credentialOfferUri: kotlin.String? = null,

    @Json(name = "state")
    val state: kotlin.String? = null

)

