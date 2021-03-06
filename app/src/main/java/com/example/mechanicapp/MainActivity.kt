package com.example.mechanicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
private const val TAG ="MainActivity"
private const val API_KEY="pJRPnK2xowMVmYfm2zyBkHewAXuQl_0JjdE005dzqjQUX6cTPa4IHHiEbBNnJRYWasyL349-aFNyXkgfBFifQQ7mkK-r55qsz7bfZja0k-zKZJTPPCyL_okJGKoOYXYx"
private const val BASE_URL = "https://api.yelp.com/v3/"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

        val yelpData = retrofit.create(YelpData::class.java)

        yelpData.searchMechanics("Bearer $API_KEY","car Mechanic","Stockton").enqueue(object : Callback<YelpSearchResult>{
            override fun onResponse(call: Call<YelpSearchResult>, response: Response<YelpSearchResult>) {
                Log.i(TAG,"onResponse $response")
            }

            override fun onFailure(call: Call<YelpSearchResult>, t: Throwable) {

                Log.i(TAG,"onFailure $t")
            }



        })

    }
}