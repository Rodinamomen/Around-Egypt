plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.androidx.navigation.safe.args)
}

android {
    namespace = "com.example.aroundegypt"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.aroundegypt"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    //navigation
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)
    //Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    //datastore
    implementation(libs.androidx.datastore.preferences)
    //retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    //truth
    testImplementation(libs.truth)
    androidTestImplementation(libs.truth)
    //coroutinesTesting
    testImplementation(libs.kotlinx.coroutines.test)
    //mockito
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.mockito.core.v520)
    testImplementation(libs.mockito.inline.v520)
    //serialization
    implementation(libs.kotlinx.serialization.json)
    //room
    implementation(libs.androidx.room.runtime)

}
kapt {
    correctErrorTypes = true
}