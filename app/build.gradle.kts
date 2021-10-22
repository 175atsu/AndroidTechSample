import com.example.buildsrc.Dep
import com.example.buildsrc.Versions

plugins {
  id("com.android.application")
  id("kotlin-android")
  id("kotlin-kapt")
  id("androidx.navigation.safeargs.kotlin")
  id("dagger.hilt.android.plugin")
}

android {
  compileSdk = 30
  buildToolsVersion = "30.0.3"

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
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = Versions.Androidx.compose
  }
}

dependencies {
  implementation(Dep.AndroidX.appCompat)
  implementation(Dep.AndroidX.core)
  implementation(Dep.AndroidX.constraintLayout)
  implementation(Dep.AndroidX.work)
  implementation(Dep.AndroidX.biometric)
  implementation(Dep.AndroidX.Navigation.fragmentKtx)
  implementation(Dep.AndroidX.Navigation.ui)
  implementation(Dep.AndroidX.Navigation.runtime)
  implementation(Dep.AndroidX.CameraX.core)
  implementation(Dep.AndroidX.CameraX.camera2)
  implementation(Dep.AndroidX.CameraX.lifecycle)
  implementation(Dep.AndroidX.CameraX.view)
  implementation(Dep.AndroidX.CameraX.extensions)
  implementation(Dep.AndroidX.Compose.runtime)
  implementation(Dep.coroutine)
  implementation(Dep.material)
  implementation(Dep.compat)
  implementation(Dep.DI.hilt)
  kapt(Dep.DI.hiltKapt)

  implementation(Dep.Glide.core)
  kapt(Dep.Glide.compiler)

  implementation(Dep.Groupie.groupie)
  implementation(Dep.Groupie.databinding)

  implementation(Dep.Timber.plugin)

  androidTestImplementation(Dep.AndroidX.Test.ext)
  androidTestImplementation(Dep.AndroidX.Test.espresso)

  testImplementation(Dep.Test.junit4)
}
