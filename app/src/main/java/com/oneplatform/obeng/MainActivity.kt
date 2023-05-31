package com.oneplatform.obeng

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.oneplatform.obeng.ui.screen.RegisterScreen
import com.oneplatform.obeng.ui.screen.SplashScreen
import com.oneplatform.obeng.ui.theme.ObengTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ObengTheme {

                val navigateToLogin = remember { mutableStateOf(false) }

                if (navigateToLogin.value) {

                    RegisterScreen()
                    //LoginScreen(openDashboard = {})
                } else {
                    SplashScreen(onTimeout = { navigateToLogin.value = true })
                }



            }

        }

    }


}
