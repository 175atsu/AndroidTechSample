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

  implementation(com.example.buildsrc.Dep.AndroidX.appCompat)
  implementation(com.example.buildsrc.Dep.AndroidX.constraintLayout)
  implementation(com.example.buildsrc.Dep.AndroidX.Navigation.fragmentKtx)
  implementation(com.example.buildsrc.Dep.DI.hilt)
  kapt(com.example.buildsrc.Dep.DI.hiltKapt)

  implementation(com.example.buildsrc.Dep.Groupie.groupie)
  implementation(com.example.buildsrc.Dep.Groupie.databinding)
  implementation(com.example.buildsrc.Dep.material)
  implementation(com.example.buildsrc.Dep.Timber.plugin)
}
