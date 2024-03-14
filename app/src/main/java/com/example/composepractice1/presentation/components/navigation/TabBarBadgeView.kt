package com.example.composepractice1.presentation.components.navigation

import androidx.compose.material.Text
import androidx.compose.material3.Badge
import androidx.compose.runtime.Composable

@Composable
fun TabBarBadgeView(count: Int? = null) {
    if (count != null) {
        Badge {
            Text(count.toString())
        }
    }
}