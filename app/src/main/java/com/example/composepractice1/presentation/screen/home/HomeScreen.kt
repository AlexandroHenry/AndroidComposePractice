package com.example.composepractice1.presentation.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter

@Composable
fun HomeScreen(urls: List<String>) {
    Column(Modifier.fillMaxSize()) {
        Text("title", style = TextStyle(fontSize = 32.sp))

        LazyRow {
            items(urls) { url ->
                val painter = rememberImagePainter(url)
                ImageButton(painter = painter, onClick = { /* Handle button click */ })
            }
        }
    }
}

@Composable
fun ImageButton(painter: Painter, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(300.dp, 200.dp) // 이미지 크기 조정
            .padding(8.dp) // 이미지 간격 조정
            .clickable { onClick }
            .clip(RoundedCornerShape(16.dp)) // 모서리 적용
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(), // 이미지를 박스에 꽉 채움
            contentScale = ContentScale.Crop // 이미지를 크롭하여 채우도록 설정
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    val urls = listOf(
        "https://plus.unsplash.com/premium_photo-1684952851101-6ab3e41b0448?q=80&w=1254&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        "https://images.unsplash.com/photo-1705374464124-42c35f96da9f?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        "https://images.unsplash.com/photo-1707423948446-95e2604d4f8d?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
    )

    HomeScreen(urls)
}
