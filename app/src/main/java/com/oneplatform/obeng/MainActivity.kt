package com.oneplatform.obeng

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.core.view.WindowCompat
import com.oneplatform.obeng.ui.screen.LoginScreen
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

                    //RegisterScreen()
                    LoginScreen(openDashboard = {})
                } else {
                    SplashScreen(onTimeout = { navigateToLogin.value = true })
                }


            }

        }

    }


}
