plugins {
    id("java-library")
    id("kotlin")
}
java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies {
    implementation(Dependencies.kotlin.coroutine)
//    implementation(Dependencies.androidX.paging.common)
    implementation(Dependencies.jsr330)
}