package example.androidmvvmhiltjetpackcompose.interfaces

import news.model.NewsResponse

interface NewsRepository {
    suspend fun fetchNews(category: String, country: String): NewsResponse
}