plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.story.fadristoryapp20"
    compileSdk = 34
    testOptions{
        unitTests.isReturnDefaultValues = true
        animationsDisabled = true

    }

    defaultConfig {
        applicationId = "com.story.fadristoryapp20"
        minSdk = 24
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation("com.google.android.gms:play-services-maps:18.0.0") // Google Play services untuk peta
    implementation("com.google.android.gms:play-services-location:18.0.0") // Google Play services untuk lokasi
    implementation("androidx.room:room-paging:2.6.0-rc01") // Room dengan dukungan paging
    implementation("androidx.paging:paging-runtime-ktx:3.2.1") // Dukungan runtime Paging untuk AndroidX
    implementation("androidx.room:room-ktx:2.5.2") // Room dengan ekstensi Kotlin
    ksp("androidx.room:room-compiler:2.5.2") // KAPT plugin untuk Room
    implementation("androidx.room:room-runtime:2.5.2") // Room runtime
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.2.0-alpha01") // SwipeRefreshLayout
    implementation("androidx.datastore:datastore-preferences:1.0.0") // DataStore untuk preferensi
    implementation("com.github.bumptech.glide:glide:4.16.0") // Glide untuk pengelolaan gambar
    implementation("pl.droidsonroids.gif:android-gif-drawable:1.2.19") // Drawable GIF untuk Android
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3") // Coroutines - Core
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3") // Coroutines - Android
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2") // LiveData dengan ekstensi Kotlin
    implementation("androidx.activity:activity-ktx:1.8.0") // AndroidX Activity dengan ekstensi Kotlin
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2") // ViewModel dengan ekstensi Kotlin
    implementation("com.squareup.retrofit2:retrofit:2.9.0") // Retrofit untuk REST API
    implementation("com.squareup.retrofit2:converter-gson:2.9.0") // Konverter GSON untuk Retrofit
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0") // Interceptor logging untuk OkHttp
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2") // Komponen Runtime untuk AndroidX Lifecycle
    testImplementation("androidx.arch.core:core-testing:2.1.0") // Rule pengujian untuk penggunaan LiveData
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.1") // Pengujian coroutines untuk Kotlin
    testImplementation("org.mockito:mockito-core:5.2.0") // Framework mockito untuk pengujian
    testImplementation("org.mockito:mockito-inline:5.2.0") // Mockito inline untuk Kotlin
    androidTestImplementation("com.squareup.okhttp3:mockwebserver:4.9.3") // Server palsu untuk pengujian HTTP
    androidTestImplementation("com.squareup.okhttp3:okhttp-tls:4.9.3") // Dukungan TLS untuk OkHttp di pengujian instrumen
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.gms:play-services-maps:18.2.0")
    implementation("androidx.test.espresso:espresso-idling-resource:3.5.1")
    implementation("com.google.maps:google-maps-services:0.15.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}