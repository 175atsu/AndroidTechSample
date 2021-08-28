import com.example.buildsrc.Dep

plugins {
  id("com.android.application")
  id("kotlin-android")
  id("kotlin-kapt")
  id("dagger.hilt.android.plugin")
}

android {
  compileSdk = 30
  buildToolsVersion = "29.0.3"

  defaultConfig {
    applicationId = "com.example.androidtechsample"
    minSdk = 23
    targetSdk = 30
    versionCode = 1
    versionName = "1.0"

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
  implementation(Dep.AndroidX.appCompat)
  implementation(Dep.AndroidX.core)
  implementation(Dep.AndroidX.constraintLayout)
  implementation(Dep.AndroidX.navFragmentKtx)
  implementation(Dep.AndroidX.navUi)
  implementation(Dep.AndroidX.navRuntime)
  implementation(Dep.AndroidX.work)
  implementation(Dep.AndroidX.biometric)
  implementation(Dep.AndroidX.CameraX.core)
  implementation(Dep.AndroidX.CameraX.camera2)
  implementation(Dep.AndroidX.CameraX.lifecycle)
  implementation(Dep.AndroidX.CameraX.view)
  implementation(Dep.AndroidX.CameraX.extensions)
  implementation(Dep.coroutine)
  implementation(Dep.material)
  implementation(Dep.compat)
  implementation(Dep.DI.hilt)
  kapt(Dep.DI.hiltKapt)

  implementation(Dep.Groupie.groupie)
  implementation(Dep.Groupie.databinding)

  implementation(Dep.Timber.plugin)

  androidTestImplementation(Dep.AndroidX.Test.ext)
  androidTestImplementation(Dep.AndroidX.Test.espresso)

  testImplementation(Dep.Test.junit4)
}
