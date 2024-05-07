
# PresentationRequestSubmitResponseModelDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**meta** | [**PresentationRequestSetCredentialsResponseModelDtoMeta**](PresentationRequestSetCredentialsResponseModelDtoMeta.md) |  |  [optional]
**redirectUri** | **kotlin.String** | Redirect URI to follow on the frontend.  In case of response_mode &#x60;fragment&#x60;, this contains the Authorization Response attributes and this is how they are passed to the verifier.  In case of response_mode &#x60;direct_post&#x60;, this is the URI that was returned after successfully posting the Authorization Response to the &#x60;response_uri&#x60; of the verifier.  |  [optional]
**state** | **kotlin.String** |  |  [optional]



