import com.example.buildsrc.Dep
import com.example.buildsrc.Versions

plugins {
  id("com.android.library")
  id("kotlin-android")
}

android {
  compileSdk = Versions.Sdk.compile
  defaultConfig {
    minSdk = Versions.Sdk.min
    targetSdk = Versions.Sdk.target
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = com.example.buildsrc.Versions.Androidx.compose
  }
}

dependencies {
  implementation(Dep.AndroidX.Navigation.fragmentKtx)
  implementation(Dep.AndroidX.Navigation.ui)
  implementation(Dep.AndroidX.Navigation.runtime)
  implementation(Dep.AndroidX.Compose.ui)
  implementation(Dep.AndroidX.Compose.navigation)
  implementation(Dep.AndroidX.Compose.material)
  implementation(Dep.AndroidX.Compose.uiTooling)
  implementation(Dep.AndroidX.Compose.runtime)
  implementation(Dep.AndroidX.Compose.runtimeLiveData)
}
