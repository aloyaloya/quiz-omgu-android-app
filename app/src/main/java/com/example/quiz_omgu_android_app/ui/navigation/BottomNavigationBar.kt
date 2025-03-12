package com.example.quiz_omgu_android_app.ui.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.quiz_omgu_android_app.R
import com.example.quiz_omgu_android_app.navigation.RootScreensRoutes
import com.example.quiz_omgu_android_app.ui.theme.AppShapes

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    navController: NavController,
    currentDestination: NavDestination?,
    isNavBarVisible: Boolean
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        AnimatedVisibility(
            visible = isNavBarVisible,
            enter = slideInVertically(initialOffsetY = { it }),
            exit = slideOutVertically(targetOffsetY = { it })
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding()
                    .padding(dimensionResource(R.dimen.medium_padding))
            ) {
                NavigationBar(
                    modifier = Modifier
                        .height(64.dp)
                        .clip(AppShapes.large),
                    containerColor = MaterialTheme.colorScheme.primary,
                    tonalElevation = 0.dp,
                    windowInsets = WindowInsets(0.dp),
                ) {
                    RootScreensRoutes.forEach { screen ->
                        val isSelected = currentDestination?.hierarchy?.any {
                            it.route == screen.route
                        } == true

                        NavigationBarItem(
                            icon = {
                                Icon(
                                    modifier = Modifier
                                        .size(dimensionResource(R.dimen.medium_icon))
                                        .shadow(
                                            elevation = 8.dp,
                                            ambientColor = Color.Black.copy(alpha = 0.5f),
                                            spotColor = Color.Black.copy(alpha = 0.5f)
                                        ),
                                    painter = painterResource(id = screen.iconOutline),
                                    contentDescription = screen.name,
                                    tint = MaterialTheme.colorScheme.onPrimary
                                )
                            },
                            selected = isSelected,
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                                unselectedIconColor = MaterialTheme.colorScheme.onPrimary,
                                indicatorColor = MaterialTheme.colorScheme.primary
                            ),
                            label = {
                                Box(modifier = Modifier
                                    .size(dimensionResource(R.dimen.extra_small_spacer))
                                    .shadow(elevation = 4.dp, shape = CircleShape)
                                    .background(
                                        color = if (isSelected) {
                                            MaterialTheme.colorScheme.onPrimary
                                        } else {
                                            MaterialTheme.colorScheme.primary
                                        },
                                        shape = CircleShape
                                    )
                                    .clip(CircleShape)
                                )
                            },
                            onClick = {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}