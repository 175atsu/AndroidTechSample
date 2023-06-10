package com.example.compose.component

import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MessiRadioButton(selected: Boolean, onClick: () -> Unit) {
  RadioButton(selected = selected, onClick = onClick)
}

@Preview
@Composable
fun MessiRadioButtonPreview() {
  MessiRadioButton(selected = true) {}
}
