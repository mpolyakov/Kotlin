package com.kts.kotlinnotes.ui.main

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.kts.kotlinnotes.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        adapter = MainAdapter()
        mainRecycler.adapter = adapter

        viewModel.viewState().observe(this, Observer<MainViewState> {t -> t?.let { adapter.notes = it.notes }  })


    }


}
