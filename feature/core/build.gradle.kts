import com.example.buildsrc.Dep

plugins {
  id("com.android.library")
  id("kotlin-android")
}

android {
  compileSdk = 31
  defaultConfig {
    minSdk = 23
  }
}

dependencies {
  implementation(Dep.AndroidX.Navigation.fragmentKtx)
  implementation(Dep.AndroidX.Navigation.ui)
  implementation(Dep.AndroidX.Navigation.runtime)
}
