package com.example.cookmate.domain.usecases

import com.example.cookmate.domain.RecipeRepository
import com.example.cookmate.domain.dtos.MealDetailsDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMealDetailsUseCase @Inject constructor(
    private val recipeRepository: RecipeRepository
) {

    suspend operator fun invoke(
        id: String
    ): Flow<MealDetailsDto> = recipeRepository.getMealDetails(id)
}
