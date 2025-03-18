package com.example.quiz_omgu_android_app.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.quiz_omgu_android_app.navigation.NavGraph
import com.example.quiz_omgu_android_app.ui.navigation.BottomNavigationBar

@Composable
fun Root(
    modifier: Modifier = Modifier,
    innerPaddings: PaddingValues
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    var isNavBarVisible by remember { mutableStateOf(true) }
    var scrollDirection by remember { mutableStateOf(0f) }
    val scrollState = rememberLazyListState()

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                scrollDirection = available.y
                return Offset.Zero
            }
        }
    }

    LaunchedEffect(scrollDirection, scrollState.firstVisibleItemScrollOffset, scrollState.isScrollInProgress) {
        if (scrollState.isScrollInProgress) {
            val newVisibility = scrollDirection > 0 || scrollState.firstVisibleItemScrollOffset == 0
            if (isNavBarVisible != newVisibility) {
                isNavBarVisible = newVisibility
            }
        }
    }

    Box(
        modifier = modifier
            .padding(innerPaddings)
            .nestedScroll(nestedScrollConnection)
    ) {
        NavGraph(
            modifier = Modifier.fillMaxSize(),
            navController = navController,
            scrollState = scrollState,
            onNavBarVisibilityChange = { isVisible -> isNavBarVisible = isVisible }
        )

        BottomNavigationBar(
            modifier = Modifier.align(Alignment.BottomCenter),
            navController = navController,
            currentDestination = currentDestination,
            isNavBarVisible = isNavBarVisible
        )
    }
}