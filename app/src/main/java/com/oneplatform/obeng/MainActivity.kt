package com.oneplatform.obeng

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.oneplatform.obeng.navigation.Navigation
import com.oneplatform.obeng.ui.screen.HomeScreen
import com.oneplatform.obeng.ui.screen.LoginScreen
import com.oneplatform.obeng.ui.screen.SplashScreen
import com.oneplatform.obeng.ui.theme.ObengTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ObengTheme {
                ObengComposeUIMain()
            }
        }
    }

    @Composable
    fun ObengComposeUIMain(){
        Surface(color = MaterialTheme.colorScheme.background) {
            Navigation()
        }
    }

}
