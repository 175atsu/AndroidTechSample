package com.example.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.core.SpacerHeight
import com.example.core.SpacerWidth
import com.example.resouces.textStyleBlackBody2
import com.example.resouces.textStyleBlackHead5

@Composable
fun HomeScreen() {
  LazyColumn(
    modifier = Modifier.fillMaxSize()
  ) {
    items(10) {
      TweetItem()
      Divider(
        color = Color.LightGray,
        thickness = 0.5.dp
      )
    }
  }
}

@Composable
fun TweetItem(modifier: Modifier = Modifier) {
  Row(
    modifier = modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp, vertical = 8.dp)
  ) {
    Image(
      painter = rememberImagePainter("https://cdn08.net/dqwalk/data/img0/img698_1.jpg?53d"),
      contentDescription = null,
      modifier = Modifier
        .size(52.dp)
        .clip(CircleShape)
    )
    SpacerWidth(width = 8.dp)
    Column(
      modifier = modifier
    ) {
      Row(
        verticalAlignment = Alignment.Bottom,
        modifier = modifier
          .fillMaxWidth()
      ) {
        Text(
          text = "ユーザー名",
          style = textStyleBlackHead5()
        )
        SpacerWidth(width = 8.dp)
        Text(
          text = "ユーザーID",
          style = textStyleBlackBody2()
        )
        SpacerWidth(width = 8.dp)
        Text(
          text = "時間",
          style = textStyleBlackBody2()
        )
      }
      Text(
        text = "ツイート内容ツイート内容ツイート内容ツイート内容ツイート内容ツイート内容ツイート内容ツイート内容",
        style = textStyleBlackBody2()
      )
      SpacerHeight(height = 8.dp)
      Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
          .fillMaxWidth()
      ) {
        IconText(R.drawable.ic_chat_bubble_outline_black_24dp)
        IconText(R.drawable.ic_repeat_black_24dp)
        IconText(R.drawable.ic_favorite_border_black_24dp)
        Icon(
          painter = painterResource(id = R.drawable.ic_share_black_24dp),
          contentDescription = null,
          modifier = modifier
            .size(20.dp)
        )
        SpacerWidth(width = 16.dp)
      }
    }
  }
}

@Composable
fun IconText(@DrawableRes resource: Int, modifier: Modifier = Modifier) {
  Row {
    Icon(
      painter = painterResource(id = resource),
      contentDescription = null,
      modifier = modifier
        .size(20.dp)
    )
    Text(
      text = "3",
      style = textStyleBlackBody2()
    )
  }
}

@Preview
@Composable
fun Preview() {
  HomeScreen()
}
