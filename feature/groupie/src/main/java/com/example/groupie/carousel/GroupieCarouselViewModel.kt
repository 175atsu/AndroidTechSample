package com.example.groupie.carousel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xwray.groupie.Group
import com.xwray.groupie.GroupieAdapter

class GroupieCarouselViewModel : ViewModel() {

  private val _itemList = MutableLiveData<List<Group>>()
  val itemList: LiveData<List<Group>> = _itemList

  fun fetchData(colors: IntArray, adapter: GroupieAdapter) {
    val list = mutableListOf<Group>()
    for (i in 0..9) {
      list += GroupieCarouselItem(colors[i], adapter)
    }
    _itemList.value = list
  }

//  fun delete(postion: Int) {
//    list.removeAt(postion)
//    _itemList.value = list
//
//  }
}
