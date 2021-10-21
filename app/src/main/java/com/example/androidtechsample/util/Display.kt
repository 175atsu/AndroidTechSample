package com.example.androidtechsample.util

import android.content.Context
import android.graphics.Point
import android.util.DisplayMetrics
import android.util.Size
import android.view.WindowManager

class Display {
  companion object {
    fun getDisplaySize(context: Context): Size {
      val point = Point()
      val manager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
      manager.defaultDisplay.getSize(point)
      return Size(point.x, point.y)
    }
  }
}

val Context.displayWidth: Int
  get() = this.displayMetrics.widthPixels

val Context.displayMetrics: DisplayMetrics
  get() {
    val metrics = DisplayMetrics()
    val wm = getSystemService(Context.WINDOW_SERVICE) as WindowManager
    wm.defaultDisplay.getMetrics(metrics)
    return metrics
  }
