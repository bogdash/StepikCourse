package com.bogdash.stepikcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.ViewModelProvider
import com.bogdash.stepikcourse.ui.theme.InstagramProfileCard
import com.bogdash.stepikcourse.ui.theme.StepikCourseTheme

class MainActivity : ComponentActivity() {
//    private val viewModel by viewModels<VkNewsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[InstagramViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            Test(viewModel = viewModel)
//            StepikCourseTheme {
//                VkNewsMainScreen(
//                    viewModel = viewModel
//                )
//            }
        }
    }
}

@Composable
private fun Test(viewModel: InstagramViewModel) {
    StepikCourseTheme {
        val models = viewModel.models.observeAsState(listOf())
        LazyColumn {
            items(models.value) { model ->
                InstagramProfileCard(
                    model = model,
                    onFollowedButtonClickListener = viewModel::changeFollowingStatus
                )
            }
        }

    }
}
