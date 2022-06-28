package com.example.arquiteturaexemplo.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Planeta(val nome:String, val imagem:String, val pequenaDescricao:String, val longaDescricao:String) :
    Parcelable