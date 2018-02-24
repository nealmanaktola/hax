package com.manaktola.hax

/**
 * Created by nealmanaktola on 2017-09-05.
 */
object StoriesRepositoryProvider {

    fun provideStoriesRepository() : StoriesRepository {
        return StoriesRepository(HackernewsApiService.create())
    }
}