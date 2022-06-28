package com.example.arquiteturaexemplo.data.repository.home

import com.example.arquiteturaexemplo.data.Resource

interface IHomeRepository {
    fun buscaPlanetas(): Resource
}