package com.manaktola.hax

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

/**
 * Created by nealmanaktola on 2017-08-20.
 */

/***
 * ViewModel for the StoriesFragment
 */
class StoriesViewModel (val repository: StoriesRepository): ViewModel() {
    private var stories : LiveData<List<NewsItem>>? = null

    init {
        loadTopStories()
    }


    /**
     * load top stories
     */
    private fun loadTopStories() {
        if (stories == null) {
            stories = repository.getTopStories();
        }
    }

    fun getStories() : LiveData<List<NewsItem>>? {
        return stories
    }

}