import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("com.android.kotlin.multiplatform.library")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.compose")
}

kotlin {
    android {
        namespace = "com.restartthread.shared"
        compileSdk = 37
        minSdk = 24
        withHostTestBuilder {}
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    val appleTargets = listOf(
        iosArm64(),
        iosSimulatorArm64(),
        iosX64(),
    )
    appleTargets.forEach { target ->
        (target as KotlinNativeTarget).binaries.framework {
            baseName = "RestartThreadShared"
            isStatic = true
        }
    }

    sourceSets {
        all {
            if (name.startsWith("ios")) {
                languageSettings.optIn("kotlinx.cinterop.ExperimentalForeignApi")
            }
        }
        commonMain.dependencies {
            implementation("org.jetbrains.compose.runtime:runtime:1.10.3")
            implementation("org.jetbrains.compose.foundation:foundation:1.10.3")
            implementation("org.jetbrains.compose.material3:material3:1.10.0-alpha05")
            implementation("org.jetbrains.compose.ui:ui:1.10.3")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
            implementation("com.revenuecat.purchases:purchases-kmp-core:3.4.0")
            implementation("com.revenuecat.purchases:purchases-kmp-result:3.4.0")
            implementation("com.revenuecat.purchases:purchases-kmp-ui:3.4.0")
        }
        commonTest.dependencies {
            implementation(kotlin("test"))
        }
    }
}
