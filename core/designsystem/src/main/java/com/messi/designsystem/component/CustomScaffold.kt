package com.messi.designsystem.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter

@Composable
fun CustomScaffold(
  label: String,
  navigationIcon: Painter? = null,
  onClickNavigationIcon: () -> Unit = {},
  content: @Composable () -> Unit,
) {
  Scaffold(
    topBar = {
      CustomTopAppBar(
        text = label,
        navigationIcon = navigationIcon,
        onClickNavigationIcon = onClickNavigationIcon
      )
    }
  ) {
    Surface(
      modifier = Modifier
        .fillMaxSize()
        .padding(it),
      color = MaterialTheme.colorScheme.background
    ) {
      content()
    }
  }
}
