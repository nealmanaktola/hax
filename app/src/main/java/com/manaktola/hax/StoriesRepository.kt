package com.manaktola.hax

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by nealmanaktola on 2017-08-20.
 */


class StoriesRepository(private val api: HackernewsApiService) {
    fun getTopStories() : LiveData<List<NewsItem>> {
        val data = MutableLiveData<List<NewsItem>>()

        api.topStories()
                .flatMapIterable { it }
                .map { id -> api.itemById(id) }
                .flatMap{ it }
                .toList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{itemList -> data.value = itemList}

        return data
    }
}