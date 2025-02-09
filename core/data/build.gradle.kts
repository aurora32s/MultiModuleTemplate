plugins {
    id("seomseom.android.library")
    id("seomseom.android.hilt")
}

android {
    namespace = "com.seomseom.data"
}

dependencies {
    implementation(project(":core:datastore"))
    implementation(project(":core:network"))
    implementation(project(":core:database"))
    implementation(project(":core:domain"))

    implementation(libs.bundles.retrofit)
}