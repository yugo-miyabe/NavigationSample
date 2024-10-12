package kr.teams.android.jetpack_bottomnavigation.feature.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import kr.teams.android.jetpack_bottomnavigation.BottomNavItem

@Serializable
data object HomeRoute

fun NavController.navigateToHomeScreen(navOptions: NavOptions) {
    navigate(route = HomeRoute, navOptions)
}

fun NavGraphBuilder.homeNavGraph() {
    composable(BottomNavItem.Home.route) {
        HomeScreen()
    }
}

@Composable
fun HomeNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = HomeRoute) {
        composable<HomeRoute> {
            HomeScreen()
        }
    }
}
