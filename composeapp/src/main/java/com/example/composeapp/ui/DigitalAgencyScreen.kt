package com.example.composeapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composeapp.R
import com.messi.designsystem.digitalagency.DigitalAgencyTheme
import com.messi.designsystem.digitalagency.component.ButtonSize
import com.messi.designsystem.digitalagency.component.DigitalAgencyTopAppBar
import com.messi.designsystem.digitalagency.component.PrimaryButton
import com.messi.designsystem.digitalagency.component.ScrollTopButton
import com.messi.designsystem.digitalagency.component.SecondaryButton
import com.messi.designsystem.digitalagency.component.TertiaryButton
import kotlinx.coroutines.launch

@Composable
fun DigitalAgencyScreen(navController: NavController) {
  val listState = rememberLazyListState()
  val coroutineScope = rememberCoroutineScope()
  Scaffold(
    topBar = {
      DigitalAgencyTopAppBar(
        textResId = R.string.compose_digital_agency,
        navigationIcon = R.drawable.ic_arrow_back,
        onClickNavigationIcon = navController::popBackStack
      )
    },
    floatingActionButton = {
      ScrollTopButton {
        coroutineScope.launch {
          listState.animateScrollToItem(index = 0)
        }
      }
    }
  ) {
    Surface(
      modifier = Modifier
        .fillMaxSize()
        .padding(it),
      color = DigitalAgencyTheme.colors.backgroundPrimary
    ) {
      LazyColumn(
        state = listState,
        contentPadding = PaddingValues(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
      ) {
        item {
          ContentsCard(
            modifier = Modifier.padding(horizontal = 16.dp),
            description = "ボタン"
          ) {
            PrimaryButton(text = "ボタン", size = ButtonSize.Large) {}
          }
        }
        item {
          ContentsCard(
            modifier = Modifier.padding(horizontal = 16.dp),
            description = "ボタン"
          ) {
            PrimaryButton(text = "ボタン", size = ButtonSize.Large) {}
          }
        }
        item {
          PrimaryButton(text = "ラベル", size = ButtonSize.Large) {}
          Spacer(modifier = Modifier.height(48.dp))
          PrimaryButton(text = "ラベル", size = ButtonSize.Medium) {}
          Spacer(modifier = Modifier.height(148.dp))
          PrimaryButton(text = "ラベル", size = ButtonSize.Small) {}
          Spacer(modifier = Modifier.height(148.dp))
          SecondaryButton(text = "ラベル", size = ButtonSize.Large) {}
          Spacer(modifier = Modifier.height(48.dp))
          SecondaryButton(text = "ラベル", size = ButtonSize.Medium) {}
          Spacer(modifier = Modifier.height(48.dp))
          SecondaryButton(text = "ラベル", size = ButtonSize.Small) {}
          Spacer(modifier = Modifier.height(148.dp))
          TertiaryButton(text = "ラベル", size = ButtonSize.Large) {}
          Spacer(modifier = Modifier.height(48.dp))
          TertiaryButton(text = "ラベル", size = ButtonSize.Medium) {}
          Spacer(modifier = Modifier.height(48.dp))
          TertiaryButton(text = "ラベル", size = ButtonSize.Small) {}
        }
      }
    }
  }
}

@Composable
private fun ContentsCard(
  modifier: Modifier = Modifier,
  description: String,
  content: @Composable (BoxScope) -> Unit
) {
  Column(
    modifier = modifier
      .clip(RoundedCornerShape(8.dp))
      .clickable { }
      .border(
        width = 1.dp,
        color = DigitalAgencyTheme.colors.borderDivider,
        shape = RoundedCornerShape(8.dp)
      )
  ) {
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .aspectRatio(16f / 9f)
        .background(
          DigitalAgencyTheme.colors.backgroundTertiary,
          RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)
        ),
      contentAlignment = Alignment.Center,
      content = content
    )
    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)) {
      Text(text = description, color = DigitalAgencyTheme.colors.textBody)
    }
  }
}
