package com.example.compose

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TextBlackHead1(text: String, modifier: Modifier = Modifier) {
  Text(
    text = text,
    style = textStyleBlackHead1(),
    modifier = modifier
  )
}

@Composable
fun TextBlackHead2(text: String, modifier: Modifier = Modifier) {
  Text(
    text = text,
    style = textStyleBlackHead2(),
    modifier = modifier
  )
}

@Composable
fun TextWhiteBody1(text: String, modifier: Modifier = Modifier) {
  Text(
    text = text,
    style = textStyleWhiteBody1(),
    modifier = modifier
  )
}
