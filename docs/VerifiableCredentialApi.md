# VerifiableCredentialApi

All URIs are relative to *https://holder-wallet-dev.svx.internal*

Method | HTTP request | Description
------------- | ------------- | -------------
[**credentialsControllerFindAll**](VerifiableCredentialApi.md#credentialsControllerFindAll) | **GET** /wallets/{walletId}/credentials | Get credentials
[**credentialsControllerFindOne**](VerifiableCredentialApi.md#credentialsControllerFindOne) | **GET** /wallets/{walletId}/credentials/{vcId} | Get credential by ID
[**credentialsControllerImport**](VerifiableCredentialApi.md#credentialsControllerImport) | **POST** /wallets/{walletId}/credentials/import | Import credential
[**credentialsControllerPatch**](VerifiableCredentialApi.md#credentialsControllerPatch) | **PATCH** /wallets/{walletId}/credentials/{vcId} | Patch credential by ID
[**credentialsControllerRemove**](VerifiableCredentialApi.md#credentialsControllerRemove) | **DELETE** /wallets/{walletId}/credentials/{vcId} | Delete credential by ID
[**credentialsControllerVerify**](VerifiableCredentialApi.md#credentialsControllerVerify) | **GET** /wallets/{walletId}/credentials/{vcId}/verify | Verify credential by ID


<a id="credentialsControllerFindAll"></a>
# **credentialsControllerFindAll**
> CredentialsResponseDto credentialsControllerFindAll(walletId, order, orderBy, perPage, page)

Get credentials

Fetch a paginated list of credentials stored inside the Wallet.

### Example
```kotlin
// Import classes:
//import me.meeco.holder.wallet.infrastructure.*
//import me.meeco.holder.wallet.models.*

val apiInstance = VerifiableCredentialApi()
val walletId : kotlin.String = walletId_example // kotlin.String | 
val order : kotlin.String = DESC // kotlin.String | Issuance state response order. Default ordering: `DESC` (Supported: `ASC`, `DESC`)
val orderBy : kotlin.String = created_at // kotlin.String | Order Issuance state by an attribute, defaults to: `created_at` (Supported: `created_at`)
val perPage : kotlin.Any = 10 // kotlin.Any | Number of records per page
val page : kotlin.Any = 1 // kotlin.Any | Page number (starting from 1)
try {
    val result : CredentialsResponseDto = apiInstance.credentialsControllerFindAll(walletId, order, orderBy, perPage, page)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling VerifiableCredentialApi#credentialsControllerFindAll")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling VerifiableCredentialApi#credentialsControllerFindAll")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **walletId** | **kotlin.String**|  |
 **order** | **kotlin.String**| Issuance state response order. Default ordering: &#x60;DESC&#x60; (Supported: &#x60;ASC&#x60;, &#x60;DESC&#x60;) | [optional] [enum: ASC, DESC]
 **orderBy** | **kotlin.String**| Order Issuance state by an attribute, defaults to: &#x60;created_at&#x60; (Supported: &#x60;created_at&#x60;) | [optional] [enum: created_at]
 **perPage** | [**kotlin.Any**](.md)| Number of records per page | [optional]
 **page** | [**kotlin.Any**](.md)| Page number (starting from 1) | [optional]

### Return type

[**CredentialsResponseDto**](CredentialsResponseDto.md)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="credentialsControllerFindOne"></a>
# **credentialsControllerFindOne**
> CredentialResponseDto credentialsControllerFindOne(walletId, vcId)

Get credential by ID

Fetch credential information by ID stored inside the Wallet

### Example
```kotlin
// Import classes:
//import me.meeco.holder.wallet.infrastructure.*
//import me.meeco.holder.wallet.models.*

val apiInstance = VerifiableCredentialApi()
val walletId : kotlin.String = walletId_example // kotlin.String | 
val vcId : kotlin.String = vcId_example // kotlin.String | 
try {
    val result : CredentialResponseDto = apiInstance.credentialsControllerFindOne(walletId, vcId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling VerifiableCredentialApi#credentialsControllerFindOne")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling VerifiableCredentialApi#credentialsControllerFindOne")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **walletId** | **kotlin.String**|  |
 **vcId** | **kotlin.String**|  |

### Return type

[**CredentialResponseDto**](CredentialResponseDto.md)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="credentialsControllerImport"></a>
# **credentialsControllerImport**
> CredentialResponseDto credentialsControllerImport(walletId, credentialImportRequestModelDto)

Import credential

Import an existing credential from a known format into a Wallet.  Depending on how key binding is performed, the import process associates the credential with the given &#x60;did&#x60; and/or &#x60;kid&#x60; if managed by the wallet: - &#x60;did&#x60;: The DID used for binding a DID to the credential. - &#x60;kid&#x60;: The key ID used for binding the key to the credential.  If the &#x60;did&#x60; or &#x60;kid&#x60; is not managed by the wallet, fields are ignored. They can later be updated with &#x60;PATCH /wallets/{walletId}/credentials/{credentialId}&#x60;. 

### Example
```kotlin
// Import classes:
//import me.meeco.holder.wallet.infrastructure.*
//import me.meeco.holder.wallet.models.*

val apiInstance = VerifiableCredentialApi()
val walletId : kotlin.String = walletId_example // kotlin.String | 
val credentialImportRequestModelDto : CredentialImportRequestModelDto =  // CredentialImportRequestModelDto | 
try {
    val result : CredentialResponseDto = apiInstance.credentialsControllerImport(walletId, credentialImportRequestModelDto)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling VerifiableCredentialApi#credentialsControllerImport")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling VerifiableCredentialApi#credentialsControllerImport")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **walletId** | **kotlin.String**|  |
 **credentialImportRequestModelDto** | [**CredentialImportRequestModelDto**](CredentialImportRequestModelDto.md)|  |

### Return type

[**CredentialResponseDto**](CredentialResponseDto.md)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="credentialsControllerPatch"></a>
# **credentialsControllerPatch**
> credentialsControllerPatch(walletId, vcId, credentialPatchRequestModelDto)

Patch credential by ID

Patches credential stored inside a Wallet.  Used to update &#x60;did&#x60; and &#x60;kid&#x60; fields in the meta data of the credential. Note that the &#x60;did&#x60; and &#x60;kid&#x60; need to reference an existing DID and Key Id. This is used to associate an (existing) Key and/or DID controlled by the wallet with the credential to make it easier to reference that Key and/or DID when presenting credentials for example. 

### Example
```kotlin
// Import classes:
//import me.meeco.holder.wallet.infrastructure.*
//import me.meeco.holder.wallet.models.*

val apiInstance = VerifiableCredentialApi()
val walletId : kotlin.String = walletId_example // kotlin.String | 
val vcId : kotlin.String = vcId_example // kotlin.String | 
val credentialPatchRequestModelDto : CredentialPatchRequestModelDto =  // CredentialPatchRequestModelDto | 
try {
    apiInstance.credentialsControllerPatch(walletId, vcId, credentialPatchRequestModelDto)
} catch (e: ClientException) {
    println("4xx response calling VerifiableCredentialApi#credentialsControllerPatch")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling VerifiableCredentialApi#credentialsControllerPatch")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **walletId** | **kotlin.String**|  |
 **vcId** | **kotlin.String**|  |
 **credentialPatchRequestModelDto** | [**CredentialPatchRequestModelDto**](CredentialPatchRequestModelDto.md)|  |

### Return type

null (empty response body)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="credentialsControllerRemove"></a>
# **credentialsControllerRemove**
> credentialsControllerRemove(walletId, vcId)

Delete credential by ID

Deletes credential by ID stored inside the Wallet

### Example
```kotlin
// Import classes:
//import me.meeco.holder.wallet.infrastructure.*
//import me.meeco.holder.wallet.models.*

val apiInstance = VerifiableCredentialApi()
val walletId : kotlin.String = walletId_example // kotlin.String | 
val vcId : kotlin.String = vcId_example // kotlin.String | 
try {
    apiInstance.credentialsControllerRemove(walletId, vcId)
} catch (e: ClientException) {
    println("4xx response calling VerifiableCredentialApi#credentialsControllerRemove")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling VerifiableCredentialApi#credentialsControllerRemove")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **walletId** | **kotlin.String**|  |
 **vcId** | **kotlin.String**|  |

### Return type

null (empty response body)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="credentialsControllerVerify"></a>
# **credentialsControllerVerify**
> CredentialVerificationResponseDto credentialsControllerVerify(walletId, vcId)

Verify credential by ID

Verifies a verifiable credential by ID that is stored inside the Wallet

### Example
```kotlin
// Import classes:
//import me.meeco.holder.wallet.infrastructure.*
//import me.meeco.holder.wallet.models.*

val apiInstance = VerifiableCredentialApi()
val walletId : kotlin.String = walletId_example // kotlin.String | 
val vcId : kotlin.String = vcId_example // kotlin.String | 
try {
    val result : CredentialVerificationResponseDto = apiInstance.credentialsControllerVerify(walletId, vcId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling VerifiableCredentialApi#credentialsControllerVerify")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling VerifiableCredentialApi#credentialsControllerVerify")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **walletId** | **kotlin.String**|  |
 **vcId** | **kotlin.String**|  |

### Return type

[**CredentialVerificationResponseDto**](CredentialVerificationResponseDto.md)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

