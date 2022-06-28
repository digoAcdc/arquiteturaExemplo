package com.example.arquiteturaexemplo.extensions

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController

//fun Fragment.navigateTo(@IdRes resId: Int) = try{
//    findNavController().navigate(resId)
//}catch (e:Exception){
//
//}
//
//fun Fragment.navigateWithArgumentTo(@IdRes resId: Int, argument: Bundle) = try{
//    findNavController().navigate(resId, argument)
//}catch (e:Exception){
//
//}

fun Fragment.findNavigateController(): NavController = NavHostFragment.findNavController(this)