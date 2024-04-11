package com.stu71930.lab2_assignment.models

import androidx.compose.runtime.mutableIntStateOf
import kotlin.random.Random
import androidx.compose.runtime.MutableState



data class Movie(
    val name: String,
    val image: String,
    val certification: String,
    val description: String,
    val cast: Array<String>,
    val movieLength: String,
    var seatsRemaining: MutableState<Int>,
    var seatsSelected: MutableState<Int>
)


val movieList = listOf(
    Movie("KUNG FU PANDA 4",
        "https://www.myvue.com/-/jssmedia/vuecinemas/img/import/a223aaeb-6a2d-4561-92f0-e3efa105a21e_kung-fu-panda-4_posters_kf4_intl_dgtl_payoff_1sheet_uk_712px.jpg?mw=450&rev=7239547d058742c7b4ee0899fe51c29e",
        "https://www.myvue.com/-/jssmedia/vuecinemas/img/certificates/ie/pg.png?mw=25&mh=25&rev=be4a86333c51431593fef1189e30e84e",
        "After Po is tapped to become the Spiritual Leader of the Valley of Peace, he needs to find and train.",
        arrayOf("Jack Black", "Awkwafina", "Viola David", "Dustin Hoffman"),
        " 1hr 34mins",
        mutableIntStateOf(Random.nextInt(0, 16)),
        mutableIntStateOf(0)
    ),

    Movie("GODZILLA X KONG: THE NEW EMPIRE",
        "https://www.myvue.com/-/jssmedia/vuecinemas/img/import/7bf51248-5164-49ec-ab6f-090e904a263f_godzilla-x-kong-the-new-empire_posters_teaser---one-sheet_712px.jpg?mw=450&rev=013f431ef34d4bd98344d19d229a4345",
        "https://www.myvue.com/-/jssmedia/vuecinemas/img/certificates/ie/12a.png?mw=25&mh=25&rev=d1b78b8f625a43b098703bf1bf397269",
        "The new installment in the Monsterverse puts the mighty Kong and the fearsome Godzilla against a colossal deadly threat hidden within our world.",
        arrayOf("Rebecca Hall", "Dan Stevens", "Brian Tyree Henry", "Fala Chen", "Kaylee Hottle", "Alex Ferns"),
        "1hr 55mins",
        mutableIntStateOf(Random.nextInt(0, 16)),
        mutableIntStateOf(0)
    ),

    Movie("BACK TO BLACK",
        "https://www.myvue.com/-/jssmedia/vuecinemas/film-and-events/jan-2024/backtoblack.jpg?mw=450&rev=ff98831535e845679aaeca281ae8ce70",
        "https://www.myvue.com/-/jssmedia/vuecinemas/img/certificates/ie/15a.png?mw=25&mh=25&rev=fd3786da538c4502b4e4c02ea3c7b44e",
        "Follow the life and music of Winehouse, who started out as a jazz singer to eventually become a Grammy-winning music superstar.",
        arrayOf("Eddie Marsan", "Jack O'Connell", "Lesley Manville", "Marisa Abela"),
        "2hr 2mins",
        mutableIntStateOf(Random.nextInt(0, 16)),
        mutableIntStateOf(0)
    ),

    Movie("CIVIL WAR",
        "https://www.myvue.com/-/jssmedia/civil-war_vue_540x480.jpg?mw=768&rev=29936c4503f84ea18e3c35d6e72d287b",
        "https://www.myvue.com/-/jssmedia/vuecinemas/img/certificates/ie/15a.png?mw=25&mh=25&rev=fd3786da538c4502b4e4c02ea3c7b44e",
        "In the near future, a team of journalists travel across the United States during a rapidly escalating civil war that has engulfed the entire nation.",
        arrayOf("Wagner Moura", "Kirsten Dunst", "Cailee Spaeny", "Stephen McKinley Henderson"),
        "1hr 49mins",
        mutableIntStateOf(Random.nextInt(0, 16)),
        mutableIntStateOf(0)
    )
)