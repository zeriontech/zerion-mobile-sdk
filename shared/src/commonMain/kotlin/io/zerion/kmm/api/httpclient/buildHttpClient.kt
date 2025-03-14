package io.zerion.kmm.api.httpclient

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.headers
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.json
import io.zerion.kmm.api.api.ZerionApiConstants.DEFAULT_API_URL
import io.zerion.kmm.api.exceptions.ZerionApiException
import kotlinx.serialization.json.Json
import io.zerion.kmm.api.utils.Logging

internal fun buildHttpClient(authorization: String, apiUrl: String = DEFAULT_API_URL): HttpClient {
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

        HttpResponseValidator {
            validateResponse { response ->
                val statusCode = response.status.value
                if (statusCode >= 400) {
                    val errorBody = response.bodyAsText()
                    Logging.error("API request failed with status code: $statusCode, error: $errorBody")
                    throw ZerionApiException.fromHttpCode(
                        code = statusCode,
                        message = errorBody
                    )
                }
            }
        }

        defaultRequest {
            url(apiUrl)
            headers { set("Authorization", "Basic $authorization") }
        }
    }
}