package com.example.quiz_omgu_android_app.ui.screens.rooms_screen

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.quiz_omgu_android_app.R
import com.example.quiz_omgu_android_app.data.model.RoomTestData
import com.example.quiz_omgu_android_app.ui.components.ScreenHeader
import com.example.quiz_omgu_android_app.ui.screens.rooms_screen.components.RoomsCategoryTabs
import com.example.quiz_omgu_android_app.ui.screens.rooms_screen.components.RoomsLazyColumn
import com.example.quiz_omgu_android_app.ui.screens.rooms_screen.components.inputs.SearchAndSortBar
import com.example.quiz_omgu_android_app.ui.screens.rooms_screen.components.dialogs.SortOptionsDialog

object RoomTabs {
    val tabs = listOf("закрытые", "в процессе", "черновики")
}

@Composable
fun RoomsScreen(
    modifier: Modifier = Modifier,
    scrollState: LazyListState,
    onNavBarVisibleChange: (Boolean) -> Unit,
    onCreateRoomClick: () -> Unit
) {
    var searchQuery by rememberSaveable { mutableStateOf("") }
    val pagerState = rememberPagerState(pageCount = { RoomTabs.tabs.size })
    var isSortDialogVisible by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    val onNavBarVisibilityChangeState = rememberUpdatedState(onNavBarVisibleChange)

    LaunchedEffect(Unit) {
        onNavBarVisibilityChangeState.value(true)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        ScreenHeader(
            title = "Комнаты",
            showRightButton = true,
            onRightButtonClick = onCreateRoomClick
        )

        RoomsCategoryTabs(
            pagerState = pagerState,
            coroutineScope = coroutineScope,
            tabsList = RoomTabs.tabs
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.small_spacer)))

        SearchAndSortBar(
            searchQuery = searchQuery,
            onSearchQueryChange = { searchQuery = it },
            onSearch = {}, // TODO: Добавить обработку поискового запроса
            onSortClick = { isSortDialogVisible = true }
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.medium_spacer)))

        HorizontalPager(state = pagerState) { page ->
            when (page) {
                0 -> RoomsLazyColumn(rooms = RoomTestData.closedRooms, scrollState = scrollState)
                1 -> {} // TODO: Добавить карточки активных комнат
                2 -> RoomsLazyColumn(rooms = RoomTestData.draftRooms, scrollState = scrollState)
            }
        }

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.medium_spacer)))

        if (isSortDialogVisible) {
            SortOptionsDialog(
                onDismiss = { isSortDialogVisible = false },
                onSortSelected = {} // TODO: Добавить обработку сортировки
            )
        }
    }
}