package com.example.cookmate.data.response

import com.google.gson.annotations.SerializedName

data class MealDetailsListResponse(
    @SerializedName("meals") val meals: List<MealDetailsResponse>
)
