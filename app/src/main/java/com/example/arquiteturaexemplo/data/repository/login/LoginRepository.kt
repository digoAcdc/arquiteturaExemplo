package com.example.arquiteturaexemplo.data.repository.login

import com.example.arquiteturaexemplo.data.Resource
import com.example.arquiteturaexemplo.data.model.UsuarioLogado

class LoginRepository : ILoginRepository {
    override fun login(usuario: String, senha: String): Resource {
        return Resource.Success(data = UsuarioLogado("Leandro Miguel", "leandro.miguel@zup.com.br", 30))
    }
}