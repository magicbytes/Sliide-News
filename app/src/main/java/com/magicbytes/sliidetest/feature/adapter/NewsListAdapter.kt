package com.magicbytes.sliidetest.feature.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.magicbytes.sliidetest.R
import com.magicbytes.sliidetest.feature.adapter.viewHolders.BaseNewsViewHolder
import com.magicbytes.sliidetest.feature.adapter.viewHolders.SingleNewsViewHolder

class NewsListAdapter : RecyclerView.Adapter<BaseNewsViewHolder>() {

    var news: List<NewsListItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseNewsViewHolder {
        val itemType = NewsListItem.Type.values()[viewType]

        val inflater = LayoutInflater.from(parent.context)
        when (itemType) {
            NewsListItem.Type.SingleContent -> {
                val view = inflater.inflate(R.layout.list_item_news, parent, false)
                return SingleNewsViewHolder(view)
            }
            NewsListItem.Type.CarouselContent -> TODO()
        }
    }

    override fun onBindViewHolder(holder: BaseNewsViewHolder, position: Int) {
        holder.show(news[position])
    }

    override fun getItemCount(): Int {
        return news.size
    }

    override fun getItemViewType(position: Int): Int {
        return news[position].type.ordinal
    }
}