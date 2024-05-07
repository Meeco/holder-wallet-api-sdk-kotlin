# DIDManagementApi

All URIs are relative to *https://holder-wallet-dev.svx.internal*

Method | HTTP request | Description
------------- | ------------- | -------------
[**didControllerCreate**](DIDManagementApi.md#didControllerCreate) | **POST** /wallets/{walletId}/dids | Create a DID for a Wallet
[**didControllerDelete**](DIDManagementApi.md#didControllerDelete) | **DELETE** /wallets/{walletId}/dids/{id} | Delete a DID from a Wallet


<a id="didControllerCreate"></a>
# **didControllerCreate**
> DidControllerCreate201Response didControllerCreate(walletId, didControllerCreateRequest)

Create a DID for a Wallet



### Example
```kotlin
// Import classes:
//import me.meeco.holder.wallet.infrastructure.*
//import me.meeco.holder.wallet.models.*

val apiInstance = DIDManagementApi()
val walletId : kotlin.String = walletId_example // kotlin.String | 
val didControllerCreateRequest : DidControllerCreateRequest =  // DidControllerCreateRequest | 
try {
    val result : DidControllerCreate201Response = apiInstance.didControllerCreate(walletId, didControllerCreateRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DIDManagementApi#didControllerCreate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DIDManagementApi#didControllerCreate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **walletId** | **kotlin.String**|  |
 **didControllerCreateRequest** | [**DidControllerCreateRequest**](DidControllerCreateRequest.md)|  |

### Return type

[**DidControllerCreate201Response**](DidControllerCreate201Response.md)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="didControllerDelete"></a>
# **didControllerDelete**
> didControllerDelete(walletId, id)

Delete a DID from a Wallet



### Example
```kotlin
// Import classes:
//import me.meeco.holder.wallet.infrastructure.*
//import me.meeco.holder.wallet.models.*

val apiInstance = DIDManagementApi()
val walletId : kotlin.String = walletId_example // kotlin.String | 
val id : kotlin.String = id_example // kotlin.String | 
try {
    apiInstance.didControllerDelete(walletId, id)
} catch (e: ClientException) {
    println("4xx response calling DIDManagementApi#didControllerDelete")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DIDManagementApi#didControllerDelete")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **walletId** | **kotlin.String**|  |
 **id** | **kotlin.String**|  |

### Return type

null (empty response body)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

