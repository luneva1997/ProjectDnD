package com.example.begin.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.begin.data.db.dao.AdventuresDao
import com.example.begin.data.db.entities.Adventure

@Database(
    version = 1,
    entities = [Adventure::class],
)
abstract class DndProjectDatabase : RoomDatabase() {
    abstract fun adventuresDao(): AdventuresDao
}