package com.example.composeapp

import android.content.Context
import android.graphics.Bitmap
import androidx.core.graphics.drawable.toBitmapOrNull
import coil.imageLoader
import coil.request.CachePolicy
import coil.request.ErrorResult
import coil.request.ImageRequest
import coil.request.SuccessResult

suspend fun Context.getRandomImage(url: String, force: Boolean = false): Bitmap? {
  val request = ImageRequest.Builder(this).data(url).apply {
    if (force) {
      memoryCachePolicy(CachePolicy.DISABLED)
      diskCachePolicy(CachePolicy.DISABLED)
    }
  }.build()

  return when (val result = imageLoader.execute(request)) {
    is ErrorResult -> throw result.throwable
    is SuccessResult -> result.drawable.toBitmapOrNull()
  }
}
