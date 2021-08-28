package com.example.androidtechsample.ui.camera

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CameraViewModel : ViewModel() {

  private val _hasSelectorState = MutableLiveData(CameraSelector.BACK)
  val hasSelectorState = _hasSelectorState

  fun changeCameraSelector() {
    when (hasSelectorState.value) {
      CameraSelector.FRONT -> hasSelectorState.value = CameraSelector.BACK
      CameraSelector.BACK -> hasSelectorState.value = CameraSelector.FRONT
    }
  }
}
