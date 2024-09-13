package com.example.mvpdecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mvpdecompose.presenter.MainPresenter
import com.example.mvpdecompose.state.rememberMainState
import com.example.mvpdecompose.ui.compose.MainScreen
import com.example.mvpdecompose.ui.theme.MvpDeComposeTheme

class MainActivity : ComponentActivity() {
    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val state = rememberMainState(initData = "")
            presenter = MainPresenter(state)
            MvpDeComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        state = state,
                        onLoadData = { presenter.loadData("Hello!") }
                    )
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MvpDeComposeTheme {
        Greeting("Android")
    }
}
