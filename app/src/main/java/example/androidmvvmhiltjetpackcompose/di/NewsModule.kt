package example.androidmvvmhiltjetpackcompose.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import example.androidmvvmhiltjetpackcompose.interfaces.NewsRepository
import example.androidmvvmhiltjetpackcompose.repository.NewsRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class NewsModule {

    // Binds establish a one-to-one relationship between an interface and its implementation
    @Binds
    abstract fun bindNewsRepository(newsRepositoryImpl: NewsRepositoryImpl): NewsRepository
}