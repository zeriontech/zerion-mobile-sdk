package io.zerion.kmm.api.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.zerion.kmm.api.models.PortfolioResponse


internal interface ZerionAPI {
    suspend fun getWalletPortfolio(address: String): PortfolioResponse
}

internal class ZerionAPIImpl(private val client: HttpClient) : ZerionAPI {

    override suspend fun getWalletPortfolio(address: String): PortfolioResponse {
        return client.get("wallets/$address/portfolio").body()
    }

}