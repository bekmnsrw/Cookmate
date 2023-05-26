package com.example.cookmate.data

import com.example.cookmate.data.mappers.toCategoryDtoList
import com.example.cookmate.data.mappers.toMealDetailsDto
import com.example.cookmate.data.mappers.toMealDtoList
import com.example.cookmate.domain.RecipeRepository
import com.example.cookmate.domain.dtos.CategoryDto
import com.example.cookmate.domain.dtos.MealDetailsDto
import com.example.cookmate.domain.dtos.MealDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val recipeApi: RecipeApi
) : RecipeRepository {

    override suspend fun getCategories(): Flow<List<CategoryDto>> = flow {
        emit(
            recipeApi.getCategories()
                .categories
                .toCategoryDtoList()
        )
    }

    override suspend fun getMealsByCategory(
        category: String
    ): Flow<List<MealDto>> = flow {
        emit(
            recipeApi.getMealsByCategory(category)
                .meals
                .toMealDtoList()
        )
    }

    override suspend fun getMealDetails(
        id: String
    ): Flow<MealDetailsDto> = flow {
        emit(
            recipeApi.getMealById(id)
                .meals
                .first()
                .toMealDetailsDto()
        )
    }
}
