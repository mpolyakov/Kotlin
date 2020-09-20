package com.kts.kotlinnotes.ui.main

import com.kts.kotlinnotes.data.entity.Note
import com.kts.kotlinnotes.ui.base.BaseViewState

class MainViewState(val notes: List<Note>? = null, error:Throwable? = null) : BaseViewState<List<Note>?>(notes, error)
