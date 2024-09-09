package dev.yelinaung.apptest.api

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import dev.yelinaung.apptest.BaseActivity
import dev.yelinaung.apptest.api.model.Api
import dev.yelinaung.apptest.databinding.ActivityNetworkBinding
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkActivity : BaseActivity<ActivityNetworkBinding>() {

    companion object {

        fun getInstance(context: Context): Intent {
            return Intent(context, NetworkActivity::class.java)
        }

    }

    private lateinit var apiService: ApiService

    override val pageTitle: String = "Networking"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityNetworkBinding {
        return ActivityNetworkBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        apiService = Api.createApiService()
        binding.swipeRefreshLayout.setOnRefreshListener {
            this.fetchMovies()
        }
    }

    private fun fetchMovies() {
        /*val client = OkHttpClient()

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
        }*/

        AsyncTask.execute {
            val response = apiService.getMovies()
        }
    }

    private fun testAuthentication() {
        val client = OkHttpClient()

        val request = Request.Builder()
            .url("https://api.themoviedb.org/3/authentication")
            .get()
            .addHeader("accept", "application/json")
            .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2MGIzMjBhMjk2MmEyODEyYzM2ZDFmNGJmZWU2Y2IyNSIsIm5iZiI6MTcyNDE1Mzg3Ny42MTcwODgsInN1YiI6IjYxODVmYWZiZDQ4Y2VlMDA2MmQyZTQ5OSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.1OF4x9sf6p6gEzChm2xvSLd2_yi-osVt6dVqMz0PQYU")
            .build()

        AsyncTask.execute {
            val response = client.newCall(request).execute()

            Log.d("TEST_LOG", "Status Code: ${response.code}")
            Log.d("TEST_LOG", "Success: ${response.isSuccessful}")
            Log.d("TEST_LOG", "Body: ${response.body?.string()}")
        }
    }

}