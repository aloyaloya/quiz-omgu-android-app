package com.example.quiz_omgu_android_app.data.model

data class Task(
    val id: Int,
    val title: String,
    val isCompleted: Boolean = false
)