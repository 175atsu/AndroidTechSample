package com.example.androidtechsample.util

import android.graphics.Outline
import android.view.View
import android.view.ViewOutlineProvider
import androidx.databinding.BindingAdapter

object RoundedCornerAdapter {
  @JvmStatic
  @BindingAdapter("rect_radius_dp")
  fun setRect(view: View, radius: Int) {
    view.outlineProvider = RoundedCornerOutlineProvider(radius.dp)
    view.clipToOutline = true
  }
}

class RoundedCornerOutlineProvider(
  private val radius: Int
) : ViewOutlineProvider() {

  override fun getOutline(view: View, outline: Outline) {
    outline.setRoundRect(
      0, 0,
      view.width,
      view.height,
      radius.toFloat()
    )
  }
}
