package com.example.greenguardian

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
                val shouldDisplayNavigationBar = remember { mutableStateOf(false) }

                // Set up navigation
                NavHost(navController = navController, startDestination = "Splash") {
                    composable(route = "Splash") {
                        SplashScreen(navController = navController)
                    }
                    composable(route = "List") {
                        ListScreen(
                            navController = navController,
                            toggleNavigationBar = {
                                shouldDisplayNavigationBar.value = !shouldDisplayNavigationBar.value
                            }
                        )
                    }
                    composable(route = "Detail/{itemId}") { backStackEntry ->
                        val itemId = backStackEntry.arguments?.getString("itemId")
                        DetailScreen(
                            itemId = itemId,
                            navController = navController,
                            toggleNavigationBar = {
                                shouldDisplayNavigationBar.value = !shouldDisplayNavigationBar.value
                            },
                            shouldDisplayNavigationBar = shouldDisplayNavigationBar.value
                        )
                    }
                }
            }
        }
    }
}