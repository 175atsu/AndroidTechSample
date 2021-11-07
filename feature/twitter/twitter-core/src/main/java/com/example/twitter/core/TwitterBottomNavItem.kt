package com.example.twitter.core

import androidx.annotation.DrawableRes

sealed class TwitterBottomNavItem(
  val root: String,
  @DrawableRes var icon: Int
) {
  companion object {
    const val HOME_ROUTE = "home"
    const val SEARCH_ROUTE = "search"
    const val NOTIFICATION_ROUTE = "notification"
    const val DM_ROUTE = "dm"
  }

  object Home :
    TwitterBottomNavItem(
      HOME_ROUTE,
      R.drawable.ic_chat_bubble_outline_black_24dp,
    )

  object Search :
    TwitterBottomNavItem(
      SEARCH_ROUTE,
      R.drawable.ic_chat_bubble_outline_black_24dp
    )

  object Notification : TwitterBottomNavItem(
    NOTIFICATION_ROUTE,
    R.drawable.ic_chat_bubble_outline_black_24dp
  )

  object DM :
    TwitterBottomNavItem(
      DM_ROUTE,
      R.drawable.ic_chat_bubble_outline_black_24dp
    )
}
