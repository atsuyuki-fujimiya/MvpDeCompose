package com.example.mvpdecompose.presenter

import com.example.mvpdecompose.state.MainState

class MainPresenter(private val state: MainState) {
    fun loadData(data: String) {
        state.updateData(data)
    }
}
