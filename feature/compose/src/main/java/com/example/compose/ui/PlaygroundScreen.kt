package com.example.compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.compose.NavRouter
import com.example.compose.R
import com.example.core.SpacerHeight
import com.example.resouces.CustomTheme
import com.example.resouces.textStyleBlackHead1
import com.example.resouces.textStyleBlackHead2
import com.example.resouces.textStyleWhiteBody1

@Composable
fun PlaygroundScreen(navController: NavController) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(color = CustomTheme.colors.surfacePrimary)
      .padding(horizontal = 16.dp, vertical = 8.dp)
  ) {
    Text(
      text = stringResource(id = R.string.compose_label),
      style = textStyleBlackHead1(),
      modifier = Modifier.padding(vertical = 8.dp)
    )
    SpacerHeight(16.dp)
    Text(
      text = stringResource(id = R.string.compose_twitter),
      style = textStyleBlackHead2()
    )
    ToPageButton(
      toPage = { navController.navigate(NavRouter.TwitterScreen) },
      textResource = R.string.compose_twitter
    )
    SpacerHeight(16.dp)
    Text(
      text = stringResource(id = R.string.compose_pager),
      style = textStyleBlackHead2()
    )
    ToPageButton(
      toPage = { navController.navigate(NavRouter.PagerScreen) },
      textResource = R.string.compose_pager
    )
    SpacerHeight(16.dp)
    Text(
      text = stringResource(id = R.string.compose_animation),
      style = textStyleBlackHead2()
    )
    ToPageButton(
      toPage = { navController.navigate(NavRouter.AnimationScreen) },
      textResource = R.string.compose_animation
    )
  }
}

@Composable
fun ToPageButton(
  toPage: () -> Unit,
  textResource: Int,
) {
  Button(
    onClick = toPage,
    shape = RoundedCornerShape(8.dp)
  ) {
    Text(
      text = stringResource(textResource),
      style = textStyleWhiteBody1()
    )
  }
}

@Preview
@Composable
fun Preview() {
//  PlaygroundScreen()
}
