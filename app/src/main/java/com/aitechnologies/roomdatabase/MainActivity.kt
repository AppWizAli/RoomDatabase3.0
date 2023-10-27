package com.aitechnologies.roomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.aitechnologies.ActivityAssign
import com.aitechnologies.TeacherDao
import com.aitechnologies.roomdatabase.databinding.ActivityMainBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() ,AdapterUser2.OnItemClickListener{
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var userDao:UserDao
        var teacherDao: TeacherDao

       /* binding.submitButton.setOnClickListener {
            // Assuming you have a user to insert
            val userEntity = UserEntity(name = binding.nameEditText.text.toString(), email =binding.emailEditText.text.toString())

            // Insert the user data using a coroutine
            GlobalScope.launch(Dispatchers.IO) {
                // Get a reference to the Room database
                val database = AppDataBase.createDataBase(applicationContext)

                // Get the UserDao
                userDao = database.userDao()

                // Insert the user
                userDao.insertUser(userEntity)

                // Now, the user data is inserted into the database





            }
        }*/
        binding.submitteacher.setOnClickListener {
            // Assuming you have a user to insert
            val userEntity = TeacherEntity(0,binding.nameEditText.text.toString(),binding.emailEditText.text.toString())

            // Insert the user data using a coroutine
            GlobalScope.launch(Dispatchers.IO) {
                // Get a reference to the Room database
                val database = AppDataBase.createDataBase(applicationContext)

                // Get the UserDao
                teacherDao = database.teacherdao()

                // Insert the user
                teacherDao.insertTeacher(userEntity)

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
        binding.getbutton.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                // Get a reference to the Room database
                val database = AppDataBase.createDataBase(applicationContext)

                // Get the UserDao
            //    userDao = database.userDao()
                teacherDao = database.teacherdao()

         //       val users = userDao.getAllusers()!!
                val teachers = teacherDao.getallteachers()!!

                runOnUiThread {

              /*      binding.rvUser.layoutManager = LinearLayoutManager(this@MainActivity)
                    val adapter = AdapterUser(users)
                    binding.rvUser.adapter = adapter*/


                    binding.rvTeacher.layoutManager = LinearLayoutManager(this@MainActivity)
                    val adapterteacher = AdapterUser2(teachers,this@MainActivity)
                    binding.rvTeacher.adapter = adapterteacher



                }
            }
        }
/*binding.deletestudentall.setOnClickListener {
    GlobalScope.launch(Dispatchers.IO) {
        val database = AppDataBase.createDataBase(applicationContext)
        teacherDao = database.teacherdao()
        userDao = database.userDao()
        userDao.deleteallUser(userDao.getAllusers()!!)
        teacherDao.deleteallteacher(teacherDao.getallteachers()!!)
    }
}*/
        binding.deleteteacherall.setOnClickListener {
    GlobalScope.launch(Dispatchers.IO) {
        val database = AppDataBase.createDataBase(applicationContext)
        teacherDao = database.teacherdao()
        teacherDao.deleteallteacher(teacherDao.getallteachers()!!)
    }
}
/*binding.assign.setOnClickListener {
    GlobalScope.launch(Dispatchers.IO) {
        val database = AppDataBase.createDataBase(applicationContext)
        teacherDao = database.teacherdao()
        userDao = database.userDao()
     var allteacher=teacherDao.getallteachers()!!
     var alluser=userDao.getAllusers()!!
    }
}*/

    }

    override fun onItemClick(teacher: TeacherEntity) {
       startActivity(Intent(this@MainActivity,ActivityAssign::class.java).putExtra("id",teacher.id
           .toString()))
    }


}


