package com.example.quiz_omgu_android_app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.example.quiz_omgu_android_app.R

@Composable
fun DropdownSelector(
    modifier: Modifier = Modifier,
    options: List<String>,
    selected: String?,
    placeholder: String,
    onSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    Box(modifier = modifier) {
        DropdownButton(
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                },
            selected = selected,
            placeholder = placeholder,
            expanded = expanded,
            onClick = { expanded = !expanded },
            icon = true
        )

        DropdownMenu(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.background)
                .width(with(LocalDensity.current) { textFieldSize.width.toDp() }),
            expanded = expanded,
            offset = DpOffset(
                x = 0.dp,
                y = dimensionResource(R.dimen.extra_small_padding)
            ),
            onDismissRequest = { expanded = false }
        ) {
            options.forEachIndexed { index, option ->
                DropdownButton(
                    selected = option,
                    expanded = expanded,
                    onClick = {
                        onSelected(option)
                        expanded = false
                    },
                    icon = false
                )

                if (index < options.size - 1) {
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(horizontal = dimensionResource(R.dimen.small_padding)),
                        thickness = 3.dp
                    )
                }
            }
        }
    }
}

@Composable
fun DropdownButton(
    modifier: Modifier = Modifier,
    selected: String?,
    placeholder: String? = null,
    expanded: Boolean,
    onClick: () -> Unit,
    icon: Boolean = false
) {
    val text = selected ?: placeholder.orEmpty()

    val textColor = if (selected == null) {
        MaterialTheme.colorScheme.onTertiary
    } else {
        MaterialTheme.colorScheme.tertiary
    }

    Button(
        modifier = modifier,
        contentPadding = PaddingValues(
            horizontal = dimensionResource(R.dimen.medium_padding),
            vertical = dimensionResource(R.dimen.medium_padding)
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
        shape = MaterialTheme.shapes.medium,
        onClick = onClick,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium,
                color = textColor
            )

            if (icon) {
                Icon(
                    painter = if (expanded) {
                        painterResource(R.drawable.ic_arrow_up)
                    } else {
                        painterResource(R.drawable.ic_arrow_down)
                    },
                    contentDescription = "Dropdown Icon",
                    tint = MaterialTheme.colorScheme.tertiary
                )
            }
        }
    }
}