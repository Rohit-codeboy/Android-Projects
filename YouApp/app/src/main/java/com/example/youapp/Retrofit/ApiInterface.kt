package com.example.youapp.Retrofit


import okhttp3.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("playlistItems?part=snippet%2CcontentDetails")
//    fun getAllVideos(
//        @Query("maxResults") max: Int,
//        @Query("playlistId") playlistId: String,
//        @Query("key") apikey: String
//    ): Call<Response> {
//
//    }
    Call<Response> getAllVideos(@Query("maxResults") int max,
    @Query("playlistId") String playlistId,
    @Query("key") String apikey);
}