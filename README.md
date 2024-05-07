# me.meeco.holder.wallet - Kotlin client library for Holder Wallet API

The Holder Wallet API (the service) provides an interface for managing (personal) digital wallets inside an SVX tenant environment. It facilitates a range of operations including key management, DID management, and credential issuance (receiving) and credential presentation (presenting). The goal is to provide flexibility on how the component is integrated, be it with a mobile or web application, or with a third party service.

All cryptographic keys are managed by the service (often referred to as custodial key management) in a secure manner and can be used to control identifers (i.e. DIDs), as well as perform key binding in credentials.

The service facilitates receiving and presenting credentials in accordance to leading standards and specifications in the space. The main focus is on the family of OpenID4VC standards, JWT based credential formats and (optionally) DIDs.

One instance of the service is able to manage multiple wallets, each of which is a collection of keys, DIDs and associated credentials. This service operates in a trusted environment where its client applications are expected to be trusted as well.

## Wallet Management

It is possible to identify a wallet using an external identifier that matches the client application's user identifier. When providing an external identifier to the create wallet operation, it first searches if an existing wallet exists and returns a reference instead of creating a new instance.

## Key Management

Keys to perform various cryptographic operations are managed within the service and private keys never leave the service.

The following operations are supported:

- Create a new key
- Delete an existing key
- Get a key
- Import an existing key
- Sign
- Sign JWT
- Encrypt JWE
- Decrypt JWE

The service supports the following algorithms as defined in RFC7518:

- ES256

Keys are stored currently stored in a DB (e.g. Postgres). We plan to add integration with HSM services in the future.

## DID Management

