package com.example.note.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.note.components.Toolbar
import com.example.note.data.local.model.NoteModel
import com.example.note.utils.Navigation
import com.example.note.viewmodel.MainViewModel

@Composable
fun AddNoteScreen(navController: NavController) {
    Scaffold(topBar = {
        AddNoteToolbar {
            navController.navigate(Navigation.MainScreen.route)
        }
    }) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            var title by remember {
                mutableStateOf("")
            }
            var desc by remember {
                mutableStateOf("")
            }
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp), label = { Text(text = "Title") }, singleLine = true,
                value = title,
                onValueChange = { title = it })
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(12.dp), label = { Text(text = "Description") },
                value = desc,
                onValueChange = { desc = it })
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(75.dp)
                    .padding(12.dp)
            ) {
                Text(text = "Add Note")
            }
        }
    }
}

@Composable
fun AddNoteToolbar(onBackClick: () -> Unit) {
    TopAppBar(
        title = { Text(text = "Add Note") },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        navigationIcon = {
            IconButton(onClick = {
                onBackClick.invoke()
            }) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = null
                )
            }
        },
    )
}

@Composable
fun InsertNote() {
    val viewModel: MainViewModel by viewModel()
    val note = NoteModel(0, "", "")
    viewModel.insertNote(note)
}

fun insertNote() {

}

@Preview
@Composable
fun AddNoteScreenPreview() {
    val navController = rememberNavController()
    AddNoteScreen(navController)
}