package com.example.quiz_omgu_android_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import com.example.quiz_omgu_android_app.ui.Root
import com.example.quiz_omgu_android_app.ui.theme.QuizomguandroidappTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            QuizomguandroidappTheme(dynamicColor = false) {
                Scaffold { innerPadding ->
                    Root(innerPaddings = innerPadding)
                }
            }
        }
    }
}
