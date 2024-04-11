package com.stu71930.lab2_assignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.stu71930.lab2_assignment.controllers.App
import com.stu71930.lab2_assignment.ui.theme.Lab2_assignmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab2_assignmentTheme {
                App()
            }
        }
    }
}

