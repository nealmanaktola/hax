package com.manaktola.hax

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

/**
 * Created by nealmanaktola on 2017-09-05.
 */

class StoriesViewModelFactory(private val storiesRepository: StoriesRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return StoriesViewModel(storiesRepository) as T
    }

}
