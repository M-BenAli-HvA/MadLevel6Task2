package com.example.madlevel6task2.api

import com.example.madlevel6task2.services.MoviesApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MoviesApi {

    companion object {
       const val baseURL = "https://api.themoviedb.org/3/discover/movie?api_key=1aedca454e9de96637badb619d147f7c"

        fun createAPI(): MoviesApiService {
//            OkHttpClient to make logs of network traffic
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

//            Create movie api instance
            val movieApi = Retrofit.Builder().baseUrl(baseURL).client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return movieApi.create(MoviesApiService::class.java)
        }


    }


}