package com.example.lesson27

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson27.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding : ActivityEditBinding
    private var indexImage = 0
    private var ImageId = R.drawable.animal1
    val u = 5


    private val imageIdList = listOf(
        R.drawable.animal1,
        R.drawable.animal2,
        R.drawable.animal3,
        R.drawable.animal4,
        R.drawable.animal5,
        R.drawable.animal6,
        R.drawable.animal7,
        R.drawable.animal8,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtons()
    }
    private fun initButtons()= with(binding) {

        bNext.setOnClickListener{
            indexImage++
            if (indexImage > imageIdList.size -1) indexImage = 0
            ImageId = imageIdList[indexImage]
            imageView.setImageResource(ImageId)
        }
        bDone.setOnClickListener {
            val result = Animal(ImageId, edTitle.text.toString(), edDesc.text.toString())
            val editIntent = Intent().apply{
                putExtra("animal", result)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }
}