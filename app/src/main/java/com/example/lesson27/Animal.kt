package com.example.lesson27

import java.io.Serializable
import java.text.ParsePosition
import java.util.*

/**
 * Класс Animal сюда приходит: / ID изображений(ImageId) / текст в поле tvTitle (title) / текст в поле edDesc(desc)
 */

data class Animal(val ImageId: Int, val title : String , val desc:String) : Serializable
