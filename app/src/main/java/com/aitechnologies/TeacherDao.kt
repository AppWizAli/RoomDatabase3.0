package com.aitechnologies

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.aitechnologies.roomdatabase.TeacherEntity
import com.aitechnologies.roomdatabase.UserEntity

@Dao
interface TeacherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeacher(teacherEntity: TeacherEntity)


    @Query("SELECT * FROM teachers")
    suspend fun getallteachers():List<TeacherEntity>?
    @Delete
    suspend fun deleteallteacher(user: List<TeacherEntity>)
}