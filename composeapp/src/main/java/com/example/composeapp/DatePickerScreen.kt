package com.example.composeapp

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.composeapp.util.formatYearMonthDay
import com.messi.designsystem.component.CustomScaffold
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerScreen(navController: NavController, viewModel: DatePickerViewModel = viewModel()) {
  val uiState by viewModel.uiState.collectAsState()
  val context = LocalContext.current
  CustomScaffold(
    label = stringResource(id = R.string.compose_date_picker),
    navigationIcon = painterResource(id = R.drawable.ic_arrow_back),
    onClickNavigationIcon = navController::popBackStack
  ) {
    var datePickerExpanded by remember { mutableStateOf(false) }
    val localDateTime = uiState.selectedDateMillis?.let {
      LocalDateTime.ofInstant(
        Instant.ofEpochMilli(it), ZoneId.systemDefault(),
      ).formatYearMonthDay(context)
    } ?: ""
    LazyColumn {
      item {
        Text(text = "DatePickerDialog")
        Text(text = localDateTime)
        Button(onClick = { datePickerExpanded = true }) {
          Text(text = "選択する")
        }
      }
    }

    val datePickState: DatePickerState =
      rememberDatePickerState(initialSelectedDateMillis = uiState.selectedDateMillis)
    if (datePickerExpanded) {
      DatePickerDialog(
        confirmButton = {
          Button(onClick = {
            viewModel.onSelectedDate(datePickState.selectedDateMillis)
            datePickerExpanded = false
          }) {
            Text(text = "決定")
          }
        },
        dismissButton = {
          OutlinedButton(onClick = { datePickerExpanded = false }) {
            Text(text = "キャンセル")
          }
        },
        onDismissRequest = { datePickerExpanded = false }
      ) {
        DatePicker(
          state = datePickState,
        )
      }
    }
  }
}
