package com.example.androidtechsample.ui.camera

import android.content.ContentValues
import android.content.Context
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import androidx.camera.core.ImageCapture
import com.example.androidtechsample.R
import java.io.File
import javax.inject.Inject

class MediaController @Inject constructor() {

  private fun getContentValue(outputDirectory: String): ContentValues {
    return ContentValues().apply {
      put(MediaStore.MediaColumns.DISPLAY_NAME, System.currentTimeMillis())
      put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
      put(MediaStore.MediaColumns.RELATIVE_PATH, outputDirectory)
    }
  }

  fun getOutputFileOptions(context: Context): ImageCapture.OutputFileOptions {
    val contentResolver = context.contentResolver
    val folderName = context.getString(R.string.camera_folder_name)

    val outputOptions = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
      val outputDirectory = "${Environment.DIRECTORY_DCIM}/${folderName}/"
      val contentValues = getContentValue(outputDirectory)
      val contentUri = MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)
      ImageCapture.OutputFileOptions.Builder(contentResolver, contentUri, contentValues)
    } else {
      val outputDirectory =
        "${context.getExternalFilesDir(Environment.DIRECTORY_DCIM)}/${folderName}/"
      File(outputDirectory).mkdirs()
      val file = File(outputDirectory, "${System.currentTimeMillis()}.jpg")

      ImageCapture.OutputFileOptions.Builder(file)
    }.build()
    return outputOptions
  }
}
