package dev.yelinaung.apptest.api

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import dev.yelinaung.apptest.BaseActivity
import dev.yelinaung.apptest.databinding.ActivityNetworkBinding
import dev.yelinaung.apptest.helper.showToast
import dev.yelinaung.apptest.viewmodel.MyVM
import io.reactivex.rxjava3.kotlin.addTo
import okhttp3.OkHttpClient
import okhttp3.Request
import org.koin.androidx.viewmodel.ext.android.viewModel

class NetworkActivity : BaseActivity<ActivityNetworkBinding>() {

    companion object {

        fun getInstance(context: Context): Intent {
            return Intent(context, NetworkActivity::class.java)
        }

    }

    override val pageTitle: String = "Networking"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityNetworkBinding {
        return ActivityNetworkBinding.inflate(layoutInflater)
    }

    private val myVM: MyVM by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.fetchMovies()

        binding.swipeRefreshLayout.setOnRefreshListener {
            this.fetchMovies()
        }
    }

    override fun onStart() {
        super.onStart()

        myVM.movieSubject.subscribe({
            binding.swipeRefreshLayout.isRefreshing = false
            showToast("Movie Count = ${it.results.count()}")
        }, Throwable::printStackTrace).addTo(disposable)

        myVM.movieData.observe(this) {
            binding.swipeRefreshLayout.isRefreshing = false
            showToast("Movie Count = ${it.results.count()}")
        }
    }

    private fun fetchMovies() {
        binding.swipeRefreshLayout.isRefreshing = false
        this.myVM.fetchMovies()
    }

    /*private fun fetchMovies() {
        val client = OkHttpClient()

        val request = Request.Builder()
            .url("https://api.themoviedb.org/3/discover/movie?language=en-US&page=1")
            .get()
            .addHeader("accept", "application/json")
            .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2MGIzMjBhMjk2MmEyODEyYzM2ZDFmNGJmZWU2Y2IyNSIsIm5iZiI6MTcyNDE1Mzg3Ny42MTcwODgsInN1YiI6IjYxODVmYWZiZDQ4Y2VlMDA2MmQyZTQ5OSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.1OF4x9sf6p6gEzChm2xvSLd2_yi-osVt6dVqMz0PQYU")
            .build()

        AsyncTask.execute {
            val response = client.newCall(request).execute()
            val body = response.body?.string()

            Log.d("TEST_LOG", "Status Code: ${response.code}")
            Log.d("TEST_LOG", "Success: ${response.isSuccessful}")
            Log.d("TEST_LOG", "Body: $body")

            var moviePage: MoviePage? = null

            body?.let {
                try {
                    val gson = Gson()
                    moviePage = gson.fromJson(it, MoviePage::class.java)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            runOnUiThread {
                binding.swipeRefreshLayout.isRefreshing = false
                moviePage?.let {
                    showToast("Movie Count = ${it.results.count()}")
                }
            }
        }
    }*/

    private fun testAuthentication() {
        val client = OkHttpClient()

        val request = Request.Builder().url("https://api.themoviedb.org/3/authentication").get()
            .addHeader("accept", "application/json").addHeader(
                "Authorization",
                "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2MGIzMjBhMjk2MmEyODEyYzM2ZDFmNGJmZWU2Y2IyNSIsIm5iZiI6MTcyNDE1Mzg3Ny42MTcwODgsInN1YiI6IjYxODVmYWZiZDQ4Y2VlMDA2MmQyZTQ5OSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.1OF4x9sf6p6gEzChm2xvSLd2_yi-osVt6dVqMz0PQYU"
            ).build()

        AsyncTask.execute {
            val response = client.newCall(request).execute()

            Log.d("TEST_LOG", "Status Code: ${response.code}")
            Log.d("TEST_LOG", "Success: ${response.isSuccessful}")
            Log.d("TEST_LOG", "Body: ${response.body?.string()}")
        }
    }

}