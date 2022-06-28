package com.example.arquiteturaexemplo.domain.login

import com.example.arquiteturaexemplo.data.Resource


interface ILoginUserCase {
    fun login(usuario:String, senha:String): Resource
}