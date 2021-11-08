package com.example.twitter.core

import androidx.annotation.DrawableRes

sealed class TwitterBottomNavItem(
  val root: String,
  @DrawableRes var selectIcon: Int,
  @DrawableRes var unSelectIcon: Int
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
      R.drawable.ic_home_fill_black_24dp,
      R.drawable.ic_home_black_24dp
    )

  object Search :
    TwitterBottomNavItem(
      SEARCH_ROUTE,
      R.drawable.ic_search_black_24dp,
      R.drawable.ic_search_black_24dp
    )

  object Notification : TwitterBottomNavItem(
    NOTIFICATION_ROUTE,
    R.drawable.ic_notifications_fill_black_24dp,
    R.drawable.ic_notifications_black_24dp
  )

  object DM :
    TwitterBottomNavItem(
      DM_ROUTE,
      R.drawable.ic_email_fill_black_24dp,
      R.drawable.ic_email_black_24dp
    )
}
