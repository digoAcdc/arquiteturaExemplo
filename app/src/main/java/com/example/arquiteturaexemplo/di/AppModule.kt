package com.example.arquiteturaexemplo.di


import com.example.arquiteturaexemplo.data.repository.home.HomeRepository
import com.example.arquiteturaexemplo.data.repository.home.IHomeRepository
import com.example.arquiteturaexemplo.data.repository.login.ILoginRepository
import com.example.arquiteturaexemplo.data.repository.login.LoginRepository
import com.example.arquiteturaexemplo.domain.home.HomeUseCase
import com.example.arquiteturaexemplo.domain.home.IHomeUseCase
import com.example.arquiteturaexemplo.domain.login.ILoginUserCase
import com.example.arquiteturaexemplo.domain.login.LoginUserCase
import com.example.arquiteturaexemplo.ui.home.HomeViewModel
import com.example.arquiteturaexemplo.ui.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        LoginViewModel(useCase = get())
    }
    viewModel {
        HomeViewModel(useCase = get())
    }
}

val useCaseModule = module{
    factory<ILoginUserCase> {
        LoginUserCase(repository = get())
    }
    factory<IHomeUseCase> {
        HomeUseCase(repository = get())
    }
}

val repositoryModule = module{
    factory<ILoginRepository> {
       LoginRepository()
    }
    factory<IHomeRepository> {
        HomeRepository()
    }
}