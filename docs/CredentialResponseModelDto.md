
# CredentialResponseModelDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**credential** | **kotlin.String** | The encoded string representation of the credential. | 
**format** | [**inline**](#Format) | Format of the credential. | 
**id** | **kotlin.String** | A unique identifier of the credential. | 
**createdAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | The date and time when the credential was added to a Wallet. |  [optional]
**meta** | [**CredentialResponseModelDtoMeta**](CredentialResponseModelDtoMeta.md) |  |  [optional]


<a id="Format"></a>
## Enum: format
Name | Value
---- | -----
format | vc+sd-jwt, jwt_vc_json



