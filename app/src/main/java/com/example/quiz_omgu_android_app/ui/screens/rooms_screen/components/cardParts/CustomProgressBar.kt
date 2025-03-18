package com.example.quiz_omgu_android_app.ui.screens.rooms_screen.components.cardParts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.quiz_omgu_android_app.R
import com.example.quiz_omgu_android_app.ui.theme.AppShapes

@Composable
fun CustomProgressBar(
    modifier: Modifier = Modifier,
    progress: Int
) {
    val progressFloat = if (progress > 10) {
        (progress / 100f).coerceIn(0f, 1f)
    } else {
        (10 / 100f).coerceIn(0f, 1f)
    }

    val progressColor = when {
        progress <= 30 -> MaterialTheme.colorScheme.surfaceContainerLowest
        progress <= 69 -> MaterialTheme.colorScheme.surfaceContainerHigh
        else -> MaterialTheme.colorScheme.surfaceContainerHighest
    }

    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Spacer(modifier = Modifier.weight(1.5f))

            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(38.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = R.drawable.progressbar_rectangle),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
                Text(
                    text = "$progress%",
                    color = progressColor,
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .clip(RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp, bottomEnd = 16.dp))
                .background(MaterialTheme.colorScheme.background)
        ) {
            Box(
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.extra_small_padding))
                    .fillMaxWidth(progressFloat)
                    .fillMaxHeight()
                    .clip(AppShapes.medium)
                    .background(progressColor)
                    .padding(dimensionResource(R.dimen.extra_small_padding))
            )
        }
    }
}