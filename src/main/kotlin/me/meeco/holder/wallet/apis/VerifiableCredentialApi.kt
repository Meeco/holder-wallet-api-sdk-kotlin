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

package me.meeco.holder.wallet.apis

import java.io.IOException
import okhttp3.OkHttpClient
import okhttp3.HttpUrl

import me.meeco.holder.wallet.models.CredentialImportRequestModelDto
import me.meeco.holder.wallet.models.CredentialPatchRequestModelDto
import me.meeco.holder.wallet.models.CredentialResponseDto
import me.meeco.holder.wallet.models.CredentialVerificationResponseDto
import me.meeco.holder.wallet.models.CredentialsControllerFindOne404Response
import me.meeco.holder.wallet.models.CredentialsControllerFindOne500Response
import me.meeco.holder.wallet.models.CredentialsControllerImport400Response
import me.meeco.holder.wallet.models.CredentialsControllerPatch404Response
import me.meeco.holder.wallet.models.CredentialsControllerPatch500Response
import me.meeco.holder.wallet.models.CredentialsControllerRemove500Response
import me.meeco.holder.wallet.models.CredentialsControllerVerify500Response
import me.meeco.holder.wallet.models.CredentialsResponseDto
import me.meeco.holder.wallet.models.InvalidPathParamError
import me.meeco.holder.wallet.models.ReceiveControllerFindAll400Response
import me.meeco.holder.wallet.models.ReceiveControllerFindAll500Response
import me.meeco.holder.wallet.models.WalletNotFoundError

import com.squareup.moshi.Json

import me.meeco.holder.wallet.infrastructure.ApiClient
import me.meeco.holder.wallet.infrastructure.ApiResponse
import me.meeco.holder.wallet.infrastructure.ClientException
import me.meeco.holder.wallet.infrastructure.ClientError
import me.meeco.holder.wallet.infrastructure.ServerException
import me.meeco.holder.wallet.infrastructure.ServerError
import me.meeco.holder.wallet.infrastructure.MultiValueMap
import me.meeco.holder.wallet.infrastructure.PartConfig
import me.meeco.holder.wallet.infrastructure.RequestConfig
import me.meeco.holder.wallet.infrastructure.RequestMethod
import me.meeco.holder.wallet.infrastructure.ResponseType
import me.meeco.holder.wallet.infrastructure.Success
import me.meeco.holder.wallet.infrastructure.toMultiValue

