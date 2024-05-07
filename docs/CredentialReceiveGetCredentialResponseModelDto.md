
# CredentialReceiveGetCredentialResponseModelDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**state** | **kotlin.String** |  | 
**cNonce** | **kotlin.String** | String containing a nonce to be used to create a proof of possession of key material when requesting a Credential |  [optional]
**cNonceExpiresIn** | **kotlin.Int** | Number denoting the lifetime in seconds of the c_nonce. |  [optional]
**credential** | **kotlin.String** | Contains issued Credential. MUST be present when transaction_id is not returned. MAY be a string or an object, depending on the Credential format. See Appendix E for the Credential format specific encoding requirements. |  [optional]
**credentialId** | **kotlin.String** | Id under which the credential is stored in the wallet |  [optional]
**transactionId** | **kotlin.String** | A string identifying a Deferred Issuance transaction. This claim is contained in the response if the Credential Issuer was unable to immediately issue the Credential |  [optional]



