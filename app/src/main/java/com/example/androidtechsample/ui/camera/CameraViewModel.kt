package com.example.androidtechsample.ui.camera

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidtechsample.util.Display
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CameraViewModel @Inject constructor() : ViewModel() {

  private val _hasSelectorState = MutableLiveData(CameraSelectorType.BACK)
  val hasSelectorState = _hasSelectorState

  private val _hasPreviewSizeState = MutableLiveData(CameraSizeType.BASIC)
  val hasPreviewSizeState = _hasPreviewSizeState

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
}
