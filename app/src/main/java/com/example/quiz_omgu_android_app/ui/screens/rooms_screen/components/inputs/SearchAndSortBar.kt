package com.example.quiz_omgu_android_app.ui.screens.rooms_screen.components.inputs

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import com.example.quiz_omgu_android_app.R
import com.example.quiz_omgu_android_app.ui.theme.AppShapes
import com.example.quiz_omgu_android_app.utils.dropShadow

@Composable
fun SearchAndSortBar(
    modifier: Modifier = Modifier,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    onSortClick: () -> Unit,
    onSearch: () -> Unit
) {
    val textFieldColors = TextFieldDefaults.colors(
        focusedContainerColor = MaterialTheme.colorScheme.background,
        unfocusedContainerColor = MaterialTheme.colorScheme.background,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        focusedPlaceholderColor = MaterialTheme.colorScheme.onTertiary,
        unfocusedPlaceholderColor = MaterialTheme.colorScheme.onTertiary,
        focusedTextColor = MaterialTheme.colorScheme.tertiary,
        unfocusedTextColor = MaterialTheme.colorScheme.tertiary
    )

    TextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(R.dimen.medium_padding))
            .dropShadow(),
        value = searchQuery,
        onValueChange = onSearchQueryChange,
        textStyle = MaterialTheme.typography.bodyMedium,
        placeholder = {
            Text(
                text = "поиск по названию...",
                style = MaterialTheme.typography.bodyMedium
            )
        },
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = { onSearch() }),
        singleLine = true,
        shape = AppShapes.medium,
        colors = textFieldColors,
        trailingIcon = {
            Row {
                SortButton(onSortClick)
                SearchButton(onSearch)
            }
        }
    )
}

@Composable
private fun SortButton(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            modifier = Modifier.size(dimensionResource(R.dimen.medium_icon)),
            painter = painterResource(R.drawable.ic_sort_button),
            contentDescription = "Sort",
            tint = MaterialTheme.colorScheme.tertiary
        )
    }
}

@Composable
private fun SearchButton(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            modifier = Modifier.size(dimensionResource(R.dimen.medium_icon)),
            imageVector = Icons.Default.Search,
            contentDescription = "Search",
            tint = MaterialTheme.colorScheme.tertiary
        )
    }
}