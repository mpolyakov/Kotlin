package com.kts.kotlinnotes.ui.note

import androidx.lifecycle.Observer
import com.kts.kotlinnotes.data.NotesRepository
import com.kts.kotlinnotes.data.entity.Note
import com.kts.kotlinnotes.data.model.NoteResult
import com.kts.kotlinnotes.ui.base.BaseViewModel


class NoteViewModel: BaseViewModel<Note?, NoteViewState>() {

    init {
        viewStateLiveData.value = NoteViewState()
    }

    private var pendingNote: Note? = null

    fun save(note: Note){
        pendingNote = note
    }

    fun loadNote(noteId: String) {
        NotesRepository.getNoteById(noteId).observeForever(object : Observer<NoteResult> {
            override fun onChanged(t: NoteResult?) {
                t ?: return
                when(t){
                    is NoteResult.Success<*> -> {
                        viewStateLiveData.value = NoteViewState(note = t.data as Note)
                    }
                    is NoteResult.Error -> {
                        viewStateLiveData.value = NoteViewState(error = t.error)
                    }
                }
            }

        })
    }

    override fun onCleared(){
        pendingNote?.let {
            NotesRepository.saveNote(it)
        }
    }

}