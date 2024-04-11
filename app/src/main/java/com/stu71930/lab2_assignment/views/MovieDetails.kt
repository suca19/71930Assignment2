package com.stu71930.lab2_assignment.views

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Remove
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.stu71930.lab2_assignment.R
import com.stu71930.lab2_assignment.models.movieList

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MovieDetails(movieName: String?, navController: NavController) {

    val movie = movieList.find { it.name == movieName }

    Text(text = "Movie Details: $movieName")

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(android.graphics.Color.parseColor("#24243C")),
                    titleContentColor = Color(android.graphics.Color.parseColor("#EBECEC"))
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBackIosNew,
                            contentDescription = "Navigate Up",
                            tint = Color.White
                        )
                    }
                },
                title = {
                    Text(
                        text = "${movie?.name}",
                        fontFamily = FontFamily(Font(resId = R.font.roboto_condensed_regular)),
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 2.sp
                    )
                })
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color(android.graphics.Color.parseColor("#24243C")),
                contentColor = Color(android.graphics.Color.parseColor("#EBECEC"))
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val seatsColor =
                        if (movie?.seatsRemaining?.value!! <= 3) Color.Red else Color.White

                    IconButton(onClick = {
                        if (movie.seatsSelected.value > 0) {
                            movie.seatsSelected.value--
                            movie.seatsRemaining.value++
                        }
                    }) {
                        Surface(
                            modifier = Modifier.size(26.dp),
                            shape = CircleShape,
                            color = Color.Transparent,
                            border = BorderStroke(2.dp, Color.LightGray)
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Remove,
                                contentDescription = "Remove Seat",
                                tint = Color.White,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }

                    Text(
                        text = "${movie.seatsSelected.value}",
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(resId = R.font.roboto_condensed_regular)),
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )

                    IconButton(onClick = {
                        if (movie.seatsRemaining.value > 0) {
                            movie.seatsSelected.value++
                            movie.seatsRemaining.value--
                        }
                    }) {
                        Surface(
                            modifier = Modifier.size(26.dp),
                            shape = CircleShape,
                            color = Color.Transparent,
                            border = BorderStroke(2.dp, Color.LightGray)
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Add,
                                contentDescription = "Add Seat",
                                tint = Color.White,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }

                    Text(
                        text = if (movie.seatsRemaining.value == 0) "No seats available" else "Seats Available: ${movie.seatsRemaining.value}",
                        color = seatsColor,
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(resId = R.font.roboto_condensed_regular)),
                        modifier = Modifier.padding(end  = 5.dp)
                    )
                }
            }
        }
    ){

        LazyColumn(
            contentPadding = PaddingValues(top = 60.dp),
            modifier = Modifier
                .fillMaxSize()
                .background(Color(android.graphics.Color.parseColor("#000000"))),


            ) {
            item {
                Image(
                    painter = rememberAsyncImagePainter(model = movie?.image),
                    contentDescription = movie?.name,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .fillMaxWidth()
                        .height(300.dp),
                    contentScale = ContentScale.FillBounds
                )
                Column(modifier = Modifier.padding(16.dp)) {

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            fontFamily = FontFamily(Font(resId = R.font.roboto_condensed_regular)),
                            text = "${movie?.name}",
                            fontSize = 26.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color(android.graphics.Color.parseColor("#D3D3D3"))
                        )

                        Spacer(modifier = Modifier.width(16.dp))
                        Image(
                            painter = rememberAsyncImagePainter(model = movie?.certification),
                            contentDescription = movie?.certification,
                            modifier = Modifier.size(26.dp),
                            contentScale = ContentScale.FillBounds
                        )
                    }

                    when {
                        movie?.seatsRemaining?.value!! in 1..3 -> {
                            Row {
                                Icon(
                                    Icons.Filled.Warning,
                                    contentDescription = "Warning",
                                    tint = Color.Red,
                                )
                                Text(
                                    text = "${movie.seatsRemaining.value} seats remaining!",
                                    fontFamily = FontFamily(Font(resId = R.font.roboto_condensed_regular)),
                                    color = Color.Red,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(start = 8.dp)
                                )
                            }
                        }

                        movie.seatsRemaining.value!! == 0 -> {
                            Row {
                                Icon(
                                    Icons.Filled.Cancel,
                                    contentDescription = "Sold Out",
                                    tint = Color.Red,
                                )
                                Text(
                                    text = "Sold Out!",
                                    fontFamily = FontFamily(Font(resId = R.font.roboto_condensed_regular)),
                                    color = Color.Red,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(start = 8.dp)
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row {

                        Text(
                            text = "Starring ",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily(Font(resId = R.font.roboto_condensed_regular)),
                            color = Color(android.graphics.Color.parseColor("#D3D3D3"))
                        )
                        Text(
                            text = "Starring: ${movie?.cast?.joinToString()}",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily(Font(resId = R.font.roboto_condensed_regular)),
                            color = Color(android.graphics.Color.parseColor("#6E6E6E"))
                        )
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    Row {

                        Text(
                            text = "Running Time ",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily(Font(resId = R.font.roboto_condensed_regular)),
                            color = Color(android.graphics.Color.parseColor("#D3D3D3"))
                        )
                        Text(
                            text = "${movie?.movieLength} ",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily(Font(resId = R.font.roboto_condensed_regular)),

                            color = Color(android.graphics.Color.parseColor("#6E6E6E"))
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "${movie?.description}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White,
                        maxLines = 10,
                        overflow = TextOverflow.Ellipsis,
                        fontFamily = FontFamily(Font(resId = R.font.roboto_condensed_regular)),
                        modifier = Modifier.padding(bottom = 100.dp)

                    )

                }
            }
        }
    }
}