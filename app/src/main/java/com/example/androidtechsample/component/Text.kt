package com.example.androidtechsample.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.androidtechsample.resource.*
import com.example.androidtechsample.resource.textStyleBlackBody1

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
fun TextBlackHead4(text: String, modifier: Modifier = Modifier) {
  Text(
    text = text,
    style = textStyleBlackHead4(),
    modifier = modifier
  )
}

@Composable
fun TextBlackHead5(text: String, modifier: Modifier = Modifier) {
  Text(
    text = text,
    style = textStyleBlackHead5(),
    modifier = modifier
  )
}

@Composable
fun TextBlackBody2(text: String, modifier: Modifier = Modifier) {
  Text(
    text = text,
    style = textStyleBlackBody2(),
    modifier = modifier
  )
}

@Composable
fun TextBlackBody3(text: String, modifier: Modifier = Modifier) {
  Text(
    text = text,
    style = textStyleBlackBody3(),
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
