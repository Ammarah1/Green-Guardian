package com.example.greenguardian

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
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
                        // Render the side navigation bar on the list screen
                        Surface(modifier = Modifier.fillMaxSize()) {
                            SideBarMainScreen(navController = navController) {
                                ListScreen(navController = navController)
                            }
                        }
                    }
                    composable(route = "Detail/{itemId}") { backStackEntry ->
                        val itemId = backStackEntry.arguments?.getString("itemId")
                        // Render the side navigation bar on the detail screen
                        Surface(modifier = Modifier.fillMaxSize()) {
                            SideBarMainScreen(navController = navController) {
                                DetailScreen(itemId = itemId)
                            }
                        }
                    }
                }
            }
        }
    }
}
