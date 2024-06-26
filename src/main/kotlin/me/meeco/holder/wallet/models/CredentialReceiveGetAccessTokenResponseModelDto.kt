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
 * @param authorizationUrl The URL to open in a browser in order to complete the authorization with the Authorization Server.
 * @param cNonce String containing a nonce to be used to create a proof of possession of key material when requesting a Credential
 * @param cNonceExpiresIn Number denoting the lifetime in seconds of the c_nonce.
 * @param credentialDefinition 
 * @param clientId Client identifier in OAuth 2.0
 * @param refreshToken 
 * @param state 
 */


data class CredentialReceiveGetAccessTokenResponseModelDto (

    @Json(name = "access_token")
    val accessToken: kotlin.String? = null,

    /* The URL to open in a browser in order to complete the authorization with the Authorization Server. */
    @Json(name = "authorization_url")
    val authorizationUrl: kotlin.String? = null,

    /* String containing a nonce to be used to create a proof of possession of key material when requesting a Credential */
    @Json(name = "c_nonce")
    val cNonce: kotlin.String? = null,

    /* Number denoting the lifetime in seconds of the c_nonce. */
    @Json(name = "c_nonce_expires_in")
    val cNonceExpiresIn: kotlin.Int? = null,

    @Json(name = "credential_definition")
    val credentialDefinition: CredentialReceiveGetAccessTokenRequestModelDtoAuthorizationDetailsInnerCredentialDefinition? = null,

    /* Client identifier in OAuth 2.0 */
    @Json(name = "client_id")
    val clientId: kotlin.String? = null,

    @Json(name = "refresh_token")
    val refreshToken: kotlin.String? = null,

    @Json(name = "state")
    val state: kotlin.String? = null

)

