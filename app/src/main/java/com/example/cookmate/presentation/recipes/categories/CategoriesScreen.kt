package com.example.cookmate.presentation.recipes.categories

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.size.Scale
import com.example.cookmate.R
import com.example.cookmate.Screen
import com.example.cookmate.domain.dtos.CategoryDto

@Composable
fun CategoriesScreen(
    navController: NavController,
    viewModel: CategoriesViewModel = hiltViewModel()
) {

    val state = viewModel.state.collectAsStateWithLifecycle()
    val action by viewModel.action.collectAsStateWithLifecycle(initialValue = null)

    CategoriesContent(
        screenState = state.value,
        navController = navController
    )

    CategoriesScreenActions(
        screenAction = action
    )
}

@Composable
fun CategoriesContent(
    screenState: CategoriesScreenState,
    navController: NavController
) {

    CategoriesList(screenState, navController)
}

@Composable
private fun CategoriesScreenActions(
    screenAction: CategoriesScreenAction?
) {
    when (screenAction) {
        null -> Unit
        is CategoriesScreenAction.ShowError -> TODO()
    }
}

@Composable
fun CategoriesList(
    screenState: CategoriesScreenState,
    navController: NavController
) {

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Text(
                text = stringResource(id = R.string.categories_title),
                modifier = Modifier.padding(16.dp)
            )
        }
        items(
            screenState.categories,
            key = { it.id }
        ) {
            ListItem(categoryDto = it) { categoryName ->
                navController.navigate(Screen.Dishes.createRoute(categoryName))
            }
        }
    }
    CircularProgressBar(
        screenState = screenState
    )
}

@Composable
fun ListItem(
    categoryDto: CategoryDto,
    onClick: (String) -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                bottom = 16.dp,
                start = 16.dp,
                end = 16.dp
            )
            .clickable { onClick.invoke(categoryDto.name) },
        elevation = 6.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row {
            AsyncImage(
                modifier = Modifier.padding(vertical = 12.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(categoryDto.photoUrl)
                    .crossfade(true)
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.placeholder)
                    .diskCachePolicy(CachePolicy.ENABLED)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        end = 24.dp,
                        top = 16.dp,
                        bottom = 16.dp
                    )
            ) {
                Text(
                    text = categoryDto.name
                )
                Text(
                    text = categoryDto.description,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
private fun CircularProgressBar(screenState: CategoriesScreenState) {
    if (screenState.isLoading) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator()
        }
    }
}