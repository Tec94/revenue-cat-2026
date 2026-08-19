// swift-tools-version: 6.0

import PackageDescription

let package = Package(
    name: "RestartThreadApple",
    platforms: [
        .iOS(.v15),
        .macOS(.v12),
    ],
    products: [
        .library(name: "RestartThreadCore", targets: ["RestartThreadCore"]),
        .library(name: "RestartThreadApple", targets: ["RestartThreadApple"]),
    ],
    dependencies: [
        .package(url: "https://github.com/auth0/Auth0.swift", exact: "3.0.2"),
        .package(url: "https://github.com/RevenueCat/purchases-ios-spm.git", exact: "5.82.0"),
    ],
    targets: [
        .target(name: "RestartThreadCore"),
        .target(
            name: "RestartThreadApple",
            dependencies: [
                "RestartThreadCore",
                .product(name: "Auth0", package: "Auth0.swift"),
                .product(name: "RevenueCat", package: "purchases-ios-spm"),
                .product(name: "RevenueCatUI", package: "purchases-ios-spm"),
            ]
        ),
        .testTarget(
            name: "RestartThreadCoreTests",
            dependencies: ["RestartThreadCore"]
        ),
    ]
)
