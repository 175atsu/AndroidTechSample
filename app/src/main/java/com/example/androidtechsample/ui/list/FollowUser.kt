package com.example.androidtechsample.ui.list

data class FollowUser(
  val name: String,
  val icon: String
) {
  companion object {
    val SAMPLE = FollowUser(
      name = "テスト",
      icon = "https://pbs.twimg.com/profile_images/1261703567934513152/ql-g9xKD_400x400.jpg"
    )
  }
}
