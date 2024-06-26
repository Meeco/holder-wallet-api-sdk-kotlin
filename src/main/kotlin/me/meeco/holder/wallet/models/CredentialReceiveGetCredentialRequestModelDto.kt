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

import me.meeco.holder.wallet.models.CredentialReceiveGetAccessTokenRequestModelDtoAuthorizationDetailsInnerCredentialDefinition

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param accessToken 
 * @param credentialDefinition 
 * @param did 
 * @param format 
 * @param kid 
 * @param state 
 * @param transactionId A string identifying a Deferred Issuance transaction. This claim is contained in the response if the Credential Issuer was unable to immediately issue the Credential
 */


data class CredentialReceiveGetCredentialRequestModelDto (

    @Json(name = "access_token")
    val accessToken: kotlin.String? = null,

    @Json(name = "credential_definition")
    val credentialDefinition: CredentialReceiveGetAccessTokenRequestModelDtoAuthorizationDetailsInnerCredentialDefinition? = null,

    @Json(name = "did")
    val did: kotlin.String? = null,

    @Json(name = "format")
    val format: CredentialReceiveGetCredentialRequestModelDto.Format? = null,

    @Json(name = "kid")
    val kid: kotlin.String? = null,

    @Json(name = "state")
    val state: kotlin.String? = null,

    /* A string identifying a Deferred Issuance transaction. This claim is contained in the response if the Credential Issuer was unable to immediately issue the Credential */
    @Json(name = "transaction_id")
    val transactionId: kotlin.String? = null

) {

    /**
     * 
     *
     * Values: vcPlusSdMinusJwt,jwtVcJson
     */
    @JsonClass(generateAdapter = false)
    enum class Format(val value: kotlin.String) {
        @Json(name = "vc+sd-jwt") vcPlusSdMinusJwt("vc+sd-jwt"),
        @Json(name = "jwt_vc_json") jwtVcJson("jwt_vc_json");
    }
}

