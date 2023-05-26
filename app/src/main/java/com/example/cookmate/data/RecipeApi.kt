package com.example.cookmate.data

import com.example.cookmate.data.response.CategoryListResponse
import com.example.cookmate.data.response.MealDetailsListResponse
import com.example.cookmate.data.response.MealListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApi {

    @GET("categories.php")
    suspend fun getCategories(): CategoryListResponse

    @GET("filter.php")
    suspend fun getMealsByCategory(
        @Query("c") category: String
    ): MealListResponse

    @GET("lookup.php")
    suspend fun getMealById(
        @Query("i") id: String
    ): MealDetailsListResponse
}
