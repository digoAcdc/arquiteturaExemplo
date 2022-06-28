package com.example.arquiteturaexemplo.data.repository.home

import com.example.arquiteturaexemplo.data.Resource
import com.example.arquiteturaexemplo.data.model.planetas

class HomeRepository:IHomeRepository {
    override fun buscaPlanetas(): Resource {
        return Resource.Success(data = planetas)
    }
}