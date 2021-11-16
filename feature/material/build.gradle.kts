import com.example.buildsrc.Dep
plugins {
  id("com.android.library")
  id("kotlin-android")
  id("kotlin-kapt")
  id("dagger.hilt.android.plugin")
}

android {
  compileSdk = 31
  defaultConfig {
    minSdk = 23
  }
  buildFeatures {
    dataBinding = true
  }
}

dependencies {
  implementation(project(":feature:resources"))
  implementation(project(":feature:core"))

  implementation(Dep.AndroidX.constraintLayout)
  implementation(Dep.DI.hilt)
  kapt(Dep.DI.hiltKapt)
}
