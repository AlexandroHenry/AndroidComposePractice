package com.example.composepractice1.presentation.components.navigation

import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composepractice1.presentation.navigation.TabBarItem


@Composable
fun TabView(tabBarItems: List<TabBarItem>, navController: NavController) {
    var selectedTabIndex by rememberSaveable {
        mutableStateOf(0)
    }

    NavigationBar {
        // looping over each tab to generate the views and navigation for each item

        tabBarItems.forEachIndexed { index, tabBarItem ->
//            NavigationBarItem(selected = selectedTabIndex == index, onClick = {
//                selectedTabIndex = index
//                navController.navigate(tabBarItem.title)
//            }, icon = {
//                TabBarIconView(
//                    isSelected = selectedTabIndex == index,
//                    selectedIcon = tabBarItem.selectedIcon,
//                    unselectedIcon = tabBarItem.unselectedIcon,
//                    title = tabBarItem.title,
//                    badgeAmount = tabBarItem.badgeAmount
//                )
//            }, label = { Text(tabBarItem.title) })
            BottomNavigationItem(
                selected = selectedTabIndex == index,
                onClick = {
                    selectedTabIndex = index
                    navController.navigate(tabBarItem.title)
                },
                icon = {
                    Icon(
                        imageVector = if (selectedTabIndex == index) {
                            tabBarItem.selectedIcon
                        } else {
                            tabBarItem.unselectedIcon
                        },
                        contentDescription = null,
                        tint = if (selectedTabIndex == index) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground
                    )
                },
                label = { Text(tabBarItem.title) }
            )
        }
    }
}

@Preview
@Composable
fun TabViewPreview() {
    val navController = rememberNavController()
    val tabBarItems = listOf(
        TabBarItem(title = "Home", selectedIcon = Icons.Filled.Home, unselectedIcon = Icons.Outlined.Home),
        TabBarItem(
            title = "Alerts",
            selectedIcon = Icons.Filled.Notifications,
            unselectedIcon = Icons.Outlined.Notifications,
            badgeAmount = 7
        ),
        TabBarItem(title = "Settings", selectedIcon = Icons.Filled.Settings, unselectedIcon = Icons.Outlined.Settings),
        TabBarItem(title = "More", selectedIcon = Icons.Filled.List, unselectedIcon = Icons.Outlined.List)
    )

    TabView(tabBarItems = tabBarItems, navController = navController)
}