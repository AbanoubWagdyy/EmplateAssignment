package com.emplate.ui

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel() : ViewModel() {
    val compositeDisposable = CompositeDisposable()
}