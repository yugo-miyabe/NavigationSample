package kr.teams.android.jetpack_bottomnavigation.feature.search

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import kr.teams.android.jetpack_bottomnavigation.BottomNavItem
import kr.teams.android.jetpack_bottomnavigation.feature.profile.ProfileScreen


@Serializable
data object SearchRoute

fun NavGraphBuilder.searchNavGraph() {
    composable(BottomNavItem.Search.route) {
        ProfileScreen()
    }
}