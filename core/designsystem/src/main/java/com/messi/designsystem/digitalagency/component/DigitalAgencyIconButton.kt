package com.messi.designsystem.digitalagency.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.messi.designsystem.R
import com.messi.designsystem.digitalagency.DigitalAgencyTheme

@Composable
fun ScrollTopButton(modifier: Modifier = Modifier, enabled: Boolean = true, onClick: () -> Unit) {
  IconButton(
    modifier = modifier
      .size(56.dp)
      .border(width = 1.dp, color = DigitalAgencyTheme.colors.iconActive, shape = CircleShape),
    enabled = enabled,
    onClick = onClick,
  ) {
    Icon(
      painter = painterResource(id = R.drawable.ic_arrow_back),
      contentDescription = null,
      tint = DigitalAgencyTheme.colors.iconActive
    )
  }
}
