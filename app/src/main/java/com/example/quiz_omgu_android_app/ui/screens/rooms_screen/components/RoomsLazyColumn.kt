package com.example.quiz_omgu_android_app.ui.screens.rooms_screen.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.quiz_omgu_android_app.R
import com.example.quiz_omgu_android_app.data.model.Room
import com.example.quiz_omgu_android_app.ui.screens.rooms_screen.components.cardParts.SwipeableCardWithAction
import com.example.quiz_omgu_android_app.ui.screens.rooms_screen.components.cardParts.ActionCardButton
import com.example.quiz_omgu_android_app.ui.screens.rooms_screen.components.cards.ClosedRoomCard
import com.example.quiz_omgu_android_app.ui.screens.rooms_screen.components.cards.DraftRoomCard

@Composable
fun RoomsLazyColumn(
    modifier: Modifier = Modifier,
    scrollState: LazyListState,
    rooms: List<Room>
) {
    var expandedCardIndex by remember { mutableIntStateOf(-1) }

    LazyColumn(
        state = scrollState,
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = dimensionResource(R.dimen.medium_padding)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.medium_spacer))
    ) {
        itemsIndexed(rooms) { index, room ->
            SwipeableRoomCard(
                room = room,
                isExpanded = expandedCardIndex == index,
                onExpand = { expandedCardIndex = index },
                onCollapse = { if (expandedCardIndex == index) expandedCardIndex = -1 }
            )
        }
    }
}

@Composable
private fun SwipeableRoomCard(
    room: Room,
    isExpanded: Boolean,
    onExpand: () -> Unit,
    onCollapse: () -> Unit
) {
    SwipeableCardWithAction(
        expanded = isExpanded,
        onExpand = onExpand,
        onCollapse = onCollapse,
        action = {
            ActionCardButton(
                text = "удалить",
                icon = R.drawable.ic_delete_action,
                onAction = {}
            )
        }
    ) {
        when (room) {
            is Room.Closed -> ClosedRoomCard(room = room)
            is Room.Draft -> DraftRoomCard(room = room, onClick = {})
            is Room.Active -> {} // TODO: Добавить обработку активных комнат
        }
    }
}