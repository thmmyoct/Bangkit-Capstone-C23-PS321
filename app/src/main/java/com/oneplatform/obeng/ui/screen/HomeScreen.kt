package com.oneplatform.obeng.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(){
    Text(modifier = Modifier.fillMaxSize(),text = "Testing")

    LazyColumn(Modifier.background(Color.Red)){
        items(10){
            Text(text = "Hello Rakha!")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}