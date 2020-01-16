package com.magicbytes.sliidetest.feature.adapter.viewHolders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.magicbytes.sliidetest.R
import com.magicbytes.sliidetest.data.News
import com.magicbytes.sliidetest.feature.adapter.NewsListItem
import com.squareup.picasso.Picasso

class SingleNewsViewHolder(itemView: View) : BaseNewsViewHolder(itemView) {

    private val imageView: ImageView = itemView.findViewById(R.id.newsImage)
    private val titleTextView: TextView = itemView.findViewById(R.id.newsTitleTextView)

    override fun show(newsListItem: NewsListItem) {
        val news = newsListItem.data as? News ?: return

        titleTextView.text = news.title
        if (news.contentSourceLogo.isNotEmpty()) {
            Picasso.get().load(news.contentSourceLogo).into(imageView)
        }
    }
}