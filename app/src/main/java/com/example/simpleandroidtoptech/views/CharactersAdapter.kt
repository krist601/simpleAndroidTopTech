package com.example.simpleandroidtoptech.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleandroidtoptech.views.utils.LoadMoreViewHolder
import com.example.core.getImgPicasso
import com.example.simpleandroidtoptech.R
import com.example.simpleandroidtoptech.databinding.CellCharacterBinding
import com.example.simpleandroidtoptech.domain.entities.CharacterMemory
import com.example.simpleandroidtoptech.domain.entities.GeneralHeaderMemory

class CharactersAdapter (
    private var itemList: MutableList<CharacterMemory?>?,
    private var listener: OnClickItemListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), LoadMoreViewHolder.OnLoadMoreDataListener {

    fun setData(result: GeneralHeaderMemory<List<CharacterMemory>>) {
        itemList = result.results?.toMutableList()
        notifyDataSetChanged()
    }
    fun addData(result: GeneralHeaderMemory<List<CharacterMemory>>) {
        if(itemList?.size ?: 0 > 0 && itemList?.lastOrNull() == null) itemList?.lastIndex?.let { itemList?.removeAt(it) }
        result.results?.let { itemList?.addAll(it) }
        if(result.info?.next != null) itemList?.add(null)
        notifyItemRangeInserted(itemList?.count() ?: 0 - (result.results?.count() ?: 0), result.results?.count() ?: 0 - if(itemList?.size ?: 0 > 0 && itemList?.lastOrNull() == null) 0 else 1)
    }

    override fun getItemCount(): Int {
        return itemList?.size ?: 0
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 0) CharacterViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.cell_character, parent, false), listener)
        else LoadMoreViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.cell_load_more, parent, false), this)
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(itemList?.get(position) != null) (holder as CharacterViewHolder).bind(itemList?.getOrNull(position)!!)
        else (holder as LoadMoreViewHolder).bind()
    }

    //******************* CLICK LISTENER *******************//

    interface OnClickItemListener {
        fun click(item: CharacterMemory)
        fun loadMoreData()
    }
    override fun loadMoreData(){
        this.listener.loadMoreData()
    }

    //******************* HOLDER *******************//

    internal class CharacterViewHolder(private val binding: CellCharacterBinding, private val listener: OnClickItemListener): View.OnClickListener, RecyclerView.ViewHolder(binding.root) {
        private lateinit var itemHolder: CharacterMemory

        fun bind(item: CharacterMemory) = with(itemView) {
            itemHolder = item
            itemView.setOnClickListener(this@CharacterViewHolder)

            binding.titleTextView.text = item.name
            getImgPicasso(item.image, binding.photoImageView, android.R.drawable.ic_menu_camera)
        }

        override fun onClick(view: View) {
            listener.click(itemHolder)
        }
    }
}