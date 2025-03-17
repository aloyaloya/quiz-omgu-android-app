package com.example.quiz_omgu_android_app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.quiz_omgu_android_app.R

@Composable
fun ScreenHeader(
    modifier: Modifier = Modifier,
    title: String,
    showBackButton: Boolean = false,
    onBackClick: (() -> Unit)? = null,
    showRightButton: Boolean = false,
    onRightButtonClick: (() -> Unit)? = null
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = dimensionResource(R.dimen.medium_padding)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier.size(48.dp)) {
            if (showBackButton && onBackClick != null) {
                IconButtonWithShadow(
                    icon = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "On previous screen",
                    backgroundColor = MaterialTheme.colorScheme.primary,
                    iconColor = MaterialTheme.colorScheme.onPrimary,
                    shadowColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    onClick = onBackClick
                )
            }
        }

        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            color =  MaterialTheme.colorScheme.tertiary
        )

        Box(modifier.size(48.dp)) {
            if (showRightButton && onRightButtonClick != null) {
                IconButtonWithShadow(
                    icon = Icons.Default.Add,
                    contentDescription = "New room",
                    backgroundColor = MaterialTheme.colorScheme.primary,
                    iconColor = MaterialTheme.colorScheme.onPrimary,
                    shadowColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    onClick = onRightButtonClick
                )
            }
        }
    }
}