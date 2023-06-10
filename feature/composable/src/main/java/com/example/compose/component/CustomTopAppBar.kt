package com.example.compose.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.R
import com.example.resouces.CustomTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
  label: String,
  contentDescription: String?,
  navigationIcon: Painter = painterResource(id = R.drawable.ic_share_black_24dp),
  onClickNavigationIcon: () -> Unit = {},
  isNavigationIcon: Boolean = true
) {
  TopAppBar(
    colors = TopAppBarDefaults.smallTopAppBarColors(
      containerColor = CustomTheme.colors.surfacePrimary
    ),
    title = {
      Text(
        text = label,
        color = CustomTheme.colors.textHighEmphasis,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
      )
    },
    navigationIcon = {
      if (isNavigationIcon) {
        IconButton(onClick = onClickNavigationIcon) {
          Icon(
            modifier = Modifier
              .size(44.dp)
              .padding(10.dp),
            painter = navigationIcon,
            contentDescription = contentDescription,
            tint = CustomTheme.colors.objectHighEmphasis
          )
        }
      }
    }
  )
}
