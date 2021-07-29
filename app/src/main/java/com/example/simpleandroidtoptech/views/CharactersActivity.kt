package com.example.simpleandroidtoptech.views

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.core.BaseActivity
import com.example.core.LiveDataStatus
import com.example.simpleandroidtoptech.databinding.ActivityCharactersBinding
import com.example.simpleandroidtoptech.domain.entities.CharacterMemory
import com.example.simpleandroidtoptech.domain.entities.GeneralHeaderMemory
import com.example.simpleandroidtoptech.viewModels.CharactersViewModel

class CharactersActivity : BaseActivity(), CharactersAdapter.OnClickItemListener {

    //******************* VIEW VARIABLES *******************//

    private val viewModel: CharactersViewModel? = null
    lateinit var binding: ActivityCharactersBinding
    lateinit var adapter: CharactersAdapter

    //******************* VIEW LIFECYCLE *******************//

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharactersBinding.inflate(layoutInflater)
        adapter = CharactersAdapter(mutableListOf(), this)
        binding.listView.layoutManager = (LinearLayoutManager(this, RecyclerView.VERTICAL, false))
        binding.reloadButton.setOnClickListener { reload() }
        viewModel?.dataLiveData?.observe(this, {
            it?.also { characterObserver(it.status, it.data) }
        })
        request()
    }

    private fun characterObserver(status: LiveDataStatus, result: GeneralHeaderMemory<List<CharacterMemory>>?) {
        when (status) {
            LiveDataStatus.LOADING -> if (viewModel?.page == 1) onLoading(binding.progressBar, binding.noDataTextView, binding.listView, binding.reloadButton)
            LiveDataStatus.SUCCESS -> {
                if (result?.results?.isNullOrEmpty() == false) {
                    if(viewModel?.page == 1) adapter.setData(result) else adapter.addData(result)
                    onSuccess(binding.progressBar, binding.noDataTextView, binding.listView, binding.reloadButton)
                } else onNoData(binding.progressBar, binding.noDataTextView, binding.listView, binding.reloadButton)
            }
            LiveDataStatus.TIME_OUT -> onError(binding.progressBar, binding.noDataTextView, binding.listView, binding.reloadButton)
            else -> onError(binding.progressBar, binding.noDataTextView, binding.listView, binding.reloadButton)
        }
    }

    override fun loadMoreData() {
        viewModel?.page = viewModel?.page ?: 0 + 1
        request()
    }

    private fun reload(){
        viewModel?.page = 1
        request()
    }
    private fun request() {
        viewModel?.getCharacters()
    }

    override fun click(item: CharacterMemory) {
        TODO("Not yet implemented")
    }
}