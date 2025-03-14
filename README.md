# ZerionMobile SDK

ZerionMobile SDK contains the implementation of the Zerion API with corresponding methods and responses.

## Features

The SDK is written using Kotlin Multiplatform Mobile (KMM), making it flexible and compatible with:
- iOS projects
- Android projects
- KMM / CMM projects

## Getting Started

To start using the ZerionMobile SDK, you will need an authorization key. You can obtain your key by following the steps outlined here: [Zerion API Documentation](https://developers.zerion.io/reference/intro/getting-started).

## Installation

### For Android
Include the SDK in your project's dependencies in the `build.gradle` file:
```gradle
implementation("com.zerion:mobile-sdk:<latest_version>")
```

### For iOS
Add the SDK as a dependency in your `Podfile` or include it in your Swift Package Manager configuration.

### For KMM / CMM
Add the SDK to the `commonMain` dependencies in your `build.gradle.kts` file:
```kotlin
implementation("com.zerion:mobile-sdk:<latest_version>")
```

## Usage

### Example of Usage in Kotlin:

```kotlin
// Initialize the SDK with your authorization key
ZerionSDK.initialize("YOUR_AUTHORIZATION_KEY")

// Get the Zerion API Interactor
val zerionApiInteractor = ZerionSDK.getZerionApiInteractor()

// Example: Fetch wallet positions with filters
suspend fun getWalletPositions(address: String) {
    try {
        val positions = zerionApiInteractor.getWalletPositions(
            address = address,
            chainIds = listOf("ethereum", "polygon"),
            positionTypes = listOf("wallet", "deposited")
        )
        positions.data.forEach { position ->
            println("Position: ${position.attributes.name}")
        }
    } catch (e: Exception) {
        println("Failed to fetch wallet positions: ${e.message}")
    }
}
```

### Example of Usage in iOS:

```swift
import ZerionSDK

// Initialize the SDK with your authorization key
ZerionSDK.shared.initialize(authorization: "YOUR_AUTHORIZATION_KEY")

// Get the Zerion API Interactor
let zerionApiInteractor = ZerionSDK.shared.getZerionApiInteractor()

// Example: Fetch wallet positions with filters
Task {
    do {
        let positions = try await zerionApiInteractor.getWalletPositions(
            address: "0x42b9df65b219b3dd36ff330a4dd8f327a6ada990",
            chainIds: ["ethereum", "polygon"],
            positionTypes: ["wallet"]
        )
        positions.data.forEach { position in
            print("Position: \(position.attributes.name)")
        }
    } catch {
        print("Failed to fetch wallet positions: \(error)")
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
