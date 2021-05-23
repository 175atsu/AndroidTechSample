package com.example.androidtechsample.ui.groupie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidtechsample.data.GroupieSampleModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GroupieBasicViewModel @Inject constructor(
  private val groupieSample: GroupieSampleModel
) : ViewModel() {

  private val _itemList = MutableLiveData<List<String>>()
  val itemList: LiveData<List<String>> = _itemList

  fun fetchData() {
    _itemList.value = groupieSample.sampleBasicList
  }
}
