package com.magicbytes.sliidetest.data

import androidx.lifecycle.LiveData
import com.magicbytes.sliidetest.data.News

interface NewsRepository {
    fun getAllNews(): LiveData<List<News>>
}