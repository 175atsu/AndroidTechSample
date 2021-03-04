package com.example.androidtechsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment

class ComposeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                NewsStory()
            }
        }
    }

    @Composable
    fun NewsStory() {
        val image = painterResource(R.drawable.header)
        val counterState = remember { mutableStateOf(0) }
        val names = List(1000) { "Hello Android #$it" }
        MaterialTheme {
            val typography = MaterialTheme.typography
            Column(
                modifier = Modifier
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val imageModifier = Modifier
                    .requiredHeight(180.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp))

                Image(
                    painter = image,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = imageModifier
                )
                Spacer(Modifier.height(16.dp))
                Text(
                    "A day wandering through the sandhills" +
                            "in Shark Fin Cove, and a few of the " +
                            "sights I saw",
                    style = typography.h6,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Surface(color = Color.Yellow) {
                    Text(
                        "Davenport, California",
                        style = typography.body2,
                        modifier = Modifier
                            .padding(24.dp)
                            .fillMaxWidth()
                    )
                }
                Divider(
                    color = Color.Black,
                    thickness = 4.dp
                )
                Text(
                    "December 2018",
                    style = typography.body1
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Counter()
                    Counter2(
                        count = counterState.value,
                        updateCount = {
                            counterState.value = it
                        }
                    )
                }
                NameList(names, Modifier.weight(1f))
                PhotographerCard()
            }
        }
    }

    @Composable
    fun Counter() {
        val count = remember { mutableStateOf(0) }
        Button(onClick = { count.value++ }) {
            Text("I've been clicked ${count.value} times")
        }
    }

    @Composable
    fun Counter2(count: Int, updateCount: (Int) -> Unit) {
        Button(
            onClick = { updateCount(count + 1) },
            colors = ButtonDefaults.buttonColors(backgroundColor = if (count > 5) Color.Green else Color.White)
        ) {
            Text("I've been clicked $count times")
        }
    }

    @Composable
    fun NameList(names: List<String>, modifier: Modifier = Modifier) {
        LazyColumn(modifier = modifier) {
            items(items = names) { name ->
                Greeting(name = name)
                Divider(color = Color.Black)
            }
        }
    }

    @Composable
    fun PhotographerCard(modifier: Modifier = Modifier) {
        Row(
            modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(MaterialTheme.colors.surface)
                .clickable(onClick = {})
                .padding(16.dp)
        ) {
            Surface(
                modifier = Modifier.size(50.dp),
                shape = CircleShape,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
            ) {

            }
            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text("Alfred Sisley", fontWeight = FontWeight.Bold)
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text("3 minutes ago", style = MaterialTheme.typography.body2)
                }
            }
        }
    }

    @Composable
    fun Greeting(name: String) {
        val isSelected = remember { mutableStateOf(false) }
        val backgroundColor =
            animateColorAsState(if (isSelected.value) Color.Red else Color.Transparent)
        Text(
            text = "Hello $name!",
            modifier = Modifier
                .padding(24.dp)
                .background(color = backgroundColor.value)
                .clickable(onClick = { isSelected.value = !isSelected.value })
        )
    }

    @Preview
    @Composable
    fun DefaultPreview() {
        NewsStory()
    }
}