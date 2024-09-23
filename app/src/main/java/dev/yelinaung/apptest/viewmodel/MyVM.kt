package dev.yelinaung.apptest.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.PublishSubject

class MyVM : ViewModel() {

    private val _data = MutableLiveData<String>()
    val data: LiveData<String> = _data

    val publishSubject: PublishSubject<String> = PublishSubject.create()
    val behaviorSubject: BehaviorSubject<String> = BehaviorSubject.create()


    fun getRandomNumber() {
        val num = (0..1000).random()

        _data.value = num.toString()
        publishSubject.onNext(num.toString())
        behaviorSubject.onNext(num.toString())
    }

    fun testObservable() {
        Observable.create { emitter ->
            var num = 0
            for (i in 1..10000) {
                num++
            }
            emitter.onNext(num)
        }
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                Log.d("ObserverActivity", "onNext: $it")
            }
            .doOnError {
                Log.d("ObserverActivity", "onError: $it")
            }
            .doOnComplete {
                Log.d("ObserverActivity", "onComplete")
            }
            .subscribe()
    }

}