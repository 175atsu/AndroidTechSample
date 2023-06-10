package com.example.compose.component

import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MessiElevatedButton(text: String, onClick: () -> Unit) {
  ElevatedButton(onClick = onClick) {
    Text(text = text)
  }
}

@Composable
fun MessiOutlinedButton(text: String, onClick: () -> Unit) {
  OutlinedButton(onClick = onClick) {
    Text(text = text)
  }
}

@Preview
@Composable
fun MessiElevatedButtonPreview() {
  MessiElevatedButton(text = "ElevatedButton") {}
}

@Preview
@Composable
fun MessiOutlinedButtonPreview() {
  MessiOutlinedButton(text = "OutlinedButton") {}
}
