package com.example.buildsrc

object Versions {
  const val kotlin = "1.8.10"
  const val gradle = "7.0.2"
  const val navigation = "2.4.1"
  const val hilt = "2.37"
  const val groupie = "2.9.0"

  object Sdk {
    const val min = 26
    const val target = 34
    const val compile = 34
  }

  object Androidx {
    const val compose = "1.4.3"
  }
}

object Dep {

  const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"

  object Kotlin {
    const val plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
  }

  object AndroidX {
    const val appCompat = "androidx.appcompat:appcompat:1.4.1"
    const val core = "androidx.core:core-ktx:1.7.0"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.3"
    const val work = "androidx.work:work-runtime-ktx:2.7.0"
    const val biometric = "androidx.biometric:biometric:1.1.0"
    const val browser = "androidx.browser:browser:1.5.0"

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
      const val ui = "androidx.compose.ui:ui:1.4.1"
      const val uiTooling = "androidx.compose.ui:ui-tooling:1.4.1"
      const val navigation = "androidx.navigation:navigation-compose:2.5.3"
      const val material = "androidx.compose.material:material:1.4.1"
      const val material3 = "androidx.compose.material3:material3:1.0.1"
      const val runtime = "androidx.compose.runtime:runtime:1.4.1"
      const val runtimeLiveData = "androidx.compose.runtime:runtime-livedata:1.4.1"
    }

    object Hilt {
      const val lifecycle = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha01"
      const val compiler = "androidx.hilt:hilt-compiler:1.0.0-alpha01"
    }

    object Grance {
      const val core = "androidx.glance:glance:1.0.0"
      const val appwidget = "androidx.glance:glance-appwidget:1.0.0"
    }

    object Test {
      const val ext = "androidx.test.ext:junit:1.1.3"
      const val espresso = "androidx.test.espresso:espresso-core:3.4.0"
    }
  }

  object KotlinX {
    object Coroutine {
      const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0"
      const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9"
    }
  }

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
    const val gradle = "org.jlleitschuh.gradle:ktlint-gradle:10.0.0"
  }

  object Timber {
    const val plugin = "com.jakewharton.timber:timber:5.0.1"
  }

  const val material = "com.google.android.material:material:1.6.0"
  const val compat = "com.android.support:support-compat:28.0.0"

  object Dagger {
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltKapt = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val plugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
  }

  const val coil = "io.coil-kt:coil-compose:2.3.0"

  object Test {
    const val junit4 = "junit:junit:4.13.2"
  }
}
