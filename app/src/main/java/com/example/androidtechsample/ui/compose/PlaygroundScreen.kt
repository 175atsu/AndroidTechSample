package com.example.androidtechsample.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androidtechsample.R
import com.example.androidtechsample.component.TextBlackHead1
import com.example.androidtechsample.component.TextBlackHead2
import com.example.androidtechsample.component.TextWhiteBody1

@Composable
fun PlaygroundScreen(navController: NavController) {
  MaterialTheme {
    Column(
      modifier = Modifier.padding(16.dp)
    ) {
      TextBlackHead1(
        text = stringResource(id = R.string.compose_playground)
      )
      Spacer(Modifier.height(24.dp))
      TextBlackHead2(
        text = stringResource(id = R.string.compose_ameba)
      )
      Spacer(Modifier.height(16.dp))
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
    TextWhiteBody1(stringResource(textResource))
  }
}

@Preview
@Composable
fun Preview() {
//  PlaygroundScreen()
}
