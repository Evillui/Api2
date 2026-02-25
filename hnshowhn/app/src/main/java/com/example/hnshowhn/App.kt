package com.example.hnshowhn

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.hnshowhn.navigation.Routes
import com.example.hnshowhn.ui.screen.ShowHnDetailScreen
import com.example.hnshowhn.ui.screen.ShowHnListScreen

@Composable
fun App() {
    val navController = rememberNavController()

    Scaffold { padding ->
        NavHost(
            navController = navController,
            startDestination = Routes.List.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(Routes.List.route) {
                ShowHnListScreen(
                    onOpenDetail = { id ->
                        navController.navigate(Routes.Detail.create(id))
                    }
                )
            }

            composable(
                route = Routes.Detail.route,
                arguments = listOf(
                    navArgument(Routes.Detail.ARG_ID) { type = NavType.LongType }
                )
            ) { backStackEntry ->
                val id = backStackEntry.arguments?.getLong(Routes.Detail.ARG_ID)
                if (id != null) {
                    ShowHnDetailScreen(
                        itemId = id,
                        onBack = { navController.popBackStack() }
                    )
                }
            }
        }
    }
}