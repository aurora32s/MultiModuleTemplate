plugins {
    id("seomseom.android.library")
    id("seomseom.android.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "com.seomseom.network"
}

dependencies {
    implementation(project(":core:common"))
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.bundles.retrofit)
}