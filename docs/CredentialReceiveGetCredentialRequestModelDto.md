
# CredentialReceiveGetCredentialRequestModelDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accessToken** | **kotlin.String** |  |  [optional]
**credentialDefinition** | [**CredentialReceiveGetAccessTokenRequestModelDtoAuthorizationDetailsInnerCredentialDefinition**](CredentialReceiveGetAccessTokenRequestModelDtoAuthorizationDetailsInnerCredentialDefinition.md) |  |  [optional]
**did** | **kotlin.String** |  |  [optional]
**format** | [**inline**](#Format) |  |  [optional]
**kid** | **kotlin.String** |  |  [optional]
**state** | **kotlin.String** |  |  [optional]
**transactionId** | **kotlin.String** | A string identifying a Deferred Issuance transaction. This claim is contained in the response if the Credential Issuer was unable to immediately issue the Credential |  [optional]


<a id="Format"></a>
## Enum: format
Name | Value
---- | -----
format | vc+sd-jwt, jwt_vc_json



