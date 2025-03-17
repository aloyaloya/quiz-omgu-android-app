package com.example.quiz_omgu_android_app.ui.screens.rooms_screen.components.cardParts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.example.quiz_omgu_android_app.R
import com.example.quiz_omgu_android_app.ui.theme.AppShapes

@Composable
fun ActionCardButton(
    modifier: Modifier = Modifier,
    text: String,
    icon: Int,
    onAction: () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxHeight(),
        onClick = onAction,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFFCDCD),
            contentColor = Color(0xFFBE0E0E)
        ),
        contentPadding = PaddingValues(dimensionResource(R.dimen.medium_padding)),
        shape = AppShapes.large
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.small_spacer)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier.size(dimensionResource(R.dimen.large_icon)),
                painter = painterResource(icon),
                contentDescription = null
            )
            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}