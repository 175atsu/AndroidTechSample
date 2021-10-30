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
}

dependencies {
  implementation(com.example.buildsrc.Dep.DI.hilt)
  kapt(com.example.buildsrc.Dep.DI.hiltKapt)
}
