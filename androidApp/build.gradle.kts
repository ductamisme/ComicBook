//import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform")
    id("com.android.application")
    id("org.jetbrains.compose")
    id("com.google.gms.google-services")
    id("kotlin-kapt")
//    id("dagger.hilt.android.plugin")
//    id("org.jetbrains.kotlin.android") version ("1.8.0")
}

kotlin {
    android()
    sourceSets {
        val androidMain by getting {
            dependencies {
                implementation(project(":shared"))
                implementation(project(":feature:comic"))
//                implementation(project(":share-ui"))
//                implementation(libs.hyperdrive.multiplatformx.api)
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.runtime)
//                implementation("androidx.activity:activity-compose:1.6.1")
//                implementation(libs.koin.core)
                implementation(libs.koin.core)
                implementation(libs.koin.android)
                implementation(libs.koin.androidx.compose)
                api(libs.activity.compose)
                api(libs.appcompat)
                api(libs.androidx.core.ktx)
                implementation(libs.androidx.core.ktx)
                implementation(libs.voyager.navigator)
//                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0")
//                implementation("com.google.firebase:firebase-auth:21.3.0")
//                implementation("com.google.dagger:hilt-android:2.44")
//                kapt("com.google.dagger:hilt-android-compiler:2.44")
//                kapt("androidx.hilt:hilt-compiler:1.0.0")
//                implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
//                platform("com.google.firebase:firebase-bom:31.5.0")
//                implementation ("com.google.firebase:firebase-analytics-ktx")
            }
        }
    }
}
android {
    namespace = "com.aicontent.comicbook.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.aicontent.comicbook"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}
dependencies {
implementation("com.google.firebase:firebase-auth-ktx:21.3.0")
    implementation("com.google.firebase:firebase-functions-ktx:20.2.2")
    implementation("com.google.android.gms:play-services-auth:20.5.0")
    implementation(project(mapOf("path" to ":feature:comic")))
    //    implementation("com.google.firebase:firebase-auth:21.3.0")
//    implementation("com.google.dagger:hilt-android:2.44")
////    kapt("com.google.dagger:hilt-android-compiler:2.44")
//    kapt("androidx.hilt:hilt-compiler:1.0.0")
//    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
}
