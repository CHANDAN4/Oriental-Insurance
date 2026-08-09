import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinSerialization)
}

kotlin {
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    js {
        browser()
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }
    
    androidLibrary {
       namespace = "com.app.orientalinsurance.shared"
       compileSdk = libs.versions.android.compileSdk.get().toInt()
       minSdk = libs.versions.android.minSdk.get().toInt()
    
       compilerOptions {
           jvmTarget = JvmTarget.JVM_11
       }
       androidResources {
           enable = true
       }
       withHostTest {
           isIncludeAndroidResources = true
       }
    }
    
    sourceSets {
        androidMain.dependencies {
            implementation(libs.compose.uiToolingPreview)
            //To api implementation
            implementation("io.ktor:ktor-client-okhttp:3.2.2")

            //Koin DI
            implementation("io.insert-koin:koin-android:4.0.0")

            //Gson
            implementation("com.google.code.gson:gson:2.13.1")
            implementation(libs.androidx.material3)
        }
        commonMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.compose.components.resources)
            implementation(libs.compose.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)

            //To Navigation
            implementation("org.jetbrains.androidx.navigation:navigation-compose:2.9.0")

            //Koin DI
            implementation("io.insert-koin:koin-core:4.0.0")
            implementation("io.insert-koin:koin-compose:4.0.0")
            implementation("io.insert-koin:koin-compose-viewmodel:4.0.0")
            //Ktor to api implementation
            implementation("io.ktor:ktor-client-core:3.2.2")
            implementation("io.ktor:ktor-client-content-negotiation:3.2.2")
            implementation("io.ktor:ktor-serialization-kotlinx-json:3.2.2")
            implementation("io.ktor:ktor-client-logging:3.2.2")
            //Coroutine
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")

            //ViewModel
            implementation("org.jetbrains.androidx.lifecycle:lifecycle-viewmodel-compose:2.9.4")

            implementation(compose.materialIconsExtended)

            //multiplatform datastore
            implementation("com.russhwolf:multiplatform-settings:1.3.0")
        }

        iosMain.dependencies {
            implementation("io.ktor:ktor-client-darwin:3.2.2")
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        jsMain.dependencies {
            implementation(libs.wrappers.browser)
            implementation("io.ktor:ktor-client-cio:3.2.2")
        }
        wasmJsMain.dependencies {
            implementation("io.ktor:ktor-client-js:3.2.2")
        }
        webMain.dependencies {
            implementation("io.insert-koin:koin-core:4.0.0")
            implementation("com.russhwolf:multiplatform-settings:1.3.0")
        }

    }
}

dependencies {
    androidRuntimeClasspath(libs.compose.uiTooling)
}