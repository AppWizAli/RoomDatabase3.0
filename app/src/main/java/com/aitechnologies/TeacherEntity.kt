package com.aitechnologies.roomdatabase

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teachers")
data class TeacherEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,  // Use "var" instead of "val"
    var name: String = "",
    var email: String = ""
)
