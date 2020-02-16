package com.kts.kotlinnotes.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.kts.kotlinnotes.R
import com.kts.kotlinnotes.ui.note.NoteActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var adapter: NotesRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        rv_notes.layoutManager = GridLayoutManager(this, 2)

        adapter = NotesRVAdapter { note ->
            NoteActivity.start(this, note)
        }

        rv_notes.adapter = adapter

        viewModel.viewState().observe(this, Observer { state ->
            state?.let {
                adapter.notes = it.notes
            }
        })

        fab.setOnClickListener {
            NoteActivity.start(this)
        }
    }
}