package com.oneplatform.obeng

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oneplatform.obeng.ui.screen.LoginScreen
import com.oneplatform.obeng.ui.screen.RegisterScreen
import com.oneplatform.obeng.ui.screen.SplashScreen
import com.oneplatform.obeng.ui.theme.ObengTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ObengTheme {
               // RegisterScreen()

                val navigateToLogin = remember { mutableStateOf(false) }

                if (navigateToLogin.value) {
                    LoginScreen(openDashboard = {})
                } else {
                    SplashScreen(onTimeout = { navigateToLogin.value = true })
                }


            }

        }

    }
}
