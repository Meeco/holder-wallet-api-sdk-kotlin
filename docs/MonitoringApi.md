# MonitoringApi

All URIs are relative to *https://holder-wallet-dev.svx.internal*

Method | HTTP request | Description
------------- | ------------- | -------------
[**appControllerGetSystemStatus**](MonitoringApi.md#appControllerGetSystemStatus) | **GET** /system/status | Get deployed service status information
[**appControllerGetVersion**](MonitoringApi.md#appControllerGetVersion) | **GET** /version | Get deployed service version information


<a id="appControllerGetSystemStatus"></a>
# **appControllerGetSystemStatus**
> StatusDto appControllerGetSystemStatus()

Get deployed service status information

Endpoint to read deployed service status information.

### Example
```kotlin
// Import classes:
//import me.meeco.holder.wallet.infrastructure.*
//import me.meeco.holder.wallet.models.*

val apiInstance = MonitoringApi()
try {
    val result : StatusDto = apiInstance.appControllerGetSystemStatus()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MonitoringApi#appControllerGetSystemStatus")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MonitoringApi#appControllerGetSystemStatus")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**StatusDto**](StatusDto.md)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="appControllerGetVersion"></a>
# **appControllerGetVersion**
> VersionDto appControllerGetVersion()

Get deployed service version information

Endpoint to read deployed service version information.

### Example
```kotlin
// Import classes:
//import me.meeco.holder.wallet.infrastructure.*
//import me.meeco.holder.wallet.models.*

val apiInstance = MonitoringApi()
try {
    val result : VersionDto = apiInstance.appControllerGetVersion()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MonitoringApi#appControllerGetVersion")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MonitoringApi#appControllerGetVersion")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**VersionDto**](VersionDto.md)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

