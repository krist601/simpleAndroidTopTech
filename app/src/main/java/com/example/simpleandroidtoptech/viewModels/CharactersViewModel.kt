package com.example.simpleandroidtoptech.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.core.LiveDataStatus
import com.example.core.Resource
import com.example.core.post
import com.example.simpleandroidtoptech.domain.entities.CharacterMemory
import com.example.simpleandroidtoptech.domain.entities.GeneralHeaderMemory
import com.example.simpleandroidtoptech.domain.useCases.CharactersUseCases
import java.net.SocketTimeoutException
import javax.inject.Inject

class CharactersViewModel @Inject constructor(private val charactersUseCases: CharactersUseCases): ViewModel(){
    val dataLiveData = MutableLiveData<Resource<GeneralHeaderMemory<List<CharacterMemory>>?>>()
    var page = 1

    fun getCharacters(){
        dataLiveData.post(LiveDataStatus.LOADING)
        fun handleSuccess(response: Pair<LiveDataStatus, GeneralHeaderMemory<List<CharacterMemory>>?>) {
            dataLiveData.postValue(Resource(LiveDataStatus.SUCCESS, response.second))
        }
        fun handleFailure(e: Exception) {
            if(e is SocketTimeoutException) dataLiveData.postValue(Resource(LiveDataStatus.TIME_OUT, null))
            dataLiveData.postValue(Resource(LiveDataStatus.ERROR, null, e))
        }
        charactersUseCases.invoke(page, ::handleSuccess, ::handleFailure)
    }
}