package com.example.composepractice1.presentation.screen.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

}

//@HiltViewModel
//class MainViewModel @Inject constructor(
//    private val mainRepository: MainRepository
//) : ViewModel() {
//
//    fun getUserInfo(owner: String) = mainRepository.getUserInfo(owner)
//        .subscribeOn(Schedulers.io())
//        .observeOn(Schedulers.io())
//        .subscribe({ items ->
//            items.forEach { println(it) }
//        }, { e ->
//            println(e.toString())
//        })
//
//}