package com.magicbytes.sliidetest.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.magicbytes.sliidetest.R
import com.magicbytes.sliidetest.data.News
import com.magicbytes.sliidetest.feature.adapter.NewsListAdapter
import com.magicbytes.sliidetest.feature.adapter.NewsListItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: NewsListViewModel

    private val adapter = NewsListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newsRecyclerView.adapter = adapter;

        viewModel = ViewModelProvider(this)[NewsListViewModel::class.java]
        viewModel.getAllNews().observe(this, Observer { listNews ->
            // 0,1,2 - single
            // 3, 4,5
            // 6, 7, 8 - singl
            // 9, 10, 11
            // 12, 13, 14 - single


            val group = mutableListOf<News>()
            val displayListItems = mutableListOf<NewsListItem>()
            listNews.forEachIndexed { index, news ->
                val isSingle = (index / 3) % 2 == 0
                if (isSingle) {
                    if (group.isNotEmpty()) {
                        displayListItems.add(NewsListItem(NewsListItem.Type.CarouselContent, group.toList()))
                    }
                    group.clear()
                    displayListItems.add(NewsListItem(NewsListItem.Type.SingleContent, news))
                } else {
                    group.add(news)
                }
            }

            if (group.isNotEmpty()) {
                displayListItems.add(NewsListItem(NewsListItem.Type.CarouselContent, group))
            }

            adapter.news = displayListItems
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_activity_menu, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.refreshItem -> {
                viewModel.refreshNews()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}
