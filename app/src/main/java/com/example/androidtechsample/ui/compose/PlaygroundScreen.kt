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
import com.example.androidtechsample.R
import com.example.androidtechsample.component.TextBlackHead1
import com.example.androidtechsample.component.TextBlackHead2
import com.example.androidtechsample.component.TextWhiteBody1

@Composable
fun PlaygroundScreen() {
  MaterialTheme {
    Column(
      modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
      TextBlackHead1(
        text = stringResource(id = R.string.compose_playground),
        modifier = Modifier.padding(vertical = 8.dp)
      )
      Spacer(Modifier.height(16.dp))
      TextBlackHead2(
        text = stringResource(id = R.string.compose_test)
      )
      ToPageButton(toPage = { /*TODO*/ }, textResource = R.string.compose_new_page)
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
  PlaygroundScreen()
}
