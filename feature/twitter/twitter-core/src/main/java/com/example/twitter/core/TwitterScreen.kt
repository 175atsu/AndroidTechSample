package com.example.twitter.core

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.home.ui.HomeScreen
import com.example.twitter.core.TwitterBottomNavItem.Companion.DM_ROUTE
import com.example.twitter.core.TwitterBottomNavItem.Companion.HOME_ROUTE
import com.example.twitter.core.TwitterBottomNavItem.Companion.NOTIFICATION_ROUTE
import com.example.twitter.core.TwitterBottomNavItem.Companion.SEARCH_ROUTE

@Composable
fun TwitterScreen() {
  val selectedItem = remember { mutableStateOf(0) }
  val items = listOf(
    TwitterBottomNavItem.Home,
    TwitterBottomNavItem.Search,
    TwitterBottomNavItem.Notification,
    TwitterBottomNavItem.DM
  )
  val navController = rememberNavController()
  Scaffold(
    bottomBar = {
      BottomNavigation {
        items.forEachIndexed { index, item ->
          BottomNavigationItem(
            icon = {
              Icon(
                painter = painterResource(item.icon),
                contentDescription = item.root
              )
            },
            selected = selectedItem.value == index,
            onClick = {
              navController.navigate(item.root) {
                popUpTo(navController.graph.findStartDestination().id) {
                  saveState = true
                }
                launchSingleTop = true
                restoreState = true
              }
            }
          )
        }
      }
    }
  ) {
    NavHost(
      navController,
      startDestination = TwitterBottomNavItem.Home.root,
    ) {
      composable(HOME_ROUTE) { HomeScreen() }
      composable(SEARCH_ROUTE) { HomeScreen() }
      composable(NOTIFICATION_ROUTE) { HomeScreen() }
      composable(DM_ROUTE) { HomeScreen() }
    }
  }
}
