package com.example.androidtechsample.util

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager

val Context.displayWidth: Int
  get() = this.displayMetrics.widthPixels

val Context.displayMetrics: DisplayMetrics
  get() {
    val metrics = DisplayMetrics()
    val wm = getSystemService(Context.WINDOW_SERVICE) as WindowManager
    wm.defaultDisplay.getMetrics(metrics)
    return metrics
  }
