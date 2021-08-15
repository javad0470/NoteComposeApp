package com.example.note.utils

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SnackBar(message: String) {
    val snackState = remember {
        mutableStateOf(false)
    }
    val coroutineScope = rememberCoroutineScope()

    Snackbar(modifier = Modifier.padding(8.dp)) {
        Text(text = message)
    }
}
