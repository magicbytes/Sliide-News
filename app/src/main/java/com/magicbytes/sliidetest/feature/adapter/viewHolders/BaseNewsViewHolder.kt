package com.magicbytes.sliidetest.feature.adapter.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.magicbytes.sliidetest.data.News
import com.magicbytes.sliidetest.feature.adapter.NewsListItem

abstract class BaseNewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun show(newsListItem: NewsListItem)
}