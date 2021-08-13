package com.example.note.utils

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.note.MainScreen
import com.example.note.screens.AddNoteScreen
import com.example.note.screens.FavoriteScreen
import com.example.note.screens.HomeScreen
import com.example.note.screens.UpdateNoteScreen

@Composable
fun NavigateMainScreens(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Navigation.MainScreen.route) {
        composable(Navigation.MainScreen.route) {
            MainScreen(navController)
        }
        composable(Navigation.AddNoteScreen.route) {
            AddNoteScreen()
        }
        composable(Navigation.UpdateNote.route){
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
            HomeScreen()
        }
        composable(BottomNavigationItems.Favorite.route) {
            FavoriteScreen()
        }
    }
}