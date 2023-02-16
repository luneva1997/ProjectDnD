package com.example.begin.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Adventure(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val description: String = "",
    val status: Status = Status.IN_PROGRESS
) {
    enum class Status {
        IN_PROGRESS, COMPLETED
    }
}