package com.example.androidtechsample.binding

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object ImageViewBindingAdapters {

  @BindingAdapter("image_circle")
  @JvmStatic
  fun ImageView.loadCircleImageUri(imageUri: String?) {
    imageUri.let {
      Glide.with(this)
        .load(it)
        .into(this)
//      GlideApp.with(this)
//        .load(it)
//        .circleCrop()
//        .into(this)
    }
  }
}
