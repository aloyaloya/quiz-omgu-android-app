package com.example.quiz_omgu_android_app.ui.screens.rooms_screen.components.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.quiz_omgu_android_app.R
import com.example.quiz_omgu_android_app.data.model.Room
import com.example.quiz_omgu_android_app.ui.components.ButtonWithShadow
import com.example.quiz_omgu_android_app.ui.screens.rooms_screen.components.cardParts.RoomCardHeader
import com.example.quiz_omgu_android_app.ui.theme.AppShapes
import com.example.quiz_omgu_android_app.utils.dropShadow

@Composable
fun DraftRoomCard(
    modifier: Modifier = Modifier,
    room: Room.Draft,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .dropShadow(shape = AppShapes.large),
        shape = AppShapes.large,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary)
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(R.dimen.medium_padding)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.large_spacer))
        ) {
            RoomCardHeader(
                title = room.title,
                subject = room.subject,
                grade = room.grade
            )

            ButtonWithShadow(
                modifier = Modifier.fillMaxWidth(),
                label = "Назначить",
                textColor = MaterialTheme.colorScheme.onPrimary,
                backgroundColor = MaterialTheme.colorScheme.onSecondary,
                shadowColor = MaterialTheme.colorScheme.secondaryContainer,
                onClick = onClick
            )
        }
    }
}