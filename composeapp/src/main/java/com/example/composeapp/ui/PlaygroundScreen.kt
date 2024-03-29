package com.example.composeapp.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.compose.component.MessiElevatedButton
import com.example.composeapp.NavRouter
import com.example.composeapp.R
import com.messi.designsystem.CustomTheme
import com.messi.designsystem.component.CustomScaffold

@Composable
fun PlaygroundScreen(navController: NavController) {
  CustomScaffold(label = stringResource(id = R.string.compose_app_name)) {
    LazyColumn {
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
        MessiElevatedButton(text = stringResource(id = R.string.compose_date_picker)) {
          navController.navigate(NavRouter.DatePickerScreen)
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
