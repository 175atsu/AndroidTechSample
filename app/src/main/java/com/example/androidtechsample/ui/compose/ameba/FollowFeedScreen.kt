package com.example.androidtechsample.ui.compose.ameba

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.androidtechsample.component.*

@Composable
fun FollowFeedScreen() {
  val blogList = listOf("a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a")
  LazyColumn(
    modifier = Modifier.fillMaxSize()
  ) {
    items(blogList.size) {
      BlogItem()
    }
  }
}

@Composable
fun BlogItem(modifier: Modifier = Modifier) {
  Column(
    modifier = modifier
      .fillMaxSize()
      .padding(horizontal = 16.dp)
  ) {
    SpacerHeight(8.dp)
    Row(
      verticalAlignment = Alignment.CenterVertically
    ) {
      Image(
        painter = rememberImagePainter("https://cdn08.net/dqwalk/data/img0/img698_1.jpg?53d"),
        contentDescription = null,
        modifier = Modifier
          .size(24.dp)
          .clip(CircleShape)
      )
      SpacerWidth(8.dp)
      TextBlackBody2(text = "ブログタイトル")
    }
    Row(
      horizontalArrangement = Arrangement.SpaceBetween,
      modifier = modifier
        .fillMaxSize()
    ) {
      Column {
        SpacerHeight(16.dp)
        TextBlackHead5(text = "記事タイトル記事タイトル")
        SpacerHeight(8.dp)
        TextBlackBody3(text = "12時間前")
      }
      SpacerWidth(8.dp)
      Image(
        painter = rememberImagePainter("https://img.gamewith.jp/article/thumbnail/rectangle/234714.png"),
        contentDescription = "thumbnail",
        contentScale = ContentScale.Crop,
        modifier = modifier
          .size(72.dp)
          .clip(RoundedCornerShape(8.dp))
      )
    }
    SpacerHeight(8.dp)
    Divider(color = Color.Gray)
  }
}


@Preview
@Composable
fun Preview() {
  FollowFeedScreen()
}
