package com.kts.kotlinnotes.ui.main

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class LogoutDialog: DialogFragment() {
    companion object{
        val TAG = LogoutDialog::class.java.name + "TAG"
        fun createInstance() = LogoutDialog()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?) =
            AlertDialog.Builder(context)
                    .setTitle("Выход")
                    .setMessage("Вы уверены?")
                    .setPositiveButton("Да"){dialog, which -> (activity as LogoutListener).onLogout()}
                    .setNegativeButton("Нет"){dialog, which -> dismiss()}
                    .create()

    interface LogoutListener{
        fun onLogout()
    }
}