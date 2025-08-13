package example.androidmvvmhiltjetpackcompose.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import example.androidmvvmhiltjetpackcompose.interfaces.NewsRepository
import example.androidmvvmhiltjetpackcompose.model.NewsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: NewsRepository
) : ViewModel() {
    private val _uiState =
        MutableStateFlow<NewsUiState>(
            NewsUiState.Loading
        )
    val uiState = _uiState.asStateFlow()

    fun fetchNews(category: String, country: String) {
        viewModelScope.launch {
            _uiState.value =
                NewsUiState.Loading // Set state to loading
            try {
                val newsResponse = repository.fetchNews(category, country)
                _uiState.value =
                    NewsUiState.Success(
                        newsResponse.articles
                    ) // Set state to success
            } catch (e: Exception) {
                _uiState.value =
                    NewsUiState.Error(
                        "Failed to load news: ${e.message}"
                    ) // Set state to error
            }
        }
    }
}