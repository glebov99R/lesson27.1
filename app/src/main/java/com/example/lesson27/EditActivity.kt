package com.example.lesson27

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lesson27.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding

    /**
     * Объявляем переменные индекса и ID изображений
     */
    private var indexImage = 0
    private var ImageId = R.drawable.animal1

    /**
     * Заполняем список ImageIdList изображениями из папки drawable
     */
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

    /**
     * Функция onCreate запустится вместе с данным activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtons() // Инициализация функции
    }

    /**
     * В функцию initButton помещаем два слушателя нажатий на кнопки / NEXT IMAGE / DONE /
     */

    private fun initButtons() = with(binding) { // with(binding) == binding.indexImage,..

        bNext.setOnClickListener { // слушатель нажатий на кнопку NEXT IMAGE
            indexImage++ // с каждым нажатием на кнопку NEXT IMAGE индекс увеличивается на 1
            if (indexImage > imageIdList.size - 1) indexImage = 0 // Если индекс больше длины списка, то индекс обнулсяется
            ImageId = imageIdList[indexImage] // Если индекс не превышает длины списка происходит переход на следующее изображение в списке
            imageView.setImageResource(ImageId) // imageView визуализирует изображение
        }
        bDone.setOnClickListener { // Слушатель нажатий кнопки DONE
            val result = Animal(ImageId, edTitle.text.toString(), edDesc.text.toString()) // В result присваиваются параметры класса Animal в формате ID и текста
            val editIntent = Intent().apply { // В переменную editIntent присваивается  объекст класса Intent
                putExtra("animal", result) // Намерение отправить result на другое Activity которые примет его по слову "animal"
            }
            setResult(RESULT_OK, editIntent) // Устанавливаем результат
            finish() // закрывает данное Activity
        }
    }
}