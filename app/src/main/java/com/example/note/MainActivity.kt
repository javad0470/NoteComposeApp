package com.example.note

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.note.components.BottomNavigationBar
import com.example.note.components.FabActionButton
import com.example.note.ui.theme.NoteTheme
import com.example.note.utils.NavigateBetweenBottomNav
import com.example.note.utils.NavigateMainScreens
import com.example.note.utils.Navigation
import com.example.note.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    NavigateMainScreens(navController)
                }
            }
        }
    }
}


@Composable
fun MainScreen(navController: NavController) {
    // TODO Specific for bottom navigation {this navController}
    val bottomBarNavController = rememberNavController()

    Scaffold(floatingActionButton = {
        FabActionButton {
            navController.navigate(Navigation.AddNoteScreen.route) {
                launchSingleTop = true
                popUpTo(Navigation.MainScreen.route)
            }
        }
    }, bottomBar = { BottomNavigationBar(navController = bottomBarNavController) }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(bottom = 56.dp)
        ) {
            NavigateBetweenBottomNav(navController = bottomBarNavController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val navController = rememberNavController()
    NoteTheme {
        MainScreen(navController)
    }
}