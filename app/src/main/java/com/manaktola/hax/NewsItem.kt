package com.manaktola.hax

/**
 * Created by nealmanaktola on 2017-08-20.
 */
data class NewsItem(
    val id: Int,
    val deleted: Boolean,
    val type: String,
    val by: String,
    val time: Int,
    val text: String,
    val dead: Boolean,
    val parent: Int,
    val poll: Int,
    val kids: List<Int>,
    val url: String,
    val score: Int,
    val title: String,
    val parts: List<Int>,
    val descendants: Int
)

