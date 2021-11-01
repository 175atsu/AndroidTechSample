package com.example.followfeed.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.followfeed.data.FollowFeedBlogData
import com.example.followfeed.data.mockFollowFeed
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FollowFeedViewModel @Inject constructor() : ViewModel() {

  private val _blogList = MutableLiveData<List<FollowFeedBlogData>>(emptyList())
  val blogList = _blogList

  fun subscribe() {
    getBlogList()
  }

  private fun getBlogList() {
    _blogList.value = mockFollowFeed
  }
}
