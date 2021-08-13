package com.example.note.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.note.R

sealed class BottomNavigationItems(var route: String, var icon: ImageVector, var title: String) {

    object Home : BottomNavigationItems("home", Icons.Default.Home, "Home")
    object Favorite : BottomNavigationItems("favorite", Icons.Default.Favorite, "Favorite")


}