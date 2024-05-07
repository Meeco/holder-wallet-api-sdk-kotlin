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
 * @param request JWT respresentation of the request following RFC9101 (JAR)
 * @param submissionStatus 
 */


data class PresentationStateResponseDtoMeta (

    /* JWT respresentation of the request following RFC9101 (JAR) */
    @Json(name = "request")
    val request: kotlin.String? = null,

    @Json(name = "submission_status")
    val submissionStatus: PresentationStateResponseDtoMeta.SubmissionStatus? = null

) {

    /**
     * 
     *
     * Values: pending,failed,success
     */
    @JsonClass(generateAdapter = false)
    enum class SubmissionStatus(val value: kotlin.String) {
        @Json(name = "pending") pending("pending"),
        @Json(name = "failed") failed("failed"),
        @Json(name = "success") success("success");
    }
}
