package com.kts.kotlinnotes.ui.splash

import com.kts.kotlinnotes.data.NotesRepository
import com.kts.kotlinnotes.data.errors.NoAuthException
import com.kts.kotlinnotes.ui.base.BaseViewModel



class SplashViewModel() : BaseViewModel<Boolean?, SplashViewState>() {
    fun requestUser() {
        NotesRepository.getCurrentUser().observeForever {
            viewStateLiveData.value = if (it != null) {
                SplashViewState(authenticated = true)
            }  else {
                SplashViewState(error = NoAuthException())
            }
        }
    }
}