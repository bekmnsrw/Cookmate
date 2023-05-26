package com.example.cookmate.data.response

import com.google.gson.annotations.SerializedName

data class MealResponse(
    @SerializedName("strMeal") val name: String,
    @SerializedName("strMealThumb") val photoUrl: String,
    @SerializedName("idMeal") val id: String
)
