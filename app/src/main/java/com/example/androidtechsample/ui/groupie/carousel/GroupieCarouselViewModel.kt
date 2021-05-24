package com.example.androidtechsample.ui.groupie.carousel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xwray.groupie.Group

class GroupieCarouselViewModel : ViewModel() {

  private val _itemList = MutableLiveData<List<Group>>()
  val itemList: LiveData<List<Group>> = _itemList

  fun fetchData(colors: IntArray) {
    val list = mutableListOf<Group>()
    for (i in 0..9) {
      list += GroupieCarouselItem(colors[i])
    }
    _itemList.value = list
  }
}
