package com.aitechnologies.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aitechnologies.TeacherDao

@Database (entities = [UserEntity::class,TeacherEntity::class], version = 1)
abstract  class AppDataBase:RoomDatabase() {
    abstract  fun userDao():UserDao
    abstract  fun teacherdao():TeacherDao


    companion object{
        lateinit var dataBase: AppDataBase


        fun  createDataBase(context:Context)=
            Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java,
                "teacher-db"
            ).build()
    }
}