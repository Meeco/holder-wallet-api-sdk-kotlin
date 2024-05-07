/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package me.meeco.holder.wallet.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param allWallets 
 * @param nonEmptyWallets 
 */


data class WalletCountsResponseModelDto (

    @Json(name = "all_wallets")
    val allWallets: java.math.BigDecimal,

    @Json(name = "non_empty_wallets")
    val nonEmptyWallets: java.math.BigDecimal

)

