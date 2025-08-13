package example.androidmvvmhiltjetpackcompose.model

import news.model.NewsResponse

sealed class NewsUiState {
    data object Loading : NewsUiState()
    data class Success(val articles: List<NewsResponse.Article>) : NewsUiState()
    data class Error(val message: String) : NewsUiState()
}