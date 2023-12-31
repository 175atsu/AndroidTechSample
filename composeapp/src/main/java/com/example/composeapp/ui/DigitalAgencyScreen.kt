package com.example.composeapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.composeapp.R
import com.messi.designsystem.digitalagency.DigitalAgencyTheme
import com.messi.designsystem.digitalagency.component.ButtonSize
import com.messi.designsystem.digitalagency.component.DigitalAgencyScaffold
import com.messi.designsystem.digitalagency.component.DigitalAgencyTopAppBar
import com.messi.designsystem.digitalagency.component.PrimaryButton
import com.messi.designsystem.digitalagency.component.SecondaryButton
import com.messi.designsystem.digitalagency.component.TertiaryButton

@Composable
fun DigitalAgencyScreen(navController: NavController) {
  DigitalAgencyScaffold(
    topBar = {
      DigitalAgencyTopAppBar(
        textResId = R.string.compose_digital_agency,
        navigationIcon = R.drawable.ic_arrow_back,
        onClickNavigationIcon = navController::popBackStack
      )
    }
  ) {
    Surface(
      modifier = Modifier
        .fillMaxSize()
        .padding(it),
      color = DigitalAgencyTheme.colors.backgroundPrimary
    ) {
      LazyColumn() {
        item {
          PrimaryButton(text = "ラベル", size = ButtonSize.Large) {}
          PrimaryButton(text = "ラベル", size = ButtonSize.Medium) {}
          PrimaryButton(text = "ラベル", size = ButtonSize.Small) {}
          SecondaryButton(text = "ラベル", size = ButtonSize.Large) {}
          SecondaryButton(text = "ラベル", size = ButtonSize.Medium) {}
          SecondaryButton(text = "ラベル", size = ButtonSize.Small) {}
          TertiaryButton(text = "ラベル", size = ButtonSize.Large) {}
          TertiaryButton(text = "ラベル", size = ButtonSize.Medium) {}
          TertiaryButton(text = "ラベル", size = ButtonSize.Small) {}
        }
      }
    }
  }
}
