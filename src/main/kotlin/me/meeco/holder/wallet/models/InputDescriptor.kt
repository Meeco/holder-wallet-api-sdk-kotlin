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

import me.meeco.holder.wallet.models.InputDescriptorConstraints

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param constraints 
 * @param id 
 * @param format http://identity.foundation/claim-format-registry/schemas/presentation-definition-claim-format-designations.json
 * @param group 
 * @param name 
 * @param purpose 
 */


data class InputDescriptor (

    @Json(name = "constraints")
    val constraints: InputDescriptorConstraints,

    @Json(name = "id")
    val id: kotlin.Any?,

    /* http://identity.foundation/claim-format-registry/schemas/presentation-definition-claim-format-designations.json */
    @Json(name = "format")
    val format: kotlin.collections.Map<kotlin.String, kotlin.Any>? = null,

    @Json(name = "group")
    val group: kotlin.Any? = null,

    @Json(name = "name")
    val name: kotlin.Any? = null,

    @Json(name = "purpose")
    val purpose: kotlin.Any? = null

) : kotlin.collections.HashMap<String, kotlin.Any>()

