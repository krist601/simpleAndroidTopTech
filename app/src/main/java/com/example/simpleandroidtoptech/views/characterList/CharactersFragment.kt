package com.example.simpleandroidtoptech.views.characterList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.core.BaseFragment
import com.example.core.LiveDataStatus
import com.example.simpleandroidtoptech.appComponent
import com.example.simpleandroidtoptech.databinding.FragmentCharactersBinding
import com.example.simpleandroidtoptech.di.ViewModelFactory
import com.example.simpleandroidtoptech.di.getViewModel
import com.example.simpleandroidtoptech.domain.entities.CharacterMemory
import com.example.simpleandroidtoptech.domain.entities.GeneralHeaderMemory
import com.example.simpleandroidtoptech.viewModels.CharactersViewModel
import javax.inject.Inject

class CharactersFragment: BaseFragment(), CharactersAdapter.OnClickItemListener {

    //******************* VIEW VARIABLES *******************//

    @Inject lateinit var viewModelFactory: ViewModelFactory
    private var viewModel: CharactersViewModel? = null
    lateinit var binding: FragmentCharactersBinding
    lateinit var adapter: CharactersAdapter

    //******************* VIEW LIFECYCLE *******************//

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent().inject(this)
        viewModel = getViewModel(viewModelFactory)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCharactersBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = CharactersAdapter(mutableListOf(), this)
        binding.listView.adapter = adapter
        binding.listView.layoutManager = (LinearLayoutManager(activity, RecyclerView.VERTICAL, false))
        binding.reloadButton.setOnClickListener { reload() }
        viewModel?.dataLiveData?.observe(viewLifecycleOwner, {
                it?.also { characterObserver(it.status, it.data) }
        })
        request()
    }

    private fun characterObserver(status: LiveDataStatus, result: GeneralHeaderMemory<List<CharacterMemory>>?) {
        when (status) {
            LiveDataStatus.LOADING -> if (viewModel?.page == 1) onLoading(binding.progressBar, binding.noDataTextView, binding.listView, binding.reloadButton)
            LiveDataStatus.SUCCESS -> {
                if (result?.results?.isNullOrEmpty() == false) {
                    if(viewModel?.page == 1)
                        adapter.setData(result)
                    else
                        adapter.addData(result)
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