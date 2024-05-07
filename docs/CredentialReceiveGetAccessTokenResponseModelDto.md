
# CredentialReceiveGetAccessTokenResponseModelDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accessToken** | **kotlin.String** |  |  [optional]
**authorizationUrl** | **kotlin.String** | The URL to open in a browser in order to complete the authorization with the Authorization Server. |  [optional]
**cNonce** | **kotlin.String** | String containing a nonce to be used to create a proof of possession of key material when requesting a Credential |  [optional]
**cNonceExpiresIn** | **kotlin.Int** | Number denoting the lifetime in seconds of the c_nonce. |  [optional]
**credentialDefinition** | [**CredentialReceiveGetAccessTokenRequestModelDtoAuthorizationDetailsInnerCredentialDefinition**](CredentialReceiveGetAccessTokenRequestModelDtoAuthorizationDetailsInnerCredentialDefinition.md) |  |  [optional]
**clientId** | **kotlin.String** | Client identifier in OAuth 2.0 |  [optional]
**refreshToken** | **kotlin.String** |  |  [optional]
**state** | **kotlin.String** |  |  [optional]



