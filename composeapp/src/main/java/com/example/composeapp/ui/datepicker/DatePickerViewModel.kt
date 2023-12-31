package com.example.composeapp.ui.datepicker

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DatePickerViewModel : ViewModel() {
  private val _uiState = MutableStateFlow(DatePickerUiState())
  val uiState: StateFlow<DatePickerUiState> = _uiState.asStateFlow()

  fun onSelectedDate(selectedDateMillis: Long?) {
    _uiState.update { it.copy(selectedDateMillis = selectedDateMillis) }
  }

}
