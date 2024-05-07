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
 * @param database 
 * @param disk 
 * @param memory 
 */


data class HealthCheck (

    @Json(name = "database")
    val database: kotlin.Any,

    @Json(name = "disk")
    val disk: kotlin.Any,

    @Json(name = "memory")
    val memory: kotlin.Any

)
