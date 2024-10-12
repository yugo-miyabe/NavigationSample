package kr.teams.android.jetpack_bottomnavigation

import android.annotation.SuppressLint
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import kotlinx.serialization.Serializable
import kr.teams.android.jetpack_bottomnavigation.feature.home.homeNavGraph
import kr.teams.android.jetpack_bottomnavigation.feature.profile.profileNavGraph
import kr.teams.android.jetpack_bottomnavigation.feature.search.searchNavGraph
import kr.teams.android.jetpack_bottomnavigation.feature.tutorial.navigationTutorialNavGraph

@Serializable
data object TutorialRoute

@Serializable
data object AppRoute

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = TutorialRoute,
        modifier = Modifier
    ) {
        navigationTutorialNavGraph(
            navController = navController,
            navOptions = navOptions {
                popUpTo(TutorialRoute) { inclusive = true }
            }
        )
        navigationRootNavGraph()
    }
}

fun NavGraphBuilder.navigationRootNavGraph() {
    composable<AppRoute> { BottomNavScreen() }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNavScreen() {
    val navController = rememberNavController()
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Search,
        BottomNavItem.Profile
    )
    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                items.forEach { item ->
                    NavigationBarItem(
                        icon = { Icon(item.icon, contentDescription = item.title) },
                        label = { Text(item.title) },
                        selected = currentRoute == item.route,
                        onClick = {
                            navController.navigate(route = item.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) {
        Root(navController = navController)
    }
}

@Composable
fun Root(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route
    ) {
        homeNavGraph()
        searchNavGraph()
        profileNavGraph()

        /*
        composable(route = BottomNavItem.Home.route) {
            HomeScreen()
        }
        composable(route = BottomNavItem.Search.route) {
            SearchScreen()
        }
        composable(route = BottomNavItem.Profile.route) {
            ProfileScreen()
        }
        */
    }
}
