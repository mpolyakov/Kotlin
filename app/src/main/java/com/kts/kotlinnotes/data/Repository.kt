package com.kts.kotlinnotes.data

import com.kts.kotlinnotes.data.model.Note

object Repository {

    private val notes: List<Note>

    init {
        notes = listOf(

                Note("Первая заметка", "Здесь написано что-то полезное",0xfff9a43e.toInt()),
                Note("Вторая заметка", "Здесь написано что-то полезное",0xFF0000AA.toInt()),
                Note("Третья заметка", "Здесь написано что-то полезное",0xff9575cd.toInt()),
                Note("Четвертая заметка", "Здесь написано что-то полезное",0xff64b5f6.toInt()),
                Note("Пятая заметка", "Здесь написано что-то полезное",0xFF0000AA.toInt()),
                Note("Шестая заметка", "Здесь написано что-то полезное", 0xffd4e157.toInt()),
                Note("Четвертая заметка", "Здесь написано что-то полезное", 0xff64b5f6.toInt()),
                Note("Пятая заметка", "Здесь написано что-то полезное", 0xFF0000AA.toInt()),
                Note("Шестая заметка", "Здесь написано что-то полезное", 0xffd4e157.toInt()),
                Note("Седьмая заметка", "Здесь написано что-то полезное", 0xffaed581.toInt()),
                Note("Седьмая заметка", "Здесь написано что-то полезное", 0xffaed581.toInt())

        )
    }

    fun getNotes(): List<Note> {
        return notes
    }
}