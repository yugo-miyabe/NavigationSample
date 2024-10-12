package kr.teams.android.jetpack_bottomnavigation.feature.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import kr.teams.android.jetpack_bottomnavigation.BottomNavItem

@Serializable
data object ProfileRoute

fun NavGraphBuilder.profileNavGraph() {
    composable(BottomNavItem.Profile.route) {
        ProfileScreen()
    }
}
