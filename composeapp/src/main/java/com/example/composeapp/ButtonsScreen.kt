package com.example.composeapp

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.compose.component.MessiTopAppBar

@Composable
fun ButtonsScreen(navController: NavController) {
  Scaffold(topBar = {
    MessiTopAppBar(
      text = "Buttons",
      navigationIcon = painterResource(id = R.drawable.ic_arrow_back),
      onClickNavigationIcon = navController::popBackStack
    )
  }) {
    LazyColumn(Modifier.padding(it)) {

    }
  }
}
