package com.example.quiz_omgu_android_app.ui.screens.rooms_screen.components.dialogs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.quiz_omgu_android_app.R
import com.example.quiz_omgu_android_app.ui.theme.AppShapes

@Composable
fun SortOptionsDialog(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
    onSortSelected: (String) -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Card(
            modifier = modifier.padding(horizontal = dimensionResource(R.dimen.medium_padding)),
            shape = AppShapes.large,
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary)
        ) {
            Column(
                modifier = Modifier.padding(dimensionResource(R.dimen.medium_padding))
            ) {
                SortOptionsHeader(onClose = onDismiss)

                Spacer(Modifier.height(dimensionResource(R.dimen.large_spacer)))

                SortSelectorDropdown(
                    label = "Класс",
                    items = listOf("6-1", "7-1", "8-1"),
                    onItemSelected = { onSortSelected("Class: $it") }
                )

                Spacer(Modifier.height(dimensionResource(R.dimen.medium_spacer)))

                SortSelectorDropdown(
                    label = "Предмет",
                    items = listOf("Информатика", "Математика"),
                    onItemSelected = { onSortSelected("Subject: $it") }
                )
            }
        }
    }
}