package com.example.androidtechsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
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
        MaterialTheme {
            val typography = MaterialTheme.typography
            Column(
                modifier = Modifier.padding(16.dp)
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
                Text(
                    "Davenport, California",
                    style = typography.body2
                )
                Text(
                    "December 2018",
                    style = typography.body1
                )
            }
        }
    }

    @Preview
    @Composable
    fun DefaultPreview() {
        NewsStory()
    }
}