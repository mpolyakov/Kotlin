package com.kts.kotlinnotes.data.provider

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import com.kts.kotlinnotes.data.entity.Note
import com.kts.kotlinnotes.data.model.NoteResult

interface RemoteDataProvider {
    fun subscribeToAllNotes(): LiveData<NoteResult>
    fun getNoteById(id:String) : LiveData<NoteResult>
    fun saveNote(note: Note) : LiveData<NoteResult>
}