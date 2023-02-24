import com.example.buildsrc.Dep
import com.example.buildsrc.Versions

plugins {
  id("com.android.library")
  id("kotlin-android")
  id("kotlin-kapt")
  id("dagger.hilt.android.plugin")
}

android {
  compileSdk = Versions.Sdk.compile
  defaultConfig {
    minSdk = Versions.Sdk.min
targetSdk = Versions.Sdk.target
  }
  buildFeatures {
    dataBinding = true
  }
}

dependencies {
  implementation(project(":feature:resources"))
  implementation(project(":feature:core"))

  implementation(Dep.material)

  implementation(Dep.AndroidX.constraintLayout)
  implementation(Dep.Dagger.hilt)
  kapt(Dep.Dagger.hiltKapt)
}
