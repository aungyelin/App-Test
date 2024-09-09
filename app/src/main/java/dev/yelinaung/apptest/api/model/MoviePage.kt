package dev.yelinaung.apptest.api.model

import com.google.gson.annotations.SerializedName

data class MoviePage(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val results: List<Movie>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int
)