package com.example.note.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.note.utils.SnackBar

@Composable
fun UpdateNoteScreen(navController: NavController) {
    Scaffold(topBar = { UpdateNoteToolbar() }) {
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
                onClick = {  },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(75.dp)
                    .padding(12.dp)
            ) {
                Text(text = "Update Note")
            }
        }
    }
}

@Composable
fun UpdateNoteToolbar() {
    TopAppBar(
        title = { Text(text = "Update Note") },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = null
                )
            }
        },
    )
}

@Composable
fun checkEditTextValidation(title: String, desc: String) {
    val context = LocalContext.current
    if (title.isNullOrEmpty() || desc.isNullOrEmpty()) {
        Toast.makeText(context,"Please Fill All Amount",Toast.LENGTH_SHORT).show()
    }
}

@Preview
@Composable
fun UpdateNotePreview() {
    val navController = rememberNavController()
    UpdateNoteScreen(navController)
}