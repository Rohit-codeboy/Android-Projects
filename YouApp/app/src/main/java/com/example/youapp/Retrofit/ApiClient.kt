package com.example.youapp.Retrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object {
        const val BASE_URL = "https://www.googleapis.com/youtube/v3/"
    }

    private var retrofit: Retrofit? = null

    fun getApiClient(): Retrofit? {
        if (retrofit == null) {
            val gson = GsonBuilder().setLenient().create()

            retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson)).build()
        }
        return retrofit
    }
}