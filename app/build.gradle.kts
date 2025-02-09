plugins {
    id("seomseom.android.application")
    id("seomseom.android.application.compose")
}

android {
    namespace = "com.seomseom.multiModuleTemplate"
}

dependencies {
    implementation(project(":core:domain"))
    implementation(project(":core:data"))
    implementation(project(":core:ui"))

    implementation(libs.glide)
}