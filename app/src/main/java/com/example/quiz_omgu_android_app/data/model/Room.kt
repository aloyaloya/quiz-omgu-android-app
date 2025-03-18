package com.example.quiz_omgu_android_app.data.model

sealed class Room(
    open val id: String,
    open val title: String,
    open val subject: String,
    open val grade: String,
    open val tasks: List<String>,
    open val studentsCount: Int // Количество студентов, которым доступна комната
) {
    data class Active(
        override val id: String,
        override val title: String,
        override val subject: String,
        override val grade: String,
        override val tasks: List<String>,
        override val studentsCount: Int,
        val startDate: String,  // Дата начала (yyyy-MM-dd)
        val startTime: String,  // Время начала (HH:mm)
        val endDate: String,    // Дата закрытия
        val endTime: String     // Время закрытия
    ) : Room(id, title, subject, grade, tasks, studentsCount) {

        fun closeRoom(studentsPassed: Int, successRate: Int): Closed {
            return Closed(
                id = id,
                title = title,
                subject = subject,
                grade = grade,
                tasks = tasks,
                studentsCount = studentsCount,
                startDate = startDate,
                startTime = startTime,
                endDate = endDate,
                endTime = endTime,
                studentsPassed = studentsPassed,
                successRate = successRate
            )
        }
    }

    data class Closed(
        override val id: String,
        override val title: String,
        override val subject: String,
        override val grade: String,
        override val tasks: List<String>,
        override val studentsCount: Int,
        val startDate: String,  // Дата начала (yyyy-MM-dd)
        val startTime: String,  // Время начала (HH:mm)
        val endDate: String,    // Дата закрытия
        val endTime: String,    // Время закрытия
        val studentsPassed: Int, // Количество учеников, прошедших тест
        val successRate: Int     // Общий процент выполнения задач
    ) : Room(id, title, subject, grade, tasks, studentsCount)

    data class Draft(
        override val id: String,
        override val title: String,
        override val subject: String,
        override val grade: String,
        override val tasks: List<String>,
        override val studentsCount: Int
    ) : Room(id, title, subject, grade, tasks, studentsCount)
}