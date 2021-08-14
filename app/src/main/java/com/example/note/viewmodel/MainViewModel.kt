package com.example.note.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.note.data.Repository
import com.example.note.data.local.model.NoteModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    // Local Database (Room)
    val getAllData: Flow<List<NoteModel>> = repository.getAllData

    fun insertNote(noteModel: NoteModel) = viewModelScope.launch {
        repository.insertNote(noteModel)
    }

    fun deleteNote(noteModel: NoteModel) = viewModelScope.launch {
        repository.deleteNote(noteModel = noteModel)
    }


    // Add Note Screen Functions




}