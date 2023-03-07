package com.example.anime

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.controls.actions.FloatAction
import android.util.Log
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.core.view.postDelayed
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.anime.R.*
import com.example.anime.adapter.AnimeAdapter
import com.example.anime.api.AnimeServes
import com.example.anime.api.GetAnime
import com.example.anime.model.Anime
import com.example.anime.model.AnimeItem
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create


class MainActivity : AppCompatActivity() {
    lateinit var adapter: AnimeAdapter
    lateinit var anime: GetAnime
    lateinit var swipeRefreshLayout:SwipeRefreshLayout
    lateinit var recyclerView:RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        swipeRefreshLayout =findViewById<SwipeRefreshLayout>(R.id.swipeRefreshLayout)
        recyclerView = findViewById<RecyclerView>(id.recyclerView)
        val linearLayout = LinearLayoutManager(this@MainActivity)
        recyclerView.layoutManager = linearLayout
        getData()


        swipeRefreshLayout.setOnRefreshListener {

            swipeRefreshLayout.postDelayed(1000, action = { getData() })
            swipeRefreshLayout.isRefreshing=false
        }

    }

    private fun getData() {
        AnimeServes.Intent.getQuote().enqueue(object : Callback<Anime> {
            override fun onResponse(call: Call<Anime>, response: Response<Anime>) {
                if (response.isSuccessful) {
                    adapter = AnimeAdapter(this@MainActivity,response.body()!!)
                    recyclerView.adapter = adapter
                }
            }

            override fun onFailure(call: Call<Anime>, t: Throwable) {
                Toast.makeText(this@MainActivity, "application is Failed ", Toast.LENGTH_LONG)
                    .show()
            }

        })
    }


}