# VerifiablePresentationApi

All URIs are relative to *https://holder-wallet-dev.svx.internal*

Method | HTTP request | Description
------------- | ------------- | -------------
[**presentationControllerCreate**](VerifiablePresentationApi.md#presentationControllerCreate) | **POST** /wallets/{walletId}/send | Register authorization request
[**presentationControllerFindAll**](VerifiablePresentationApi.md#presentationControllerFindAll) | **GET** /wallets/{walletId}/send | Get presentation states
[**sendControllerDeleteOne**](VerifiablePresentationApi.md#sendControllerDeleteOne) | **DELETE** /wallets/{walletId}/send/{state} | Delete Verifiable Presentation State by ID
[**sendControllerFindOne**](VerifiablePresentationApi.md#sendControllerFindOne) | **GET** /wallets/{walletId}/send/{state} | Get present credential state
[**sendControllerSetCredentials**](VerifiablePresentationApi.md#sendControllerSetCredentials) | **POST** /wallets/{walletId}/send/set_credentials | Set the credentials to be presented
[**sendControllerSubmit**](VerifiablePresentationApi.md#sendControllerSubmit) | **POST** /wallets/{walletId}/send/submit | Submit the presentation response to the verifier


<a id="presentationControllerCreate"></a>
# **presentationControllerCreate**
> AuthorizationRequestResponseDto presentationControllerCreate(walletId, presentationRequestSendRequestModelDto)

Register authorization request

Parse the authorization request URI and get the following information.  - &#x60;client_id&#x60;: The Client ID of the verifier. - &#x60;client_id_scheme&#x60;: The Client ID scheme of the verifier. - &#x60;client_metadata&#x60;: Verifier client metadata. - &#x60;nonce&#x60;: Nonce provided by the verifier to be returned in the response - &#x60;presentation_definition&#x60;: What credentials the verifier is requesting from the Wallet. - &#x60;redirect_uri&#x60;: The redirect URI of the verifier. - &#x60;response_mode&#x60;: How to return the response. - &#x60;response_type&#x60;: Which parameters to use to return the presentation to the verifier. - &#x60;response_uri&#x60;: Where to send the response. - &#x60;verifier_state&#x60;: State passed by the verifier to link request and response. - &#x60;meta.protocol_version&#x60;: Version of the protocol to be used. Supported values &#x60;draft10&#x60; and &#x60;draft18&#x60;. The default value is &#x60;draft10&#x60;.  This information informs the Wallet how to process the request and respond to the verifier.  ## Request Parameters  The following sections describe in more detail the parameters, their default values and behaviour.  ### client_id (required)  Depending on the &#x60;client_id_scheme&#x60; the Client ID is either the &#x60;client_id&#x60;, the &#x60;redirect_uri&#x60; or the &#x60;did&#x60; of the verifier.  ### client_id_scheme  The mechanism to obtain and validate metadata of a verifier beyond that specified in RFC6749.  Currently supported values are: - &#x60;pre-registered&#x60; (default): The verifier is pre-registered with the SVX Platform. - &#x60;redirect_uri&#x60;: The redirect URI is the identifier of the verifier. Note that in this case the request MUST NOT be signed. - &#x60;did&#x60;: The DID is the identifier of the verifier. Note that in this case the request MUST be signed with a &#x60;verificationMethod&#x60; property in the DID document. This also requires that verifier metadata is passed using &#x60;client_metadata&#x60; or &#x60;client_metadata_uri&#x60;.  ### client_metadata (required)  Client metadata, also called verifier metadata in this case can be implemented using static configuration values, as well as employ Dynamic Discovery.  The static configuration is usually bound to an existing profile, for example.  - [JWT VC Presentation Profile](https://identity.foundation/jwt-vc-presentation-profile/) - [HAIP](https://openid.net/specs/openid4vc-high-assurance-interoperability-profile-sd-jwt-vc-1_0-00.html)  They use specific, custom URL schemes such as &#x60;openid-vc&#x60; or &#x60;haip&#x60;. When these are used, values referred to in these profiles should be used as client metadata.  Each network can define their own set of static configuration values for client metadata.  The use of fedarations or trust schemes is not yet supported.  ### nonce  Nonce to be returned in the response to prevent replay attacks.  ### presentation_definition (required)  Expresses which credentials a verifier asks a wallet to present. The syntax to do this should conform to DIF Presentation Exchange specification. The structure of the definition is validated by a JSON schema associated with the &#x60;presentation_definition&#x60; schema in the OpenAPI definition.  It is also possible to use &#x60;presentation_definition_uri&#x60;. In this case the wallet performs a GET request to the &#x60;presentation_definition_uri&#x60; and parses the response. The response is stored in the &#x60;presentation_definition&#x60; attribute.  Note that the service does not necessarily support all options defined in the Presentation Exchange specification.  ### response_mode  How the response is sent to the verifier. Possible values are  - &#x60;direct_post&#x60;: In this mode, the Authorization Response is sent to the Verifier using an HTTPS POST request to an endpoint controlled by the Verifier. The Authorization Response parameters are encoded in the body using the application/x-www-form-urlencoded content type.  When using &#x60;direct_post&#x60;, note that the &#x60;redirect_uri&#x60; must be returned after successfully posting the Authorization Response to the &#x60;response_uri&#x60;.  Note that &#x60;fragment&#x60; is currently not supported.  ### response_uri  If the &#x60;response_mode&#x60; is &#x60;direct_post&#x60; this is the URI to send the response to.  ### verifier_state  Opaque state that can be used to link the request and response. Is returned as the &#x60;state&#x60; parameter in the Authorization Response.  ## Use of JAR (RFC9101)  JAR (RFC9101) is a JWT representation of the request. The JWT is signed with the verifier&#39;s private key. There are two ways to do this.  - &#x60;request&#x60;: The &#x60;request&#x60; parameter is the JWT representation of the request. - &#x60;request_uri&#x60;: The &#x60;request_uri&#x60; parameter is the URL of the request.  In most cases &#x60;request_uri&#x60; is used instead of &#x60;request&#x60; as it is more convenient, especially in situations when a QR code is used to represent the authorization request.  The JAR contains the necessary information and is fetched, verified and subsequently parsed. See the previous section for more details.  ## Examples  Below are some examples of valid authorization requests and how they are parsed.  &#x60;&#x60;&#x60; openid-vc://?request_uri&#x3D;https://example.com/oidc/presentations/requests/c63aa3e9-dc7d-4753-9ac8-30bf7add6e4c/jwt&amp;client_id&#x3D;https://example.com/cb &#x60;&#x60;&#x60;  This is an example where JAR is used. First, the &#x60;request_uri&#x60; is used to fetch the request JWT. The JWT is validated and then parsed. The parsed request is stored in the &#x60;metadata.request&#x60; attribute. All the required information, except for the &#x60;client_id&#x60; is fetched from the JWT, validated and stored. 

### Example
```kotlin
// Import classes:
//import me.meeco.holder.wallet.infrastructure.*
//import me.meeco.holder.wallet.models.*

val apiInstance = VerifiablePresentationApi()
val walletId : kotlin.String = walletId_example // kotlin.String | 
val presentationRequestSendRequestModelDto : PresentationRequestSendRequestModelDto =  // PresentationRequestSendRequestModelDto | 
try {
    val result : AuthorizationRequestResponseDto = apiInstance.presentationControllerCreate(walletId, presentationRequestSendRequestModelDto)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling VerifiablePresentationApi#presentationControllerCreate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling VerifiablePresentationApi#presentationControllerCreate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **walletId** | **kotlin.String**|  |
 **presentationRequestSendRequestModelDto** | [**PresentationRequestSendRequestModelDto**](PresentationRequestSendRequestModelDto.md)|  |

### Return type

[**AuthorizationRequestResponseDto**](AuthorizationRequestResponseDto.md)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="presentationControllerFindAll"></a>
# **presentationControllerFindAll**
> PresentationStatesResponseDto presentationControllerFindAll(walletId, order, orderBy, perPage, page)

Get presentation states



### Example
```kotlin
// Import classes:
//import me.meeco.holder.wallet.infrastructure.*
//import me.meeco.holder.wallet.models.*

val apiInstance = VerifiablePresentationApi()
val walletId : kotlin.String = walletId_example // kotlin.String | 
val order : kotlin.String = DESC // kotlin.String | Presentation States response order. Default ordering: `DESC` (Supported: `ASC`, `DESC`)
val orderBy : kotlin.String = created_at // kotlin.String | Order Presentation States by an attribute, defaults to: `created_at` (Supported: `created_at`)
val perPage : kotlin.Any = 10 // kotlin.Any | Number of records per page
val page : kotlin.Any = 1 // kotlin.Any | Page number (starting from 1)
try {
    val result : PresentationStatesResponseDto = apiInstance.presentationControllerFindAll(walletId, order, orderBy, perPage, page)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling VerifiablePresentationApi#presentationControllerFindAll")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling VerifiablePresentationApi#presentationControllerFindAll")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **walletId** | **kotlin.String**|  |
 **order** | **kotlin.String**| Presentation States response order. Default ordering: &#x60;DESC&#x60; (Supported: &#x60;ASC&#x60;, &#x60;DESC&#x60;) | [optional] [enum: ASC, DESC]
 **orderBy** | **kotlin.String**| Order Presentation States by an attribute, defaults to: &#x60;created_at&#x60; (Supported: &#x60;created_at&#x60;) | [optional] [enum: created_at]
 **perPage** | [**kotlin.Any**](.md)| Number of records per page | [optional]
 **page** | [**kotlin.Any**](.md)| Page number (starting from 1) | [optional]

### Return type

[**PresentationStatesResponseDto**](PresentationStatesResponseDto.md)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="sendControllerDeleteOne"></a>
# **sendControllerDeleteOne**
> sendControllerDeleteOne(walletId, state)

Delete Verifiable Presentation State by ID

Delete state of a presentation flow

### Example
```kotlin
// Import classes:
//import me.meeco.holder.wallet.infrastructure.*
//import me.meeco.holder.wallet.models.*

val apiInstance = VerifiablePresentationApi()
val walletId : kotlin.String = walletId_example // kotlin.String | 
val state : kotlin.String = state_example // kotlin.String | 
try {
    apiInstance.sendControllerDeleteOne(walletId, state)
} catch (e: ClientException) {
    println("4xx response calling VerifiablePresentationApi#sendControllerDeleteOne")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling VerifiablePresentationApi#sendControllerDeleteOne")
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

<a id="sendControllerFindOne"></a>
# **sendControllerFindOne**
> PresentationStateResponseDto sendControllerFindOne(walletId, state)

Get present credential state



### Example
```kotlin
// Import classes:
//import me.meeco.holder.wallet.infrastructure.*
//import me.meeco.holder.wallet.models.*

val apiInstance = VerifiablePresentationApi()
val walletId : kotlin.String = walletId_example // kotlin.String | 
val state : kotlin.String = state_example // kotlin.String | 
try {
    val result : PresentationStateResponseDto = apiInstance.sendControllerFindOne(walletId, state)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling VerifiablePresentationApi#sendControllerFindOne")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling VerifiablePresentationApi#sendControllerFindOne")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **walletId** | **kotlin.String**|  |
 **state** | **kotlin.String**|  |

### Return type

[**PresentationStateResponseDto**](PresentationStateResponseDto.md)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="sendControllerSetCredentials"></a>
# **sendControllerSetCredentials**
> PresentationRequestSetCredentialsResponseModelDto sendControllerSetCredentials(walletId, presentationRequestSetCredentialsRequestModelDto)

Set the credentials to be presented

Set the credentials to be presented as part of this presentation response.  Each credential must be linked to an input descriptor from the credential definition. For credentials that support selective disclosure, there is the possibility to use the &#x60;claims_to_disclose&#x60; property. Use object notation to specify which claims to disclose. For example:  &#x60;&#x60;&#x60; \&quot;claims_to_disclose\&quot;: [\&quot;given_name\&quot;, \&quot;address.street_address\&quot;, \&quot;address.locality\&quot;, \&quot;nationalities[0]\&quot;] &#x60;&#x60;&#x60;  If a claim or a nested claim is not found in the credential or it doesn&#39;t support selective disclosure, it will be ignored.  By default, the key ID linked to the credential is used to sign the presentation. The &#x60;kid&#x60; property can be used to specify another key ID. If no key ID is linked to the credential and none is specified, no signature is added to the presentation. 

### Example
```kotlin
// Import classes:
//import me.meeco.holder.wallet.infrastructure.*
//import me.meeco.holder.wallet.models.*

val apiInstance = VerifiablePresentationApi()
val walletId : kotlin.String = walletId_example // kotlin.String | 
val presentationRequestSetCredentialsRequestModelDto : PresentationRequestSetCredentialsRequestModelDto =  // PresentationRequestSetCredentialsRequestModelDto | 
try {
    val result : PresentationRequestSetCredentialsResponseModelDto = apiInstance.sendControllerSetCredentials(walletId, presentationRequestSetCredentialsRequestModelDto)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling VerifiablePresentationApi#sendControllerSetCredentials")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling VerifiablePresentationApi#sendControllerSetCredentials")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **walletId** | **kotlin.String**|  |
 **presentationRequestSetCredentialsRequestModelDto** | [**PresentationRequestSetCredentialsRequestModelDto**](PresentationRequestSetCredentialsRequestModelDto.md)|  |

### Return type

[**PresentationRequestSetCredentialsResponseModelDto**](PresentationRequestSetCredentialsResponseModelDto.md)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="sendControllerSubmit"></a>
# **sendControllerSubmit**
> PresentationRequestSubmitResponseModelDto sendControllerSubmit(walletId, presentationRequestSubmitRequestModelDto)

Submit the presentation response to the verifier

Generate the presentation response to present the credentials to the verifier.  Based on the &#x60;response_type&#x60;, the following parameters are included in the response:  The response always includes: - &#x60;vp_token&#x60;: A single JSON string or array of JSON strings representing the presentation. - &#x60;presentation_submission&#x60;: A JSON object containing the mapping between the requested credentials and where to find them in the returned VP token. This follows the DIF Presentation Exchange specification.  Optionally, the following is also included: - &#x60;id_token&#x60;: A single JSON string that proves control of the wallet over key material.  Depending on the &#x60;response_mode&#x60; option, the response can be sent to the verifier using an HTTPS POST request or an HTTP redirect.  In case of &#x60;response_mode&#x3D;fragment&#x60; (default), the response is sent via the front channel by opening the &#x60;redirect_uri&#x60;, which is returned in the response to this request. This &#x60;redirect_uri&#x60; includes all the response parameters. Note that this is currently not supported.  In case of &#x60;response_mode&#x3D;direct_post&#x60; or &#x60;response_mode&#x3D;post&#x60;, the response is submitted via an HTTPS POST request to the &#x60;response_uri&#x60;. In this case, it is expected that a &#x60;redirect_uri&#x60; is returned in the response to this request. This &#x60;redirect_uri&#x60; is also to be opened in the front channel, but is simply used to continue the verification process and not to transmit the response to the verifier.  The status of this submission can be tracked via the &#x60;meta.submission_status&#x60; attribute. Note that in case of &#x60;response_mode&#x3D;fragment&#x60;, the status is always &#x60;success&#x60;. 

### Example
```kotlin
// Import classes:
//import me.meeco.holder.wallet.infrastructure.*
//import me.meeco.holder.wallet.models.*

val apiInstance = VerifiablePresentationApi()
val walletId : kotlin.String = walletId_example // kotlin.String | 
val presentationRequestSubmitRequestModelDto : PresentationRequestSubmitRequestModelDto =  // PresentationRequestSubmitRequestModelDto | 
try {
    val result : PresentationRequestSubmitResponseModelDto = apiInstance.sendControllerSubmit(walletId, presentationRequestSubmitRequestModelDto)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling VerifiablePresentationApi#sendControllerSubmit")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling VerifiablePresentationApi#sendControllerSubmit")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **walletId** | **kotlin.String**|  |
 **presentationRequestSubmitRequestModelDto** | [**PresentationRequestSubmitRequestModelDto**](PresentationRequestSubmitRequestModelDto.md)|  |

### Return type

[**PresentationRequestSubmitResponseModelDto**](PresentationRequestSubmitResponseModelDto.md)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

