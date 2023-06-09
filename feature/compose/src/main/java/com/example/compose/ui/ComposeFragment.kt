package com.example.compose.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.AnimationScreen
import com.example.compose.NavRouter
import com.example.compose.PagerScreen
import com.example.resouces.CustomTheme
import com.example.twitter.core.TwitterScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComposeFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View = ComposeView(requireContext()).apply {
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
    composable(NavRouter.TwitterScreen) { TwitterScreen() }
    composable(NavRouter.PagerScreen) { PagerScreen() }
    composable(NavRouter.AnimationScreen) { AnimationScreen() }
  }
}
