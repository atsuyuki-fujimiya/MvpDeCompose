package com.example.mvpdecompose.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

data class MainState(
    val data: String,
    val initData: String,
    val updateData: (String) -> Unit,
)

@Composable
fun rememberMainState(initData: String): MainState {
    val state = remember {
        mutableStateOf(initData)
    }

    val updateData: (String) -> Unit = { newData ->
        state.value = newData
    }

    return MainState(
        state.value,
        initData,
        updateData
    )
}
