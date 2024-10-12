package kr.teams.android.jetpack_bottomnavigation.feature.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object ProfileRoute

fun NavGraphBuilder.profileNavGraph() {
    composable<ProfileRoute> {
        ProfileScreen()
    }
}
