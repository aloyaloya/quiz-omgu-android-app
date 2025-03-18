package com.example.quiz_omgu_android_app.data.model

object RoomTestData {
    val activeRooms = listOf(
        Room.Active(
            id = "1",
            title = "Проверочная работа №1",
            subject = "Математика",
            grade = "6_1",
            startDate = "2025-04-10",
            startTime = "10:00",
            endDate = "2025-04-10",
            endTime = "11:00",
            tasks = listOf("Задача 1", "Задача 2", "Задача 3"),
            studentsCount = 30
        ),
        Room.Active(
            id = "2",
            title = "Контрольная работа №1",
            subject = "Информатика",
            grade = "6_2",
            startDate = "2025-04-12",
            startTime = "09:30",
            endDate = "2025-04-12",
            endTime = "10:30",
            tasks = listOf("Задача 1", "Задача 2"),
            studentsCount = 25
        )
    )

    val closedRooms = listOf(
        Room.Closed(
            id = "3",
            title = "Проверочная работа №3",
            subject = "Информатика",
            grade = "6_1",
            startDate = "2025-03-15",
            startTime = "12:00",
            endDate = "2025-03-15",
            endTime = "13:00",
            tasks = listOf("Задача 1", "Задача 2", "Задача 3", "Задача 4"),
            studentsPassed = 25,
            successRate = 85,
            studentsCount = 28
        ),
        Room.Closed(
            id = "4",
            title = "Проверочная работа №4",
            subject = "Математика",
            grade = "7_1",
            startDate = "2025-03-20",
            startTime = "14:00",
            endDate = "2025-03-20",
            endTime = "15:00",
            tasks = listOf("Задача 1", "Задача 2", "Задача 3"),
            studentsPassed = 30,
            successRate = 55,
            studentsCount = 32
        ),
        Room.Closed(
            id = "4",
            title = "Проверочная работа №4",
            subject = "Математика",
            grade = "7_1",
            startDate = "2025-03-20",
            startTime = "14:00",
            endDate = "2025-03-20",
            endTime = "15:00",
            tasks = listOf("Задача 1", "Задача 2", "Задача 3"),
            studentsPassed = 30,
            successRate = 55,
            studentsCount = 32
        ),
        Room.Closed(
            id = "4",
            title = "Проверочная работа №4",
            subject = "Информатика",
            grade = "7_1",
            startDate = "2025-03-20",
            startTime = "14:00",
            endDate = "2025-03-20",
            endTime = "15:00",
            tasks = listOf("Задача 1", "Задача 2", "Задача 3"),
            studentsPassed = 30,
            successRate = 2,
            studentsCount = 32
        ),
        Room.Closed(
            id = "4",
            title = "Проверочная работа №4",
            subject = "Информатика",
            grade = "7_1",
            startDate = "2025-03-20",
            startTime = "14:00",
            endDate = "2025-03-20",
            endTime = "15:00",
            tasks = listOf("Задача 1", "Задача 2", "Задача 3"),
            studentsPassed = 30,
            successRate = 20,
            studentsCount = 32
        )
    )

    val draftRooms = listOf(
        Room.Draft(
            id = "5",
            title = "Контрольная работа №1",
            subject = "Математика",
            grade = "6_1",
            tasks = listOf("Задача 1", "Задача 2"),
            studentsCount = 27
        ),
        Room.Draft(
            id = "6",
            title = "Контрольная работа №7",
            subject = "Математика",
            grade = "6_2",
            tasks = emptyList(),
            studentsCount = 22
        ),
        Room.Draft(
            id = "6",
            title = "Контрольная работа №7",
            subject = "Информатика",
            grade = "6_2",
            tasks = emptyList(),
            studentsCount = 22
        ),
        Room.Draft(
            id = "6",
            title = "Контрольная работа №7",
            subject = "Математика",
            grade = "6_2",
            tasks = emptyList(),
            studentsCount = 22
        )
    )
}