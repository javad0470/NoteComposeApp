package com.example.note.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_notes")
data class NoteModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var description: String
)