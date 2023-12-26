package com.example.composeapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.compose.component.MessiElevatedButton
import com.example.compose.component.MessiTopAppBar
import com.messi.designsystem.CustomTheme

@Composable
fun PlaygroundScreen(navController: NavController) {
  Scaffold(
    topBar = {
      MessiTopAppBar(text = stringResource(id = R.string.compose_app_name))
    }
  ) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
      LazyColumn(modifier = Modifier.padding(it)) {
        item {
          MessiElevatedButton(text = stringResource(id = R.string.compose_component)) {
            navController.navigate(NavRouter.ComponentScreen)
          }
          MessiElevatedButton(text = stringResource(id = R.string.compose_animation)) {
            navController.navigate(NavRouter.AnimationScreen)
          }
          MessiElevatedButton(text = stringResource(id = R.string.compose_pager)) {
            navController.navigate(NavRouter.PagerScreen)
          }
        }
      }
    }
  }
}

@Preview
@Composable
fun PlaygroundScreenPreview() {
  val navController = rememberNavController()
  CustomTheme {
    PlaygroundScreen(navController = navController)
  }
}
