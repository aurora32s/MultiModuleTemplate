plugins {
    id("seomseom.android.library")
}

android {
    namespace = "com.seomseom.ui"

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.bundles.kotlin)
    implementation(libs.bundles.androidx)
}