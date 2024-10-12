package kr.teams.android.jetpack_bottomnavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

@Serializable
data object HomeRote

@Serializable
data object SearchRote

@Serializable
data object ProfileRote

sealed class BottomNavItem(
    val route: String,
    val icon: ImageVector,
    val title: String
) {
    data object Home : BottomNavItem("home", Icons.Default.Home, "Home")
    data object Search : BottomNavItem("search", Icons.Default.Search, "Search")
    data object Profile : BottomNavItem("profile", Icons.Default.Person, "Profile")
}