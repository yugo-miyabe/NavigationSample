package kr.teams.android.jetpack_bottomnavigation.feature.tutorial

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun TutorialScreen(onNext: () -> Unit) {
    Column {
        Text("Tutorial Screen")
        Button(onClick = onNext) {
            Text("Button")
        }
    }
}