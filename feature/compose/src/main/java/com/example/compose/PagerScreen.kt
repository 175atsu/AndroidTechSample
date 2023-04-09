package com.example.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.resouces.CustomTheme

@Composable
fun PagerScreen() {
  Scaffold {
    Surface(
      modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues = it),
      color = CustomTheme.colors.surfacePrimary
    ) {
      Text(text = "PagerScreen")
    }
  }
}
