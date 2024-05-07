
# PresentationStateResponseDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**authorizationRequestUri** | **kotlin.String** |  |  [optional]
**clientId** | **kotlin.String** |  |  [optional]
**meta** | [**PresentationStateResponseDtoMeta**](PresentationStateResponseDtoMeta.md) |  |  [optional]
**nonce** | **kotlin.String** | Nonce provided by the verifier to be returned in the response |  [optional]
**presentationDefinition** | [**PresentationDefinition**](PresentationDefinition.md) |  |  [optional]
**redirectUri** | **kotlin.String** |  |  [optional]
**responseMode** | [**inline**](#ResponseMode) | Parameter to ask the Wallet to send the response to the verifier. Possible values are &#39;direct_post&#39; |  [optional]
**responseType** | [**inline**](#ResponseType) | Response type of the request. Possible values are &#x60;vp_token&#x60;, &#x60;id_token&#x60; |  [optional]
**responseUri** | **kotlin.String** | Response uri of the request. Only relevant if response type is &#x60;direct_post&#x60; |  [optional]
**state** | **kotlin.String** |  |  [optional]
**verifierState** | **kotlin.String** | State provided by the verifier to be returned in the response |  [optional]


<a id="ResponseMode"></a>
## Enum: response_mode
Name | Value
---- | -----
responseMode | direct_post


<a id="ResponseType"></a>
## Enum: response_type
Name | Value
---- | -----
responseType | vp_token, vp_token id_token



