package com.example.buildsrc

object Versions {
  const val kotlin = "1.5.30"
  const val gradle = "7.0.2"
  const val navigation = "2.4.0-alpha10"
  const val hilt = "2.37"
  const val groupie = "2.9.0"

  object Androidx {
    const val compose = "1.0.3"
  }
}

object Dep {

  object Kotlin {
    const val plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val jdk = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val reflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
    const val allOpen = "org.jetbrains.kotlin:kotlin-allopen:${Versions.kotlin}"
  }

  object Jetpack {
    const val startup = "androidx.startup:startup-runtime:1.0.0"
    const val browser = "androidx.browser:browser:1.3.0"
    const val dataStore = "androidx.datastore:datastore-preferences:1.0.0-alpha06"
  }

  object AndroidX {
    const val appCompat = "androidx.appcompat:appcompat:1.3.0"
    const val core = "androidx.core:core-ktx:1.5.0-beta01"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.4"
    const val work = "androidx.work:work-runtime-ktx:2.5.0"
    const val biometric = "androidx.biometric:biometric:1.1.0"

    object Navigation {
      const val ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
      const val runtime = "androidx.navigation:navigation-runtime-ktx:${Versions.navigation}"
      const val fragmentKtx =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
      const val safeArgs =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
    }

    object CameraX {
      const val core = "androidx.camera:camera-core:1.0.1"
      const val camera2 = "androidx.camera:camera-camera2:1.0.1"
      const val lifecycle = "androidx.camera:camera-lifecycle:1.0.1"
      const val view = "androidx.camera:camera-view:1.0.0-alpha27"
      const val extensions = "androidx.camera:camera-extensions:1.0.0-alpha27"
    }

    object Compose {
      const val ui = "androidx.compose.ui:ui:${Versions.Androidx.compose}"
      const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.Androidx.compose}"
      const val navigation = "androidx.navigation:navigation-compose:${Versions.navigation}"
      const val foundation = "androidx.compose.foundation:foundation:${Versions.Androidx.compose}"
      const val foundationLayout =
        "androidx.compose.foundation:foundation-layout:${Versions.Androidx.compose}"
      const val material = "androidx.compose.material:material:${Versions.Androidx.compose}"
      const val materialIconsCore =
        "androidx.compose.material:material-icons-core:${Versions.Androidx.compose}"
      const val materialIconExtended =
        "androidx.compose.material:material-icons-extended:${Versions.Androidx.compose}"
      const val animation = "androidx.compose.animation:animation:${Versions.Androidx.compose}"
      const val layout =
        "androidx.compose.foundation:foundation-layout:${Versions.Androidx.compose}"
      const val runtime = "androidx.compose.runtime:runtime:${Versions.Androidx.compose}"
      const val runtimeLiveData =
        "androidx.compose.runtime:runtime-livedata:${Versions.Androidx.compose}"
      const val uiUtil = "androidx.compose.ui:ui-util:${Versions.Androidx.compose}"
      const val uiTest = "androidx.compose.ui:ui-test-junit4:${Versions.Androidx.compose}"
    }

    object Test {
      const val ext = "androidx.test.ext:junit:1.1.3"
      const val espresso = "androidx.test.espresso:espresso-core:3.4.0"
    }
  }

  const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9"

  object Glide {
    const val core = "com.github.bumptech.glide:glide:4.12.0"
    const val compiler = "com.github.bumptech.glide:compiler:4.12.0"
  }

  object Groupie {
    const val groupie = "com.github.lisawray.groupie:groupie:${Versions.groupie}"
    const val databinding = "com.github.lisawray.groupie:groupie-databinding:${Versions.groupie}"
  }

  object Ktlint {
    const val plugin = "com.pinterest:ktlint:0.40.0"
  }

  object Timber {
    const val plugin = "com.jakewharton.timber:timber:4.7.1"
  }

  const val material = "com.google.android.material:material:1.3.0"
  const val compat = "com.android.support:support-compat:28.0.0"

  object DI {
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltKapt = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
  }

  object Test {
    const val junit4 = "junit:junit:4.13.2"
  }
}
