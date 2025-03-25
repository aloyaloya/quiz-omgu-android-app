package com.example.quiz_omgu_android_app.ui.screens.create_room_screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import com.example.quiz_omgu_android_app.ui.components.ScreenHeader
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.quiz_omgu_android_app.R
import com.example.quiz_omgu_android_app.data.model.TasksTestData
import com.example.quiz_omgu_android_app.ui.screens.create_room_screen.components.CollapsedTaskList
import com.example.quiz_omgu_android_app.ui.screens.create_room_screen.components.ContinueButton
import com.example.quiz_omgu_android_app.ui.components.DropdownSelector

@Composable
fun CreateRoomScreen(
    modifier: Modifier = Modifier,
    onNavBarVisibilityChange: (Boolean) -> Unit,
    onBackClick: () -> Unit,
    viewModel: CreateRoomViewModel
) {
    val uiState by viewModel.uiState.collectAsState()
    var expandedCategories by remember { mutableStateOf(emptyMap<String, Boolean>()) }
    val context = LocalContext.current

    LaunchedEffect(uiState.selectedClass) {
        expandedCategories = emptyMap()
    }

    LaunchedEffect(Unit) {
        onNavBarVisibilityChange(false)
    }

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        ScreenHeader(
            title = "Новая комната",
            showBackButton = true,
            onBackClick = onBackClick
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = dimensionResource(R.dimen.medium_padding))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            shape = MaterialTheme.shapes.large,
                            color = MaterialTheme.colorScheme.secondary
                        )
                        .padding(dimensionResource(R.dimen.medium_padding))
                ) {
                    DropdownSelector(
                        options = TasksTestData.flatMap {
                            it.subjects.map { subject -> subject.name }
                        }.distinct(),
                        selected = uiState.selectedSubject,
                        placeholder = "Выберите предмет",
                        onSelected = { subject -> viewModel.selectSubject(subject) }
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    DropdownSelector(
                        options = TasksTestData.map { it.grade.toString() },
                        selected = uiState.selectedClass?.toString(),
                        placeholder = "Выберите класс",
                        onSelected = { grade -> viewModel.selectClass(grade.toInt()) }
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                if (uiState.tasks.isNotEmpty()) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        CollapsedTaskList(
                            categories = uiState.tasks,
                            selectedTasks = uiState.selectedTasks,
                            expandedCategories = expandedCategories,
                            onExpandChange = { category, expanded ->
                                expandedCategories = expandedCategories.toMutableMap().apply {
                                    this[category] = expanded
                                }
                            },
                            onTaskToggle = { task -> viewModel.toggleTask(task) }
                        )

                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }

            ContinueButton(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .background(MaterialTheme.colorScheme.background)
                    .padding(top = dimensionResource(R.dimen.small_padding)),
                onClick = {
                    if (uiState.selectedTasks.isEmpty()) {
                        Toast.makeText(context, "Вы не выбрали задачу", Toast.LENGTH_SHORT).show()
                    } else {
                        // TODO: переход на следующий экран
                    }
                },
                enabled = uiState.selectedTasks.isNotEmpty(),
            )
        }
    }
}
