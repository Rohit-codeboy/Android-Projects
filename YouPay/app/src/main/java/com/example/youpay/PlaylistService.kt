package com.example.youpay

import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

// https://youtube.googleapis.com/youtube/v3/playlists?part=snippet&channelId=UCOknqk-MSOCf3SANW8Wumfg&maxResults=1&key=API_KEY
const val BASE_URL = "https://youtube.googleapis.com/youtube/v3/"
const val API_KEY = "AIzaSyBUJ8z9DC4tTuDQTe6o6cNjIOGdQO6V-p8"

interface PlaylistInterface {
    @GET("playlists?part=snippet&key=$API_KEY")
    fun getPlaylists(
        @Query("channelId") channelId: String,
        @Query("maxResults") maxResults: Int
    ): Call<Playlists>
}

object PlaylistService{
    val playlistInstance: PlaylistInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        playlistInstance = retrofit.create(PlaylistInterface::class.java)
    }
}