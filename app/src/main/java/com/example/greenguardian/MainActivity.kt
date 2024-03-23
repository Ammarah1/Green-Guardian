package com.example.greenguardian

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.greenguardian.ui.theme.GreenGuardianTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            GreenGuardianTheme {
                val navController = rememberNavController()

                // Set up navigation
                NavHost(navController = navController, startDestination = "Splash") {
                    composable(route = "Splash") {
                        SplashScreen(navController = navController)
                    }
                    composable(route = "List") {
                        ListScreen(navController = navController)
                    }
                    composable(route = "Detail/{itemId}") { backStackEntry ->
                        val itemId = backStackEntry.arguments?.getString("itemId")
                        DetailScreen(itemId = itemId)
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {
    val selectedItem = remember { mutableStateOf("Home") }

    SideBarMainScreen(navController = navController) {
        // Content of the screen goes here
        // You can use selectedItem.value to determine which screen is selected
        // For now, let's display a simple text
        Text(text = "Content Screen")
    }
}
