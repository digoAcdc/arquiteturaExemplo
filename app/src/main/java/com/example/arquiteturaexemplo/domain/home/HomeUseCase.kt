package com.example.arquiteturaexemplo.domain.home

import com.example.arquiteturaexemplo.data.Resource
import com.example.arquiteturaexemplo.data.repository.home.IHomeRepository

class HomeUseCase(val repository: IHomeRepository): IHomeUseCase {
    override fun buscaPlanetas(): Resource {
        return repository.buscaPlanetas()
    }
}