package com.example.androidtechsample.ui.compose

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
import com.example.androidtechsample.ui.compose.MainDestinations.PLAYGROUND_ROUTE
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComposeFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View = ComposeView(requireContext()).apply {
    setContent {
      CreateNav()
    }
  }
}

object MainDestinations {
  const val PLAYGROUND_ROUTE = "playground"
}

@Composable
fun CreateNav(startDestination: String = PLAYGROUND_ROUTE) {
  val navController = rememberNavController()
  NavHost(navController = navController, startDestination = startDestination) {
    composable(PLAYGROUND_ROUTE) { PlaygroundScreen() }
  }
}
