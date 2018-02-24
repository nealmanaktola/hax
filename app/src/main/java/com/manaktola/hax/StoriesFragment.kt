package com.manaktola.hax

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by nealmanaktola on 2017-08-20.
 */
class StoriesFragment : Fragment() {

    private var storiesViewModel: StoriesViewModel? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_stories, container, false)
        initViewModel()

        return view
    }


    private fun initViewModel() {
        val storiesRepository = StoriesRepositoryProvider.provideStoriesRepository()
        storiesViewModel = ViewModelProviders.of(this, StoriesViewModelFactory(storiesRepository))
                .get(StoriesViewModel::class.java)

        storiesViewModel?.getStories()?.observe(this, Observer {
            storiesList -> storiesList!!.forEach {
                Log.d("StoriesFragment", "Story found: " + it)
            }
        })
    }
}