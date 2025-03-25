package com.example.quiz_omgu_android_app.data.model

val TasksTestData = listOf(
    SchoolClass(
        grade = 6,
        subjects = listOf(
            Subject(
                name = "Математика",
                categories = listOf(
                    TaskCategory(
                        name = "Числа и вычисления",
                        tasks = listOf(
                            Task(id = 1, title = "Определение суммы и разности чисел"),
                            Task(id = 2, title = "Прочитай выражение"),
                            Task(id = 3, title = "Вычисли рациональным способом"),
                            Task(id = 4, title = "Реши задачу на проценты")
                        )
                    ),
                    TaskCategory(
                        name = "Геометрия",
                        tasks = listOf(
                            Task(id = 5, title = "Определи тип угла"),
                            Task(id = 6, title = "Найди периметр треугольника"),
                            Task(id = 7, title = "Определи площадь квадрата")
                        )
                    ),
                    TaskCategory(
                        name = "Уравнения",
                        tasks = listOf(
                            Task(id = 5, title = "Определи тип угла"),
                            Task(id = 6, title = "Найди периметр треугольника"),
                            Task(id = 7, title = "Определи площадь квадрата")
                        )
                    ),
                    TaskCategory(
                        name = "Fffff",
                        tasks = listOf(
                            Task(id = 5, title = "Определи тип угла"),
                            Task(id = 6, title = "Найди периметр треугольника"),
                            Task(id = 7, title = "Определи площадь квадрата")
                        )
                    )
                )
            ),
            Subject(
                name = "Информатика",
                categories = listOf(
                    TaskCategory(
                        name = "Алгоритмы",
                        tasks = listOf(
                            Task(id = 8, title = "Создай блок-схему"),
                            Task(id = 9, title = "Определи, что делает код"),
                            Task(id = 10, title = "Напиши алгоритм сортировки")
                        )
                    ),
                    TaskCategory(
                        name = "Основы работы с ПК",
                        tasks = listOf(
                            Task(id = 11, title = "Изучи устройство компьютера"),
                            Task(id = 12, title = "Разбери основные компоненты ПК")
                        )
                    )
                )
            )
        )
    ),
    SchoolClass(
        grade = 7,
        subjects = listOf(
            Subject(
                name = "Математика",
                categories = listOf(
                    TaskCategory(
                        name = "Линейные уравнения",
                        tasks = listOf(
                            Task(id = 16, title = "Реши уравнение с одной переменной"),
                            Task(id = 17, title = "Графическое решение уравнения"),
                            Task(id = 18, title = "Система двух линейных уравнений")
                        )
                    ),
                    TaskCategory(
                        name = "Теория вероятностей",
                        tasks = listOf(
                            Task(id = 19, title = "Рассчитай вероятность события"),
                            Task(id = 20, title = "Реши задачу на комбинаторику")
                        )
                    )
                )
            ),
            Subject(
                name = "Информатика",
                categories = listOf(
                    TaskCategory(
                        name = "Программирование",
                        tasks = listOf(
                            Task(id = 21, title = "Напиши простой код на Python"),
                            Task(id = 22, title = "Используй условные конструкции"),
                            Task(id = 23, title = "Создай функцию с параметрами")
                        )
                    ),
                    TaskCategory(
                        name = "Базы данных",
                        tasks = listOf(
                            Task(id = 24, title = "Создай таблицу в SQL"),
                            Task(id = 25, title = "Напиши SQL-запрос на выборку данных")
                        )
                    )
                )
            )
        )
    )
)