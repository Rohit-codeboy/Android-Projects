package com.example.youpay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var PAGE_TOKEN = "CAUQAQ"
    private lateinit var adapter: PlayListAdapter
    lateinit var next: Button
    val CHANNEL_ID = "UCOknqk-MSOCf3SANW8Wumfg"
    lateinit var rv: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv = findViewById<RecyclerView>(R.id.playlistRV)
        next = findViewById(R.id.bt_next)
        getPlaylists()

        next.setOnClickListener { getPlaylists() }
    }

    private fun getPlaylists() {
        val playlist = SearchService.searchInstance.getPlaylists("Android",PAGE_TOKEN)
        playlist.enqueue(object : Callback<SearchPlaylists>{
            override fun onResponse(call: Call<SearchPlaylists>, response: Response<SearchPlaylists>) {
                val playl = response.body()
                Log.d("Vilgad",playl.toString())
                adapter = PlayListAdapter(this@MainActivity, playl!!.items)
                PAGE_TOKEN = playl.nextPageToken
                rv.adapter = adapter
                rv.layoutManager = LinearLayoutManager(this@MainActivity)
            }

            override fun onFailure(call: Call<SearchPlaylists>, t: Throwable) {
                Log.d("Vilgad","Error in fetching playlists")
            }
        })
    }
}