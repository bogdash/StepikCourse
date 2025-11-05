package com.bogdash.stepikcourse

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel: ViewModel() {
    private val _isFollowing = MutableStateFlow<Boolean>(false)
    val isFollowing = _isFollowing.asStateFlow()

    fun changeFollowingStatus() {
        val wasFollowing = isFollowing.value
        _isFollowing.value = !wasFollowing
    }
}