package com.messi.designsystem.digitalagency.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
  actions: @Composable RowScope.() -> Unit = {},
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
    actions = actions,
  )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DigitalAgencyTopAppBar(
  title: @Composable () -> Unit,
  modifier: Modifier = Modifier,
  navigationIcon: @Composable () -> Unit = {},
  actions: @Composable RowScope.() -> Unit = {},
) {
  TopAppBar(
    title = title,
    modifier = modifier.statusBarsPadding(),
    navigationIcon = navigationIcon,
    actions = actions,
    colors = TopAppBarDefaults.topAppBarColors(
      containerColor = DigitalAgencyTheme.colors.backgroundPrimary
    ),
  )
}
