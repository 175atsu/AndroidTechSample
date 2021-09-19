package com.example.androidtechsample.ui.camera

import android.content.Context
import android.media.MediaActionSound
import androidx.camera.core.ImageCapture
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidtechsample.util.Display
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

  private val _hasLightState = MutableLiveData(CameraLightType.OFF)
  val hasLightState = _hasLightState

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
    val displaySize = Display.getDisplaySize(context)
    return displaySize.width
  }

  fun changeCameraLight() {
    when (hasLightState.value) {
      CameraLightType.ON -> _hasLightState.value = CameraLightType.OFF
      CameraLightType.OFF -> _hasLightState.value = CameraLightType.ON
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
