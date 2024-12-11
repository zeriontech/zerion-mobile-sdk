# ZerionMobile SDK

ZerionMobile SDK contains the implementation of the Zerion API with corresponding methods and response DTOs.

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
Refer to the official documentation for examples on how to integrate and use the ZerionMobile SDK in your project.
[Zerion API Documentation](https://developers.zerion.io/reference/intro/getting-started)

## Contributors
- Uladzislau ([uladzislau@zerion.io](mailto:uladzislau@zerion.io))
