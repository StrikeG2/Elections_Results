plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.elections_results"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.elections_results"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(libs.appcompat.v161)
    implementation(libs.constraintlayout.v214)
    implementation(libs.material.v190)

    // ViewModel and LiveData
    implementation(libs.lifecycle.extensions)

    // Room database
    implementation(libs.room.runtime)
    annotationProcessor(libs.room.compiler)

    // Retrofit for API calls
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // Google Maps
    implementation(libs.play.services.maps)

    // Charts
    implementation(libs.mpandroidchart)

    // WorkManager for periodic sync
    implementation(libs.work.runtime)

    testImplementation(libs.junit)
    androidTestImplementation(libs.junit.v115)
    androidTestImplementation(libs.espresso.core.v351)
}
