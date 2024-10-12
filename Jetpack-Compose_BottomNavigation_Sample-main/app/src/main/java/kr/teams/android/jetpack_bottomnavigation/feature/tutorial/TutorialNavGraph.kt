package kr.teams.android.jetpack_bottomnavigation.feature.tutorial

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kr.teams.android.jetpack_bottomnavigation.AppRoute
import kr.teams.android.jetpack_bottomnavigation.TutorialRoute

fun NavGraphBuilder.navigationTutorialNavGraph(
    navController: NavHostController,
    navOptions: NavOptions
) {
    composable<TutorialRoute> {
        TutorialScreen(
            onNext = {
                navController.navigate(route = AppRoute, navOptions = navOptions)
            }
        )
    }
}