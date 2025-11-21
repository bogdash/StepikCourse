package com.bogdash.stepikcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.bogdash.stepikcourse.ui.theme.StepikCourseTheme
import com.bogdash.stepikcourse.ui.views.InstagramProfileCard

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[InstagramViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            Test(viewModel = viewModel)
        }
    }
}

@Composable
private fun Test(viewModel: InstagramViewModel) {
    StepikCourseTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            val models = viewModel.models.observeAsState(listOf())
            LazyColumn {
                items(models.value, key = { it.id }) { model ->
                    val dismissState = rememberSwipeToDismissBoxState(
                        confirmValueChange = { value ->
                            val isDismissed = value in setOf(
                                SwipeToDismissBoxValue.EndToStart
                            )

                            if (isDismissed) {
                                viewModel.delete(model)
                            }
                            return@rememberSwipeToDismissBoxState isDismissed
                        }
                    )
                    SwipeToDismissBox(
                        state = dismissState,
                        enableDismissFromEndToStart = true,
                        enableDismissFromStartToEnd = false,
                        backgroundContent = {
                            Box(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxSize()
                                    .background(Color.Red.copy(alpha = 0.5f)),
                                contentAlignment = Alignment.CenterEnd
                            ) {
                                Text(
                                    modifier = Modifier.padding(16.dp),
                                    text = "Delete item",
                                    color = Color.White,
                                    fontSize = 24.sp
                                )
                            }
                        }
                    ) {
                        InstagramProfileCard(
                            model = model,
                            onFollowedButtonClickListener = viewModel::changeFollowingStatus
                        )
                    }

                }
            }
        }
    }
}
