package com.manaktola.hax

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

/**
 * Created by nealmanaktola on 2017-08-20.
 */
class StoriesFragment : Fragment() {

    private var storiesViewModel: StoriesViewModel? = null
    private var adapter: StoriesAdapter? = null
    private var items: ArrayList<NewsItem> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_stories, container, false)
        initViewModel()

        val rv = view.findViewById<RecyclerView>(R.id.storiesList)
        rv.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)


        adapter = StoriesAdapter(items)
        rv.adapter = adapter
        return view
    }


    private fun initViewModel() {
        val storiesRepository = StoriesRepositoryProvider.provideStoriesRepository()
        storiesViewModel = ViewModelProviders.of(this, StoriesViewModelFactory(storiesRepository))
                .get(StoriesViewModel::class.java)

        storiesViewModel?.getStories()?.observe(this, Observer {
            items.addAll(it!!)
            adapter!!.notifyDataSetChanged()
        })
    }
}