package dev.yelinaung.apptest.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dev.yelinaung.apptest.api.ApiService
import dev.yelinaung.apptest.api.model.MoviePage
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.PublishSubject

class MyVM(private val apiService: ApiService) : BaseVM() {

    private val _data = MutableLiveData<String>()
    val data: LiveData<String> = _data

    private val _movieData = MutableLiveData<MoviePage>()
    val movieData: LiveData<MoviePage> = _movieData

    val publishSubject: PublishSubject<String> = PublishSubject.create()
    val behaviorSubject: BehaviorSubject<String> = BehaviorSubject.create()

    val movieSubject: BehaviorSubject<MoviePage> = BehaviorSubject.create()


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

    fun fetchMovies() {
        apiService.getMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _movieData.value = it
                movieSubject.onNext(it)
            }, Throwable::printStackTrace)
            .addTo(disposable)
    }

}