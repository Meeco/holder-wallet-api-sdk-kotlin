# Kotlin client library for Holder Wallet API

The Holder Wallet API (the service) provides an interface for managing (personal) digital wallets inside an SVX tenant environment. It facilitates a range of operations including key management, DID management, credential issuance (receiving), and credential presentation (presenting). The goal is to provide flexibility on how the component is integrated, be it with a mobile or web application, or with a third-party service.

All cryptographic keys are managed by the service (often referred to as custodial key management) in a secure manner and can be used to control identifiers (i.e. DIDs), as well as perform key binding in credentials.

The service facilitates receiving and presenting credentials in accordance with leading standards and specifications in the space. The focus is on the family of OpenID4VC standards, JWT based credential formats and (optionally) DIDs.

One instance of the service can manage multiple wallets, each of which is a collection of keys, DIDs and associated credentials. This service operates in a trusted environment where its client applications are expected to be trusted as well.

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

This API client was generated by the [OpenAPI Generator](https://openapi-generator.tech) project. By using the [openapi-spec](https://github.com/OAI/OpenAPI-Specification) from a remote server, you can easily generate an API client.

- API version: 4.1.0
- Package version:
- Build package: org.openapitools.codegen.languages.KotlinClientCodegen

## Requires

- Kotlin 1.7.21
- Gradle 7.5

## Gradle Example

```groovy

plugins {
    kotlin("jvm") version "1.9.23"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.1")
    implementation("me.meeco:holder-wallet-api-kotlin-sdk:5.0.0-stage.20240418233521.25cbd64")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.0")
    implementation("org.bitbucket.b_c:jose4j:0.9.6")
    testImplementation("io.mockk:mockk:1.12.0")
    implementation("com.squareup.okhttp3:okhttp:4.9.1")
}

tasks.test {
    useJUnitPlatform()
}

```

```kotlin

import org.openapitools.client.apis.*
import org.openapitools.client.models.*
import java.util.*


fun registerTestWallet(url: String, externalRef: String? = null): WalletResponseDto {
    return WalletApi(url).walletsControllerCreate(
        CreateWalletPayloadDto(
            externalRef ?: "test-${UUID.randomUUID()}"
        )
    )
}

fun registerTestKey(url: String, walletID: String, kty: String = "EC", crv: String = "P-256" ): KeysControllerCreate201Response {
    return KeyManagementApi(url).keysControllerCreate(
        walletID,
        KeysControllerCreateRequest(
            KeysControllerCreateRequestKey(
                kty = kty,
                crv= crv
            )
        )
    )
}

fun main(args: Array<String>) {
    var url = "http://holder-wallet-stage.svx.internal"
    var wallet = registerTestWallet(url)
    var keys = registerTestKey(url, wallet.wallet.id, )
}
```


