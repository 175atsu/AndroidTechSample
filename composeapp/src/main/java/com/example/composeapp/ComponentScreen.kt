package com.example.composeapp

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.compose.component.MessiElevatedButton
import com.example.compose.component.MessiOutlinedButton
import com.example.compose.component.MessiRadioButton
import com.example.compose.component.MessiTopAppBar
import com.messi.designsystem.CustomTheme

@Composable
fun ComponentScreen(navController: NavController) {

  Scaffold(
    topBar = {
      MessiTopAppBar(
        text = "Buttons",
        navigationIcon = painterResource(id = R.drawable.ic_arrow_back),
        onClickNavigationIcon = navController::popBackStack
      )
    },
  ) {
    LazyColumn(Modifier.padding(it)) {
      item {
        ButtonContent()
        RadioButtonContent()
      }
    }
  }
}

@Composable
private fun ButtonContent() {
  SectionTitle(text = "Button")
  MessiElevatedButton(text = "MessiElevatedButton") {}
  MessiOutlinedButton(text = "MessiOutlinedButton") {}
}

@Composable
private fun RadioButtonContent() {
  var selectItem by remember { mutableStateOf<Selects?>(null) }
  SectionTitle(text = "RadioButton")
  Selects.values().forEach {
    SelectItem(
      select = it,
      selected = selectItem == it
    ) { selectItem = it }
  }
}

@Composable
private fun SelectItem(select: Selects, selected: Boolean, onClick: () -> Unit) {
  Row(verticalAlignment = Alignment.CenterVertically) {
    MessiRadioButton(selected = selected, onClick = onClick)
    Text(text = select.name)
  }
}

enum class Selects {
  CHOICE1, CHOICE2, CHOICE3
}

@Composable
private fun SectionTitle(text: String) {
  Text(text = text, fontSize = 18.sp, fontWeight = FontWeight.Bold)
}

@Preview
@Composable
fun ComponentScreenPreview() {
  val navController = rememberNavController()
  CustomTheme {
    ComponentScreen(navController)
  }
}
