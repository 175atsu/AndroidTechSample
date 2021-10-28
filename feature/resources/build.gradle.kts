import com.example.buildsrc.Dep
plugins {
  id("com.android.library")
}

android {
  compileSdk = 31
}

dependencies {
  implementation(Dep.AndroidX.appCompat)
  implementation(Dep.material)
}
