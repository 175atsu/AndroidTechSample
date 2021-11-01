package com.example.followfeed.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.core.SpacerHeight
import com.example.core.SpacerWidth
import com.example.followfeed.data.FollowFeedBlogData
import com.example.resouces.textStyleBlackBody2
import com.example.resouces.textStyleBlackBody3
import com.example.resouces.textStyleBlackHead5

@Composable
fun FollowFeedScreen(
  viewModel: FollowFeedViewModel = viewModel()
) {
  viewModel.subscribe()
  val state by viewModel.blogList.observeAsState(emptyList())
  LazyColumn(
    modifier = Modifier.fillMaxSize()
  ) {
    items(state) {
      BlogItem(it)
    }
  }
}

@Composable
fun BlogItem(blogItem: FollowFeedBlogData, modifier: Modifier = Modifier) {
  Column(
    modifier = modifier
      .fillMaxSize()
      .padding(horizontal = 16.dp)
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = modifier
        .padding(top = 12.dp, bottom = 8.dp)
    ) {
      Image(
        painter = rememberImagePainter(blogItem.blogIcon),
        contentDescription = null,
        modifier = Modifier
          .size(24.dp)
          .clip(CircleShape)
      )
      SpacerWidth(8.dp)
      Text(
        text = blogItem.blogTitle,
        style = textStyleBlackBody2()
      )
    }
    Row(
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically,
      modifier = modifier
        .fillMaxSize()
    ) {
      Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
          .weight(1f)
      ) {
        Text(
          text = blogItem.articleTitle,
          style = textStyleBlackHead5(),
          maxLines = 2,
          overflow = TextOverflow.Ellipsis,
        )
        SpacerHeight(8.dp)
        Text(
          text = blogItem.postTime,
          style = textStyleBlackBody3()
        )
      }
      SpacerWidth(8.dp)
      Image(
        painter = rememberImagePainter(blogItem.articleThumbnail),
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
