import com.example.buildsrc.Dep
plugins {
  id("com.android.library")
  id("kotlin-android")
  id("kotlin-kapt")
  id("dagger.hilt.android.plugin")
}

android {
  compileSdk = 31
  buildFeatures {
    dataBinding = true
  }
}

dependencies {
  implementation(project(":feature:resources"))

  implementation(Dep.AndroidX.constraintLayout)
  implementation(Dep.AndroidX.biometric)
  implementation(Dep.DI.hilt)
  kapt(Dep.DI.hiltKapt)
}
