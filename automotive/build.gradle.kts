plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.gearapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.gearapp"
        minSdk = 28
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
    kotlinOptions {
        jvmTarget = "11"
    }
    useLibrary ("android.car")
}

dependencies {
    implementation (project(":gear-module"))
    implementation (project(":ui-module"))
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")
    implementation ("androidx.compose.ui:ui:1.7.6")
    implementation ("androidx.compose.material:material:1.7.6")
    implementation ("androidx.navigation:navigation-compose:2.8.5")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}