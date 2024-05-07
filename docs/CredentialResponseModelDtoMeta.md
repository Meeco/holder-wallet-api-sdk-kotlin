
# CredentialResponseModelDtoMeta

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**claims** | [**kotlin.Any**](.md) |  |  [optional]
**credentialDefinition** | [**CredentialDefinition**](CredentialDefinition.md) | Object containing the detailed description of the credential type of the W3C VC Data Model.  Snapshot from Credential Issuer Metadata taken at the time of issuance. See Appendix A.1.1.2 in OpenID for Verifiable Credential Issuance for more information.  |  [optional]
**did** | **kotlin.String** | A DID managed by the wallet used to perform credential key binding. |  [optional]
**display** | [**kotlin.collections.List&lt;CredentialDisplayObjectInner&gt;**](CredentialDisplayObjectInner.md) |  |  [optional]
**issuerDisplay** | [**kotlin.collections.List&lt;IssuerDisplayObjectInner&gt;**](IssuerDisplayObjectInner.md) |  |  [optional]
**kid** | **kotlin.String** | An ID for a key managed by the wallet used to perform credential key binding. |  [optional]
**vct** | **kotlin.String** | The Credential type of the SD-JWT VC.  Snapshot from Credential Issuer Metadata taken at the time of issuance. See Appendix A.2.2 in OpenID for Verifiable Credential Issuance for more information.  |  [optional]



