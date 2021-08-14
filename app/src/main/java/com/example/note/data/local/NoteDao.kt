package com.example.note.data.local

import androidx.room.*
import com.example.note.data.local.model.NoteModel

@Dao
interface NoteDao {

    @Query("SELECT * FROM tbl_notes ORDER BY id DESC")
    fun getAllData(): List<NoteModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(noteModel: NoteModel): Long

    @Delete
    suspend fun deleteNote(noteModel: NoteModel): Int
}