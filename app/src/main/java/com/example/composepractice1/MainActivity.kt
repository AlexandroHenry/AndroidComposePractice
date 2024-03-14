package com.example.composepractice1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composepractice1.presentation.navigation.NavGraph
import com.example.composepractice1.presentation.screen.more.MoreScreen
import com.example.composepractice1.ui.theme.ComposePractice1Theme

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePractice1Theme {
                navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}