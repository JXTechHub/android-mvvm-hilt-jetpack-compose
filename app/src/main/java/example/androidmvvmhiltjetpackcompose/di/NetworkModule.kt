package example.androidmvvmhiltjetpackcompose.di


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import news.KtorClient

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun providesKtorClient(): KtorClient {
        return KtorClient()
    }
}