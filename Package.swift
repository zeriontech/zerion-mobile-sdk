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
            url: "https://github.com/uladzerion/ZerionMobileSDK/releases/download/1.0.0/ZerionMobileSDK.xcframework.zip",
            checksum:"23a1b0de6cbb52ad48a70ff49ffd3c325aa2a431eeaa50046284b4d60a8c9424"
        )
    ]
)