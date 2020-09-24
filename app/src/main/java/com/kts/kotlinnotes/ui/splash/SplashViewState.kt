package com.kts.kotlinnotes.ui.splash

import com.kts.kotlinnotes.ui.base.BaseViewState

class SplashViewState(authenticated: Boolean? = null, error: Throwable? = null) : BaseViewState<Boolean?>(authenticated, error)