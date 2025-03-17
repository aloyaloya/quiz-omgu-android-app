package com.example.quiz_omgu_android_app.ui.screens.rooms_screen.components.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import com.example.quiz_omgu_android_app.R
import com.example.quiz_omgu_android_app.data.model.Room
import com.example.quiz_omgu_android_app.ui.screens.rooms_screen.components.cardParts.CustomProgressBar
import com.example.quiz_omgu_android_app.ui.screens.rooms_screen.components.cardParts.RoomCardHeader
import com.example.quiz_omgu_android_app.ui.theme.AppShapes
import com.example.quiz_omgu_android_app.utils.dropShadow

@Composable
fun ClosedRoomCard(
    modifier: Modifier = Modifier,
    room: Room.Closed
) {
    Card(
        modifier = modifier.dropShadow(shape = AppShapes.large),
        shape = AppShapes.large,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary)
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(R.dimen.medium_padding))
        ) {
            RoomCardHeader(
                title = room.title,
                subject = room.subject,
                grade = room.grade
            )

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.medium_spacer)))

            RoomCardDetails(
                endDate = room.endDate,
                totalStudents = room.studentsCount,
                passedStudents = room.studentsPassed
            )

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.small_spacer)))

            CustomProgressBar(progress = room.successRate)
        }
    }
}

@Composable
private fun RoomCardDetails(
    modifier: Modifier = Modifier,
    endDate: String,
    totalStudents: Int,
    passedStudents: Int
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.small_spacer))
    ) {
        RoomInfoItem(
            text = endDate.replace("-", "."),
            icon = Icons.Default.Person,
            color = MaterialTheme.colorScheme.tertiary
        )

        RoomInfoItem(
            text = "$passedStudents/$totalStudents",
            icon = Icons.Default.Person,
            color = MaterialTheme.colorScheme.tertiary
        )
    }
}

@Composable
private fun RoomInfoItem(
    icon: ImageVector,
    text: String,
    color: Color
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.extra_small_spacer))
    ) {
        Icon(
            modifier = Modifier.size(dimensionResource(R.dimen.medium_icon)),
            imageVector = icon,
            contentDescription = null,
            tint = color
        )
        Text(
            text = text,
            color = color,
            style = MaterialTheme.typography.bodySmall
        )
    }
}