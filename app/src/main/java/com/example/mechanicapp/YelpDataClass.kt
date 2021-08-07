package com.example.mechanicapp

import com.google.gson.annotations.SerializedName


data class YelpSearchResult(

    @SerializedName("total") val total: Int,
    @SerializedName("businesses") val shops:List<YelpShop>


)

data class YelpShop(

    val name: String,
    val rating: Double,
    val price: String,

    @SerializedName("review_count") val numReviews: Int,
    @SerializedName("distance") val distanceInMeters: Double,
    @SerializedName("image_url") val imageUrl: String


)


data class YelpCategory(

    val title: String

)