package com.example.lesson27

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson27.databinding.AnimalItemBinding

class AnimalAdapter(val listener: Listener) : RecyclerView.Adapter<AnimalAdapter.AnimalHolder>() {
    val AnimalList = ArrayList<Animal>() // Создаём список типа Animal

    class AnimalHolder(item: View) : RecyclerView.ViewHolder(item)  { // класс AnimalHolder хранит в себе ссылки на айтемы резметки animal_item
        private val binding = AnimalItemBinding.bind(item) // аналог FindViewBinding

        /**
         * Функция bind присваивает элементам разметки в layout-е значение в констркукторе дата класса Animal
         */
        fun bind(flower: Animal, listener: Listener) {
            binding.apply {
                im.setImageResource(flower.ImageId)
                tvTitle.text = flower.title

                /**
                 * Слушатель нажатий
                 */
                itemView.setOnClickListener{
                    listener.onClick(flower) // при нажатии открывает созданную карточку животного
                }

            }
        }
    }

    /**
     * Функция onCreateViewHolder позволяет нарисовать разметку для animal_item
     */
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AnimalHolder { // СОЗДАЕТ НАШУ РАЗМЕТКУ И СОЗДАЁТ КЛАСС FlowerHolder // теперь разметка в памяти и можно ее заполнить
        val view = LayoutInflater.from(parent.context).inflate(R.layout.animal_item, parent, false) // ШАБЛОН создаёт разметку с помощью LayoutInflater и появляется View
        return AnimalHolder(view) // AnimaHolder возвращается в нарисованой разметке
    }

    override fun onBindViewHolder(holder: AnimalHolder, position: Int) { // ЗАПОЛНЯЕТ РАЗМЕТКУ
        holder.bind(AnimalList[position], listener)
    }

    override fun getItemCount(): Int { // getItemCount определяет сколько раз нужно создать шаблон и заполнить его
        return AnimalList.size
    }

    /**
     * Функция addAnimal добавляет в список AnimalList новые объекты класса Animal
     */
    @SuppressLint("NotifyDataSetChanged")
    fun addAnimal(animal: Animal) {
        AnimalList.add(animal)
        notifyDataSetChanged() // порверяет список flowerList находит новый элемент и добавляет его
    }
 // Создан интерфейч
    interface Listener{
        fun onClick(animal: Animal)
    }

}