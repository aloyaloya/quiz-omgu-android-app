package com.example.quiz_omgu_android_app.ui.screens.create_room_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CreateRoomScreen(
    modifier: Modifier = Modifier,
    onNavBarVisibilityChange: (Boolean) -> Unit,
    onBackPressed: () -> Unit
) {
    LaunchedEffect(Unit) {
        onNavBarVisibilityChange(false)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Button(
            modifier = Modifier.height(36.dp),
            onClick = { onBackPressed() }
        ) {
            Text("Назад")
        }
    }
}