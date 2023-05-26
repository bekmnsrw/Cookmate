package com.example.cookmate.data.response

import com.google.gson.annotations.SerializedName

data class CategoryListResponse(
    @SerializedName("categories") val categories: List<CategoryResponse>
)
