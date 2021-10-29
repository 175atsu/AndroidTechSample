package com.example.androidtechsample.ui.camera

import android.content.Context
import android.media.MediaActionSound
import androidx.camera.core.ImageCapture
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.core.util.displayMetrics
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CameraViewModel @Inject constructor(
  private val mediaController: MediaController
) : ViewModel() {

  private val _hasSelectorState = MutableLiveData(CameraSelectorType.BACK)
  val hasSelectorState = _hasSelectorState

  private val _hasPreviewSizeState = MutableLiveData(CameraSizeType.BASIC)
  val hasPreviewSizeState = _hasPreviewSizeState

  private val _hasFlashState = MutableLiveData(CameraFlashType.AUTO)
  val hasFlashState = _hasFlashState

  fun changeCameraSelector() {
    when (hasSelectorState.value) {
      CameraSelectorType.FRONT -> _hasSelectorState.value = CameraSelectorType.BACK
      CameraSelectorType.BACK -> _hasSelectorState.value = CameraSelectorType.FRONT
    }
  }

  fun changeCameraSize() {
    when (hasPreviewSizeState.value) {
      CameraSizeType.BASIC -> _hasPreviewSizeState.value = CameraSizeType.SQUARE
      CameraSizeType.SQUARE -> _hasPreviewSizeState.value = CameraSizeType.BASIC
    }
  }

  fun getDisplayWidth(context: Context): Int {
    val displaySize = context.displayMetrics
    return displaySize.widthPixels
  }

  fun changeCameraLight() {
    when (hasFlashState.value) {
      CameraFlashType.ON -> _hasFlashState.value = CameraFlashType.OFF
      CameraFlashType.OFF -> _hasFlashState.value = CameraFlashType.AUTO
      else -> _hasFlashState.value = CameraFlashType.ON
    }
  }

  fun getOutputFileOptions(context: Context): ImageCapture.OutputFileOptions {
    return mediaController.getOutputFileOptions(context)
  }

  fun createShutterSound(): MediaActionSound {
    val sound = MediaActionSound()
    sound.load(MediaActionSound.SHUTTER_CLICK)
    return sound
  }
}
