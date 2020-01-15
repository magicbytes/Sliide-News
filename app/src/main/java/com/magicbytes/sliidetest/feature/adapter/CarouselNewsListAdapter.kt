package com.magicbytes.sliidetest.feature.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.magicbytes.sliidetest.R
import com.magicbytes.sliidetest.feature.adapter.viewHolders.BaseNewsViewHolder
import com.magicbytes.sliidetest.feature.adapter.viewHolders.SingleNewsViewHolder

class CarouselNewsListAdapter : RecyclerView.Adapter<SingleNewsViewHolder>() {

    var news: List<NewsListItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleNewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item_big_title_news, parent, false)
        return SingleNewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: SingleNewsViewHolder, position: Int) {
        holder.show(news[position])
    }

    override fun getItemCount(): Int {
        return news.size
    }
}