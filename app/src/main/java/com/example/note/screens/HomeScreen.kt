package com.example.note.screens


import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.note.components.Toolbar


@Composable
fun HomeScreen() {

    Scaffold(topBar = {
        Toolbar(title = "Notes Screen")
    }) {
        LazyColumn {
            items(20) {
                NoteItemCard {
                    // Click Action for Items
                }
            }
        }
    }
}

@Composable
fun NoteItemCard(onNoteItemClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(12.dp)
            .clickable { onNoteItemClick.invoke() },
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
                text = "Title", maxLines = 1, modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 30.dp)
            )

            Spacer(modifier = Modifier.padding(4.dp))

            Text(
                text = "Description", modifier = Modifier
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
