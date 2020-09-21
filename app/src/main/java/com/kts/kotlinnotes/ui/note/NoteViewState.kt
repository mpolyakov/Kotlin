package com.kts.kotlinnotes.ui.note

import com.kts.kotlinnotes.data.entity.Note
import com.kts.kotlinnotes.ui.base.BaseViewState

class NoteViewState (note: Note? = null, error: Throwable? = null) : BaseViewState<Note?> (note, error) {

}