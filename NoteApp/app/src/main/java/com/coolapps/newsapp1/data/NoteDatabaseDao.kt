package com.coolapps.newsapp1.data

import androidx.room.*
import com.coolapps.newsapp1.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDatabaseDao {
    @Query("SELECT * from notes_tbl")
    fun getNotes():
            Flow<List<Note>>

    @Query("SELECT * FROM notes_tbl where id =:id")
    suspend fun getNoteById(id: String) : Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note : Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

    @Query("DELETE FROM notes_tbl")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteNote(note: Note)
}
