package com.example.quiz_omgu_android_app.ui.screens.rooms_screen.components.dialogs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size


@Composable
fun SortSelectorDropdown(
    modifier: Modifier = Modifier,
    label: String,
    items: List<String>,
    onItemSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val buttonSize = remember { mutableStateOf(Size.Zero) }
    var selectedItem by remember { mutableStateOf("") }
}