package com.messi.designsystem.digitalagency.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.messi.designsystem.digitalagency.DigitalAgencyTheme

@Composable
fun DigitalAgencyTopAppBar(
  @StringRes textResId: Int,
  contentDescription: String? = null,
  @DrawableRes navigationIcon: Int? = null,
  onClickNavigationIcon: () -> Unit = {},
) {
  DigitalAgencyTopAppBar(
    title = {
      Text(
        text = stringResource(id = textResId),
      )
    },
    navigationIcon = {
      navigationIcon?.let {
        IconButton(onClick = onClickNavigationIcon) {
          Icon(
            modifier = Modifier.size(24.dp),
            painter = painterResource(id = navigationIcon),
            contentDescription = contentDescription,
            tint = DigitalAgencyTheme.colors.iconLabel
          )
        }
      }
    },
  )
}

@Composable
fun DigitalAgencyTopAppBar(
  title: @Composable () -> Unit,
  modifier: Modifier = Modifier,
  navigationIcon: @Composable (() -> Unit)? = null,
  actions: @Composable RowScope.() -> Unit = {},
) {
  TopAppBar(
    title = title,
    modifier = modifier.statusBarsPadding(),
    navigationIcon = navigationIcon,
    actions = actions,
    backgroundColor = DigitalAgencyTheme.colors.backgroundPrimary,
    contentColor = DigitalAgencyTheme.colors.textBody,
    elevation = 0.dp,
  )
}
