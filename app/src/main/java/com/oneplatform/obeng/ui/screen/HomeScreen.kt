package com.oneplatform.obeng.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(){
    Text(modifier = Modifier.fillMaxSize(),text = "Testing")
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}