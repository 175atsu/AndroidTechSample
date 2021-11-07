package com.example.twitter.core

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.home.ui.HomeScreen
import com.example.twitter.core.TwitterBottomNavItem.Companion.DM_ROUTE
import com.example.twitter.core.TwitterBottomNavItem.Companion.HOME_ROUTE
import com.example.twitter.core.TwitterBottomNavItem.Companion.NOTIFICATION_ROUTE
import com.example.twitter.core.TwitterBottomNavItem.Companion.SEARCH_ROUTE

@Composable
fun TwitterScreen() {
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
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
          BottomNavigationItem(
            icon = {
              Icon(
                painter = painterResource(item.icon),
                contentDescription = item.root
              )
            },
            selected = currentRoute == item.root,
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
  ) { innerPadding ->
    Box(modifier = Modifier.padding(innerPadding)) {
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
}
