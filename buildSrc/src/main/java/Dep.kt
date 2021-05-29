package com.example.buildsrc

object Versions {
  const val kotlin = "1.4.32"
  const val navigation = "2.3.5"
  const val hilt = "2.34.1-beta"
  const val groupie = "2.9.0"
}

object Dep {

  object Kotlin {
    const val plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val jdk = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val reflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
    const val allOpen = "org.jetbrains.kotlin:kotlin-allopen:${Versions.kotlin}"
  }

  object Jetpack {
    const val appcompat = "androidx.appcompat:appcompat:1.3.0-beta01"
    const val startup = "androidx.startup:startup-runtime:1.0.0"
    const val browser = "androidx.browser:browser:1.3.0"
    const val dataStore = "androidx.datastore:datastore-preferences:1.0.0-alpha06"
  }

  object AndroidX {
    const val appCompat = "androidx.appcompat:appcompat:1.2.0"
    const val core = "androidx.core:core-ktx:1.5.0-beta01"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.4"
    const val navUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navRuntime = "androidx.navigation:navigation-runtime-ktx:${Versions.navigation}"
    const val navFragmentKtx =
      "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val plugin =
      "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
    const val biometric = "androidx.biometric:biometric:1.1.0"

    object Test {
      const val ext = "androidx.test.ext:junit:1.1.2"
      const val espresso = "androidx.test.espresso:espresso-core:3.3.0"
    }
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

  object DI {
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltKapt = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
  }

  object Test {
    const val junit4 = "junit:junit:4.13.2"
  }
}
