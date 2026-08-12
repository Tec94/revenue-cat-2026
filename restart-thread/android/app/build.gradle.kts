import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.plugin.compose")
}

val localProperties = Properties().apply {
    val file = rootProject.file("local.properties")
    if (file.exists()) file.inputStream().use(::load)
}

fun localValue(name: String): String = localProperties.getProperty(name, "")

fun quoted(value: String): String =
    "\"${value.replace("\\", "\\\\").replace("\"", "\\\"")}\""

val configuredPlayKey = localValue("REVENUECAT_PLAY_API_KEY")
val revenueCatTestKey = localValue("REVENUECAT_TEST_API_KEY").ifBlank {
    configuredPlayKey.takeIf { it.startsWith("test_") }.orEmpty()
}
val revenueCatPlayKey = configuredPlayKey.takeUnless { it.startsWith("test_") }.orEmpty()

android {
    namespace = "com.restartthread.app"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.restartthread.app"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "0.1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    flavorDimensions += "store"
    productFlavors {
        create("play") {
            dimension = "store"
            buildConfigField(
                "String",
                "REVENUECAT_API_KEY",
                quoted(revenueCatPlayKey),
            )
        }
        create("galaxy") {
            dimension = "store"
            buildConfigField(
                "String",
                "REVENUECAT_API_KEY",
                quoted(localValue("REVENUECAT_GALAXY_API_KEY")),
            )
        }
    }

    buildTypes {
        debug {
            buildConfigField("String", "REVENUECAT_TEST_API_KEY", quoted(revenueCatTestKey))
        }
        release {
            buildConfigField("String", "REVENUECAT_TEST_API_KEY", quoted(""))
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.core:core-ktx:1.19.0")
    implementation("androidx.activity:activity-compose:1.13.0")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.11.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.11.0")

    implementation("com.revenuecat.purchases:purchases:10.16.1")
    add("galaxyImplementation", "com.revenuecat.purchases:purchases-store-galaxy:10.16.1")
    add("galaxyImplementation", "com.revenuecat.purchases:purchases-ui:10.16.1")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.3.0")
}
