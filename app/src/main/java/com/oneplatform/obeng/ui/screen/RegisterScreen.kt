package com.oneplatform.obeng.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.layout.LazyLayout
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import com.oneplatform.obeng.R
import com.oneplatform.obeng.ui.screen.components.HeaderView
import com.oneplatform.obeng.ui.screen.components.SmallBanner

@Composable
fun RegisterScreen(){

    val pageTitle = "Register"
    val bannerBackground = ImageBitmap.imageResource(id = R.drawable.login_bg)

    LazyColumn(modifier = Modifier.fillMaxSize()){
        item {
            SmallBanner(title = pageTitle, backgroundImage = bannerBackground)
        }
        items(10) {index->
            Text(text = "Hello $index")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview(){
    RegisterScreen()
}