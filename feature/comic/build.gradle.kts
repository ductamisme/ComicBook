plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("kotlinx-serialization")
    id("org.jetbrains.compose")
//    id("com.google.gms.google-services")
    id("com.google.relay") version ("0.3.05")

}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "comic"
        }
    }

    sourceSets {
        val commonMain by getting{
            dependencies {
//                implementation(project(":shared"))
                implementation(project(":domain"))
                implementation(project(":data:model"))
                implementation(project(":data:local"))
                implementation(project(":extension"))
                implementation(project(":image-loader"))

                api(libs.uuid)
//                api(libs.kotlinx.coroutines.core)
                api(libs.kotlinx.datetime)
                api(libs.multiplatformSettings.core)
//                api(projects.imageLoader)
//                api(projects.extension.blur)

                implementation(libs.stately.common)

//                implementation(libs.koin.androidx.compose)
//                implementation("io.insert-koin:koin-android:3.4.0")

                implementation(libs.voyager.core)
                implementation(libs.voyager.koin)
                implementation(libs.voyager.androidx)
                implementation(libs.voyager.bottomSheetNavigator)
                implementation(libs.voyager.navigator)
                implementation(libs.voyager.transitions)
                implementation(libs.voyager.hilt)
                implementation(libs.voyager.livedata)
                implementation(libs.voyager.androidx)
                implementation(libs.voyager.tabNavigator)
                implementation(libs.voyager.kodein)

                implementation(libs.koin.core)

                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.runtime)

                implementation(libs.hyperdrive.multiplatformx.api)

                // load image
                api("io.github.qdsfdhvh:image-loader:1.2.8")

            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting{
            kotlin.srcDirs("src/jvmMain/kotlin")
            dependencies {
                implementation(libs.koin.android)
            }
        }
        val androidUnitTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "com.aicontent.comic"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
        targetSdk = 33
    }
}
