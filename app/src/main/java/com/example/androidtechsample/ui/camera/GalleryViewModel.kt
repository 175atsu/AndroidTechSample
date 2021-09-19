package com.example.androidtechsample.ui.camera

import android.content.ContentUris
import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

  fun hoge(context: Context): List<Uri> {
    val imageList = mutableListOf<Uri>()
    val contentResolver = context.contentResolver
    val imageProjection = arrayOf(
      MediaStore.Images.Media.DISPLAY_NAME,
      MediaStore.Images.Media.TITLE,
      MediaStore.Images.Media.DATE_TAKEN,
      MediaStore.Images.Media._ID,
    )
    val cursor = contentResolver.query(
      MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
      imageProjection,
      null,
      null,
      null
    )
    cursor?.use {
      val idColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
      val titleColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media.TITLE)
      while (it.moveToNext()) {
        val id = it.getLong(idColumn)
        val title = it.getString(titleColumn)
        val imageUri = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id)
        imageList.add(imageUri)
      }
    }
    imageList.sortByDescending { it }
    return imageList
  }
}
