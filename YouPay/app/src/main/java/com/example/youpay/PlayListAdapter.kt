package com.example.youpay

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.youpay.databinding.PlaylistItemBinding

class PlayListAdapter(private val context: Context, private val lst: List<SearchItems>) : RecyclerView.Adapter<PlayListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.playlist_item,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val playlst = lst[position]
        holder.id.text = playlst.id.playlistId
        holder.title.text = playlst.snippet.title
        holder.channelTitle.text = playlst.snippet.channelTitle
    }

    override fun getItemCount(): Int {
        return lst.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.findViewById<TextView>(R.id.playlist_title)
        var id = itemView.findViewById<TextView>(R.id.playlist_id)
        var channelTitle = itemView.findViewById<TextView>(R.id.channel_title)
    }
}