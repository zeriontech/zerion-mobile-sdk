package io.zerion.kmm.api.httpclient

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.headers
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


internal fun buildHttpClient(
    authorization: String
): HttpClient {
    return HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    encodeDefaults = true
                    isLenient = true
                    allowSpecialFloatingPointValues = true
                    allowStructuredMapKeys = true
                    prettyPrint = true
                    useArrayPolymorphism = false
                    ignoreUnknownKeys = true
                }
            )
        }
        defaultRequest {
            url("https://api.zerion.io/v1/")
            headers { set("Authorization", "Basic $authorization") }
        }
    }
}