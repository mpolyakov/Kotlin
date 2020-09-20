package com.kts.kotlinnotes.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.kts.kotlinnotes.data.NotesRepository
import com.kts.kotlinnotes.data.entity.Note
import com.kts.kotlinnotes.data.model.NoteResult
import com.kts.kotlinnotes.ui.base.BaseViewModel


class MainViewModel() : BaseViewModel<List<Note>?, MainViewState>() {

    private val notesObserver = object:Observer<NoteResult>{
        override fun onChanged(t: NoteResult?) {
            t ?: return

            when(t){
                is NoteResult.Success<*> -> {
                    viewStateLiveData.value = MainViewState(notes = t.data as? List<Note>)
                }
                is NoteResult.Error -> {
                    viewStateLiveData.value = MainViewState(error = t.error)
                }
            }
        }
    }

    private val repositoryNotes = NotesRepository.getNotes()

    init {
        viewStateLiveData.value = MainViewState()
        repositoryNotes.observeForever(notesObserver)

    }

    fun viewState(): LiveData<MainViewState> = viewStateLiveData

    override fun onCleared() {
        repositoryNotes.removeObserver(notesObserver)
        super.onCleared()
    }

}