import java.util.Properties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    kotlin("kapt")
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.serialization)

}

android {
    namespace = "com.github.juanncode.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        val keystoreFile = project.rootProject.file("pokedex.properties")
        val properties = Properties()
        properties.load(keystoreFile.inputStream())
        debug {
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
        buildConfig = true
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.coroutines.core)

    //retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.okthttp3)
    implementation(libs.okthttp3.interceptor)

    //hilt
    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    //serialization
    implementation(libs.kotlin.serialization)

    //room
    implementation(libs.room.ktx)
    implementation(libs.room.runtime)
    kapt(libs.room.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}