package com.example.androidtechsample.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel : ViewModel() {

  private val _followUserState = MutableLiveData<SelectUserState>()
  val followUserState = _followUserState

  fun setPosition(position: Int) {
    _followUserState.value = SelectUserState(position)
  }
}
