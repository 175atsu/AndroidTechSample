import com.example.buildsrc.Dep
plugins {
  id("com.android.library")
  id("kotlin-android")
  id("kotlin-kapt")
  id("dagger.hilt.android.plugin")
}

android {
  compileSdk = 31
  buildToolsVersion = "30.0.3"

  defaultConfig {
    minSdk = 23
    targetSdk = 31

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = "1.8"
  }
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
