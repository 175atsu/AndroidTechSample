package com.example.groupie.basic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.groupie.data.GroupieSampleModel
import com.xwray.groupie.Group
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GroupieBasicViewModel @Inject constructor(
  private val groupieSample: GroupieSampleModel
) : ViewModel() {

  private val _itemList = MutableLiveData<List<Group>>()
  val itemList: LiveData<List<Group>> = _itemList

  fun fetchData() {
    val list = mutableListOf<Group>()
    val bodyList = listOf(
      groupieSample.basicFruitsItems,
      groupieSample.basicAnimalItems
    )
    for ((index, title) in groupieSample.basicHeaderItem.withIndex()) {
      list += HeaderItem(title)
      for (item in bodyList[index]) {
        list += BodyItem(item)
      }
    }
    _itemList.value = list
  }
}
