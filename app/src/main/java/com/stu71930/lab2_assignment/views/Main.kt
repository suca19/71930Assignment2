package com.stu71930.lab2_assignment.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.stu71930.lab2_assignment.R
import com.stu71930.lab2_assignment.models.MovieCard
import com.stu71930.lab2_assignment.models.movieList

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(android.graphics.Color.parseColor("#24243C")),
                    titleContentColor = Color(android.graphics.Color.parseColor("#EBECEC"))
                ),
                title = {
                    Text(
                        text = "Welcome to Suca Cinema",
                        fontFamily = FontFamily(Font(resId = R.font.roboto_condensed_regular)),
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 2.sp
                    )
                })
        },
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(android.graphics.Color.parseColor("#383958"))),
            contentPadding = PaddingValues(top = 100.dp),
        ) {
            itemsIndexed(movieList.chunked(2)) { _, rowMovies ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    for (movie in rowMovies) {
                        MovieCard(
                            movie = movie,
                            navController = navController,
                            modifier = Modifier
                                .size(width = 180.dp, height = 250.dp)
                                .padding(10.dp)
                        )
                    }
                }
            }
        }
    }
}