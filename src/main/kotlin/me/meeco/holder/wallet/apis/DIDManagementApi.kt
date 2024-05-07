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

import me.meeco.holder.wallet.models.CreateDidError
import me.meeco.holder.wallet.models.DeleteDidError
import me.meeco.holder.wallet.models.DidControllerCreate201Response
import me.meeco.holder.wallet.models.DidControllerCreateRequest
import me.meeco.holder.wallet.models.SvxDidCannotBeDeletedError
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

class DIDManagementApi(basePath: kotlin.String = defaultBasePath, client: OkHttpClient = ApiClient.defaultClient) : ApiClient(basePath, client) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty(ApiClient.baseUrlKey, "https://holder-wallet-dev.svx.internal")
        }
    }

    /**
     * Create a DID for a Wallet
     * 
     * @param walletId 
     * @param didControllerCreateRequest 
     * @return DidControllerCreate201Response
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun didControllerCreate(walletId: kotlin.String, didControllerCreateRequest: DidControllerCreateRequest) : DidControllerCreate201Response {
        val localVarResponse = didControllerCreateWithHttpInfo(walletId = walletId, didControllerCreateRequest = didControllerCreateRequest)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as DidControllerCreate201Response
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
     * Create a DID for a Wallet
     * 
     * @param walletId 
     * @param didControllerCreateRequest 
     * @return ApiResponse<DidControllerCreate201Response?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun didControllerCreateWithHttpInfo(walletId: kotlin.String, didControllerCreateRequest: DidControllerCreateRequest) : ApiResponse<DidControllerCreate201Response?> {
        val localVariableConfig = didControllerCreateRequestConfig(walletId = walletId, didControllerCreateRequest = didControllerCreateRequest)

        return request<DidControllerCreateRequest, DidControllerCreate201Response>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation didControllerCreate
     *
     * @param walletId 
     * @param didControllerCreateRequest 
     * @return RequestConfig
     */
    fun didControllerCreateRequestConfig(walletId: kotlin.String, didControllerCreateRequest: DidControllerCreateRequest) : RequestConfig<DidControllerCreateRequest> {
        val localVariableBody = didControllerCreateRequest
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Content-Type"] = "application/json"
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/wallets/{walletId}/dids".replace("{"+"walletId"+"}", encodeURIComponent(walletId.toString())),
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = true,
            body = localVariableBody
        )
    }

    /**
     * Delete a DID from a Wallet
     * 
     * @param walletId 
     * @param id 
     * @return void
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun didControllerDelete(walletId: kotlin.String, id: kotlin.String) : Unit {
        val localVarResponse = didControllerDeleteWithHttpInfo(walletId = walletId, id = id)

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
     * Delete a DID from a Wallet
     * 
     * @param walletId 
     * @param id 
     * @return ApiResponse<Unit?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Throws(IllegalStateException::class, IOException::class)
    fun didControllerDeleteWithHttpInfo(walletId: kotlin.String, id: kotlin.String) : ApiResponse<Unit?> {
        val localVariableConfig = didControllerDeleteRequestConfig(walletId = walletId, id = id)

        return request<Unit, Unit>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation didControllerDelete
     *
     * @param walletId 
     * @param id 
     * @return RequestConfig
     */
    fun didControllerDeleteRequestConfig(walletId: kotlin.String, id: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.DELETE,
            path = "/wallets/{walletId}/dids/{id}".replace("{"+"walletId"+"}", encodeURIComponent(walletId.toString())).replace("{"+"id"+"}", encodeURIComponent(id.toString())),
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = true,
            body = localVariableBody
        )
    }


    private fun encodeURIComponent(uriComponent: kotlin.String): kotlin.String =
        HttpUrl.Builder().scheme("http").host("localhost").addPathSegment(uriComponent).build().encodedPathSegments[0]
}