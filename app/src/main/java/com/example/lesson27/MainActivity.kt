package com.example.lesson27

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson27.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var bindingClass: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bindingClass.root)
    }
}