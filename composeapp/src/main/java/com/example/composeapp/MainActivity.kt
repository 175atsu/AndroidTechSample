package com.example.composeapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.messi.designsystem.CustomTheme

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      CustomTheme {
        CreateNav()
      }
    }
  }
}

@Composable
fun CreateNav(startDestination: String = NavRouter.PlaygroundScreen) {
  val navController = rememberNavController()
  NavHost(navController = navController, startDestination = startDestination) {
    composable(NavRouter.PlaygroundScreen) { PlaygroundScreen(navController) }
    composable(NavRouter.ComponentScreen) { ComponentScreen(navController) }
    composable(NavRouter.AnimationScreen) { AnimationScreen(navController) }
    composable(NavRouter.PagerScreen) { PagerScreen(navController) }
    composable(NavRouter.DatePickerScreen) { DatePickerScreen(navController) }
  }
}
