package news

import news.model.NewsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.json.Json

class KtorClient {
    companion object{
        //API_FORMAT = https://saurav.tech/NewsAPI/top-headlines/category/<category>/<countryCode>.json
        //Country Code: in, us, au, ru, fr, gb
       const val BASE_URL = "https://saurav.tech/NewsAPI/top-headlines/category/health/us.json"
    }
    private val client = HttpClient(OkHttp) {
        defaultRequest { url(BASE_URL) }

        install(Logging){
            logger = Logger.SIMPLE
        }

        install(ContentNegotiation){
            //Specify response in Json Format
            json(Json{
                ignoreUnknownKeys = true
            })
        }
    }


    suspend fun fetchNews(category: String, country: String): NewsResponse {
        return client.get(BASE_URL).body<NewsResponse>()
    }
}