package com.example.quiz_omgu_android_app.ui.screens.create_room_screen.components

import androidx.compose.animation.animateColor
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.example.quiz_omgu_android_app.R
import com.example.quiz_omgu_android_app.data.model.Task
import com.example.quiz_omgu_android_app.data.model.TaskCategory

@Composable
fun CollapsedTaskList(
    modifier: Modifier = Modifier,
    categories: List<TaskCategory>,
    selectedTasks: Set<Task>,
    expandedCategories: Map<String, Boolean>,
    onExpandChange: (String, Boolean) -> Unit,
    onTaskToggle: (Task) -> Unit
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(
            dimensionResource(R.dimen.small_spacer)
        )
    ) {
        items(categories) { category ->
            val expanded = expandedCategories[category.name] ?: false

            Column(
                modifier = Modifier
                    .clip(MaterialTheme.shapes.extraLarge)
                    .background(
                        shape = MaterialTheme.shapes.extraLarge,
                        color = MaterialTheme.colorScheme.secondary
                    )
                    .clickable { onExpandChange(category.name, !expanded) }
                    .padding(all = dimensionResource(R.dimen.medium_padding))
                    .animateContentSize(),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = category.name,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                    Icon(
                        modifier = Modifier
                            .padding(end = dimensionResource(R.dimen.small_padding)),
                        painter = if (expanded) {
                            painterResource(R.drawable.ic_arrow_up)
                        } else {
                            painterResource(R.drawable.ic_arrow_down)
                        },
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.tertiary
                    )
                }

                if (expanded) {
                    Column(
                        modifier = Modifier
                            .padding(
                                top = dimensionResource(R.dimen.large_padding),
                                bottom = dimensionResource(R.dimen.medium_padding)
                            ),
                        verticalArrangement = Arrangement.spacedBy(
                            dimensionResource(R.dimen.medium_padding)
                        )
                    ) {
                        category.tasks.forEach { task ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(
                                    dimensionResource(R.dimen.small_padding)
                                )
                            ) {
                                CustomCheckbox(
                                    checked = selectedTasks.contains(task),
                                    onCheckedChange = { onTaskToggle(task) }
                                )

                                Text(
                                    modifier = Modifier.weight(1f),
                                    text = task.title,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.tertiary
                                )

                                WatchTaskDetailsButton(
                                    onClick = { /* TODO: модальное окно с деталями задачи */ }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun WatchTaskDetailsButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .size(dimensionResource(R.dimen.large_icon))
            .clip(MaterialTheme.shapes.small)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(dimensionResource(R.dimen.medium_icon)),
            painter = painterResource(R.drawable.ic_watch_task),
            contentDescription = "Open task details",
            tint = MaterialTheme.colorScheme.tertiary
        )
    }
}

@Composable
fun CustomCheckbox(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    val transition = updateTransition(targetState = checked, label = "CheckboxTransition")

    val checkColor by transition.animateColor(label = "CheckColor") { isChecked ->
        if (isChecked) MaterialTheme.colorScheme.tertiary else Color.Transparent
    }

    Box(
        modifier = modifier
            .size(dimensionResource(R.dimen.large_icon))
            .clip(MaterialTheme.shapes.small)
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = MaterialTheme.shapes.small
            )
            .clickable { onCheckedChange(!checked) },
        contentAlignment = Alignment.Center
    ) {
        if (checked) {
            Icon(
                modifier = Modifier.size(dimensionResource(R.dimen.medium_icon)),
                imageVector = Icons.Default.Check,
                contentDescription = "Checked",
                tint = checkColor
            )
        }
    }
}