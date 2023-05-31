package com.oneplatform.obeng.navigation

sealed class Screen (val route: String){
    object SplashScreen : Screen("splash_screen")
    object LoginScreen : Screen("login_screen")
    object RegisterUserScreen : Screen("register_user")
    object RegisterTechnicianScreen : Screen("register_technician")
    object HomeScreen : Screen("home_screen")

}