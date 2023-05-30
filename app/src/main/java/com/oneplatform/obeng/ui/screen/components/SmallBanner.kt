package com.oneplatform.obeng.ui.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oneplatform.obeng.R

@Composable
fun SmallBanner(title: String, backgroundImage: ImageBitmap) {
    Box(
        modifier = Modifier
            .height(120.dp)
            .fillMaxWidth()
            .background(Color.LightGray, RoundedCornerShape(8.dp))
    ) {
        Image(
            bitmap = backgroundImage,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.align(Alignment.Center)) {
            Image(
                bitmap = ImageBitmap.imageResource(id = R.drawable.flower_logo),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
            )
            Text(
                text = title,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )
        }

    }
}

@Preview(showBackground = false)
@Composable
fun SmallBannerPreview(){
    SmallBanner(title = stringResource(id = R.string.app_name) , backgroundImage = ImageBitmap.imageResource(id = R.drawable.login_bg))
}