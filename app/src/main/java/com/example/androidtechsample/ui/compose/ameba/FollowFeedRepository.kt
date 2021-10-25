package com.example.androidtechsample.ui.compose.ameba

interface FollowFeedRepository {
  fun getFollowBlog(): List<FollowFeedBlogData>
}
