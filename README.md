# ZerionMobile SDK

ZerionMobile SDK contains the implementation of the Zerion API with corresponding methods and responses.

## Features

The SDK is written using Kotlin Multiplatform Mobile (KMM), making it flexible and compatible with:
- iOS projects
- Android projects
- Built-in error handling for common API errors

## Getting Started

To start using the ZerionMobile SDK, you will need an authorization key. You can obtain your key by following the steps outlined here: [Zerion API Documentation](https://developers.zerion.io/reference/intro/getting-started).

## Installation

### For Android
Include the SDK in your project's dependencies in the `build.gradle` file:
```gradle
implementation("io.github.uladzerion:zerion-mobile-sdk-android:<latest_version>")
```

### For iOS
Add the SDK as a dependency in your `Podfile` or include it in your Swift Package Manager configuration.

## Usage

### Initialization

The SDK can be initialized with either just an authorization key (using the default API URL) or with a custom API URL:

```kotlin
// Initialize with default API URL
ZerionSDK.initialize("YOUR_AUTHORIZATION_KEY")

// Or initialize with custom API URL
ZerionSDK.initialize(
    authorization = "YOUR_AUTHORIZATION_KEY",
    apiUrl = "https://your-custom-api.com/v1/",
    isWithLogging = true // Optional: Enable logging
)
```

For iOS:
```swift
// Initialize with default API URL
ZerionSDK.shared.initialize(authorization: "YOUR_AUTHORIZATION_KEY")

// Or initialize with custom API URL
ZerionSDK.shared.initialize(
    authorization: "YOUR_AUTHORIZATION_KEY",
    apiUrl: "https://your-custom-api.com/v1/"
)
```

### Error Handling

The SDK provides built-in error handling for common API errors. These are thrown as specific exceptions that you can catch and handle:

```kotlin
try {
    val positions = ZerionSDK.getWalletPositions(address = "0x...")
} catch (e: ZerionApiException) {
    when (e) {
        is ZerionApiException.MalformedParametersException -> {
            // Handle 400 Bad Request - malformed parameters
        }
        is ZerionApiException.UnauthorizedException -> {
            // Handle 401 Unauthorized - invalid API key
        }
        is ZerionApiException.TooManyRequestsException -> {
            // Handle 429 Too Many Requests - rate limit exceeded
        }
        is ZerionApiException.ZerionInitializationException -> {
            // Handle SDK initialization errors
        }
        is ZerionApiException.ZerionAuthorizationException -> {
            // Handle authorization errors
        }
        is ZerionApiException.GeneralException -> {
            // Handle other API errors
        }
    }
}
```

For iOS, these errors are mapped to NSError with appropriate error codes and descriptions.

### Example of Usage in Kotlin:

```kotlin
// Example: Fetch wallet positions with filters
suspend fun getWalletPositions(address: String) {
    try {
        val positions = ZerionSDK.getWalletPositions(
            address = address,
            chainIds = listOf("ethereum", "polygon")
        )
        positions.data.forEach { position ->
            println("Position: ${position.attributes.name}")
        }
    } catch (e: ZerionApiException) {
        println("API Error: ${e.message}")
    }
}
```

### Example of Usage in iOS:

```swift
import ZerionSDK

// Example: Fetch wallet positions with filters
Task {
    do {
        let positions = try await ZerionSDK.shared.getWalletPositions(
            address: "0x42b9df65b219b3dd36ff330a4dd8f327a6ada990",
            chainIds: ["ethereum", "polygon"]
        )
        positions.data.forEach { position in
            print("Position: \(position.attributes.name)")
        }
    } catch {
        print("API Error: \(error.localizedDescription)")
    }
}
```

## Available API Methods

`getWalletPortfolio(address)` - Retrieves wallet's portfolio information including position distributions and total value  
[API Reference](https://developers.zerion.io/reference/getwalletportfolio)

`getWalletPositions(address)` - Fetches all positions (tokens, NFTs, DeFi positions) for a given wallet address  
[API Reference](https://developers.zerion.io/reference/listwalletpositions)

`getWalletTransactions(address)` - Retrieves transaction history for a wallet with support for pagination and filtering  
[API Reference](https://developers.zerion.io/reference/listwallettransactions)

## Links
[Zerion API Documentation](https://developers.zerion.io/reference/intro/getting-started)

## Contributors
- Uladzislau ([uladzislau@zerion.io](mailto:uladzislau@zerion.io))
