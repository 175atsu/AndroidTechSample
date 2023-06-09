package com.example.compose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
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

@Composable
fun AnimationScreen() {
  Surface(color = CustomTheme.colors.surfacePrimary) {
    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
      item {
        SimpleAnimatedVisibilityContent()
        Spacer(modifier = Modifier.height(16.dp))
        RateGraphContent()
      }
    }
  }
}

@Composable
private fun SimpleAnimatedVisibilityContent() {
  var visible by remember { mutableStateOf(false) }
  val scope = rememberCoroutineScope()

  ContentText(text = "ExpandHorizontally")
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
private fun RateGraphContent() {
  val list = listOf(
    0.95f,
    0.9f,
    0.8f,
    0.7f,
    0.6f,
    0.5f,
    0.4f,
    0.3f,
    0.2f,
    0.1f,
    0.05f
  )
  var launcher by remember { mutableStateOf(false) }
  val scope = rememberCoroutineScope()

  ContentText(text = "RateGraphModule")
  Spacer(modifier = Modifier.height(8.dp))
  PlayButton(status = launcher) {
    scope.launch {
      launcher = true
      delay((150 * list.size + 1000).toLong())
      launcher = false
    }
  }
  Spacer(modifier = Modifier.height(8.dp))
  list.forEachIndexed { index, fl ->
    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = launcher) {
      visible = if (launcher) {
        delay(150 * index.toLong())
        true
      } else {
        false
      }
    }

    Row {
      AnimatedVisibility(
        visible = visible,
        enter = expandHorizontally(
          animationSpec = tween(durationMillis = 400)
        )
      ) {
        Box(
          modifier = Modifier
            .fillMaxWidth(fl)
            .height(40.dp)
            .padding(vertical = 8.dp)
            .background(color = CustomTheme.colors.objectHighEmphasis)
        )
      }
      Box(
        modifier = Modifier
          .fillMaxWidth(1 - fl)
          .height(40.dp)
          .padding(vertical = 8.dp)
          .background(color = CustomTheme.colors.objectHighEmphasisInverse)
      )
    }
  }
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

@Composable
private fun ContentText(text: String) = Text(
  text = text,
  color = CustomTheme.colors.textHighEmphasis,
  style = CustomTypography.body1Bold
)


@Preview
@Composable
fun AnimationScreenPreview() {
  CustomTheme {
    AnimationScreen()
  }
}
