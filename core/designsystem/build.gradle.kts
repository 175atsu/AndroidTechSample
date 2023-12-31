import com.example.buildsrc.Dep
import com.example.buildsrc.Versions

plugins {
  id("com.android.library")
  id("kotlin-android")
}

android {
  namespace = "com.messi.designsystem"
  compileSdk = Versions.Sdk.compile
  defaultConfig {
    minSdk = Versions.Sdk.min
    targetSdk = Versions.Sdk.target
  }

  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = Versions.Androidx.compose
  }
}

dependencies {
  implementation(project(":feature:resources"))
  
  implementation(Dep.AndroidX.appCompat)
  implementation(Dep.material)

  implementation(Dep.AndroidX.Compose.ui)
  implementation(Dep.AndroidX.Compose.navigation)
  implementation(Dep.AndroidX.Compose.material)
  implementation(Dep.AndroidX.Compose.material3)
  implementation(Dep.AndroidX.Compose.uiTooling)
  implementation(Dep.AndroidX.Compose.runtime)
}
