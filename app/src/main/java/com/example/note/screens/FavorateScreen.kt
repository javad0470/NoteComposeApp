package com.example.note.screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.note.components.Toolbar

@Composable
fun FavoriteScreen(){
    Scaffold(topBar = { Toolbar(title = "Favorite Screen") }) {

    }
}


@Preview
@Composable
fun FavoriteScreenPreview(){
    FavoriteScreen()
}