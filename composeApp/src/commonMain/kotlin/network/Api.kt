package org.masa.kmpplayground.network

import entity.MovieDetails
import entity.MoviesResult
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.headers
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

const val BASE_URL = "https://api.collectapi.com/imdb"
class Api {

    private val httpClient = HttpClient {
        install(ContentNegotiation){
            headers {
                "authorization" to "apikey 6fboN92MUSCInMEwWuVNd8:0FUxNlV0ZWIk8fUBwGKWU9"
            }
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    suspend fun searchImdb(title: String): MoviesResult {
        return httpClient.get("$BASE_URL/imdbSearchByName?query=$title").body()
    }

    suspend fun details(imdbId: String): MovieDetails{
        return httpClient.get("$BASE_URL/imdbSearchById?movieId=$imdbId").body()
    }
}