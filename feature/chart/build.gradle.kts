plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
  compileSdk = 31
  defaultConfig {
    minSdk = 23
  }
  buildFeatures {
    dataBinding = true
  }
}

dependencies {

}
