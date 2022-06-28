package com.example.arquiteturaexemplo.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.arquiteturaexemplo.data.Resource
import com.example.arquiteturaexemplo.domain.home.IHomeUseCase

class HomeViewModel(val useCase: IHomeUseCase) : ViewModel() {

    val planetasLiveData: MutableLiveData<Resource> by lazy {
        MutableLiveData<Resource>()
    }

    fun buscaPlanetas(){
        useCase.buscaPlanetas()
        when (val resource =  useCase.buscaPlanetas()) {
            is Resource.Failure<*> -> {
                println(resource.error?.message)
                planetasLiveData.value = resource
            }
            is Resource.Success<*> -> {
                println(resource.data)
                planetasLiveData.value = resource
            }
        }
    }
}