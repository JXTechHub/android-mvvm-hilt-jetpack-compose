package example.androidmvvmhiltjetpackcompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import example.androidmvvmhiltjetpackcompose.view.NewsScreen
import dagger.hilt.android.AndroidEntryPoint
import example.androidmvvmhiltjetpackcompose.ui.theme.AndroidMvvmHiltJetpackComposeTheme

@AndroidEntryPoint
class MainActivity : androidx.activity.ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidMvvmHiltJetpackComposeTheme {
                Text(text = "Hello Android")
                NewsScreen()
            }
        }
    }
}
