package com.example.lesson27

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson27.databinding.ActivityContentBinding
import com.example.lesson27.databinding.ActivityEditBinding

class ContentActivity : AppCompatActivity() {
    private lateinit var binding:  ActivityContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         * item получает данные из mainActivity и запоеяеи разметку
         */
        val item = intent.getSerializableExtra("item") as Animal
        binding.apply {
            imMain.setImageResource(item.ImageId)
            tvTitle2.text = item.title
            tvContent.text = item.desc
        }
    }
}