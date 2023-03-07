package com.example.anime.api

import com.example.anime.model.Anime
import com.example.anime.model.AnimeItem
import retrofit2.Call
import retrofit2.http.GET

interface GetAnime {
    @GET("api/quotes")
   public fun getQuote():Call<Anime>
}