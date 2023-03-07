package com.example.anime.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.anime.R
import com.example.anime.api.GetAnime
import com.example.anime.model.AnimeItem
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AnimeAdapter(private val context: Context,private val anime :List<AnimeItem>):RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {
lateinit var getAnime: GetAnime
    class AnimeViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        val anime = itemView.findViewById<TextView>(R.id.anime)
        val name = itemView.findViewById<TextView>(R.id.name)
        val quote = itemView.findViewById<TextView>(R.id.quote)
        val floating = itemView.findViewById<FloatingActionButton>(R.id.floating)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val viewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_set,parent,false)
        return AnimeViewHolder(viewHolder)
    }

    override fun getItemCount(): Int {
        return anime.size
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
       val anime =anime[position]
        holder.anime.text =anime.anime
        holder.name.text =anime.character
        holder.quote.text =anime.quote
        holder.floating.setOnClickListener {
         Toast.makeText(context,"Share this" , Toast.LENGTH_LONG).show()
            val intent = Intent(Intent.ACTION_SEND)
            intent.type ="type/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT,"Anime Quotes")
            intent.putExtra(Intent.EXTRA_TEXT,"${anime.anime }\n\n${anime.character}\n\n${anime.quote}")
            startActivity(context,intent, Bundle.EMPTY)
        }

        }



}


