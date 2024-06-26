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

import me.meeco.holder.wallet.models.PresentationDefinition
import me.meeco.holder.wallet.models.PresentationRequestSetCredentialsResponseModelDtoCredentialsInner
import me.meeco.holder.wallet.models.PresentationRequestSetCredentialsResponseModelDtoMeta

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param credentials 
 * @param state 
 * @param meta 
 * @param presentationDefinition 
 */


data class PresentationRequestSetCredentialsResponseModelDto (

    @Json(name = "credentials")
    val credentials: kotlin.collections.List<PresentationRequestSetCredentialsResponseModelDtoCredentialsInner>,

    @Json(name = "state")
    val state: kotlin.String,

    @Json(name = "meta")
    val meta: PresentationRequestSetCredentialsResponseModelDtoMeta? = null,

    @Json(name = "presentation_definition")
    val presentationDefinition: PresentationDefinition? = null

)

