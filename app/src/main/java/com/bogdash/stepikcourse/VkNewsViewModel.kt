package com.bogdash.stepikcourse

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bogdash.stepikcourse.domain.FeedPost
import com.bogdash.stepikcourse.domain.StatisticItem

class VkNewsViewModel: ViewModel() {
    private val _feedPost = MutableLiveData(FeedPost())
    val feedPost: LiveData<FeedPost> = _feedPost

    fun updateCount(item: StatisticItem) {
        // TODO: look at the type
        val oldStatistics = feedPost.value?.statistics ?: throw IllegalStateException("error in updateCount fun")
        val newStatistics = oldStatistics.toMutableList().apply {
            replaceAll { oldItem ->
                if (oldItem.type == item.type) {
                    oldItem.copy(count = oldItem.count + 1)
                } else {
                    oldItem
                }
            }
        }
        _feedPost.value = feedPost.value?.copy(statistics = newStatistics)
    }
}