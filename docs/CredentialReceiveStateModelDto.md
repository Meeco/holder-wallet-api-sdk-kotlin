
# CredentialReceiveStateModelDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accessToken** | **kotlin.String** |  |  [optional]
**authorizationUrl** | **kotlin.String** | The URL to open in a browser in order to complete the authorization with the Authorization Server. |  [optional]
**cNonce** | **kotlin.String** | String containing a nonce to be used to create a proof of possession of key material when requesting a Credential |  [optional]
**cNonceExpiresIn** | **kotlin.Int** | Number denoting the lifetime in seconds of the c_nonce. |  [optional]
**clientId** | **kotlin.String** | Client identifier in OAuth 2.0 |  [optional]
**credentialId** | **kotlin.String** | Id under which the credential is stored in the wallet |  [optional]
**credentialsIds** | **kotlin.collections.List&lt;kotlin.String&gt;** |  |  [optional]
**proof** | [**CredentialReceiveStateModelDtoProof**](CredentialReceiveStateModelDtoProof.md) |  |  [optional]
**credentialDefinition** | [**CredentialReceiveGetAccessTokenRequestModelDtoAuthorizationDetailsInnerCredentialDefinition**](CredentialReceiveGetAccessTokenRequestModelDtoAuthorizationDetailsInnerCredentialDefinition.md) |  |  [optional]
**credentialEndpoint** | **kotlin.String** | Credential Issuer credential endpoint called |  [optional]
**credentialOffer** | [**CredentialOfferDto**](CredentialOfferDto.md) |  |  [optional]
**credentialOfferUri** | **kotlin.String** |  |  [optional]
**did** | **kotlin.String** |  |  [optional]
**format** | [**inline**](#Format) |  |  [optional]
**kid** | **kotlin.String** |  |  [optional]
**refreshToken** | **kotlin.String** |  |  [optional]
**responseType** | [**inline**](#ResponseType) | This value is always &#x60;code&#x60; |  [optional]
**state** | **kotlin.String** |  |  [optional]
**tokenEndpoint** | **kotlin.String** | Credential Issuer or Authorization Server token endpoint called |  [optional]
**transactionId** | **kotlin.String** | A string identifying a Deferred Issuance transaction. This claim is contained in the response if the Credential Issuer was unable to immediately issue the Credential |  [optional]


<a id="Format"></a>
## Enum: format
Name | Value
---- | -----
format | vc+sd-jwt, jwt_vc_json


<a id="ResponseType"></a>
## Enum: response_type
Name | Value
---- | -----
responseType | code



