package com.kts.kotlinnotes.ui.note

import androidx.lifecycle.ViewModel
import com.kts.kotlinnotes.data.NotesRepository
import com.kts.kotlinnotes.data.entity.Note


class NoteViewModel: ViewModel() {
    private var pendingNote: Note? = null

    fun save(note: Note){
        pendingNote = note
    }

    override fun onCleared(){
        pendingNote?.let {
            NotesRepository.saveNote(it)
        }
    }

}