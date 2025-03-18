package com.example.quiz_omgu_android_app.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import com.example.quiz_omgu_android_app.R
import com.example.quiz_omgu_android_app.utils.dropShadow

@Composable
fun ButtonWithShadow(
    modifier: Modifier = Modifier,
    label: String,
    backgroundColor: Color,
    textColor: Color,
    shadowColor: Color,
    paddingValues: PaddingValues = PaddingValues(dimensionResource(R.dimen.medium_padding)),
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.dropShadow(color = shadowColor),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = textColor
        ),
        contentPadding = paddingValues,
        shape = MaterialTheme.shapes.medium
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}
