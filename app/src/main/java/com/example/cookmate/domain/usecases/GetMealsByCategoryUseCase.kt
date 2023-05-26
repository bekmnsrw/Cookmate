package com.example.cookmate.domain.usecases

import com.example.cookmate.domain.RecipeRepository
import com.example.cookmate.domain.dtos.MealDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMealsByCategoryUseCase @Inject constructor(
    private val recipeRepository: RecipeRepository
) {

    suspend operator fun invoke(
        category: String
    ): Flow<List<MealDto>> = recipeRepository.getMealsByCategory(category)
}
