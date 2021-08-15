package com.example.note.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.note.components.Toolbar
import com.example.note.data.local.model.NoteModel
import com.example.note.viewmodel.MainViewModel
import kotlinx.coroutines.flow.collect


@Composable
fun HomeScreen(
    mainViewModel: MainViewModel = viewModel()
) {
    val notes = mainViewModel.getAllData.collectAsState(listOf()).value

    if (notes.isNullOrEmpty()) {
        Scaffold(topBar = { Toolbar(title = "Note Screen") }) {
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                Text(text = "No data")
            }
        }
    } else {
        Scaffold(topBar = {
            Toolbar(title = "Notes Screen")
        }) {
            LazyColumn {
                items(notes) { note ->
                    NoteItemCard(note = note,mainViewModel)
                }
            }
        }
    }

}

@Composable
fun NoteItemCard(note: NoteModel, mainViewModel: MainViewModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(12.dp)
            .clickable {
                //Handle Item Click
                mainViewModel.deleteNote(note)
            },
        elevation = 8.dp
    ) {
        Box(contentAlignment = Alignment.TopEnd, modifier = Modifier.padding(12.dp)) {
            Surface(
                color = Color.Green,
                modifier = Modifier
                    .height(12.dp)
                    .width(12.dp)
                    .clip(CircleShape)
            ) {}
        }
        Column(modifier = Modifier.padding(8.dp)) {

            Text(
                text = note.title, maxLines = 1, modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 30.dp)
            )

            Spacer(modifier = Modifier.padding(4.dp))

            Text(
                text = note.description, modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(), color = Color.Black.copy(0.8f)
            )

        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
