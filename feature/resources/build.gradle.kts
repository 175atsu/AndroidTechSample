import com.example.buildsrc.Dep
plugins {
  id("com.android.library")
}

android {
  compileSdk = 31

  defaultConfig {
    minSdk = 21
    targetSdk = 31

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")
  }
}

dependencies {
  implementation(Dep.AndroidX.appCompat)
  implementation(Dep.material)
}
