package dev.yelinaung.apptest.api

import dev.yelinaung.apptest.api.model.MoviePage
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("discover/movie")
    fun getMovies(): Response<MoviePage>

}