package com.magicbytes.sliidetest.feature.adapter.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.magicbytes.sliidetest.data.News
import com.magicbytes.sliidetest.feature.adapter.NewsListItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item_news.view.*

class CarouselNewsViewHolder(itemView: View) : BaseNewsViewHolder(itemView) {

    override fun show(newsListItem: NewsListItem) {
        val news = newsListItem.data as? List<News> ?: return

    }
}