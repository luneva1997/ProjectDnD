package com.example.begin.data.db.dao

import androidx.room.*
import com.example.begin.data.db.entities.Adventure

@Dao
interface AdventuresDao {

    @Query("SELECT * FROM adventure")
    fun getAll(): List<Adventure>

    @Query("SELECT * FROM adventure WHERE status = :status")
    fun getByStatus(status: Adventure.Status): List<Adventure>

    @Query("SELECT * FROM adventure WHERE id = :id")
    fun getById(id: Int): Adventure

    @Update
    fun update(adventure: Adventure)

    @Insert
    fun create(adventureActivity: Adventure)

    @Delete
    fun delete(adventure: Adventure)
}