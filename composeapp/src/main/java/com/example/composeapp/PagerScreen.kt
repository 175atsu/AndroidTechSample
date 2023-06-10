package com.example.composeapp

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.compose.component.CustomTopAppBar
import com.example.resouces.CustomTheme
import com.example.resouces.textStyleBlackBody1
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PagerScreen() {
  Scaffold(
    topBar = {
      CustomTopAppBar(
        label = stringResource(id = R.string.compose_pager),
        contentDescription = null
      )
    }
  ) {
    Surface(
      modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues = it),
      color = CustomTheme.colors.surfacePrimary
    ) {
      LazyColumn {
        item {
          TabRowPager()
          InfinityPager()
        }
      }
    }
  }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabRowPager() {
  val tabs = List(10) { "タブ$it" }
  val selectedTabIndex by remember { mutableStateOf(0) }
  val pagerState = rememberPagerState(initialPage = selectedTabIndex)
  val scope = rememberCoroutineScope()

  ScrollableTabRow(
    selectedTabIndex = pagerState.currentPage,
    containerColor = CustomTheme.colors.surfacePrimary,
    contentColor = CustomTheme.colors.objectHighEmphasis,
    edgePadding = 0.dp
  ) {
    tabs.forEachIndexed { index, s ->
      Tab(
        selected = selectedTabIndex == index,
        onClick = { scope.launch { pagerState.scrollToPage(index) } },
        text = { Text(text = s) }
      )
    }
  }
  HorizontalPager(
    modifier = Modifier.fillMaxWidth(),
    state = pagerState,
    pageCount = tabs.size
  ) { index ->
    Box(modifier = Modifier.height(240.dp), contentAlignment = Alignment.Center) {
      Text(text = "$index", style = textStyleBlackBody1())
    }
  }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun InfinityPager() {
  val startIndex = Int.MAX_VALUE / 2
  val pagerState = rememberPagerState(initialPage = startIndex)
  val screenWidth = LocalConfiguration.current.screenWidthDp

  /** (画面幅 - itemのwidth) / 2 - item間のspace */
  val contentPadding = (screenWidth - 280) / 2 - 8
  HorizontalPager(
    modifier = Modifier.fillMaxWidth(),
    state = pagerState,
    pageCount = Int.MAX_VALUE,
    contentPadding = PaddingValues(horizontal = contentPadding.dp)
  ) {
    AsyncImage(
      modifier = Modifier.width(280.dp),
      model = "https://miro.medium.com/v2/resize:fit:1024/0*JFvF1C2N5mnmWd9u.png",
      contentDescription = null
    )
  }
  Spacer(modifier = Modifier.height(16.dp))
  Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
    repeat(5) { iteration ->
      val position = pagerState.currentPage % 5
      val color = if (position == iteration) CustomTheme.colors.objectAccentPrimary
      else CustomTheme.colors.objectHighEmphasis
      Box(
        modifier = Modifier
          .padding(horizontal = 3.dp)
          .clip(CircleShape)
          .background(color)
          .size(6.dp)
      )
    }
  }
}

@Preview
@Composable
fun PreviewPagerScreen() {
  CustomTheme {
    PagerScreen()
  }
}
