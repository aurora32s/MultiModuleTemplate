plugins {
    id("seomseom.android.library")
    id("seomseom.android.hilt")
}

android {
    namespace = "com.seomseom.datastore"
}

dependencies {
    implementation(libs.androidx.datastore)
}