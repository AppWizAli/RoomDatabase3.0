package com.aitechnologies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.aitechnologies.roomdatabase.AdapterUser
import com.aitechnologies.roomdatabase.AdapterUser2
import com.aitechnologies.roomdatabase.AppDataBase
import com.aitechnologies.roomdatabase.R
import com.aitechnologies.roomdatabase.TeacherEntity
import com.aitechnologies.roomdatabase.UserDao
import com.aitechnologies.roomdatabase.UserEntity
import com.aitechnologies.roomdatabase.databinding.ActivityAssignBinding
import com.aitechnologies.roomdatabase.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ActivityAssign : AppCompatActivity() {
    private lateinit var binding: ActivityAssignBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAssignBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var userDao: UserDao
        var teacherDao: TeacherDao
        val teacherid = intent.getStringExtra("id") // Replace "key" with the actual key used to send the data

        binding.submitButton.setOnClickListener {
            // Assuming you have a user to insert
            val userEntity = UserEntity(teacherid=teacherid.toString(),name = binding.nameEditText.text.toString(), email =binding.emailEditText.text.toString())

            // Insert the user data using a coroutine
            GlobalScope.launch(Dispatchers.IO) {
                // Get a reference to the Room database
                val database = AppDataBase.createDataBase(applicationContext)

                // Get the UserDao
                userDao = database.userDao()
                teacherDao = database.teacherdao()

                // Insert the user
                userDao.insertUser(userEntity)

                // Now, the user data is inserted into the database





            }
        }

        /*
        binding.getbutton.setOnClickListener {

            GlobalScope.launch(Dispatchers.IO) {
                // Get a reference to the Room database
                val database = AppDataBase.createDataBase(applicationContext)

                // Get the UserDao
                userDao = database.userDao()

                binding.insertedEmailTextView.text=userDao.getUsertbyId("ali")!!.email
                binding.insertedNameTextView.text=userDao.getUsertbyId("ali")!!.name
                // Now, the user data is inserted into the database





            }


        }*/
        binding.showassoign.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                // Get a reference to the Room database
                val database = AppDataBase.createDataBase(applicationContext)

                // Get the UserDao
                userDao = database.userDao()

                val users = userDao.getUsertbyId(teacherid.toString())!!

                runOnUiThread {

                    binding.rvusers.layoutManager = LinearLayoutManager(this@ActivityAssign)
                    val adapter = AdapterUser(users)
                    binding.rvusers.adapter = adapter





                }
            }
        }
        binding.showteacher.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                // Get a reference to the Room database
                val database = AppDataBase.createDataBase(applicationContext)

                // Get the UserDao
                teacherDao = database.teacherdao()

                val teacher = teacherDao.getteacherbyid(teacherid.toString().toLong())!!

                runOnUiThread {

                 binding.tvteacheremail.text=teacher.email
                 binding.tvteachername.text=teacher.name





                }
            }
        }


    }




}