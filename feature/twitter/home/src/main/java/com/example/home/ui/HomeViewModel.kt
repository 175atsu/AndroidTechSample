package com.example.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.home.data.TweetData
import com.example.home.data.mockTweet

class HomeViewModel : ViewModel() {

  private val _tweetList = MutableLiveData<List<TweetData>>()
  val tweetList: LiveData<List<TweetData>> = _tweetList

  fun fetchItem() {
    _tweetList.value = mockTweet
  }

  fun itemClick() {}
}
