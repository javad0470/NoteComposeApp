package com.example.note.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FabActionButton(onFabClick: () -> Unit) {

    FloatingActionButton(onClick = onFabClick) {
        Icon(Icons.Default.Add, contentDescription =null)
    }
}

@Preview
@Composable
fun FloatPreview(){
    FabActionButton {

    }
}