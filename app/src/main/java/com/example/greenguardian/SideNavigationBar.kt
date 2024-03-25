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
import androidx.compose.material3.Button
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
fun SideBarMainScreen(
    navController: NavController,
    toggleNavigationBar: () -> Unit,
    shouldDisplayNavigationBar: Boolean,
    content: @Composable () -> Unit
) {
    val navBarVisible = remember { mutableStateOf(false) }

    if (navBarVisible.value) {
        // Display the side navigation bar with content
        Row(Modifier.fillMaxSize()) {
            // Side navigation bar
            Column(
                modifier = Modifier
                    .width(200.dp)
                    .background(Color.LightGray)
                    .padding(16.dp)
            ) {
                DrawerItem("Home", onItemClick = {}, selectedItem = "") // Placeholder values
                DrawerItem("Profile", onItemClick = {}, selectedItem = "") // Placeholder values
                DrawerItem("Settings", onItemClick = {}, selectedItem = "") // Placeholder values
                // Add more navigation items as needed
            }

            // Content alongside the side navigation bar
            Box(modifier = Modifier.weight(1f).padding(16.dp)) {
                content() // Invoke the content lambda
            }
        }
    }

    // Button to toggle the navigation bar visibility
    Button(
        onClick = { navBarVisible.value = !navBarVisible.value },
        modifier = Modifier.padding(16.dp)
    ) {
        Text(if (navBarVisible.value) "Hide Navigation Bar" else "Show Navigation Bar")
    }
}




