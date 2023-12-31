package com.messi.designsystem.digitalagency.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DigitalAgencyScaffold(
  modifier: Modifier = Modifier,
  topBar: @Composable () -> Unit = {},
  content: @Composable (PaddingValues) -> Unit
) {
  Scaffold(
    modifier = modifier,
    topBar = topBar,
    content = content
  )
}
