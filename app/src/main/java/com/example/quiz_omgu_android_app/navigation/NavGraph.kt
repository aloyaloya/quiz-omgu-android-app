package com.example.quiz_omgu_android_app.navigation

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.quiz_omgu_android_app.ui.screens.create_room_screen.CreateRoomScreen
import com.example.quiz_omgu_android_app.ui.screens.rooms_screen.RoomsScreen

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    scrollState: LazyListState,
    onNavBarVisibilityChange: (Boolean) -> Unit,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = RootScreens.Rooms.route
    ) {
        composable(route = RootScreens.Rooms.route) {
            RoomsScreen(
                scrollState = scrollState,
                onCreateRoomClick = {
                    navController.navigate(RoomsScreens.CreateRoomScreen.route)
                },
                onNavBarVisibleChange = onNavBarVisibilityChange
            )
        }
        composable(route = RoomsScreens.CreateRoomScreen.route) {
            CreateRoomScreen(
                onNavBarVisibilityChange = onNavBarVisibilityChange,
                onBackClick = { navController.popBackStack() },
                viewModel = hiltViewModel()
            )
        }
    }
}