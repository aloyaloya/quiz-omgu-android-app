package com.example.quiz_omgu_android_app.ui.screens.create_room_screen

import androidx.lifecycle.ViewModel
import com.example.quiz_omgu_android_app.data.model.Task
import com.example.quiz_omgu_android_app.data.model.TaskCategory
import com.example.quiz_omgu_android_app.data.model.TasksTestData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CreateRoomViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(CreateRoomUiState())
    val uiState: StateFlow<CreateRoomUiState> get() = _uiState

    fun selectClass(grade: Int) {
        val availableSubjects = TasksTestData
            .firstOrNull { it.grade == grade }
            ?.subjects?.map { it.name }
            ?: emptyList()

        val selectedSubject = _uiState.value.selectedSubject
        val isSubjectValid = selectedSubject in availableSubjects

        val tasks = if (isSubjectValid) {
            TasksTestData.firstOrNull { it.grade == grade }
                ?.subjects?.firstOrNull { it.name == selectedSubject }
                ?.categories ?: emptyList()
        } else {
            emptyList()
        }

        _uiState.value = _uiState.value.copy(
            selectedClass = grade,
            selectedSubject = if (isSubjectValid) selectedSubject else null,
            tasks = tasks,
            selectedTasks = emptySet()
        )
    }

    fun selectSubject(subject: String) {
        _uiState.value = _uiState.value.copy(selectedSubject = subject)

        val selectedClass = _uiState.value.selectedClass
        if (selectedClass != null) {
            val tasks = TasksTestData.firstOrNull { it.grade == selectedClass }
                ?.subjects?.firstOrNull { it.name == subject }
                ?.categories ?: emptyList()

            _uiState.value = _uiState.value.copy(tasks = tasks)
        }
    }

    fun toggleTask(task: Task) {
        val updatedTasks = _uiState.value.selectedTasks.toMutableSet()
        if (updatedTasks.contains(task)) {
            updatedTasks.remove(task)
        } else {
            updatedTasks.add(task)
        }
        _uiState.value = _uiState.value.copy(selectedTasks = updatedTasks)
    }
}

data class CreateRoomUiState(
    val selectedClass: Int? = null,
    val selectedSubject: String? = null,
    val tasks: List<TaskCategory> = emptyList(),
    val selectedTasks: Set<Task> = emptySet()
)