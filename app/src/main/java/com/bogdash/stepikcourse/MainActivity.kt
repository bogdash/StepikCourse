package com.bogdash.stepikcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.bogdash.stepikcourse.ui.theme.StepikCourseTheme
import com.bogdash.stepikcourse.ui.theme.VkNewsMainScreen

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<VkNewsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val viewModel = ViewModelProvider(this)[InstagramViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            StepikCourseTheme {
                VkNewsMainScreen(
                    viewModel = viewModel
                )
            }
        }
    }
}
