// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "7.2.1" apply false
    id("com.android.library") version "7.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.7.10" apply false
    id("com.google.dagger.hilt.android") version Versions.hilt apply false
    id("com.google.gms.google-services") version "4.3.10" apply false
    id("org.jetbrains.kotlin.jvm") version "1.7.0" apply false
    id("com.android.dynamic-feature") version "7.2.1" apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}