# SystemMetricsApi

All URIs are relative to *https://holder-wallet-dev.svx.internal*

Method | HTTP request | Description
------------- | ------------- | -------------
[**systemMetricsControllerGetWalletCounts**](SystemMetricsApi.md#systemMetricsControllerGetWalletCounts) | **GET** /system/metrics/wallets | Wallet metrics


<a id="systemMetricsControllerGetWalletCounts"></a>
# **systemMetricsControllerGetWalletCounts**
> WalletCountsResponseDto systemMetricsControllerGetWalletCounts(startDate, endDate)

Wallet metrics

### Example
```kotlin
// Import classes:
//import me.meeco.holder.wallet.infrastructure.*
//import me.meeco.holder.wallet.models.*

val apiInstance = SystemMetricsApi()
val startDate : kotlin.String = startDate_example // kotlin.String | Counts only wallets created after the given date
val endDate : kotlin.String = endDate_example // kotlin.String | Counts only wallets created before the given date
try {
    val result : WalletCountsResponseDto = apiInstance.systemMetricsControllerGetWalletCounts(startDate, endDate)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemMetricsApi#systemMetricsControllerGetWalletCounts")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemMetricsApi#systemMetricsControllerGetWalletCounts")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **startDate** | **kotlin.String**| Counts only wallets created after the given date | [optional]
 **endDate** | **kotlin.String**| Counts only wallets created before the given date | [optional]

### Return type

[**WalletCountsResponseDto**](WalletCountsResponseDto.md)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

