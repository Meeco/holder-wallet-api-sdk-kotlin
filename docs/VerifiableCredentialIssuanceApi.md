# VerifiableCredentialIssuanceApi

All URIs are relative to *https://holder-wallet-dev.svx.internal*

Method | HTTP request | Description
------------- | ------------- | -------------
[**receiveControllerCallback**](VerifiableCredentialIssuanceApi.md#receiveControllerCallback) | **GET** /wallets/receive/callback | authorization_code flow Holder Wallet redirect uri 
[**receiveControllerCreate**](VerifiableCredentialIssuanceApi.md#receiveControllerCreate) | **POST** /wallets/{walletId}/receive | Register credential offer
[**receiveControllerDeleteOne**](VerifiableCredentialIssuanceApi.md#receiveControllerDeleteOne) | **DELETE** /wallets/{walletId}/receive/{state} | Delete receive credential state
[**receiveControllerFindAll**](VerifiableCredentialIssuanceApi.md#receiveControllerFindAll) | **GET** /wallets/{walletId}/receive | Get credential receive states
[**receiveControllerGetAccessToken**](VerifiableCredentialIssuanceApi.md#receiveControllerGetAccessToken) | **POST** /wallets/{walletId}/receive/get_access_token | Get access token
[**receiveControllerGetCredential**](VerifiableCredentialIssuanceApi.md#receiveControllerGetCredential) | **POST** /wallets/{walletId}/receive/get_credential | Get verifiable credential
[**receiveControllerGetInfo**](VerifiableCredentialIssuanceApi.md#receiveControllerGetInfo) | **GET** /wallets/{walletId}/receive/{state} | Get credential receive state


<a id="receiveControllerCallback"></a>
# **receiveControllerCallback**
> receiveControllerCallback(error, errorDescription, errorUri, code, state, iss)

authorization_code flow Holder Wallet redirect uri 

&#x60;authorization_code&#x60; redirect uri that was started via &#x60;/receive&#x60; endpoint.&lt;br/&gt; &#x60;state&#x60; and &#x60;code&#x60; come as a query parameters.&lt;br/&gt; &#x60;code&#x60; is exchanged for the &#x60;access_token&#x60; so client can call &#x60;POST /wallets/{walletId}/receive/get_credential&#x60; endpoint right away. 

### Example
```kotlin
// Import classes:
//import me.meeco.holder.wallet.infrastructure.*
//import me.meeco.holder.wallet.models.*

val apiInstance = VerifiableCredentialIssuanceApi()
val error : kotlin.String = error_example // kotlin.String | Error code
val errorDescription : kotlin.String = errorDescription_example // kotlin.String | Error description
val errorUri : kotlin.String = errorUri_example // kotlin.String | Error URI
val code : kotlin.String = code_example // kotlin.String | Authorization code
val state : kotlin.String = state_example // kotlin.String | Authorization state
val iss : kotlin.String = iss_example // kotlin.String | Access token issuer
try {
    apiInstance.receiveControllerCallback(error, errorDescription, errorUri, code, state, iss)
} catch (e: ClientException) {
    println("4xx response calling VerifiableCredentialIssuanceApi#receiveControllerCallback")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling VerifiableCredentialIssuanceApi#receiveControllerCallback")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **error** | **kotlin.String**| Error code | [optional]
 **errorDescription** | **kotlin.String**| Error description | [optional]
 **errorUri** | **kotlin.String**| Error URI | [optional]
 **code** | **kotlin.String**| Authorization code | [optional]
 **state** | **kotlin.String**| Authorization state | [optional]
 **iss** | **kotlin.String**| Access token issuer | [optional]

### Return type

null (empty response body)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="receiveControllerCreate"></a>
# **receiveControllerCreate**
> CredentialReceiveResponseModelDto receiveControllerCreate(walletId, credentialReceiveRequestModelDto)

Register credential offer

Credential offer is a JSON encoded object that the issuer uses to pass information to the wallet and initiate the issuance process. This endpoint is used to validate, parse and extract the necessary information, leading to the next step in the process, getting an access token.  For more information on the structure of the credential offer object, see section 4.1 in OpenID4VCI.  The three supported methods for registering a credential offer are: - &#x60;credential_offer&#x60;: Pass the JSON object by value - &#x60;credential_offer_uri&#x60;: Pass the JSON object by reference. The service performs a GET request to retrieve the object. - &#x60;credential_offer_endpoint&#x60; - Credential Offer sent by the issuer to the wallet credential offer endpoint. It contains a single URI query parameter, either credential_offer or credential_offer_uri  Note that the options above are mutually exclusive.  After successfully registering the credential offer, a state is returned. This state is used as an identifier to link subsequent calls to receive endpoints.  ### Next Step  To continue the issuance process, call:  &#x60;&#x60;&#x60;POST /wallets/{walletId}/receive/get_access_token&#x60;&#x60;&#x60; 

### Example
```kotlin
// Import classes:
//import me.meeco.holder.wallet.infrastructure.*
//import me.meeco.holder.wallet.models.*

val apiInstance = VerifiableCredentialIssuanceApi()
val walletId : kotlin.String = walletId_example // kotlin.String | 
val credentialReceiveRequestModelDto : CredentialReceiveRequestModelDto =  // CredentialReceiveRequestModelDto | 
try {
    val result : CredentialReceiveResponseModelDto = apiInstance.receiveControllerCreate(walletId, credentialReceiveRequestModelDto)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling VerifiableCredentialIssuanceApi#receiveControllerCreate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling VerifiableCredentialIssuanceApi#receiveControllerCreate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **walletId** | **kotlin.String**|  |
 **credentialReceiveRequestModelDto** | [**CredentialReceiveRequestModelDto**](CredentialReceiveRequestModelDto.md)|  |

### Return type

[**CredentialReceiveResponseModelDto**](CredentialReceiveResponseModelDto.md)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="receiveControllerDeleteOne"></a>
# **receiveControllerDeleteOne**
> receiveControllerDeleteOne(walletId, state)

Delete receive credential state

Delete state of a receive credential flow. 

### Example
```kotlin
// Import classes:
//import me.meeco.holder.wallet.infrastructure.*
//import me.meeco.holder.wallet.models.*

val apiInstance = VerifiableCredentialIssuanceApi()
val walletId : kotlin.String = walletId_example // kotlin.String | 
val state : kotlin.String = state_example // kotlin.String | 
try {
    apiInstance.receiveControllerDeleteOne(walletId, state)
} catch (e: ClientException) {
    println("4xx response calling VerifiableCredentialIssuanceApi#receiveControllerDeleteOne")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling VerifiableCredentialIssuanceApi#receiveControllerDeleteOne")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **walletId** | **kotlin.String**|  |
 **state** | **kotlin.String**|  |

### Return type

null (empty response body)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="receiveControllerFindAll"></a>
# **receiveControllerFindAll**
> CredentialReceiveStatesModelDto receiveControllerFindAll(walletId, order, orderBy, perPage, page)

Get credential receive states



### Example
```kotlin
// Import classes:
//import me.meeco.holder.wallet.infrastructure.*
//import me.meeco.holder.wallet.models.*

val apiInstance = VerifiableCredentialIssuanceApi()
val walletId : kotlin.String = walletId_example // kotlin.String | 
val order : kotlin.String = DESC // kotlin.String | Issuance state response order. Default ordering: `DESC` (Supported: `ASC`, `DESC`)
val orderBy : kotlin.String = created_at // kotlin.String | Order Issuance state by an attribute, defaults to: `created_at` (Supported: `created_at`)
val perPage : kotlin.Any = 10 // kotlin.Any | Number of records per page
val page : kotlin.Any = 1 // kotlin.Any | Page number (starting from 1)
try {
    val result : CredentialReceiveStatesModelDto = apiInstance.receiveControllerFindAll(walletId, order, orderBy, perPage, page)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling VerifiableCredentialIssuanceApi#receiveControllerFindAll")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling VerifiableCredentialIssuanceApi#receiveControllerFindAll")
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

[**CredentialReceiveStatesModelDto**](CredentialReceiveStatesModelDto.md)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="receiveControllerGetAccessToken"></a>
# **receiveControllerGetAccessToken**
> CredentialReceiveGetAccessTokenResponseModelDto receiveControllerGetAccessToken(walletId, credentialReceiveGetAccessTokenRequestModelDto)

Get access token

The get access token endpoint ensures the wallet is able to retrieve a valid access token to go to the next step of actually getting the credential(s).  Two flows that are supported are: - Pre-Authorized Code Flow - Authorization Code Flow  ### Authorization Code Flow  Uses the &#x60;authorization_code&#x60; as defined in RFC6749 to issue access tokens.  This is usually a two-step process, that involves authentication on the front channel (through a browser window) to be performed by the client.  In step 1, a call to this endpoint returns the &#x60;authorization_url&#x60;. This URL is what needs to be opened in a browser window and will authenticate the end-user to the service. This includes a redirect_uri responsible for receiving and storing the &#x60;authorization_code&#x60;.  In step 2, the service, exchanges the code for an access token by calling the Token Endpoint.  Note that at this point, the wallet initiated Authorization Code flow is not supported.  ### Pre-Authorized Code Flow  This flow is used when the issuer has already authenticated and authorized the end-user. The issuer provides a Pre-Authorized Code in the credential offer which is used to exchange it for an access token in the Token Endpoint. The Authorization Endpoint is not used in this flow.  For more information, see section 3.5 in OpenID4VCI.  ### Next Step  To continue the issuance process, call:  &#x60;&#x60;&#x60;POST /wallets/{walletId}/receive/get_credential&#x60;&#x60;&#x60; 

### Example
```kotlin
// Import classes:
//import me.meeco.holder.wallet.infrastructure.*
//import me.meeco.holder.wallet.models.*

val apiInstance = VerifiableCredentialIssuanceApi()
val walletId : kotlin.String = walletId_example // kotlin.String | 
val credentialReceiveGetAccessTokenRequestModelDto : CredentialReceiveGetAccessTokenRequestModelDto =  // CredentialReceiveGetAccessTokenRequestModelDto | 
try {
    val result : CredentialReceiveGetAccessTokenResponseModelDto = apiInstance.receiveControllerGetAccessToken(walletId, credentialReceiveGetAccessTokenRequestModelDto)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling VerifiableCredentialIssuanceApi#receiveControllerGetAccessToken")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling VerifiableCredentialIssuanceApi#receiveControllerGetAccessToken")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **walletId** | **kotlin.String**|  |
 **credentialReceiveGetAccessTokenRequestModelDto** | [**CredentialReceiveGetAccessTokenRequestModelDto**](CredentialReceiveGetAccessTokenRequestModelDto.md)|  |

### Return type

[**CredentialReceiveGetAccessTokenResponseModelDto**](CredentialReceiveGetAccessTokenResponseModelDto.md)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="receiveControllerGetCredential"></a>
# **receiveControllerGetCredential**
> CredentialReceiveGetCredentialResponseModelDto receiveControllerGetCredential(walletId, credentialReceiveGetCredentialRequestModelDto)

Get verifiable credential

Get credential from the issuer and perform key binding. A valid access token is required in order to call this endpoint.  See section 7 in OpenID4VCI for more information.  ### Key Binding  Key binding is performed by providing either  - &#x60;kid&#x60;: Public key is presented. Should be used when credential format is &#x60;vc+sd-jwt&#x60;. - &#x60;did&#x60;: DID is presented referencing one of the keys contained in the &#x60;verificationMethod&#x60; section of the DID document. Should be used when credential format is &#x60;jwt_vc_json&#x60;.  Only one of the &#x60;kid&#x60; or &#x60;did&#x60; parameters must be present during the request.  Both methods involve the wallet presenting key proof to the issuer to ensure control over cryptographic key material.  See section 7.2.1 in OpenID4VCI for more information.  ### Requesting Multiple Credentials in Sequence  The &#x60;c_nonce&#x60; and &#x60;c_nonce_expires_in&#x60; returned by the issuer allow requesting the same credential, but binding it to different key material. The service automatically manages these attributes, ensuring the correct &#x60;c_nonce&#x60; is used, allowing multiple credentials to be retrieved, but with different keys.  ### Not Supported Options  Note that the following are not supported by the endpoint  - &#x60;transaction_id&#x60;: Part of the deferred issuance flow, allows receiving a credential by referencing a &#x60;transaction_id&#x60; - Receiving encrypted credentials 

### Example
```kotlin
// Import classes:
//import me.meeco.holder.wallet.infrastructure.*
//import me.meeco.holder.wallet.models.*

val apiInstance = VerifiableCredentialIssuanceApi()
val walletId : kotlin.String = walletId_example // kotlin.String | 
val credentialReceiveGetCredentialRequestModelDto : CredentialReceiveGetCredentialRequestModelDto =  // CredentialReceiveGetCredentialRequestModelDto | 
try {
    val result : CredentialReceiveGetCredentialResponseModelDto = apiInstance.receiveControllerGetCredential(walletId, credentialReceiveGetCredentialRequestModelDto)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling VerifiableCredentialIssuanceApi#receiveControllerGetCredential")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling VerifiableCredentialIssuanceApi#receiveControllerGetCredential")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **walletId** | **kotlin.String**|  |
 **credentialReceiveGetCredentialRequestModelDto** | [**CredentialReceiveGetCredentialRequestModelDto**](CredentialReceiveGetCredentialRequestModelDto.md)|  |

### Return type

[**CredentialReceiveGetCredentialResponseModelDto**](CredentialReceiveGetCredentialResponseModelDto.md)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="receiveControllerGetInfo"></a>
# **receiveControllerGetInfo**
> CredentialReceiveStateModelDto receiveControllerGetInfo(walletId, state)

Get credential receive state



### Example
```kotlin
// Import classes:
//import me.meeco.holder.wallet.infrastructure.*
//import me.meeco.holder.wallet.models.*

val apiInstance = VerifiableCredentialIssuanceApi()
val walletId : kotlin.String = walletId_example // kotlin.String | 
val state : kotlin.String = state_example // kotlin.String | 
try {
    val result : CredentialReceiveStateModelDto = apiInstance.receiveControllerGetInfo(walletId, state)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling VerifiableCredentialIssuanceApi#receiveControllerGetInfo")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling VerifiableCredentialIssuanceApi#receiveControllerGetInfo")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **walletId** | **kotlin.String**|  |
 **state** | **kotlin.String**|  |

### Return type

[**CredentialReceiveStateModelDto**](CredentialReceiveStateModelDto.md)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

