plugins {
    alias(libs.plugins.android.application)

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

/**
 * Version of the release, taken from the git tag by the release workflow. Falls back to a
 * development version, so a local build never depends on being tagged.
 *
 * `1.2.3` becomes version code `10203`, which keeps the codes ordered without an external counter
 * and keeps the release reproducible: the same tag always produces the same APK.
 */
val dppVersionName: String = (findProperty("dpp.versionName") as String?) ?: "1.0"
val dppVersionCode: Int = dppVersionName
    .substringBefore('-')
    .split('.')
    .map { it.toIntOrNull() ?: 0 }
    .let { parts ->
        val (major, minor, patch) = List(3) { parts.getOrElse(it) { 0 } }
        major * 10_000 + minor * 100 + patch
    }
    .coerceAtLeast(1)

/**
 * Keystore of the release signing config, provided by the release workflow through the environment.
 * Without it the release build falls back to the debug key, which keeps local release builds
 * working but produces an APK that must not be published.
 */
val releaseKeystore: File? = System.getenv("DPP_KEYSTORE_FILE")?.takeIf { it.isNotBlank() }
    ?.let { rootProject.file(it) }
    ?.takeIf { it.exists() }

android {
    namespace = "edu.kit.dppviewer"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "edu.kit.dppviewer"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = dppVersionCode
        versionName = dppVersionName

        // Server the example products are loaded from. Override without touching the code, e.g. in
        // local.properties/gradle.properties or with -Pdpp.server.baseUrl=... , empty = no server.
        val dppServerBaseUrl = (findProperty("dpp.server.baseUrl") as String?)
            ?: "https://www.boebe2024tech.top:473/api/v3.0"
        buildConfigField("String", "DPP_SERVER_BASE_URL", "\"$dppServerBaseUrl\"")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }

    signingConfigs {
        releaseKeystore?.let { keystore ->
            create("release") {
                storeFile = keystore
                storePassword = System.getenv("DPP_KEYSTORE_PASSWORD")
                keyAlias = System.getenv("DPP_KEY_ALIAS")
                keyPassword = System.getenv("DPP_KEY_PASSWORD")
            }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"

            )
            buildConfigField("Boolean", "INCLUDE_DEBUG_OPTIONS", "false")
            signingConfig = signingConfigs.findByName("release")
                ?: signingConfigs.getByName("debug")
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
    testOptions {
        unitTests {
            // Robolectric needs the packaged resources and assets, e.g. for the example products.
            isIncludeAndroidResources = true
        }
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    sourceSets {
        getByName("main") {
            resources.directories += "src/main/res"
            assets.directories += "src/main/assets"
        }
        getByName("test") {
            resources.directories += "src/main/res"
            assets.directories += "src/main/assets"
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
