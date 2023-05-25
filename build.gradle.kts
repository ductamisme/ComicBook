plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    kotlin("multiplatform") apply false
    kotlin("jvm") apply false
    kotlin("android") apply false
    id("com.android.application") apply false
    id("com.android.library") apply false
    id("org.jetbrains.compose") apply false
    id("com.google.relay") version ("0.3.05")
//    id("com.google.dagger.hilt.android") version ("2.44") apply false
//    id("org.jetbrains.kotlin.android") version ("1.6.10") apply false


}

buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenLocal()
        mavenCentral()
    }
    val sqlDelightVersion = "1.5.5"
    dependencies {
//        classpath("com.android.tools.build:gradle:7.0.1")
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
//        classpath("org.jetbrains.kotlin:kotlin-serialization:1.5.21")
//        classpath("com.google.gms:google-services:4.3.5")
        classpath("dev.icerock.moko:resources-generator:0.22.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
        classpath("com.android.tools.build:gradle:7.4.2")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.8.0")
        classpath("com.squareup.sqldelight:gradle-plugin:$sqlDelightVersion")
        classpath("com.google.gms:google-services:4.3.15")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        mavenLocal()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
