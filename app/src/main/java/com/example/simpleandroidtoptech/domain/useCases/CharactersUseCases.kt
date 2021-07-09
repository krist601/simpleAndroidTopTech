package com.example.simpleandroidtoptech.domain.useCases

import androidx.lifecycle.LiveData
import com.example.simpleandroidtoptech.domain.repositories.IRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharactersUseCases constructor(private val iRepository: IRepository) {
    /*override suspend fun run(params: UpdatePhoneRequest?): UpdatePhoneResponse = iRepository.updatePhone(params!!)
    fun getCharacters(liveData: LiveData<HeaderMemory?>){
        CoroutineScope(Dispatchers.IO).launch {
            liveData.po.postLoading()
            repository.getEconomicIndicators().let{ response ->
                when (response.first) {
                    RESPONSE_SUCCESS_CODE -> liveData.postSuccess(response.second)
                    RESPONSE_ERROR_CODE -> liveData.postError()
                }
            }
        }
    }*/
}