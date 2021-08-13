package com.example.note.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.note.components.Toolbar

@Composable
fun AddNoteScreen(){
    Scaffold(topBar = { Toolbar(title = "Add Note") }) {
        Column {
            Text(text = "Add Note Screen")
        }
    }
}


@Preview
@Composable
fun AddNoteScreenPreview(){
    AddNoteScreen()
}