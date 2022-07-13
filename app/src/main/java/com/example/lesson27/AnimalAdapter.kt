package com.example.lesson27

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson27.databinding.AnimalItemBinding

class AnimalAdapter : RecyclerView.Adapter<AnimalAdapter.AnimalHolder>() {
    val AnimalList = ArrayList<Animal>()

    class AnimalHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = AnimalItemBinding.bind(item) // аналог FindViewBinding

        fun bind(flower: Animal) {
            binding.apply {
                im.setImageResource(flower.ImageId)
                tvTitle.text = flower.title

            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AnimalHolder { // СОЗДАЕТ НАШУ РАЗМЕТКУ И СОЗДАЁТ КЛАСС FlowerHolder // теперь разметка в памяти и можно ее заполнить
        val view = LayoutInflater.from(parent.context).inflate(R.layout.animal_item, parent, false) // ШАБЛОН создаёт разметку с помощью LayoutInflater и появляется View
        return AnimalHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalHolder, position: Int) { // ЗАПОЛНЯЕТ РАЗМЕТКУ
        holder.bind(AnimalList[position])
    }

    override fun getItemCount(): Int { // определяет сколько раз нужно создать шаблон и заполнить его
        return AnimalList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addAnimal(animal: Animal) {
        AnimalList.add(animal)
        notifyDataSetChanged() // порверяет список flowerList находит новый элемент и добавляет его
    }

}