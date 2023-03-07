package com.example.anime.api

import android.content.Intent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object AnimeServes {

    val retrofit =Retrofit.Builder()
        .baseUrl("https://animechan.vercel.app/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val Intent = retrofit.create(GetAnime::class.java)
}