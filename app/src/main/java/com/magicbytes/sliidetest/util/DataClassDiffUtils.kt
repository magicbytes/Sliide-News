package com.magicbytes.sliidetest.util

import androidx.recyclerview.widget.DiffUtil


/**
 * Generic diff utils. Recommended to use with data class type for correct work of equals
 */
class DataClassDiffUtils<T> constructor(
    private val oldItems: List<T>,
    private val newItems: List<T>
) : DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition] == newItems[newItemPosition]
    }

    override fun getOldListSize(): Int {
        return oldItems.size
    }

    override fun getNewListSize(): Int {
        return newItems.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition] == newItems[newItemPosition]
    }
}