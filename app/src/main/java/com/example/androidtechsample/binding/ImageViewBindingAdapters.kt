package com.example.androidtechsample.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.androidtechsample.GlideApp

object ImageViewBindingAdapters {

  @BindingAdapter("image_circle")
  @JvmStatic
  fun ImageView.loadCircleImageUri(imageUri: String?) {
    imageUri.let {
      GlideApp.with(this)
        .load(it)
        .circleCrop()
        .into(this)
    }
  }
}
