package com.example.greenguardian

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController




@Composable
fun SideNavigationBar(
    onItemClick: (String) -> Unit,
    selectedItem: String,
    content: @Composable () -> Unit // Content lambda for the screen's content
) {
    Row {
        // Display the side navigation bar
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .width(200.dp)
                .background(Color.LightGray)
        ) {
            DrawerItem("Home", onItemClick, selectedItem)
            DrawerItem("Profile", onItemClick, selectedItem)
            DrawerItem("Settings", onItemClick, selectedItem)
            // Add more navigation items as needed
        }
        // Display the content alongside the side navigation bar
        content()
    }
}


@Composable
private fun DrawerItem(
    label: String,
    onItemClick: (String) -> Unit,
    selectedItem: String
) {
    Text(
        text = label,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                onItemClick(label)
            },
        color = if (label == selectedItem) Color.Black else Color.Gray
    )
}

@Composable
fun Content(navController: NavController) {
    // Content of the screen goes here
}

@Composable
fun SideBarMainScreen(navController: NavController, content: @Composable () -> Unit) {
    val selectedItem = remember { mutableStateOf("Home") }

    val currentRoute = navController.currentDestination?.route
    val shouldDisplayNavigationBar = currentRoute != "Splash" // Change "Splash" to the route of your animation screen

    if (shouldDisplayNavigationBar) {
        // Row containing both the side navigation bar and the content
        Row(modifier = Modifier.fillMaxSize()) {
            // Side navigation bar
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(200.dp)
                    .background(Color.LightGray)
                    .padding(16.dp) // Applying padding to the side navigation bar
            ) {
                DrawerItem("Home", onItemClick = { selectedItem.value = "Home" }, selectedItem = selectedItem.value)
                DrawerItem("Profile", onItemClick = { selectedItem.value = "Profile" }, selectedItem = selectedItem.value)
                DrawerItem("Settings", onItemClick = { selectedItem.value = "Settings" }, selectedItem = selectedItem.value)
                // Add more navigation items as needed
            }

            // Content alongside the side navigation bar
            Box(modifier = Modifier.weight(1f).padding(16.dp)) {
                content() // Invoke the content lambda
            }
        }
    } else {
        // Only display the content without the navigation bar
        content()
    }
}





