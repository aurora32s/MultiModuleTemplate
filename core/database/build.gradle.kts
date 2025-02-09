plugins {
    id("seomseom.android.library")
    id("seomseom.android.hilt")
    id("org.jetbrains.kotlin.kapt")
}

android {
    namespace = "com.seomseom.database"
}

dependencies {
    kapt(libs.room.compiler)
    implementation(libs.bundles.room)
}