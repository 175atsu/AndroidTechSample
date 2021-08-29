package com.example.androidtechsample.util

import android.content.Context
import android.graphics.Point
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
