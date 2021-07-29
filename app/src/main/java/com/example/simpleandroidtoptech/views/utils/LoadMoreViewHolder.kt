package com.example.simpleandroidtoptech.views.utils

import androidx.recyclerview.widget.RecyclerView
import com.example.simpleandroidtoptech.databinding.CellLoadMoreBinding

class LoadMoreViewHolder(val binding: CellLoadMoreBinding, val listener: OnLoadMoreDataListener): RecyclerView.ViewHolder(binding.root) {
    fun bind() {
        listener.loadMoreData()
    }

    //******************* CLICK LISTENER *******************//

    interface OnLoadMoreDataListener {
        fun loadMoreData()
    }
}