package com.example.greenguardian

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

data class ListItem(
    val name: String,
    val imageResId: Int
)

@Composable
fun ListScreen(navController: NavController) {
    val items = listOf(
        ListItem(name = "Item 1", imageResId = R.drawable.list1),
        ListItem(name = "Item 2", imageResId = R.drawable.list2),
        ListItem(name = "Item 3", imageResId = R.drawable.list3),
        ListItem(name = "Item 4", imageResId = R.drawable.list4)
    )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "List Screen", // Add your desired title here
            fontSize = 24.sp,
            color = Color.Black, // Change the color to your desired color
            fontFamily = FontFamily.SansSerif, // Change the font family to your desired font
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp)) // Add padding below the title

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {
            val chunkedItems = items.chunked(2)
            chunkedItems.forEach { chunk ->
                item {
                    TwoItemsRow(items = chunk, navController = navController)
                }
            }
        }
    }


}

@Composable
fun TwoItemsRow(items: List<ListItem>, navController: NavController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Top
    ) {
        items.forEach { item ->
            ListItem(item = item, navController = navController) // Pass navController to ListItem
        }
    }
}

@Composable
fun ListItem(item: ListItem, navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top, // Align items at the top
        modifier = Modifier
            .clickable { navController.navigate("Detail/${item.name}") } // Navigate to detail screen when clicked
            .padding(8.dp)
            .fillMaxHeight()
    ) {
        Image(
            painter = painterResource(id = item.imageResId),
            contentDescription = item.name,
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = item.name, fontSize = 24.sp)
    }
}






