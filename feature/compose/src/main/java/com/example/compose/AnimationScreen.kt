package com.example.compose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun AnimationScreen() {
  Surface(color = CustomTheme.colors.surfacePrimary) {
    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
      item {
        ExpandHorizontally()
        Spacer(modifier = Modifier.height(16.dp))
        RateGraphModule()
      }
    }
  }
}

@Composable
private fun ExpandHorizontally() {
  var visible by remember { mutableStateOf(false) }
  val scope = rememberCoroutineScope()

  Text(
    text = "ExpandHorizontally",
    color = CustomTheme.colors.textHighEmphasis,
    style = CustomTypography.body1
  )
  Spacer(modifier = Modifier.height(8.dp))
  PlayButton(status = visible) {
    scope.launch {
      visible = true
      delay(1000)
      visible = false
    }
  }
  Spacer(modifier = Modifier.height(8.dp))
  Box(modifier = Modifier.size(128.dp)) {
    AnimatedVisibility(
      visible = visible,
      enter = expandHorizontally(),
      exit = fadeOut()
    ) {
      AsyncImage(
        modifier = Modifier
          .fillMaxSize()
          .clip(CircleShape),
        model = "https://img-newsweekjapan.jp/akane/assets_c/2022/12/akane221227_cat-thumb-720xauto-581933.jpg",
        contentDescription = null,
        contentScale = ContentScale.Crop,
        placeholder = painterResource(R.drawable.ic_clear)
      )
    }
  }
}

@Composable
private fun RateGraphModule() {
  Text(
    text = "RateGraphModule",
    color = CustomTheme.colors.textHighEmphasis,
    style = CustomTypography.body1
  )

  val list = List(50) { Random.nextFloat() }.sortedDescending()
  var visible by remember { mutableStateOf(false) }

  list.forEach {
    AnimatedVisibility(
      visible = visible,
      enter = expandHorizontally(
        animationSpec = tween(
          durationMillis = 400,
          delayMillis = 150
        )
      )
    ) {
      Box(
        modifier = Modifier
          .fillMaxWidth(it)
          .height(40.dp)
          .padding(vertical = 8.dp)
          .background(color = CustomTheme.colors.objectHighEmphasis)
      )
    }
  }
  LaunchedEffect(key1 = Unit) { visible = true }
}

@Composable
private fun PlayButton(status: Boolean, onClick: () -> Unit) {
  IconButton(
    modifier = Modifier
      .size(48.dp)
      .background(color = CustomTheme.colors.objectAccentPrimary, shape = CircleShape),
    onClick = onClick,
  ) {
    val resourceId = if (status) R.drawable.ic_pause else R.drawable.ic_play_arrow
    Icon(
      painter = painterResource(id = resourceId),
      contentDescription = null,
      tint = CustomTheme.colors.objectHighEmphasisInverse
    )
  }
}

@Preview
@Composable
fun AnimationScreenPreview() {
  CustomTheme {
    AnimationScreen()
  }
}
