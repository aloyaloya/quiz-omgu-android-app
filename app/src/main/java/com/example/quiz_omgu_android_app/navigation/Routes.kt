package com.example.quiz_omgu_android_app.navigation

import com.example.quiz_omgu_android_app.R

sealed class RootScreens(
    val route: String,
    val iconOutline: Int,
    val iconFilled: Int,
    val name: String
) {
    data object Rooms : RootScreens(
        route = "rooms",
        iconOutline = R.drawable.ic_rooms,
        iconFilled = R.drawable.ic_rooms,
        name = "Rooms"
    )
}

sealed class RoomsScreens(val route: String) {
    data object CreateRoomScreen : RoomsScreens("create_room_screen")
}

val RootScreensRoutes = listOf(
    RootScreens.Rooms,
    RootScreens.Rooms,
    RootScreens.Rooms
)