package com.example.arquiteturaexemplo.domain.home

import com.example.arquiteturaexemplo.data.Resource


interface IHomeUseCase {
    fun buscaPlanetas(): Resource
}