class VerifiableCredentialApi(basePath: kotlin.String = defaultBasePath, client: OkHttpClient = ApiClient.defaultClient) : ApiClient(basePath, client) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty(ApiClient.baseUrlKey, "https://holder-wallet-dev.svx.internal")
        }
    }

    /**
     * enum for parameter order
     */
     enum class OrderCredentialsControllerFindAll(val value: kotlin.String) {
         @Json(name = "ASC") aSC("ASC"),
         @Json(name = "DESC") dESC("DESC")
     }

    /**
     * enum for parameter orderBy
     */
     enum class OrderByCredentialsControllerFindAll(val value: kotlin.String) {
         @Json(name = "created_at") createdAt("created_at")
     }

    /**
     * Get credentials
     * Fetch a paginated list of credentials stored inside the Wallet.
     * @param walletId 
     * @param order Issuance state response order. Default ordering: &#x60;DESC&#x60; (Supported: &#x60;ASC&#x60;, &#x60;DESC&#x60;) (optional)
     * @param orderBy Order Issuance state by an attribute, defaults to: &#x60;created_at&#x60; (Supported: &#x60;created_at&#x60;) (optional)
     * @param perPage Number of records per page (optional)
     * @param page Page number (starting from 1) (optional)
     * @return CredentialsResponseDto
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun credentialsControllerFindAll(walletId: kotlin.String, order: OrderCredentialsControllerFindAll? = null, orderBy: OrderByCredentialsControllerFindAll? = null, perPage: kotlin.Any? = null, page: kotlin.Any? = null) : CredentialsResponseDto {
        val localVarResponse = credentialsControllerFindAllWithHttpInfo(walletId = walletId, order = order, orderBy = orderBy, perPage = perPage, page = page)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as CredentialsResponseDto
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()} ${localVarError.body}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * Get credentials
     * Fetch a paginated list of credentials stored inside the Wallet.
     * @param walletId 
     * @param order Issuance state response order. Default ordering: &#x60;DESC&#x60; (Supported: &#x60;ASC&#x60;, &#x60;DESC&#x60;) (optional)
     * @param orderBy Order Issuance state by an attribute, defaults to: &#x60;created_at&#x60; (Supported: &#x60;created_at&#x60;) (optional)
     * @param perPage Number of records per page (optional)
     * @param page Page number (starting from 1) (optional)
     * @return ApiResponse<CredentialsResponseDto?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun credentialsControllerFindAllWithHttpInfo(walletId: kotlin.String, order: OrderCredentialsControllerFindAll?, orderBy: OrderByCredentialsControllerFindAll?, perPage: kotlin.Any?, page: kotlin.Any?) : ApiResponse<CredentialsResponseDto?> {
        val localVariableConfig = credentialsControllerFindAllRequestConfig(walletId = walletId, order = order, orderBy = orderBy, perPage = perPage, page = page)

        return request<Unit, CredentialsResponseDto>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation credentialsControllerFindAll
     *
     * @param walletId 
     * @param order Issuance state response order. Default ordering: &#x60;DESC&#x60; (Supported: &#x60;ASC&#x60;, &#x60;DESC&#x60;) (optional)
     * @param orderBy Order Issuance state by an attribute, defaults to: &#x60;created_at&#x60; (Supported: &#x60;created_at&#x60;) (optional)
     * @param perPage Number of records per page (optional)
     * @param page Page number (starting from 1) (optional)
     * @return RequestConfig
     */
    fun credentialsControllerFindAllRequestConfig(walletId: kotlin.String, order: OrderCredentialsControllerFindAll?, orderBy: OrderByCredentialsControllerFindAll?, perPage: kotlin.Any?, page: kotlin.Any?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, kotlin.collections.List<kotlin.String>>()
            .apply {
                if (order != null) {
                    put("order", listOf(order.value))
                }
                if (orderBy != null) {
                    put("order_by", listOf(orderBy.value))
                }
                if (perPage != null) {
                    put("per_page", listOf(perPage.toString()))
                }
                if (page != null) {
                    put("page", listOf(page.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/wallets/{walletId}/credentials".replace("{"+"walletId"+"}", encodeURIComponent(walletId.toString())),
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = true,
            body = localVariableBody
        )
    }

    /**
     * Get credential by ID
     * Fetch credential information by ID stored inside the Wallet
     * @param walletId 
     * @param vcId 
     * @return CredentialResponseDto
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun credentialsControllerFindOne(walletId: kotlin.String, vcId: kotlin.String) : CredentialResponseDto {
        val localVarResponse = credentialsControllerFindOneWithHttpInfo(walletId = walletId, vcId = vcId)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as CredentialResponseDto
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()} ${localVarError.body}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * Get credential by ID
     * Fetch credential information by ID stored inside the Wallet
     * @param walletId 
     * @param vcId 
     * @return ApiResponse<CredentialResponseDto?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun credentialsControllerFindOneWithHttpInfo(walletId: kotlin.String, vcId: kotlin.String) : ApiResponse<CredentialResponseDto?> {
        val localVariableConfig = credentialsControllerFindOneRequestConfig(walletId = walletId, vcId = vcId)

        return request<Unit, CredentialResponseDto>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation credentialsControllerFindOne
     *
     * @param walletId 
     * @param vcId 
     * @return RequestConfig
     */
    fun credentialsControllerFindOneRequestConfig(walletId: kotlin.String, vcId: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/wallets/{walletId}/credentials/{vcId}".replace("{"+"walletId"+"}", encodeURIComponent(walletId.toString())).replace("{"+"vcId"+"}", encodeURIComponent(vcId.toString())),
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = true,
            body = localVariableBody
        )
    }

    /**
     * Import credential
     * Import an existing credential from a known format into a Wallet.  Depending on how key binding is performed, the import process associates the credential with the given &#x60;did&#x60; and/or &#x60;kid&#x60; if managed by the wallet: - &#x60;did&#x60;: The DID used for binding a DID to the credential. - &#x60;kid&#x60;: The key ID used for binding the key to the credential.  If the &#x60;did&#x60; or &#x60;kid&#x60; is not managed by the wallet, fields are ignored. They can later be updated with &#x60;PATCH /wallets/{walletId}/credentials/{credentialId}&#x60;. 
     * @param walletId 
     * @param credentialImportRequestModelDto 
     * @return CredentialResponseDto
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun credentialsControllerImport(walletId: kotlin.String, credentialImportRequestModelDto: CredentialImportRequestModelDto) : CredentialResponseDto {
        val localVarResponse = credentialsControllerImportWithHttpInfo(walletId = walletId, credentialImportRequestModelDto = credentialImportRequestModelDto)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as CredentialResponseDto
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()} ${localVarError.body}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * Import credential
     * Import an existing credential from a known format into a Wallet.  Depending on how key binding is performed, the import process associates the credential with the given &#x60;did&#x60; and/or &#x60;kid&#x60; if managed by the wallet: - &#x60;did&#x60;: The DID used for binding a DID to the credential. - &#x60;kid&#x60;: The key ID used for binding the key to the credential.  If the &#x60;did&#x60; or &#x60;kid&#x60; is not managed by the wallet, fields are ignored. They can later be updated with &#x60;PATCH /wallets/{walletId}/credentials/{credentialId}&#x60;. 
     * @param walletId 
     * @param credentialImportRequestModelDto 
     * @return ApiResponse<CredentialResponseDto?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun credentialsControllerImportWithHttpInfo(walletId: kotlin.String, credentialImportRequestModelDto: CredentialImportRequestModelDto) : ApiResponse<CredentialResponseDto?> {
        val localVariableConfig = credentialsControllerImportRequestConfig(walletId = walletId, credentialImportRequestModelDto = credentialImportRequestModelDto)

        return request<CredentialImportRequestModelDto, CredentialResponseDto>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation credentialsControllerImport
     *
     * @param walletId 
     * @param credentialImportRequestModelDto 
     * @return RequestConfig
     */
    fun credentialsControllerImportRequestConfig(walletId: kotlin.String, credentialImportRequestModelDto: CredentialImportRequestModelDto) : RequestConfig<CredentialImportRequestModelDto> {
        val localVariableBody = credentialImportRequestModelDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Content-Type"] = "application/json"
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/wallets/{walletId}/credentials/import".replace("{"+"walletId"+"}", encodeURIComponent(walletId.toString())),
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = true,
            body = localVariableBody
        )
    }

    /**
     * Patch credential by ID
     * Patches credential stored inside a Wallet.  Used to update &#x60;did&#x60; and &#x60;kid&#x60; fields in the meta data of the credential. Note that the &#x60;did&#x60; and &#x60;kid&#x60; need to reference an existing DID and Key Id. This is used to associate an (existing) Key and/or DID controlled by the wallet with the credential to make it easier to reference that Key and/or DID when presenting credentials for example. 
     * @param walletId 
     * @param vcId 
     * @param credentialPatchRequestModelDto 
     * @return void
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun credentialsControllerPatch(walletId: kotlin.String, vcId: kotlin.String, credentialPatchRequestModelDto: CredentialPatchRequestModelDto) : Unit {
        val localVarResponse = credentialsControllerPatchWithHttpInfo(walletId = walletId, vcId = vcId, credentialPatchRequestModelDto = credentialPatchRequestModelDto)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> Unit
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()} ${localVarError.body}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * Patch credential by ID
     * Patches credential stored inside a Wallet.  Used to update &#x60;did&#x60; and &#x60;kid&#x60; fields in the meta data of the credential. Note that the &#x60;did&#x60; and &#x60;kid&#x60; need to reference an existing DID and Key Id. This is used to associate an (existing) Key and/or DID controlled by the wallet with the credential to make it easier to reference that Key and/or DID when presenting credentials for example. 
     * @param walletId 
     * @param vcId 
     * @param credentialPatchRequestModelDto 
     * @return ApiResponse<Unit?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Throws(IllegalStateException::class, IOException::class)
    fun credentialsControllerPatchWithHttpInfo(walletId: kotlin.String, vcId: kotlin.String, credentialPatchRequestModelDto: CredentialPatchRequestModelDto) : ApiResponse<Unit?> {
        val localVariableConfig = credentialsControllerPatchRequestConfig(walletId = walletId, vcId = vcId, credentialPatchRequestModelDto = credentialPatchRequestModelDto)

        return request<CredentialPatchRequestModelDto, Unit>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation credentialsControllerPatch
     *
     * @param walletId 
     * @param vcId 
     * @param credentialPatchRequestModelDto 
     * @return RequestConfig
     */
    fun credentialsControllerPatchRequestConfig(walletId: kotlin.String, vcId: kotlin.String, credentialPatchRequestModelDto: CredentialPatchRequestModelDto) : RequestConfig<CredentialPatchRequestModelDto> {
        val localVariableBody = credentialPatchRequestModelDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Content-Type"] = "application/json"
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.PATCH,
            path = "/wallets/{walletId}/credentials/{vcId}".replace("{"+"walletId"+"}", encodeURIComponent(walletId.toString())).replace("{"+"vcId"+"}", encodeURIComponent(vcId.toString())),
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = true,
            body = localVariableBody
        )
    }

    /**
     * Delete credential by ID
     * Deletes credential by ID stored inside the Wallet
     * @param walletId 
     * @param vcId 
     * @return void
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun credentialsControllerRemove(walletId: kotlin.String, vcId: kotlin.String) : Unit {
        val localVarResponse = credentialsControllerRemoveWithHttpInfo(walletId = walletId, vcId = vcId)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> Unit
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()} ${localVarError.body}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * Delete credential by ID
     * Deletes credential by ID stored inside the Wallet
     * @param walletId 
     * @param vcId 
     * @return ApiResponse<Unit?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Throws(IllegalStateException::class, IOException::class)
    fun credentialsControllerRemoveWithHttpInfo(walletId: kotlin.String, vcId: kotlin.String) : ApiResponse<Unit?> {
        val localVariableConfig = credentialsControllerRemoveRequestConfig(walletId = walletId, vcId = vcId)

        return request<Unit, Unit>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation credentialsControllerRemove
     *
     * @param walletId 
     * @param vcId 
     * @return RequestConfig
     */
    fun credentialsControllerRemoveRequestConfig(walletId: kotlin.String, vcId: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.DELETE,
            path = "/wallets/{walletId}/credentials/{vcId}".replace("{"+"walletId"+"}", encodeURIComponent(walletId.toString())).replace("{"+"vcId"+"}", encodeURIComponent(vcId.toString())),
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = true,
            body = localVariableBody
        )
    }

    /**
     * Verify credential by ID
     * Verifies a verifiable credential by ID that is stored inside the Wallet
     * @param walletId 
     * @param vcId 
     * @return CredentialVerificationResponseDto
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun credentialsControllerVerify(walletId: kotlin.String, vcId: kotlin.String) : CredentialVerificationResponseDto {
        val localVarResponse = credentialsControllerVerifyWithHttpInfo(walletId = walletId, vcId = vcId)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as CredentialVerificationResponseDto
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()} ${localVarError.body}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * Verify credential by ID
     * Verifies a verifiable credential by ID that is stored inside the Wallet
     * @param walletId 
     * @param vcId 
     * @return ApiResponse<CredentialVerificationResponseDto?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun credentialsControllerVerifyWithHttpInfo(walletId: kotlin.String, vcId: kotlin.String) : ApiResponse<CredentialVerificationResponseDto?> {
        val localVariableConfig = credentialsControllerVerifyRequestConfig(walletId = walletId, vcId = vcId)

        return request<Unit, CredentialVerificationResponseDto>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation credentialsControllerVerify
     *
     * @param walletId 
     * @param vcId 
     * @return RequestConfig
     */
    fun credentialsControllerVerifyRequestConfig(walletId: kotlin.String, vcId: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/wallets/{walletId}/credentials/{vcId}/verify".replace("{"+"walletId"+"}", encodeURIComponent(walletId.toString())).replace("{"+"vcId"+"}", encodeURIComponent(vcId.toString())),
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = true,
            body = localVariableBody
        )
    }


    private fun encodeURIComponent(uriComponent: kotlin.String): kotlin.String =
        HttpUrl.Builder().scheme("http").host("localhost").addPathSegment(uriComponent).build().encodedPathSegments[0]
}