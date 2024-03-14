package com.example.composepractice1.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composepractice1.presentation.components.navigation.TabView
import com.example.composepractice1.presentation.screen.home.HomeScreen
import com.example.composepractice1.presentation.screen.more.MoreScreen
import com.example.composepractice1.ui.theme.ComposePractice1Theme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavGraph(navController: NavHostController) {

    val homeTab = TabBarItem(title = "Home", selectedIcon = Icons.Filled.Home, unselectedIcon = Icons.Outlined.Home)
    val alertsTab = TabBarItem(
        title = "Alerts",
        selectedIcon = Icons.Filled.Notifications,
        unselectedIcon = Icons.Outlined.Notifications,
        badgeAmount = 7
    )
    val settingsTab = TabBarItem(title = "Settings", selectedIcon = Icons.Filled.Settings, unselectedIcon = Icons.Outlined.Settings)
    val moreTab = TabBarItem(title = "More", selectedIcon = Icons.Filled.List, unselectedIcon = Icons.Outlined.List)

    // creating a list of all the tabs
    val tabBarItems = listOf(homeTab, alertsTab, settingsTab, moreTab)

    ComposePractice1Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(bottomBar = { TabView(tabBarItems, navController) }) {
                NavHost(navController = navController, startDestination = homeTab.title) {
                    composable(homeTab.title) {
                        HomeScreen()
                    }
                    composable(alertsTab.title) {
                        Text(alertsTab.title)
                    }
                    composable(settingsTab.title) {
                        Text(settingsTab.title)
                    }
                    composable(moreTab.title) {
                        MoreScreen()
                    }
                }
            }
        }
    }
}



data class TabBarItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val badgeAmount: Int? = null
)
