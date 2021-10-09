package com.example.androidtechsample.ui.list

data class FollowUser(
  val name: String,
  val icon: String
) {
  companion object {
    val SAMPLE = FollowUser(
      name = "テスト",
      icon = "hoge"
    )
  }
}
