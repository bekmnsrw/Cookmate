package com.example.cookmate.di

import com.example.cookmate.data.RecipeApi
import com.example.cookmate.data.RecipeRepositoryImpl
import com.example.cookmate.domain.RecipeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class RecipeModule {

    @Provides
    fun provideRecipeRepository(
        recipeApi: RecipeApi
    ): RecipeRepository = RecipeRepositoryImpl(recipeApi)
}
