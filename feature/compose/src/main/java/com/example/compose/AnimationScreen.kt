package com.example.compose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.resouces.CustomTheme
import com.example.resouces.CustomTypography

@Composable
fun AnimationScreen() {
  LazyColumn(
    modifier = Modifier
      .fillMaxSize()
      .padding(16.dp)
  ) {
    item {
      Text(
        text = "ExpandHorizontally",
        color = CustomTheme.colors.textHighEmphasis,
        style = CustomTypography.body1
      )

      var visible by remember { mutableStateOf(false) }
      AnimatedVisibility(
        visible = visible,
        enter = expandHorizontally()
      ) {
        AsyncImage(
          modifier = Modifier
            .size(64.dp)
            .clip(CircleShape),
          model = "https://img-newsweekjapan.jp/akane/assets_c/2022/12/akane221227_cat-thumb-720xauto-581933.jpg",
          contentDescription = null,
          contentScale = ContentScale.Crop,
          placeholder = painterResource(R.drawable.ic_clear)
        )
      }
      LaunchedEffect(key1 = Unit) { visible = true }
    }
  }
}

@Preview
@Composable
fun AnimationScreenPreview() {
  CustomTheme {
    AnimationScreen()
  }
}
