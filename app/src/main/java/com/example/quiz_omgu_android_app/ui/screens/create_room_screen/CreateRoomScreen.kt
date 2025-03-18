package com.example.quiz_omgu_android_app.ui.screens.create_room_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.quiz_omgu_android_app.ui.components.ScreenHeader

@Composable
fun CreateRoomScreen(
    modifier: Modifier = Modifier,
    onNavBarVisibilityChange: (Boolean) -> Unit,
    onBackClick: () -> Unit
) {
    LaunchedEffect(Unit) {
        onNavBarVisibilityChange(false)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        ScreenHeader(
            title = "Новая комната",
            showBackButton = true,
            onBackClick = onBackClick
        )
    }
}