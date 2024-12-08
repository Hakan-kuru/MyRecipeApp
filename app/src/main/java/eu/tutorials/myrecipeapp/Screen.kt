package eu.tutorials.myrecipeapp

import android.transition.Scene

sealed class Screen(val route: String) {

    object Home : Screen("home")
    object Detail : Screen("detail")
    object DetailScreen : Screen("Detail Screen")
}