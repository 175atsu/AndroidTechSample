package com.example.compose.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.NavRouter.PLAYGROUND_ROUTE
import com.example.compose.NavRouter.TWITTER_ROUTE
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
      MaterialTheme {
        CreateNav()
      }
    }
  }
}

@Composable
fun CreateNav(startDestination: String = PLAYGROUND_ROUTE) {
  val navController = rememberNavController()
  NavHost(navController = navController, startDestination = startDestination) {
    composable(PLAYGROUND_ROUTE) { PlaygroundScreen(navController) }
    composable(TWITTER_ROUTE) { TwitterScreen() }
  }
}
