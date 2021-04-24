buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.1.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${com.example.buildsrc.Versions.kotlin}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${com.example.buildsrc.Versions.hilt}")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}