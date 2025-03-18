package com.example.quiz_omgu_android_app.ui.screens.rooms_screen.components.dialogs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.quiz_omgu_android_app.R

@Composable
fun SortOptionsHeader(
    modifier: Modifier = Modifier,
    onClose: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.size(dimensionResource(R.dimen.medium_icon)))

        Text(
            text = "Фильтры",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.tertiary
        )

        CloseButton(onClick = onClose)
    }
}

@Composable
private fun CloseButton(onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        modifier = Modifier.size(dimensionResource(R.dimen.medium_icon))
    ) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "Закрыть",
            tint = MaterialTheme.colorScheme.tertiary
        )
    }
}