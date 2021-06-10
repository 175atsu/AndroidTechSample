package com.example.androidtechsample.util

fun String.rangeOfIndex(string: String): IntRange {
  val startIndex = indexOf(string)
  return startIndex until startIndex + string.length
}
