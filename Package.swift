// swift-tools-version:6.0.0
import PackageDescription

let package = Package(
    name: "ZerionMobileSDK",
    platforms: [
        .iOS(.v15) // Set the minimum supported iOS version
    ],
    products: [
        .library(
            name: "ZerionMobileSDK",
            targets: ["ZerionMobileSDK"]
        )
    ],
    targets: [
        .binaryTarget(
            name: "ZerionMobileSDK",
            url: "https://github.com/zeriontech/zerion-mobile-sdk/releases/download/0.0.1/ZerionMobileSDK.xcframework.zip",
            checksum:"78a89c7b8c77041485854894932a4930a82a9dcd69b1e03f1861f7119b395938"
        )
    ]
)