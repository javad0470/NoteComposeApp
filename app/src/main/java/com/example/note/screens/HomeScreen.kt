package com.example.note.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.note.components.Toolbar
import com.example.note.data.local.model.NoteModel
import com.example.note.viewmodel.MainViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    mainViewModel: MainViewModel = viewModel()
) {
    val notes = mainViewModel.getAllData.collectAsState(listOf()).value

    Scaffold(topBar = {
        Toolbar(title = "Notes Screen")
    }) {
        LazyColumn {
            items(notes.size) {
                notes.forEach { note ->
                    NoteItemCard(note)
                }
            }
        }


    }
}

@Composable
fun NoteItemCard(note: NoteModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(12.dp)
            .clickable {},
        elevation = 8.dp
    ) {
        Box(contentAlignment = Alignment.TopEnd, modifier = Modifier.padding(8.dp)) {
            Icon(
                imageVector = Icons.Default.Favorite, contentDescription = null,
                tint = Color.Black.copy(0.4f),
                modifier = Modifier.clickable {
                    // Add To Favorite Click
                }
            )
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
