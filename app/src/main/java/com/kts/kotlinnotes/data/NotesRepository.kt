package com.kts.kotlinnotes.data

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kts.kotlinnotes.data.entity.Note
import com.kts.kotlinnotes.data.model.NoteResult
import com.kts.kotlinnotes.data.provider.FireStoreProvider
import com.kts.kotlinnotes.data.provider.RemoteDataProvider
import java.util.*

object NotesRepository {

    private val remoteProvider: RemoteDataProvider = FireStoreProvider()

    fun getNotes(): LiveData<NoteResult> = remoteProvider.subscribeToAllNotes()
    fun saveNote(note: Note) : LiveData<NoteResult> = remoteProvider.saveNote(note)
    fun getNoteById(id : String) = remoteProvider.getNoteById(id)
    fun getCurrentUser() = remoteProvider.getCurrentUser()

}