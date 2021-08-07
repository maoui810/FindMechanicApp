package com.example.mechanicapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

public interface YelpData {

    @GET("businesses/search")
    fun searchMechanics(

        @Header("Authroization") authHeader: String,
        @Query("term") search: String,
        @Query("location") location: String): Call<YelpSearchResult>


}