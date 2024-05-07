# KeyManagementApi

All URIs are relative to *https://holder-wallet-dev.svx.internal*

Method | HTTP request | Description
------------- | ------------- | -------------
[**keyControllerImport**](KeyManagementApi.md#keyControllerImport) | **POST** /wallets/{walletId}/keys/import | Import a key to a Wallet
[**keyControllerSign**](KeyManagementApi.md#keyControllerSign) | **POST** /wallets/{walletId}/keys/{keyId}/sign | Sign data with a key from a wallet
[**keysControllerCreate**](KeyManagementApi.md#keysControllerCreate) | **POST** /wallets/{walletId}/keys | Create a key for a Wallet
[**keysControllerDelete**](KeyManagementApi.md#keysControllerDelete) | **DELETE** /wallets/{walletId}/keys/{keyId} | Delete a key from a Wallet
[**keysControllerGet**](KeyManagementApi.md#keysControllerGet) | **GET** /wallets/{walletId}/keys/{keyId} | Get a key for a Wallet


<a id="keyControllerImport"></a>
# **keyControllerImport**
> KeysControllerCreate201Response keyControllerImport(walletId, keyControllerImportRequest)

Import a key to a Wallet

Import an existing cryptographic key to a Wallet using the JOSE JWK notation.  Depending on the configuration of the service only certain cryptographic keys are supported. 

### Example
```kotlin
// Import classes:
//import me.meeco.holder.wallet.infrastructure.*
//import me.meeco.holder.wallet.models.*

val apiInstance = KeyManagementApi()
val walletId : kotlin.String = walletId_example // kotlin.String | 
val keyControllerImportRequest : KeyControllerImportRequest =  // KeyControllerImportRequest | 
try {
    val result : KeysControllerCreate201Response = apiInstance.keyControllerImport(walletId, keyControllerImportRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling KeyManagementApi#keyControllerImport")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling KeyManagementApi#keyControllerImport")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **walletId** | **kotlin.String**|  |
 **keyControllerImportRequest** | [**KeyControllerImportRequest**](KeyControllerImportRequest.md)|  |

### Return type

[**KeysControllerCreate201Response**](KeysControllerCreate201Response.md)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="keyControllerSign"></a>
# **keyControllerSign**
> KeyControllerSign201Response keyControllerSign(walletId, keyId, keyControllerSignRequest)

Sign data with a key from a wallet

Create a signature based on data provided using a cryptographic key associated with a Wallet. 

### Example
```kotlin
// Import classes:
//import me.meeco.holder.wallet.infrastructure.*
//import me.meeco.holder.wallet.models.*

val apiInstance = KeyManagementApi()
val walletId : kotlin.String = walletId_example // kotlin.String | 
val keyId : kotlin.String = keyId_example // kotlin.String | 
val keyControllerSignRequest : KeyControllerSignRequest =  // KeyControllerSignRequest | 
try {
    val result : KeyControllerSign201Response = apiInstance.keyControllerSign(walletId, keyId, keyControllerSignRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling KeyManagementApi#keyControllerSign")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling KeyManagementApi#keyControllerSign")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **walletId** | **kotlin.String**|  |
 **keyId** | **kotlin.String**|  |
 **keyControllerSignRequest** | [**KeyControllerSignRequest**](KeyControllerSignRequest.md)|  |

### Return type

[**KeyControllerSign201Response**](KeyControllerSign201Response.md)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="keysControllerCreate"></a>
# **keysControllerCreate**
> KeysControllerCreate201Response keysControllerCreate(walletId, keysControllerCreateRequest)

Create a key for a Wallet

Create a new cryptographic key associated with the Wallet. Keys are created using the JOSE JWK standard using attribute strings listed in the [JOSE IANA registry](https://www.iana.org/assignments/jose/jose.xhtml).  Depending on the configuration of the service only certain cryptographic keys are supported. 

### Example
```kotlin
// Import classes:
//import me.meeco.holder.wallet.infrastructure.*
//import me.meeco.holder.wallet.models.*

val apiInstance = KeyManagementApi()
val walletId : kotlin.String = walletId_example // kotlin.String | 
val keysControllerCreateRequest : KeysControllerCreateRequest =  // KeysControllerCreateRequest | 
try {
    val result : KeysControllerCreate201Response = apiInstance.keysControllerCreate(walletId, keysControllerCreateRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling KeyManagementApi#keysControllerCreate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling KeyManagementApi#keysControllerCreate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **walletId** | **kotlin.String**|  |
 **keysControllerCreateRequest** | [**KeysControllerCreateRequest**](KeysControllerCreateRequest.md)|  |

### Return type

[**KeysControllerCreate201Response**](KeysControllerCreate201Response.md)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="keysControllerDelete"></a>
# **keysControllerDelete**
> keysControllerDelete(walletId, keyId)

Delete a key from a Wallet



### Example
```kotlin
// Import classes:
//import me.meeco.holder.wallet.infrastructure.*
//import me.meeco.holder.wallet.models.*

val apiInstance = KeyManagementApi()
val walletId : kotlin.String = walletId_example // kotlin.String | 
val keyId : kotlin.String = keyId_example // kotlin.String | 
try {
    apiInstance.keysControllerDelete(walletId, keyId)
} catch (e: ClientException) {
    println("4xx response calling KeyManagementApi#keysControllerDelete")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling KeyManagementApi#keysControllerDelete")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **walletId** | **kotlin.String**|  |
 **keyId** | **kotlin.String**|  |

### Return type

null (empty response body)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="keysControllerGet"></a>
# **keysControllerGet**
> KeysControllerCreate201Response keysControllerGet(walletId, keyId)

Get a key for a Wallet

Return the cryptographic key information for a key associated with a Wallet.  The information returned contains only header and public attributes of the key, i.e. not the private key information which is kept in the Wallet. Key information is returned in the JOSE JWK standard using attribute strings listed in the [JOSE IANA registry](https://www.iana.org/assignments/jose/jose.xhtml). 

### Example
```kotlin
// Import classes:
//import me.meeco.holder.wallet.infrastructure.*
//import me.meeco.holder.wallet.models.*

val apiInstance = KeyManagementApi()
val walletId : kotlin.String = walletId_example // kotlin.String | 
val keyId : kotlin.String = keyId_example // kotlin.String | 
try {
    val result : KeysControllerCreate201Response = apiInstance.keysControllerGet(walletId, keyId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling KeyManagementApi#keysControllerGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling KeyManagementApi#keysControllerGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **walletId** | **kotlin.String**|  |
 **keyId** | **kotlin.String**|  |

### Return type

[**KeysControllerCreate201Response**](KeysControllerCreate201Response.md)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

