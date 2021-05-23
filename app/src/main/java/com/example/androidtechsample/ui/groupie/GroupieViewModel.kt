package com.example.androidtechsample.ui.groupie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidtechsample.data.GroupiePlaygroundModel
import com.example.androidtechsample.data.GroupieSampleModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GroupieViewModel @Inject constructor(
  private val groupieSample: GroupieSampleModel
) : ViewModel() {

  private val _itemList = MutableLiveData<List<GroupiePlaygroundModel>>()
  val itemList: LiveData<List<GroupiePlaygroundModel>> = _itemList

  fun fetchData() {
    _itemList.value = groupieSample.playgroundModel
  }
}
