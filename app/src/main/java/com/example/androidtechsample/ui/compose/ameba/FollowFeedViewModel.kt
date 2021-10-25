package com.example.androidtechsample.ui.compose.ameba

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FollowFeedViewModel @Inject constructor(
  private val followFeedRepository: FollowFeedRepository
) : ViewModel() {

  private val _blogList = MutableLiveData<List<FollowFeedBlogData>>(emptyList())
  val blogList = _blogList

  fun subscribe() {
    getBlogList()
  }

  private fun getBlogList() {
    viewModelScope.launch {
      runCatching { followFeedRepository.getFollowBlog() }
        .onSuccess {
          _blogList.value = it
        }
    }
  }
}
