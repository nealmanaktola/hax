package com.manaktola.hax

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by nealmanaktola on 2017-08-20.
 */


interface HackernewsApiService {
    @GET("v0/topstories.json")
    fun topStories() : Observable<List<Int>>

    @GET("v0/item/{id}.json")
    fun itemById(@Path("id") id : Int) : Observable<NewsItem>


    companion object Factory {
        fun create() : HackernewsApiService {
            val retrofit = Retrofit.Builder()
                    .baseUrl("https://hacker-news.firebaseio.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()

            return retrofit.create(HackernewsApiService::class.java)
        }
    }
}