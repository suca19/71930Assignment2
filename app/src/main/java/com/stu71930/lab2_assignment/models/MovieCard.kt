package com.stu71930.lab2_assignment.models

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieCard(movie: Movie, navController: NavController, modifier: Modifier = Modifier) {
    Card (
        modifier = modifier,

        onClick = { navController.navigate("movieDetails/${movie.name}") }) {
        Image(
            painter = rememberAsyncImagePainter(model = movie.image),
            contentDescription = movie.name,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}