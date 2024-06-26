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

import me.meeco.holder.wallet.models.CredentialDisplayObjectInnerLogo

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param name 
 * @param locale 
 * @param backgroundColor 
 * @param textColor 
 * @param logo 
 */


data class CredentialDisplayObjectInner (

    @Json(name = "name")
    val name: kotlin.String? = null,

    @Json(name = "locale")
    val locale: kotlin.String? = null,

    @Json(name = "background_color")
    val backgroundColor: kotlin.String? = null,

    @Json(name = "text_color")
    val textColor: kotlin.String? = null,

    @Json(name = "logo")
    val logo: CredentialDisplayObjectInnerLogo? = null

)

