package kr.teams.android.jetpack_bottomnavigation.feature.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    init {
        Timber.d("init HomeViewModel")
    }
}