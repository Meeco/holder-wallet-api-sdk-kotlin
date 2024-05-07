
# CredentialReceiveGetAccessTokenRequestModelDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**authorizationCode** | **kotlin.String** | code claimed via authorization code flow. It can to be exchanged for the access token. |  [optional]
**authorizationDetails** | [**kotlin.collections.List&lt;CredentialReceiveGetAccessTokenRequestModelDtoAuthorizationDetailsInner&gt;**](CredentialReceiveGetAccessTokenRequestModelDtoAuthorizationDetailsInner.md) | Contains details about the credentials the Wallet wants to obtain. |  [optional]
**clientId** | **kotlin.String** | Client identifier in OAuth 2.0 |  [optional]
**clientSecret** | **kotlin.String** |  |  [optional]
**codeChallenge** | **kotlin.String** | Part of PKCE, used when calling the authorization endpoint. |  [optional]
**codeChallengeMethod** | **kotlin.String** | Part of PKCE, used when calling the authorization endpoint. |  [optional]
**codeVerifier** | **kotlin.String** | Part of PKCE, used when calling the token endpoint, together with the authorization code |  [optional]
**credentialIssuer** | **kotlin.String** | The URL of the Credential Issuer from which the Wallet is requested to obtain one or more Credentials. The authorization server is determined based on the Credential Issuer Metadata. |  [optional]
**grantType** | [**inline**](#GrantType) |  |  [optional]
**issuerState** | **kotlin.String** | String value identifying a certain processing context at the Credential Issuer. This value is typically provided in the credential offer. When it is, the Wallet MUST send the value back to the Credential Issuer. |  [optional]
**preAuthorizedCode** | **kotlin.String** | The code representing the authorization to obtain Credentials of a certain type. This parameter MUST be present if the grant_type is urn:ietf:params:oauth:grant-type:pre-authorized_code. Typically provided by the Credential Issuer in the credential offer. |  [optional]
**redirectUri** | **kotlin.String** | Only relevant when the grant_type is authorization_code. |  [optional]
**scope** | **kotlin.String** | Request credentials using OAuth 2.0 scope parameter |  [optional]
**state** | **kotlin.String** |  |  [optional]
**txCode** | **kotlin.String** | String value containing a Transaction Code. This value MUST be present if a tx_code object was present in the Credential Offer (including if the object was empty).  This parameter MUST only be used if the grant_type is urn:ietf:params:oauth:grant-type:pre-authorized_code. |  [optional]


<a id="GrantType"></a>
## Enum: grant_type
Name | Value
---- | -----
grantType | authorization_code, urn:ietf:params:oauth:grant-type:pre-authorized_code



