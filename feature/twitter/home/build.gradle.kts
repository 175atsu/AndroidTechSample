import com.example.buildsrc.Dep
import com.example.buildsrc.Versions

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
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = Versions.Androidx.compose
  }
}

dependencies {
  implementation(project(":feature:core"))
  implementation(project(":feature:resources"))

  implementation(Dep.DI.hilt)
  kapt(Dep.DI.hiltKapt)
  implementation(Dep.coil)

  implementation(Dep.AndroidX.Compose.ui)
  implementation(Dep.AndroidX.Compose.navigation)
  implementation(Dep.AndroidX.Compose.material)
  implementation(Dep.AndroidX.Compose.uiTooling)
  implementation(Dep.AndroidX.Compose.runtime)
  implementation(Dep.AndroidX.Compose.runtimeLiveData)
}
