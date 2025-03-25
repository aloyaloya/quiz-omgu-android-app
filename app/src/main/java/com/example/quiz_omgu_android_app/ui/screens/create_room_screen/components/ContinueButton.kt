package com.example.quiz_omgu_android_app.ui.screens.create_room_screen.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.quiz_omgu_android_app.ui.components.ButtonWithShadow

@Composable
fun ContinueButton(
    modifier: Modifier = Modifier,
    enabled: Boolean,
    onClick: () -> Unit
) {
    val animatedBackgroundColor by animateColorAsState(
        targetValue = if (enabled) {
            MaterialTheme.colorScheme.onSecondary
        } else {
            MaterialTheme.colorScheme.onTertiary
        }
    )

    val animatedShadowColor by animateColorAsState(
        targetValue = if (enabled) {
            MaterialTheme.colorScheme.secondaryContainer
        } else {
            MaterialTheme.colorScheme.background
        }
    )

    ButtonWithShadow(
        modifier = modifier.fillMaxWidth(),
        label = "далее",
        onClick = onClick,
        textColor = MaterialTheme.colorScheme.onPrimary,
        backgroundColor = animatedBackgroundColor,
        shadowColor = animatedShadowColor
    )
}