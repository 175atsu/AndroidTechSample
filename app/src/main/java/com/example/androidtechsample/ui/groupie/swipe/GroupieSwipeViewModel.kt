package com.example.androidtechsample.ui.groupie.swipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xwray.groupie.Group
import com.xwray.groupie.GroupieAdapter

class GroupieSwipeViewModel : ViewModel() {

  private val _itemList = MutableLiveData<List<Group>>()
  val itemList: LiveData<List<Group>> = _itemList

  fun fetchData(colors: IntArray, adapter: GroupieAdapter) {
    val list = mutableListOf<Group>()
    for (i in 0..10) {
      list += GroupieSwipeItem(colors[i])
    }
    _itemList.value = list
  }
}
