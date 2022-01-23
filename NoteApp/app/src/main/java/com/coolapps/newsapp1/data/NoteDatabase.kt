package com.coolapps.newsapp1.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.coolapps.newsapp1.model.Note
import com.coolapps.newsapp1.util.DateConverter
import com.coolapps.newsapp1.util.UUIDConverter

@Database(entities = [Note::class], version = 1,exportSchema = false)

@TypeConverters (DateConverter::class, UUIDConverter::class)

abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDatabaseDao
}