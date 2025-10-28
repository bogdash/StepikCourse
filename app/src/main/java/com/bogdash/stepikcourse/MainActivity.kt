package com.bogdash.stepikcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Test()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Test() {
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                NavigationDrawerItem(
                    label = {
                        Text(" Text 1")
                    },
                    selected = true,
                    onClick = {},
                    icon = {
                        Icon(Icons.Filled.Call, null)
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
                NavigationDrawerItem(
                    label = {
                        Text(" Text 2")
                    },
                    selected = false,
                    onClick = {},
                    icon = {
                        Icon(Icons.Filled.Build, null)
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
                NavigationDrawerItem(
                    label = {
                        Text(" Text 3")
                    },
                    selected = false,
                    onClick = {},
                    icon = {
                        Icon(Icons.Filled.AccountCircle, null)
                    }
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text( text = "TopAppBarTitle" )
                    },
                    navigationIcon = {
                        IconButton(onClick = {}) {
                            Icon(Icons.Filled.Menu, contentDescription = null)
                        }
                    }
                )
            },
            bottomBar = {
                NavigationBar {
                    NavigationBarItem(
                        selected = true,
                        onClick = {},
                        icon = {
                            Icon(Icons.Filled.Favorite, contentDescription = null)
                        },
                        label = {
                            Text("Favorite")
                        }
                    )
                    NavigationBarItem(
                        selected = false,
                        onClick = {},
                        icon = {
                            Icon(Icons.Outlined.Edit, contentDescription = null)
                        },
                        label = {
                            Text("Edit")
                        }
                    )
                    NavigationBarItem(
                        selected = false,
                        onClick = {},
                        icon = {
                            Icon(Icons.Outlined.Delete, contentDescription = null)
                        },
                        label = {
                            Text("Delete")
                        }
                    )
                }
            }
        ) {
            Text(
                modifier = Modifier.padding(it),
                text = "This is scaffold content"
            )
        }
    }

}