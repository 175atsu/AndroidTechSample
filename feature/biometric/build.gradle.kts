import com.example.buildsrc.Dep
plugins {
  id("com.android.library")
  id("kotlin-android")
  id("kotlin-kapt")
  id("dagger.hilt.android.plugin")
}

android {
  compileSdk = com.example.buildsrc.Versions.Sdk.compile
  defaultConfig {
    minSdk = com.example.buildsrc.Versions.Sdk.min
    targetSdk = com.example.buildsrc.Versions.Sdk.target
  }
  buildFeatures {
    dataBinding = true
  }
}

dependencies {
  implementation(project(":feature:resources"))
  implementation(project(":feature:core"))

  implementation(Dep.AndroidX.constraintLayout)
  implementation(Dep.AndroidX.biometric)
  implementation(Dep.Dagger.hilt)
  kapt(Dep.Dagger.hiltKapt)
}
