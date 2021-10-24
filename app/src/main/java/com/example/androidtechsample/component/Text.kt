package com.example.androidtechsample.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.androidtechsample.resource.textStyleBlackBody2
import com.example.androidtechsample.resource.textStyleBlackBody3
import com.example.androidtechsample.resource.textStyleBlackHead1
import com.example.androidtechsample.resource.textStyleBlackHead2
import com.example.androidtechsample.resource.textStyleWhiteBody1

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
