package com.example.cookmate.domain.usecases

import com.example.cookmate.domain.RecipeRepository
import com.example.cookmate.domain.dtos.CategoryDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val recipeRepository: RecipeRepository
) {

    suspend operator fun invoke(): Flow<List<CategoryDto>> =
        recipeRepository.getCategories()
}
