package com.example.quiz_omgu_android_app.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import com.example.quiz_omgu_android_app.R
import com.example.quiz_omgu_android_app.utils.dropShadow

@Composable
fun IconButtonWithShadow(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    contentDescription: String,
    backgroundColor: Color,
    iconColor: Color,
    shadowColor: Color,
    onClick: () -> Unit
) {
    FilledIconButton(
        modifier = modifier
            .fillMaxSize()
            .dropShadow(color = shadowColor),
        onClick = onClick,
        colors = IconButtonDefaults.filledIconButtonColors(
            containerColor = backgroundColor,
            contentColor = iconColor
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        Icon(
            modifier = Modifier.size(dimensionResource(R.dimen.medium_icon)),
            imageVector = icon,
            contentDescription = contentDescription,
        )
    }
}