package com.example.note.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.note.data.local.model.NoteModel

@Database(entities = [NoteModel::class],version = 1,exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao() : NoteDao
}