Each wallet is able to manage one or more DIDs. The supported DID methods can be found [here](https://docs.meeco.me/guides/api-guides/dids/did-methods). A DID is typically used as a key binding mechanism in a verifiable credential. The key binding takes place in the issuance process and proof is provided during the presentation process.

## Credential Management

The wallet supports the following credential life cycle operations:

- Receive a credential
- Present a credential
- Import an existing credential

Receiving a credential from an issuer typically involves key binding, which is a process where the service provides a public key or DID to the issuer alongside proof that is controls the key material. When this is completed, the credential, signed by the issuer, is stored in the wallet with a reference to the `kid`.
Presenting a credential to a verifier involves sending the credential, alongside proof of the key binding, to the verifier.

Note that not all credential formats are supported. Please refer to the section on Supported Standards for more information on the different formats that are currently supported.

## SVX Integration

The service is integrated with SVX Platform, which provides a range of services, including:

- DID operations (create, get)
- Credential operations (verify)
- Secure data storage (store credentials)

All wallets belong to one tenant and receive a DID from the SVX Platform where they are registered as end-users. The DID is used to identify the wallet in the SVX Platform.

Every wallet instance uses its registered DID to authenticate with the SVX Platform. This enables the service to perform operations and store data for each user in its own context. For performance reasons, access tokens are cached for a limited amount of time (this can be configured).

## Supported Standards and Specifications

The Wallet provides support for a variety of specifications and standards with the aim of achieving interoperablity with the wider ecosystem. What follows is a list of the supported specifications and standards grouped per logical domain.

**Cryptographic Keys**

- `JWK`: [RFC7517](https://datatracker.ietf.org/doc/html/rfc7517)
- `JWA`: [RFC7518](https://datatracker.ietf.org/doc/html/rfc7518)
- `JWE`: [RFC7516](https://datatracker.ietf.org/doc/html/rfc7516)
- `JOSE`: [JOSE IANA registry](https://www.iana.org/assignments/jose/jose.xhtml)

**Credential formats**:

- `jwt_vc_json`: [W3C Verifiable Credentials](https://www.w3.org/TR/vc-data-model/)
- `vc+sd-jwt`: [IETF SD-JWT VC](https://datatracker.ietf.org/doc/draft-ietf-oauth-sd-jwt-vc/)

**Key Discovery**

- `/.well-known/jwt-vc-issuer` (IETF SD-JWT VC)

**Credential issuance**:

- OpenID 4 Verifiable Credential Issuance (draft 13) [(WG Draft)](https://openid.net/specs/openid-4-verifiable-credential-issuance-1_0.html) [(Editors Draft)](https://openid.github.io/OpenID4VCI/openid-4-verifiable-credential-issuance-wg-draft.html)
  - Pre-Authorized Code flow
  - Authorization Code flow
- [RFC9126 Pushed Authorization Request](https://www.rfc-editor.org/info/rfc9126)

**Credential Presentation**

- OpenID 4 Verifiable Presentation [(WG Draft)](https://openid.net/specs/openid-4-verifiable-presentations-1_0.html)

## Authentication and Authorization

The service doesn't provide authentication or authorization out-of-the-box. It is up to the client to provide this and the service as such is expected to run inside a secure environment and not directly exposed to the outside world.

A few examples of how the service can be deployed are:

- Behind an API gateway (e.g. AWS API Gateway, Azure API Management, Krakend)
- Behind a Backend For Frontend service facing the outside world

## Deployment

The service can be deployed on-premises or in a cloud environment. It relies on following services:

- Postgres (application database; keys, dids, credential metadata)
- SVX API
- Redis (access tokens)


## Overview
This API client was generated by the [OpenAPI Generator](https://openapi-generator.tech) project.  By using the [openapi-spec](https://github.com/OAI/OpenAPI-Specification) from a remote server, you can easily generate an API client.

- API version: 4.1.0
- Package version: 
- Build package: org.openapitools.codegen.languages.KotlinClientCodegen

## Requires

* Kotlin 1.7.21
* Gradle 7.5

## Build

First, create the gradle wrapper script:

```
gradle wrapper
```

Then, run:

```
./gradlew check assemble
```

This runs all tests and packages the library.

## Features/Implementation Notes

* Supports JSON inputs/outputs, File inputs, and Form inputs.
* Supports collection formats for query parameters: csv, tsv, ssv, pipes.
* Some Kotlin and Java types are fully qualified to avoid conflicts with types defined in OpenAPI definitions.
* Implementation of ApiClient is intended to reduce method counts, specifically to benefit Android targets.

<a id="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to *https://holder-wallet-dev.svx.internal*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DIDManagementApi* | [**didControllerCreate**](docs/DIDManagementApi.md#didcontrollercreate) | **POST** /wallets/{walletId}/dids | Create a DID for a Wallet
*DIDManagementApi* | [**didControllerDelete**](docs/DIDManagementApi.md#didcontrollerdelete) | **DELETE** /wallets/{walletId}/dids/{id} | Delete a DID from a Wallet
*KeyManagementApi* | [**keyControllerImport**](docs/KeyManagementApi.md#keycontrollerimport) | **POST** /wallets/{walletId}/keys/import | Import a key to a Wallet
*KeyManagementApi* | [**keyControllerSign**](docs/KeyManagementApi.md#keycontrollersign) | **POST** /wallets/{walletId}/keys/{keyId}/sign | Sign data with a key from a wallet
*KeyManagementApi* | [**keysControllerCreate**](docs/KeyManagementApi.md#keyscontrollercreate) | **POST** /wallets/{walletId}/keys | Create a key for a Wallet
*KeyManagementApi* | [**keysControllerDelete**](docs/KeyManagementApi.md#keyscontrollerdelete) | **DELETE** /wallets/{walletId}/keys/{keyId} | Delete a key from a Wallet
*KeyManagementApi* | [**keysControllerGet**](docs/KeyManagementApi.md#keyscontrollerget) | **GET** /wallets/{walletId}/keys/{keyId} | Get a key for a Wallet
*MonitoringApi* | [**appControllerGetSystemStatus**](docs/MonitoringApi.md#appcontrollergetsystemstatus) | **GET** /system/status | Get deployed service status information
*MonitoringApi* | [**appControllerGetVersion**](docs/MonitoringApi.md#appcontrollergetversion) | **GET** /version | Get deployed service version information
*SystemMetricsApi* | [**systemMetricsControllerGetWalletCounts**](docs/SystemMetricsApi.md#systemmetricscontrollergetwalletcounts) | **GET** /system/metrics/wallets | Wallet metrics
*VerifiableCredentialApi* | [**credentialsControllerFindAll**](docs/VerifiableCredentialApi.md#credentialscontrollerfindall) | **GET** /wallets/{walletId}/credentials | Get credentials
*VerifiableCredentialApi* | [**credentialsControllerFindOne**](docs/VerifiableCredentialApi.md#credentialscontrollerfindone) | **GET** /wallets/{walletId}/credentials/{vcId} | Get credential by ID
*VerifiableCredentialApi* | [**credentialsControllerImport**](docs/VerifiableCredentialApi.md#credentialscontrollerimport) | **POST** /wallets/{walletId}/credentials/import | Import credential
*VerifiableCredentialApi* | [**credentialsControllerPatch**](docs/VerifiableCredentialApi.md#credentialscontrollerpatch) | **PATCH** /wallets/{walletId}/credentials/{vcId} | Patch credential by ID
*VerifiableCredentialApi* | [**credentialsControllerRemove**](docs/VerifiableCredentialApi.md#credentialscontrollerremove) | **DELETE** /wallets/{walletId}/credentials/{vcId} | Delete credential by ID
*VerifiableCredentialApi* | [**credentialsControllerVerify**](docs/VerifiableCredentialApi.md#credentialscontrollerverify) | **GET** /wallets/{walletId}/credentials/{vcId}/verify | Verify credential by ID
*VerifiableCredentialIssuanceApi* | [**receiveControllerCallback**](docs/VerifiableCredentialIssuanceApi.md#receivecontrollercallback) | **GET** /wallets/receive/callback | authorization_code flow Holder Wallet redirect uri 
*VerifiableCredentialIssuanceApi* | [**receiveControllerCreate**](docs/VerifiableCredentialIssuanceApi.md#receivecontrollercreate) | **POST** /wallets/{walletId}/receive | Register credential offer
*VerifiableCredentialIssuanceApi* | [**receiveControllerDeleteOne**](docs/VerifiableCredentialIssuanceApi.md#receivecontrollerdeleteone) | **DELETE** /wallets/{walletId}/receive/{state} | Delete receive credential state
*VerifiableCredentialIssuanceApi* | [**receiveControllerFindAll**](docs/VerifiableCredentialIssuanceApi.md#receivecontrollerfindall) | **GET** /wallets/{walletId}/receive | Get credential receive states
*VerifiableCredentialIssuanceApi* | [**receiveControllerGetAccessToken**](docs/VerifiableCredentialIssuanceApi.md#receivecontrollergetaccesstoken) | **POST** /wallets/{walletId}/receive/get_access_token | Get access token
*VerifiableCredentialIssuanceApi* | [**receiveControllerGetCredential**](docs/VerifiableCredentialIssuanceApi.md#receivecontrollergetcredential) | **POST** /wallets/{walletId}/receive/get_credential | Get verifiable credential
*VerifiableCredentialIssuanceApi* | [**receiveControllerGetInfo**](docs/VerifiableCredentialIssuanceApi.md#receivecontrollergetinfo) | **GET** /wallets/{walletId}/receive/{state} | Get credential receive state
*VerifiablePresentationApi* | [**presentationControllerCreate**](docs/VerifiablePresentationApi.md#presentationcontrollercreate) | **POST** /wallets/{walletId}/send | Register authorization request
*VerifiablePresentationApi* | [**presentationControllerFindAll**](docs/VerifiablePresentationApi.md#presentationcontrollerfindall) | **GET** /wallets/{walletId}/send | Get presentation states
*VerifiablePresentationApi* | [**sendControllerDeleteOne**](docs/VerifiablePresentationApi.md#sendcontrollerdeleteone) | **DELETE** /wallets/{walletId}/send/{state} | Delete Verifiable Presentation State by ID
*VerifiablePresentationApi* | [**sendControllerFindOne**](docs/VerifiablePresentationApi.md#sendcontrollerfindone) | **GET** /wallets/{walletId}/send/{state} | Get present credential state
*VerifiablePresentationApi* | [**sendControllerSetCredentials**](docs/VerifiablePresentationApi.md#sendcontrollersetcredentials) | **POST** /wallets/{walletId}/send/set_credentials | Set the credentials to be presented
*VerifiablePresentationApi* | [**sendControllerSubmit**](docs/VerifiablePresentationApi.md#sendcontrollersubmit) | **POST** /wallets/{walletId}/send/submit | Submit the presentation response to the verifier
*WalletApi* | [**walletsControllerCreate**](docs/WalletApi.md#walletscontrollercreate) | **POST** /wallets | Register or find a Wallet
*WalletApi* | [**walletsControllerDeleteOne**](docs/WalletApi.md#walletscontrollerdeleteone) | **DELETE** /wallets/{walletId} | Delete Wallet by ID
*WalletApi* | [**walletsControllerGetOne**](docs/WalletApi.md#walletscontrollergetone) | **GET** /wallets/{walletId} | Get Wallet by ID


<a id="documentation-for-models"></a>
## Documentation for Models

 - [me.meeco.holder.wallet.models.App](docs/App.md)
 - [me.meeco.holder.wallet.models.AppSignal](docs/AppSignal.md)
 - [me.meeco.holder.wallet.models.AuthorizationRequestNotFoundError](docs/AuthorizationRequestNotFoundError.md)
 - [me.meeco.holder.wallet.models.AuthorizationRequestResponseDto](docs/AuthorizationRequestResponseDto.md)
 - [me.meeco.holder.wallet.models.ClaimObjectValue](docs/ClaimObjectValue.md)
 - [me.meeco.holder.wallet.models.Component](docs/Component.md)
 - [me.meeco.holder.wallet.models.CreateDidError](docs/CreateDidError.md)
 - [me.meeco.holder.wallet.models.CreateWalletPayloadDto](docs/CreateWalletPayloadDto.md)
 - [me.meeco.holder.wallet.models.CredentialDefinition](docs/CredentialDefinition.md)
 - [me.meeco.holder.wallet.models.CredentialDisplayObjectInner](docs/CredentialDisplayObjectInner.md)
 - [me.meeco.holder.wallet.models.CredentialDisplayObjectInnerLogo](docs/CredentialDisplayObjectInnerLogo.md)
 - [me.meeco.holder.wallet.models.CredentialImportRequestModelDto](docs/CredentialImportRequestModelDto.md)
 - [me.meeco.holder.wallet.models.CredentialImportRequestModelDtoMeta](docs/CredentialImportRequestModelDtoMeta.md)
 - [me.meeco.holder.wallet.models.CredentialNotFoundError](docs/CredentialNotFoundError.md)
 - [me.meeco.holder.wallet.models.CredentialOfferDto](docs/CredentialOfferDto.md)
 - [me.meeco.holder.wallet.models.CredentialPatchRequestModelDto](docs/CredentialPatchRequestModelDto.md)
 - [me.meeco.holder.wallet.models.CredentialReceiveGetAccessTokenRequestModelDto](docs/CredentialReceiveGetAccessTokenRequestModelDto.md)
 - [me.meeco.holder.wallet.models.CredentialReceiveGetAccessTokenRequestModelDtoAuthorizationDetailsInner](docs/CredentialReceiveGetAccessTokenRequestModelDtoAuthorizationDetailsInner.md)
 - [me.meeco.holder.wallet.models.CredentialReceiveGetAccessTokenRequestModelDtoAuthorizationDetailsInnerCredentialDefinition](docs/CredentialReceiveGetAccessTokenRequestModelDtoAuthorizationDetailsInnerCredentialDefinition.md)
 - [me.meeco.holder.wallet.models.CredentialReceiveGetAccessTokenRequestModelDtoAuthorizationDetailsInnerCredentialDefinitionOneOf](docs/CredentialReceiveGetAccessTokenRequestModelDtoAuthorizationDetailsInnerCredentialDefinitionOneOf.md)
 - [me.meeco.holder.wallet.models.CredentialReceiveGetAccessTokenRequestModelDtoAuthorizationDetailsInnerCredentialDefinitionOneOf1](docs/CredentialReceiveGetAccessTokenRequestModelDtoAuthorizationDetailsInnerCredentialDefinitionOneOf1.md)
 - [me.meeco.holder.wallet.models.CredentialReceiveGetAccessTokenResponseModelDto](docs/CredentialReceiveGetAccessTokenResponseModelDto.md)
 - [me.meeco.holder.wallet.models.CredentialReceiveGetCredentialRequestModelDto](docs/CredentialReceiveGetCredentialRequestModelDto.md)
 - [me.meeco.holder.wallet.models.CredentialReceiveGetCredentialResponseModelDto](docs/CredentialReceiveGetCredentialResponseModelDto.md)
 - [me.meeco.holder.wallet.models.CredentialReceiveRequestModelDto](docs/CredentialReceiveRequestModelDto.md)
 - [me.meeco.holder.wallet.models.CredentialReceiveResponseModelDto](docs/CredentialReceiveResponseModelDto.md)
 - [me.meeco.holder.wallet.models.CredentialReceiveStateModelDto](docs/CredentialReceiveStateModelDto.md)
 - [me.meeco.holder.wallet.models.CredentialReceiveStateModelDtoProof](docs/CredentialReceiveStateModelDtoProof.md)
 - [me.meeco.holder.wallet.models.CredentialReceiveStatesModelDto](docs/CredentialReceiveStatesModelDto.md)
 - [me.meeco.holder.wallet.models.CredentialResponseDto](docs/CredentialResponseDto.md)
 - [me.meeco.holder.wallet.models.CredentialResponseModelDto](docs/CredentialResponseModelDto.md)
 - [me.meeco.holder.wallet.models.CredentialResponseModelDtoMeta](docs/CredentialResponseModelDtoMeta.md)
 - [me.meeco.holder.wallet.models.CredentialVerificationCheckModelDto](docs/CredentialVerificationCheckModelDto.md)
 - [me.meeco.holder.wallet.models.CredentialVerificationResponseDto](docs/CredentialVerificationResponseDto.md)
 - [me.meeco.holder.wallet.models.CredentialsControllerFindOne404Response](docs/CredentialsControllerFindOne404Response.md)
 - [me.meeco.holder.wallet.models.CredentialsControllerFindOne500Response](docs/CredentialsControllerFindOne500Response.md)
 - [me.meeco.holder.wallet.models.CredentialsControllerImport400Response](docs/CredentialsControllerImport400Response.md)
 - [me.meeco.holder.wallet.models.CredentialsControllerPatch404Response](docs/CredentialsControllerPatch404Response.md)
 - [me.meeco.holder.wallet.models.CredentialsControllerPatch500Response](docs/CredentialsControllerPatch500Response.md)
 - [me.meeco.holder.wallet.models.CredentialsControllerRemove500Response](docs/CredentialsControllerRemove500Response.md)
 - [me.meeco.holder.wallet.models.CredentialsControllerVerify500Response](docs/CredentialsControllerVerify500Response.md)
 - [me.meeco.holder.wallet.models.CredentialsResponseDto](docs/CredentialsResponseDto.md)
 - [me.meeco.holder.wallet.models.Database](docs/Database.md)
 - [me.meeco.holder.wallet.models.DeleteCredentialError](docs/DeleteCredentialError.md)
 - [me.meeco.holder.wallet.models.DeleteDidError](docs/DeleteDidError.md)
 - [me.meeco.holder.wallet.models.DeletePresentationStateError](docs/DeletePresentationStateError.md)
 - [me.meeco.holder.wallet.models.DeleteReceiveStateError](docs/DeleteReceiveStateError.md)
 - [me.meeco.holder.wallet.models.DeleteWalletError](docs/DeleteWalletError.md)
 - [me.meeco.holder.wallet.models.DidControllerCreate201Response](docs/DidControllerCreate201Response.md)
 - [me.meeco.holder.wallet.models.DidControllerCreateRequest](docs/DidControllerCreateRequest.md)
 - [me.meeco.holder.wallet.models.DidControllerCreateRequestOptions](docs/DidControllerCreateRequestOptions.md)
 - [me.meeco.holder.wallet.models.DidControllerCreateRequestOptionsKey](docs/DidControllerCreateRequestOptionsKey.md)
 - [me.meeco.holder.wallet.models.DidKidAssociationNotFoundError](docs/DidKidAssociationNotFoundError.md)
 - [me.meeco.holder.wallet.models.DidNotFoundError](docs/DidNotFoundError.md)
 - [me.meeco.holder.wallet.models.DisplayClaimObject](docs/DisplayClaimObject.md)
 - [me.meeco.holder.wallet.models.GrantDto](docs/GrantDto.md)
 - [me.meeco.holder.wallet.models.GrantDtoAuthorizationCode](docs/GrantDtoAuthorizationCode.md)
 - [me.meeco.holder.wallet.models.GrantDtoUrnIetfParamsOauthGrantTypePreAuthorizedCode](docs/GrantDtoUrnIetfParamsOauthGrantTypePreAuthorizedCode.md)
 - [me.meeco.holder.wallet.models.GrantDtoUrnIetfParamsOauthGrantTypePreAuthorizedCodeTxCode](docs/GrantDtoUrnIetfParamsOauthGrantTypePreAuthorizedCodeTxCode.md)
 - [me.meeco.holder.wallet.models.HealthCheck](docs/HealthCheck.md)
 - [me.meeco.holder.wallet.models.InputDescriptor](docs/InputDescriptor.md)
 - [me.meeco.holder.wallet.models.InputDescriptorConstraints](docs/InputDescriptorConstraints.md)
 - [me.meeco.holder.wallet.models.InternalServerError](docs/InternalServerError.md)
 - [me.meeco.holder.wallet.models.InvalidClaimsToDiscloseError](docs/InvalidClaimsToDiscloseError.md)
 - [me.meeco.holder.wallet.models.InvalidCredentialDataError](docs/InvalidCredentialDataError.md)
 - [me.meeco.holder.wallet.models.InvalidCredentialOfferUrlError](docs/InvalidCredentialOfferUrlError.md)
 - [me.meeco.holder.wallet.models.InvalidDateFilterValueError](docs/InvalidDateFilterValueError.md)
 - [me.meeco.holder.wallet.models.InvalidOrderFilterValueError](docs/InvalidOrderFilterValueError.md)
 - [me.meeco.holder.wallet.models.InvalidPathParamError](docs/InvalidPathParamError.md)
 - [me.meeco.holder.wallet.models.InvalidPerPageFilterValueError](docs/InvalidPerPageFilterValueError.md)
 - [me.meeco.holder.wallet.models.InvalidPresentationRequestUrlError](docs/InvalidPresentationRequestUrlError.md)
 - [me.meeco.holder.wallet.models.InvalidRequestPayloadError](docs/InvalidRequestPayloadError.md)
 - [me.meeco.holder.wallet.models.IssuerDisplayObjectInner](docs/IssuerDisplayObjectInner.md)
 - [me.meeco.holder.wallet.models.JSONWebKey](docs/JSONWebKey.md)
 - [me.meeco.holder.wallet.models.JSONWebKeyPub](docs/JSONWebKeyPub.md)
 - [me.meeco.holder.wallet.models.KeyControllerImport400Response](docs/KeyControllerImport400Response.md)
 - [me.meeco.holder.wallet.models.KeyControllerImportRequest](docs/KeyControllerImportRequest.md)
 - [me.meeco.holder.wallet.models.KeyControllerSign201Response](docs/KeyControllerSign201Response.md)
 - [me.meeco.holder.wallet.models.KeyControllerSign400Response](docs/KeyControllerSign400Response.md)
 - [me.meeco.holder.wallet.models.KeyControllerSignRequest](docs/KeyControllerSignRequest.md)
 - [me.meeco.holder.wallet.models.KeyNotFoundError](docs/KeyNotFoundError.md)
 - [me.meeco.holder.wallet.models.KeyNotSupportedError](docs/KeyNotSupportedError.md)
 - [me.meeco.holder.wallet.models.KeySigningNotSupportedError](docs/KeySigningNotSupportedError.md)
 - [me.meeco.holder.wallet.models.KeysControllerCreate201Response](docs/KeysControllerCreate201Response.md)
 - [me.meeco.holder.wallet.models.KeysControllerCreateRequest](docs/KeysControllerCreateRequest.md)
 - [me.meeco.holder.wallet.models.KeysControllerCreateRequestKey](docs/KeysControllerCreateRequestKey.md)
 - [me.meeco.holder.wallet.models.KeysControllerGet404Response](docs/KeysControllerGet404Response.md)
 - [me.meeco.holder.wallet.models.LoadCredentialError](docs/LoadCredentialError.md)
 - [me.meeco.holder.wallet.models.LoadCredentialsError](docs/LoadCredentialsError.md)
 - [me.meeco.holder.wallet.models.LoadWalletError](docs/LoadWalletError.md)
 - [me.meeco.holder.wallet.models.Meta](docs/Meta.md)
 - [me.meeco.holder.wallet.models.NotImplementedError](docs/NotImplementedError.md)
 - [me.meeco.holder.wallet.models.PatchCredentialError](docs/PatchCredentialError.md)
 - [me.meeco.holder.wallet.models.PresentationControllerCreate400Response](docs/PresentationControllerCreate400Response.md)
 - [me.meeco.holder.wallet.models.PresentationDefinition](docs/PresentationDefinition.md)
 - [me.meeco.holder.wallet.models.PresentationRequestSendRequestModelDto](docs/PresentationRequestSendRequestModelDto.md)
 - [me.meeco.holder.wallet.models.PresentationRequestSetCredentialsRequestModelDto](docs/PresentationRequestSetCredentialsRequestModelDto.md)
 - [me.meeco.holder.wallet.models.PresentationRequestSetCredentialsRequestModelDtoCredentialsInner](docs/PresentationRequestSetCredentialsRequestModelDtoCredentialsInner.md)
 - [me.meeco.holder.wallet.models.PresentationRequestSetCredentialsRequestModelDtoCredentialsInnerCredential](docs/PresentationRequestSetCredentialsRequestModelDtoCredentialsInnerCredential.md)
 - [me.meeco.holder.wallet.models.PresentationRequestSetCredentialsResponseModelDto](docs/PresentationRequestSetCredentialsResponseModelDto.md)
 - [me.meeco.holder.wallet.models.PresentationRequestSetCredentialsResponseModelDtoCredentialsInner](docs/PresentationRequestSetCredentialsResponseModelDtoCredentialsInner.md)
 - [me.meeco.holder.wallet.models.PresentationRequestSetCredentialsResponseModelDtoCredentialsInnerCredential](docs/PresentationRequestSetCredentialsResponseModelDtoCredentialsInnerCredential.md)
 - [me.meeco.holder.wallet.models.PresentationRequestSetCredentialsResponseModelDtoMeta](docs/PresentationRequestSetCredentialsResponseModelDtoMeta.md)
 - [me.meeco.holder.wallet.models.PresentationRequestSubmitRequestModelDto](docs/PresentationRequestSubmitRequestModelDto.md)
 - [me.meeco.holder.wallet.models.PresentationRequestSubmitResponseModelDto](docs/PresentationRequestSubmitResponseModelDto.md)
 - [me.meeco.holder.wallet.models.PresentationStateResponseDto](docs/PresentationStateResponseDto.md)
 - [me.meeco.holder.wallet.models.PresentationStateResponseDtoMeta](docs/PresentationStateResponseDtoMeta.md)
 - [me.meeco.holder.wallet.models.PresentationStatesResponseDto](docs/PresentationStatesResponseDto.md)
 - [me.meeco.holder.wallet.models.ReceiveControllerCreate400Response](docs/ReceiveControllerCreate400Response.md)
 - [me.meeco.holder.wallet.models.ReceiveControllerFindAll400Response](docs/ReceiveControllerFindAll400Response.md)
 - [me.meeco.holder.wallet.models.ReceiveControllerFindAll500Response](docs/ReceiveControllerFindAll500Response.md)
 - [me.meeco.holder.wallet.models.ReceiveControllerGetInfo500Response](docs/ReceiveControllerGetInfo500Response.md)
 - [me.meeco.holder.wallet.models.Redis](docs/Redis.md)
 - [me.meeco.holder.wallet.models.RegisterWalletError](docs/RegisterWalletError.md)
 - [me.meeco.holder.wallet.models.SendControllerDeleteOne404Response](docs/SendControllerDeleteOne404Response.md)
 - [me.meeco.holder.wallet.models.SendControllerDeleteOne500Response](docs/SendControllerDeleteOne500Response.md)
 - [me.meeco.holder.wallet.models.StatusDto](docs/StatusDto.md)
 - [me.meeco.holder.wallet.models.SubmissionRequirement](docs/SubmissionRequirement.md)
 - [me.meeco.holder.wallet.models.SubmissionRequirementOneOf](docs/SubmissionRequirementOneOf.md)
 - [me.meeco.holder.wallet.models.SvxDidCannotBeDeletedError](docs/SvxDidCannotBeDeletedError.md)
 - [me.meeco.holder.wallet.models.VerifyCredentialError](docs/VerifyCredentialError.md)
 - [me.meeco.holder.wallet.models.VersionDto](docs/VersionDto.md)
 - [me.meeco.holder.wallet.models.WalletCountsResponseDto](docs/WalletCountsResponseDto.md)
 - [me.meeco.holder.wallet.models.WalletCountsResponseModelDto](docs/WalletCountsResponseModelDto.md)
 - [me.meeco.holder.wallet.models.WalletDIDDto](docs/WalletDIDDto.md)
 - [me.meeco.holder.wallet.models.WalletDIDDtoKeysInner](docs/WalletDIDDtoKeysInner.md)
 - [me.meeco.holder.wallet.models.WalletNotFoundError](docs/WalletNotFoundError.md)
 - [me.meeco.holder.wallet.models.WalletResponseDto](docs/WalletResponseDto.md)
 - [me.meeco.holder.wallet.models.WalletResponseModelDto](docs/WalletResponseModelDto.md)
 - [me.meeco.holder.wallet.models.WalletsControllerCreate500Response](docs/WalletsControllerCreate500Response.md)
 - [me.meeco.holder.wallet.models.WalletsControllerDeleteOne500Response](docs/WalletsControllerDeleteOne500Response.md)
 - [me.meeco.holder.wallet.models.WalletsControllerGetOne500Response](docs/WalletsControllerGetOne500Response.md)


<a id="documentation-for-authorization"></a>
## Documentation for Authorization


Authentication schemes defined for the API:
<a id="bearerAuth"></a>
### bearerAuth

- **Type**: HTTP Bearer Token authentication (JWT)

