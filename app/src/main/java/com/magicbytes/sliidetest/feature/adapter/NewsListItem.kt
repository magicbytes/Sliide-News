package com.magicbytes.sliidetest.feature.adapter

data class NewsListItem(val type: Type, val data: Any) {

    enum class Type {
        SingleContent,
        CarouselContent
    }
}