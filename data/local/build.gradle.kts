plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("com.squareup.sqldelight")
    id("org.jetbrains.compose")
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
            baseName = "local"
        }
    }

    sourceSets {
        val commonMain by getting{
            dependencies {
//                implementation(project(":shared"))

                implementation(compose.runtime)

                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")

                implementation(project(":data:model"))
                implementation(libs.sqldelight.runtime)
                implementation(libs.koin.core)
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
                implementation("com.squareup.sqldelight:runtime:1.5.5")
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

                implementation(libs.koin.core)
                implementation(libs.hyperdrive.multiplatformx.api)

                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
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
                implementation(libs.sqldelight.driver.android)
                implementation("com.squareup.sqldelight:android-driver:1.5.5")

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
            dependencies {
                implementation(libs.sqldelight.driver.ios)
                implementation("com.squareup.sqldelight:native-driver:1.5.5")

            }
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
    namespace = "com.aicontent.local"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
        targetSdk = 33
    }
}

sqldelight {
    database("ComicBookDatabase") {
        packageName = "com.aicontent.database"
        sourceFolders = listOf("sqldelight")
    }
}