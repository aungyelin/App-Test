package dev.yelinaung.apptest.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

open class BaseVM : ViewModel() {

    val disposable by lazy { CompositeDisposable() }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}