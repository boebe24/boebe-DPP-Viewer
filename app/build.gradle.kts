plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)

    /**
     * Compose
     */
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.serialization)

    /**
     * Dagger Hilt
     */
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt.android)
}

android {
    namespace = "edu.kit.dppviewer"
    compileSdk = 34

    defaultConfig {
        applicationId = "edu.kit.dppviewer"
        minSdk = 33
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"

            )
            buildConfigField("Boolean", "INCLUDE_DEBUG_OPTIONS", "false")
            signingConfig = signingConfigs.getByName("debug")
        }

        debug {
            isDebuggable = true
            buildConfigField("Boolean", "INCLUDE_DEBUG_OPTIONS", "true")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    sourceSets {
        getByName("main") {
            resources.srcDir("src/main/res")
            assets.srcDirs(
                file("src/main/assets")
            )
        }
        getByName("test") {
            resources.srcDir("src/main/res")
            assets.srcDirs(
                file("src/main/assets")
            )
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.lifecycle.runtime.compose.android)
    implementation(libs.androidx.adaptive.android)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    /**
     * Material 3
     */
    implementation(libs.material)

    /**
     * Compose
     */
    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.androidx.material.icons.extended)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.kotlinx.serialization.json)

    /**
     * Dagger Hilt
     */
    ksp(libs.hilt.android.compiler)
    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)

    /**
     * Camera
     */
    implementation(libs.androidx.camera.core)
    implementation(libs.androidx.camera.lifecycle)
    implementation(libs.androidx.camera.view)
    implementation(libs.androidx.camera.camera2)

    /**
     * QR Code Scanner & Generator
     */
    implementation(libs.zxing.core)
    implementation(libs.zxing.android.core)

    /**
     * Displaying product pictures
     */
    implementation(libs.coil.compose)
    implementation(libs.glide)
    implementation(libs.androidx.foundation)

    /**
     * Testing
     */
    testImplementation(libs.junit)
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly(libs.junitJupiterEngine)
    testImplementation(libs.junitVintageEngine)

    testImplementation(libs.robolectric)
    testImplementation(libs.mockito.core)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.truth)


    /**
     * Jackson to parse json
     */
    implementation(libs.jackson.core)
    implementation(libs.jackson.datatype.jsr310)
    implementation(libs.jackson.databind)
    implementation(libs.jackson.module.kotlin)

    /**
     * OkHttp Client
     */
    implementation(libs.okhttp)

    /**
     * Adaptive Navigation Suite for supporting different Screen Sizes
     */
    implementation(libs.androidx.material3.adaptive.navigation.suite)
}
