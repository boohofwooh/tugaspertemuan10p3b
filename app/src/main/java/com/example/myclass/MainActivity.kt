package com.example.myclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myclass.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapterClass = ClassAdapter(generateStudent()){
                clazz: Class -> Toast.makeText(this@MainActivity,
            "Data ${clazz.name}", Toast.LENGTH_SHORT).show()
            val intentToSecondActivity =
                Intent(this@MainActivity,MainActivity2::class.java)
            intentToSecondActivity.putExtra("name", clazz.name)
            intentToSecondActivity.putExtra("major", clazz.major)
            intentToSecondActivity.putExtra("gpa", clazz.gpa)
            intentToSecondActivity.putExtra("classOf", clazz.class_of)
            intentToSecondActivity.putExtra("profile", clazz.profile)
            startActivity(intentToSecondActivity)
        }
        with(binding){
            rvClass.apply {
                adapter = adapterClass
                layoutManager = LinearLayoutManager(this@MainActivity)

            }
        }
    }

    fun generateStudent() : List<Class>{
        return listOf(
            Class(name = "Marvin McKinney", major = "Software Engineering", profile = "foto1", gpa = "3.25", class_of = "2021"),
            Class(name = "Dianne Russell", major = "Computer Science", profile = "foto4", gpa = "3.50", class_of = "2022"),
            Class(name = "Brooklyn Simmons", major = "Information Technology", profile = "foto5", gpa = "2.96", class_of = "2019"),
            Class(name = "Cody Fisher", major = "Mechanical Engineering", profile = "foto3", gpa = "3.12", class_of = "2018"),
            Class(name = "Darlene Robertson", major = "Psychology", profile = "foto2", gpa = "4.00", class_of = "2023")
        )
    }
}