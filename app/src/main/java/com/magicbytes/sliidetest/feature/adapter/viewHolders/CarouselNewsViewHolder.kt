package com.magicbytes.sliidetest.feature.adapter.viewHolders

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.magicbytes.sliidetest.data.News
import com.magicbytes.sliidetest.feature.adapter.CarouselNewsListAdapter
import com.magicbytes.sliidetest.feature.adapter.NewsListItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item_carousel_news.view.*
import kotlinx.android.synthetic.main.list_item_news.view.*
import kotlin.math.sin

class CarouselNewsViewHolder(itemView: View) : BaseNewsViewHolder(itemView) {

    private var carouselAdapter = CarouselNewsListAdapter()

    init {
        itemView.contentRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
            adapter = carouselAdapter
        }
    }

    override fun show(newsListItem: NewsListItem) {
        val news = newsListItem.data as? List<News> ?: return
        val singleNews = news.map { NewsListItem(NewsListItem.Type.SingleContent, it) }
        carouselAdapter.news = singleNews
    }
}