# WalletApi

All URIs are relative to *https://holder-wallet-dev.svx.internal*

Method | HTTP request | Description
------------- | ------------- | -------------
[**walletsControllerCreate**](WalletApi.md#walletsControllerCreate) | **POST** /wallets | Register or find a Wallet
[**walletsControllerDeleteOne**](WalletApi.md#walletsControllerDeleteOne) | **DELETE** /wallets/{walletId} | Delete Wallet by ID
[**walletsControllerGetOne**](WalletApi.md#walletsControllerGetOne) | **GET** /wallets/{walletId} | Get Wallet by ID


<a id="walletsControllerCreate"></a>
# **walletsControllerCreate**
> WalletResponseDto walletsControllerCreate(createWalletPayloadDto)

Register or find a Wallet

Register a new Wallet. Optionally use &#x60;external_reference&#x60;. When a Wallet exists with the given &#x60;external_reference&#x60;, the existing Wallet information is returned making the operation idempotent. If &#x60;external_reference&#x60; is not used a new Wallet is always created.  Based on the configuration of the component, a Wallet has a default key and DID assigned to it. This key and DID are used to register and authenticate the Wallet with the SVX API. 

### Example
```kotlin
// Import classes:
//import me.meeco.holder.wallet.infrastructure.*
//import me.meeco.holder.wallet.models.*

val apiInstance = WalletApi()
val createWalletPayloadDto : CreateWalletPayloadDto =  // CreateWalletPayloadDto | 
try {
    val result : WalletResponseDto = apiInstance.walletsControllerCreate(createWalletPayloadDto)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling WalletApi#walletsControllerCreate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling WalletApi#walletsControllerCreate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createWalletPayloadDto** | [**CreateWalletPayloadDto**](CreateWalletPayloadDto.md)|  |

### Return type

[**WalletResponseDto**](WalletResponseDto.md)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="walletsControllerDeleteOne"></a>
# **walletsControllerDeleteOne**
> walletsControllerDeleteOne(walletId)

Delete Wallet by ID

Deleted Wallet by ID. All information stored inside the Wallet will be deleted as well.

### Example
```kotlin
// Import classes:
//import me.meeco.holder.wallet.infrastructure.*
//import me.meeco.holder.wallet.models.*

val apiInstance = WalletApi()
val walletId : kotlin.String = walletId_example // kotlin.String | 
try {
    apiInstance.walletsControllerDeleteOne(walletId)
} catch (e: ClientException) {
    println("4xx response calling WalletApi#walletsControllerDeleteOne")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling WalletApi#walletsControllerDeleteOne")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **walletId** | **kotlin.String**|  |

### Return type

null (empty response body)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="walletsControllerGetOne"></a>
# **walletsControllerGetOne**
> WalletResponseDto walletsControllerGetOne(walletId)

Get Wallet by ID

Fetch Wallet information by ID.

### Example
```kotlin
// Import classes:
//import me.meeco.holder.wallet.infrastructure.*
//import me.meeco.holder.wallet.models.*

val apiInstance = WalletApi()
val walletId : kotlin.String = walletId_example // kotlin.String | 
try {
    val result : WalletResponseDto = apiInstance.walletsControllerGetOne(walletId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling WalletApi#walletsControllerGetOne")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling WalletApi#walletsControllerGetOne")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **walletId** | **kotlin.String**|  |

### Return type

[**WalletResponseDto**](WalletResponseDto.md)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

