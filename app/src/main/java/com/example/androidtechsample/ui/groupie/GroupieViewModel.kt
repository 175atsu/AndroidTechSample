package com.example.androidtechsample.ui.groupie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidtechsample.data.GroupieSample1

class GroupieViewModel : ViewModel() {

  private val _itemList = MutableLiveData<List<String>>()
  val itemList: LiveData<List<String>> = _itemList

  fun fetchData() {
    val groupieSample1 = GroupieSample1()
    _itemList.value = groupieSample1.sampleList
  }
}
