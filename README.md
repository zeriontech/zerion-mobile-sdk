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

### Example of Usage in iOS:

```swift
import ZerionSDK

// Initialize the SDK with your authorization key
ZerionSDK.shared.initialize(authorization: "YOUR_AUTHORIZATION_KEY")

// Get the Zerion API Repository
let zerionApiRepository = ZerionSDK.shared.getZerionApiRepository()

// Fetch wallet portfolio asynchronously
Task {
    do {
        let response = try await zerionApiRepository.getWalletPortfolio(
            address: "0x42b9df65b219b3dd36ff330a4dd8f327a6ada990"
        )
        
        // Access the wallet positions distribution
        if let positionsByWallet = response.data?.attributes.positions_distribution_by_type.wallet {
            print(positionsByWallet)
        } else {
            print("No positions data available.")
        }
    } catch {
        print("Failed to fetch wallet portfolio: \(error)")
    }
}
```

## Links 
[Zerion API Documentation](https://developers.zerion.io/reference/intro/getting-started)

## Contributors
- Uladzislau ([uladzislau@zerion.io](mailto:uladzislau@zerion.io))
