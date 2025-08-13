package example.androidmvvmhiltjetpackcompose.repository

import news.KtorClient
import news.model.NewsResponse
import javax.inject.Inject
import example.androidmvvmhiltjetpackcompose.interfaces.NewsRepository

class NewsRepositoryImpl @Inject constructor(private val ktorClient: KtorClient) :NewsRepository {
    override suspend fun fetchNews(category: String, country: String): NewsResponse {
        return ktorClient.fetchNews(category,country)
    }
}