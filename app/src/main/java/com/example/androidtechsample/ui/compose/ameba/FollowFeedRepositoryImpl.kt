package com.example.androidtechsample.ui.compose.ameba

class FollowFeedRepositoryImpl : FollowFeedRepository {
  override fun getFollowBlog(): List<FollowFeedBlogData> = mockFollowFeed
}
