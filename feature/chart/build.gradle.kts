import com.example.buildsrc.Dep

plugins {
  id("com.android.library")
  id("org.jetbrains.kotlin.android")
}

android {
  compileSdk = 31
  defaultConfig {
    minSdk = 26
  }
  buildFeatures {
    dataBinding = true
  }
}

dependencies {
  implementation(project(":feature:resources"))
  implementation(project(":feature:core"))

  implementation(Dep.AndroidX.constraintLayout)
  implementation(Dep.chart)
}
