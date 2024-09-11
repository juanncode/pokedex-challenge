import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    kotlin("kapt")
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.serialization)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.github.juanncode.pokedex_challenge"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.github.juanncode.pokedex_challenge"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        val keystoreFile = project.rootProject.file("pokedex.properties")
        val properties = Properties()
        properties.load(keystoreFile.inputStream())
        debug {
            applicationIdSuffix = ".staging"
            val baseUrl = properties.getProperty("BASE_URL_D") ?: ""

            buildConfigField(type = "String", name = "BASE_URL", value = baseUrl)
        }
        release {
            val baseUrl = properties.getProperty("BASE_URL") ?: ""
            buildConfigField(type = "String", name = "BASE_URL", value = baseUrl)
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true

    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    //navigation
    implementation(libs.navigation.compose)
    implementation(libs.hilt.navigation)

    //retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.okthttp3)
    implementation(libs.okthttp3.interceptor)


    //hilt
    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    //coil
    implementation(libs.coil.compose)

    //serialization
    implementation(libs.kotlin.serialization)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}