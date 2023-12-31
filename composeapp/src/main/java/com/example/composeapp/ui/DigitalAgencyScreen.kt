package com.example.composeapp.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.messi.designsystem.digitalagency.DigitalAgencyTheme

@Composable
fun DigitalAgencyScreen(navController: NavController) {
  DigitalAgencyTheme {
    Text(text = "りんご", color = DigitalAgencyTheme.colors.body)
  }
}
