package com.example.androidmvvmhiltjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import com.example.androidmvvmhiltjetpackcompose.ui.theme.AndroidMvvmHiltJetpackComposeTheme
import com.example.news.TestNews
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidMvvmHiltJetpackComposeTheme {
                Text(text = "Hello Android")
                TestNews()
            }
        }
    }
}
