package com.aitechnologies.roomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,  // Use "var" instead of "val"
    var name: String = "",
    var email: String = ""
)

