package com.example.compose.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessiTopAppBar(
  text: String,
  contentDescription: String? = null,
  navigationIcon: Painter? = null,
  onClickNavigationIcon: () -> Unit = {},
) {
  TopAppBar(
    colors = TopAppBarDefaults.smallTopAppBarColors(
      containerColor = MaterialTheme.colorScheme.primary
    ),
    title = {
      Text(
        text = text,
        color = MaterialTheme.colorScheme.onPrimary,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
      )
    },
    navigationIcon = {
      navigationIcon?.let {
        IconButton(onClick = onClickNavigationIcon) {
          Icon(
            modifier = Modifier.size(24.dp),
            painter = navigationIcon,
            contentDescription = contentDescription,
            tint = MaterialTheme.colorScheme.onPrimary
          )
        }
      }
    }
  )
}
