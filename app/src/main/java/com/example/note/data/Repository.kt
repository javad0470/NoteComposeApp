package com.example.note.data

import com.example.note.data.local.NoteDao
import com.example.note.data.local.model.NoteModel
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(private val noteDao: NoteDao) {

    val getAllData: Flow<List<NoteModel>> = flow {
        emit(noteDao.getAllData())
    }.flowOn(Dispatchers.IO)

    suspend fun insertNote(noteModel: NoteModel) {
        noteDao.insertNote(noteModel)
    }

    suspend fun deleteNote(noteModel: NoteModel) {
        noteDao.deleteNote(noteModel)
    }
}