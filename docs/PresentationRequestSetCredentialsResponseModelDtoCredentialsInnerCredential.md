
# PresentationRequestSetCredentialsResponseModelDtoCredentialsInnerCredential

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**claimsToDisclose** | **kotlin.collections.List&lt;kotlin.String&gt;** | List of claims to disclose when presenting the credential. When a claim is nested, use object notation.  Examples: &#x60;given_name&#x60;, &#x60;address.street&#x60; or &#x60;nationality.country[0]&#x60;  |  [optional]
**id** | **kotlin.String** |  |  [optional]
**kid** | **kotlin.String** | Key to use for signing the presentation of the credential. If no key is specified, the key linked to the credential is used. If no key is linked to the credential, no signature is added to the presentation. |  [optional]



