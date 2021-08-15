package com.example.note.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.note.components.Toolbar

@Composable
fun FavoriteScreen(){
    Scaffold(topBar = { Toolbar(title = "Favorite Screen") }) {
        Box(contentAlignment = Alignment.Center,modifier = Modifier.fillMaxSize()) {
            Text(text = "Only for Bottom Navigation Item")
        }
    }
}


@Preview
@Composable
fun FavoriteScreenPreview(){
    FavoriteScreen()
}