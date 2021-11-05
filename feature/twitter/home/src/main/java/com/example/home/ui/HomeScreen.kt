package com.example.home.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.core.SpacerHeight
import com.example.core.SpacerWidth
import com.example.home.R
import com.example.home.data.TweetData
import com.example.home.data.mockTweet
import com.example.resouces.textStyleBlackBody2
import com.example.resouces.textStyleBlackHead6

@Composable
fun HomeScreen() {
  LazyColumn(
    modifier = Modifier.fillMaxSize()
  ) {
    items(mockTweet + mockTweet + mockTweet) {
      TweetItem(it, ::itemClick)
      Divider(
        color = Color.LightGray,
        thickness = 0.5.dp
      )
    }
  }
}

@Composable
fun TweetItem(
  tweetItem: TweetData,
  onClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  Row(
    modifier = modifier
      .fillMaxWidth()
      .clickable(onClick = onClick)
      .padding(horizontal = 16.dp, vertical = 8.dp)
  ) {
    Image(
      painter = rememberImagePainter(tweetItem.icon),
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
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
          .fillMaxWidth()
      ) {
        Row(
          verticalAlignment = Alignment.Bottom,
          modifier = modifier
            .weight(1f)
        ) {
          Text(
            text = tweetItem.name,
            style = textStyleBlackHead6(),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
          )
          SpacerWidth(width = 8.dp)
          Text(
            text = tweetItem.id,
            style = textStyleBlackBody2(),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
          )
          SpacerWidth(width = 8.dp)
          Text(
            text = tweetItem.time,
            style = textStyleBlackBody2(),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
          )
        }
        SpacerWidth(width = 8.dp)
        Icon(
          painter = painterResource(id = R.drawable.ic_more_vert_black_24dp),
          contentDescription = null,
          modifier = modifier
            .size(20.dp)
        )
      }
      Text(
        text = tweetItem.body,
        style = textStyleBlackBody2()
      )
      SpacerHeight(height = 8.dp)
      Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
          .fillMaxWidth()
      ) {
        IconText(R.drawable.ic_chat_bubble_outline_black_24dp, tweetItem.comment)
        IconText(R.drawable.ic_repeat_black_24dp, tweetItem.re)
        IconText(R.drawable.ic_favorite_border_black_24dp, tweetItem.like)
        Icon(
          painter = painterResource(id = R.drawable.ic_share_black_24dp),
          contentDescription = null,
          modifier = modifier
            .size(20.dp)
        )
        SpacerWidth(width = 8.dp)
      }
    }
  }
}

@Composable
fun IconText(@DrawableRes resource: Int, count: Int, modifier: Modifier = Modifier) {
  Row {
    Icon(
      painter = painterResource(id = resource),
      contentDescription = null,
      modifier = modifier
        .size(20.dp)
    )
    Text(
      text = count.toString(),
      style = textStyleBlackBody2(),
      maxLines = 1
    )
  }
}

fun itemClick() {}

@Preview
@Composable
fun Preview() {
  HomeScreen()
}
