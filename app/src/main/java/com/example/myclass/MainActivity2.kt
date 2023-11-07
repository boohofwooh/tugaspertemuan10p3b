package com.example.myclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myclass.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding){
            val st_name = intent.getStringExtra("name")
            val st_major = intent.getStringExtra("major")
            val st_gpa = intent.getStringExtra("gpa")
            val st_classOf = intent.getStringExtra("classOf")
            val st_profile = intent.getStringExtra("profile")

            name.text = "$st_name"
            major.text = "$st_major"
            gpa.text = "$st_gpa"
            classOf.text = "$st_classOf"

            if (st_profile != null) {
                val resID = resources.getIdentifier(st_profile, "drawable", packageName)
                profile.setImageResource(resID)
            }

            btnBack.setOnClickListener {
                val intentToFirstActivity =
                    Intent(this@MainActivity2,MainActivity::class.java)
                startActivity(intentToFirstActivity)
            }
        }
    }
}