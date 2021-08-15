package com.example.note.utils

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.note.MainScreen
import com.example.note.screens.AddNoteScreen
import com.example.note.screens.FavoriteScreen
import com.example.note.screens.HomeScreen
import com.example.note.screens.UpdateNoteScreen
import com.example.note.viewmodel.MainViewModel

@Composable
fun NavigateMainScreens(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Navigation.MainScreen.route) {
        composable(Navigation.MainScreen.route) {
            MainScreen(navController)
        }
        composable(Navigation.AddNoteScreen.route) {
            val viewModel = hiltViewModel<MainViewModel>()
            AddNoteScreen(navController, viewModel)
        }
        composable(Navigation.UpdateNote.route) {
            UpdateNoteScreen(navController)
        }
    }
}

@Composable
fun NavigateBetweenBottomNav(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavigationItems.Home.route
    ) {
        composable(BottomNavigationItems.Home.route) {
            val viewModel = hiltViewModel<MainViewModel>()
            HomeScreen(viewModel)
        }
        composable(BottomNavigationItems.Favorite.route) {
            FavoriteScreen()
        }
    }
}