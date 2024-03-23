package com.example.greenguardian

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.height

@Composable
fun DetailScreen(itemId: String?) {
    // Instead of finding the item by ID, you can directly use the provided itemId
    val selectedItem = remember { getSelectedItem(itemId) }

    // Check if the selected item is not null
    selectedItem?.let { item ->
        // If the selected item is not null, display its details
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = item.imageResId),
                contentDescription = item.name,
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = item.name,
                fontSize = 24.sp
            )
        }
    }
}

// Helper function to get the selected item by its ID
private fun getSelectedItem(itemId: String?): ListItem? {
    // Implement your logic here to retrieve the selected item based on its ID
    // For now, return null as a placeholder
    return null
}
