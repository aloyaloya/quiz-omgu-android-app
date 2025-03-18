package com.example.quiz_omgu_android_app.ui.screens.rooms_screen.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.quiz_omgu_android_app.R
import com.example.quiz_omgu_android_app.ui.components.ButtonWithShadow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun RoomsCategoryTabs(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    coroutineScope: CoroutineScope,
    tabsList: List<String>
) {
    TabRow(
        modifier = modifier,
        selectedTabIndex = pagerState.currentPage,
        containerColor = MaterialTheme.colorScheme.background,
        indicator = {},
        divider = {}
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    bottom = dimensionResource(R.dimen.small_padding)
                )
                .padding(
                    horizontal = dimensionResource(R.dimen.medium_padding),
                ),
            horizontalArrangement = Arrangement.spacedBy(
                dimensionResource(R.dimen.extra_small_padding)
            )
        ) {
            tabsList.forEachIndexed { index, tab ->
                val isSelected = pagerState.currentPage == index

                val animatedBackgroundColor by animateColorAsState(
                    targetValue = if (isSelected) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme.background
                    }
                )

                val animatedShadowColor by animateColorAsState(
                    targetValue = if (isSelected) {
                        MaterialTheme.colorScheme.onPrimaryContainer
                    } else {
                        MaterialTheme.colorScheme.background
                    }
                )

                val animatedTextColor by animateColorAsState(
                    targetValue = if (isSelected) {
                        MaterialTheme.colorScheme.onPrimary
                    } else {
                        MaterialTheme.colorScheme.tertiary
                    }
                )

                val onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }

                ButtonWithShadow(
                    modifier = Modifier.weight(1f),
                    label = tab,
                    textColor = animatedTextColor,
                    backgroundColor = animatedBackgroundColor,
                    shadowColor = animatedShadowColor,
                    paddingValues = PaddingValues(
                        horizontal = 0.dp,
                        vertical = dimensionResource(R.dimen.medium_padding)
                    ),
                    onClick = { onClick() }
                )
            }
        }
    }
}