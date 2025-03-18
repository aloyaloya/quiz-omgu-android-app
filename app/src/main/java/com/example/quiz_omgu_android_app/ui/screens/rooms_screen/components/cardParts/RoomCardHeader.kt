package com.example.quiz_omgu_android_app.ui.screens.rooms_screen.components.cardParts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import com.example.quiz_omgu_android_app.R

@Composable
fun RoomCardHeader(
    modifier: Modifier = Modifier,
    title: String,
    subject: String,
    grade: String
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.small_spacer))) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.tertiary
            )

            Text(
                text = subject.lowercase(),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.tertiary
            )
        }

        Text(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface, CircleShape)
                .padding(
                    horizontal = dimensionResource(R.dimen.small_padding),
                    vertical = dimensionResource(R.dimen.extra_small_padding)
                ),
            text = grade,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.tertiary
        )
    }
}