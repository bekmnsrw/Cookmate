package com.example.cookmate.data.response

import com.google.gson.annotations.SerializedName

data class MealListResponse(
    @SerializedName("meals") val meals: List<MealResponse>
)
