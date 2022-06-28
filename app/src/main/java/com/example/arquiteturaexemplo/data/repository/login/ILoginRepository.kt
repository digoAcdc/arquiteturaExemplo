package com.example.arquiteturaexemplo.data.repository.login

import com.example.arquiteturaexemplo.data.Resource

interface ILoginRepository {
    fun login(usuario:String, senha:String): Resource
}