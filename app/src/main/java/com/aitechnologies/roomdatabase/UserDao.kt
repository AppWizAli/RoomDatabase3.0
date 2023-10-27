package com.aitechnologies.roomdatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userEntity: UserEntity)


    @Query("SELECT * FROM users")
    suspend fun getAllusers(): List<UserEntity>?


    @Query("SELECT * FROM users WHERE name=:userId")
    suspend fun getUsertbyId(userId: String): UserEntity?

    @Update
    suspend fun updateUser(user: UserEntity)

    @Delete
    suspend fun deleteallUser(user: List<UserEntity>)
}