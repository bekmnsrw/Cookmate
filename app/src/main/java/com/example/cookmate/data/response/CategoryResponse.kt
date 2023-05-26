package com.example.cookmate.data.response

import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("idCategory") val id: String,
    @SerializedName("strCategory") val name: String,
    @SerializedName("strCategoryThumb") val photoUrl: String,
    @SerializedName("strCategoryDescription") val description: String
)
