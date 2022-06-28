package com.example.arquiteturaexemplo.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.arquiteturaexemplo.data.Resource
import com.example.arquiteturaexemplo.domain.login.ILoginUserCase

class LoginViewModel(private val useCase: ILoginUserCase) : ViewModel() {

  val loginLiveData: MutableLiveData<Resource> by lazy {
    MutableLiveData<Resource>()
  }

  fun login(user:String, senha:String){
    when (val resource =  useCase.login(user, senha)) {
      is Resource.Failure<*> -> {
        println(resource.error?.message)
        loginLiveData.value = resource
      }
      is Resource.Success<*> -> {
        println(resource.data)
        loginLiveData.value = resource
      }
    }

  }
}