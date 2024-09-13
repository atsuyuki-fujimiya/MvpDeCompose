package com.example.mvpdecompose.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mvpdecompose.state.MainState
import com.example.mvpdecompose.state.rememberMainState

@Composable
fun MainScreen(
    state: MainState,
    onLoadData: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = state.data)
        Button(onClick = onLoadData) {
            Text(text = "Load Data")
        }
    }
}

@Preview
@Composable
private fun PreviewMainScreen() {
    val state = rememberMainState(initData = "aaa")
    MainScreen(state = state) {
        state.updateData("AAA")
    }
}
