package com.example.arquiteturaexemplo.domain.login

import com.example.arquiteturaexemplo.data.Resource
import com.example.arquiteturaexemplo.data.repository.login.ILoginRepository


class LoginUserCase(val repository: ILoginRepository) : ILoginUserCase {
    override fun login(usuario: String, senha: String): Resource {
        return repository.login(usuario, senha)
    }

}