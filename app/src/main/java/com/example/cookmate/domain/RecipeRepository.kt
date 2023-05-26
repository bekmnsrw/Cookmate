package com.example.cookmate.domain

import com.example.cookmate.domain.dtos.CategoryDto
import com.example.cookmate.domain.dtos.MealDetailsDto
import com.example.cookmate.domain.dtos.MealDto
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {

    suspend fun getCategories(): Flow<List<CategoryDto>>

    suspend fun getMealsByCategory(
        category: String
    ): Flow<List<MealDto>>

    suspend fun getMealDetails(
        id: String
    ): Flow<MealDetailsDto>
}
