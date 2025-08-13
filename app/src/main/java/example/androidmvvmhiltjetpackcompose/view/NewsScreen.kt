package example.androidmvvmhiltjetpackcompose.view

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import example.androidmvvmhiltjetpackcompose.model.NewsUiState
import example.androidmvvmhiltjetpackcompose.viewmodel.NewsViewModel

@Composable
fun NewsScreen(newsViewModel: NewsViewModel = hiltViewModel()) {

    val uiState by newsViewModel.uiState.collectAsState()

    //key1 = Unit for tasks that need to happen once when the screen is first shown
    LaunchedEffect(key1 = Unit) {
        newsViewModel.fetchNews("test","Help")
    }

    when (uiState) {
        is NewsUiState.Loading -> {
            Log.d("NewsScreen","NewsUiState Loading()")
        }
        is NewsUiState.Success -> {
            Log.d("NewsScreen","NewsUiState Success()")
        }
        is NewsUiState.Error -> {
            Log.d("NewsScreen","NewsUiState Error()")
        }
    }

}