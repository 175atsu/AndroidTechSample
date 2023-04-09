package com.example.compose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.compose.component.CustomTopAppBar
import com.example.resouces.CustomTheme

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

      InfinityPager()
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
    modifier = Modifier.fillMaxSize(),
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
}
