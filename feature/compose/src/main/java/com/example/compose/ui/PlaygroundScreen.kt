package com.example.compose.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.compose.NavRouter
import com.example.compose.R
import com.example.compose.textStyleBlackHead1
import com.example.compose.textStyleBlackHead2
import com.example.compose.textStyleWhiteBody1

@Composable
fun PlaygroundScreen(navController: NavController) {
  MaterialTheme {
    Column(
      modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
      Text(
        text = stringResource(id = R.string.compose_label),
        style = textStyleBlackHead1(),
        modifier = Modifier.padding(vertical = 8.dp)
      )
      Spacer(Modifier.height(16.dp))
      Text(
        text = stringResource(id = R.string.compose_ameba),
        style = textStyleBlackHead2()
      )
      ToPageButton(
        toPage = { navController.navigate(NavRouter.AMEBA_FOLLOW_FEED_ROUTE) },
        textResource = R.string.compose_ameba_follow_feed
      )
    }
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
