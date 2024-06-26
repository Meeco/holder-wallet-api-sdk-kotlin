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
 * @param from 
 * @param rule 
 * @param count 
 * @param name 
 */


data class SubmissionRequirementOneOf (

    @Json(name = "from")
    val from: kotlin.Any?,

    @Json(name = "rule")
    val rule: SubmissionRequirementOneOf.Rule?,

    @Json(name = "count")
    val count: kotlin.Any? = null,

    @Json(name = "name")
    val name: kotlin.Any? = null

) : kotlin.collections.HashMap<String, kotlin.Any>() {

    /**
     * 
     *
     * Values: pick
     */
    @JsonClass(generateAdapter = false)
    enum class Rule(val value: kotlin.Any) {
        @Json(name = "pick") pick("pick");
    }
}

