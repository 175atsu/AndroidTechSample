package com.example.composeapp

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.compose.component.MessiElevatedButton

@Composable
fun PlaygroundScreen(navController: NavController) {
  Scaffold {
    LazyColumn(modifier = Modifier.padding(it)) {
      item { Text(text = stringResource(id = R.string.compose_app_name)) }
      item {
        MessiElevatedButton(text = stringResource(id = R.string.compose_buttons)) {
          navController.navigate(NavRouter.ButtonsScreen)
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


@Preview
@Composable
fun PlaygroundScreenPreview() {
  val navController = rememberNavController()
  PlaygroundScreen(navController = navController)
}
