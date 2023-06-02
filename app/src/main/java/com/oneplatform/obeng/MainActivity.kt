package com.oneplatform.obeng

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.oneplatform.obeng.navigation.Navigation
import com.oneplatform.obeng.ui.theme.ObengTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //getUserData()
        setContent {
                ObengComposeUIMain()
            }
        }
    }

    @Composable
    fun ObengComposeUIMain(){

        ObengTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Navigation()
        }
    }
}
