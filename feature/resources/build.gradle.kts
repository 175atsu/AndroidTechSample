import com.example.buildsrc.Dep
plugins {
  id("com.android.library")
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
    kotlinCompilerExtensionVersion = com.example.buildsrc.Versions.Androidx.compose
  }
}

dependencies {
  implementation(Dep.AndroidX.appCompat)
  implementation(Dep.material)

  implementation(Dep.AndroidX.Compose.ui)
  implementation(Dep.AndroidX.Compose.navigation)
  implementation(Dep.AndroidX.Compose.material)
  implementation(Dep.AndroidX.Compose.uiTooling)
  implementation(Dep.AndroidX.Compose.runtime)
}
