package com.example.lesson27

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lesson27.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var adapter = AnimalAdapter() // Создан объект класса адаптера и записан в переменную adapter

    private var editLauncher : ActivityResultLauncher<Intent>? = null // Создан лаунчер который запускает Activity на которое мы хотим перейти

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init() // Инициализия функции init(запускает отрисовку макета) сразу после запуска MainActivity

        /**
         * editLauncher запускается сразу после открытия данного Activity, editLauncher запускает режим  ожидания
         * данных от кнопки DONE на EditActivity по ключевому слову animal
         */
        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                adapter.addAnimal(it.data?.getSerializableExtra("animal") as Animal)
            }
        }
    }

    /**
     * Функция init - запускает отрисовку макета
     * При нажатии на кнопку ADD ANIMAL(id.buttonAdd) открывает EditActivity используя лаунчер
     */
    private fun init() {
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 3) // создаёт в MainActivity шаблон состоящий из 3 колонок
            rcView.adapter = adapter
            buttonAdd.setOnClickListener { // Слушатель нажатий ADD ANIMAL(id.buttonAdd)
                editLauncher?.launch(Intent(this@MainActivity , EditActivity::class.java)) // Открывает EditActivity
            }
        }
    }
}